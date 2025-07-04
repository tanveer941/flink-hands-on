package main.java.sliding;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.tuple.Tuple5;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.SlidingProcessingTimeWindows;
import org.apache.flink.streaming.api.windowing.assigners.TumblingProcessingTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;

import org.apache.flink.core.fs.Path;
import org.apache.flink.api.common.serialization.SimpleStringEncoder;
import org.apache.flink.streaming.api.functions.sink.filesystem.StreamingFileSink;
import org.apache.flink.streaming.api.functions.sink.filesystem.rollingpolicies.DefaultRollingPolicy;

public class AverageProfitSlidingWindowProcessingTime {
  public static void main(String[] args) throws Exception {
    // set up the streaming execution environment
    StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

    DataStream < String > data = env.socketTextStream("localhost", 9090);

    // month, product, category, profit, count
    DataStream < Tuple5 < String, String, String, Integer, Integer >> mapped = data.map(new Splitter()); // tuple  [June,Category5,Bat,12,1]
    //        [June,Category4,Perfume,10,1]
    // groupBy 'month'
    DataStream < Tuple5 < String, String, String, Integer, Integer >> reduced = mapped
            .keyBy(t -> t.f0)
            .window(SlidingProcessingTimeWindows.of(Time.seconds(2), Time.seconds(1)))
            .reduce(new Reduce1());
    // June { [Category5,Bat,12,1] Category4,Perfume,10,1}	//rolling reduce
    // reduced = { [Category4,Perfume,22,2] ..... }
    reduced.addSink(StreamingFileSink
            .forRowFormat(new Path("/Users/tanveem/non_work/builder_winner_git/flink-hands-on/windowing-stream/sliding_output"),
                    new SimpleStringEncoder < Tuple5 < String, String, String, Integer, Integer >> ("UTF-8"))
            .withRollingPolicy(DefaultRollingPolicy.builder().build())
            .build());
    // execute program
    env.execute("Avg Profit Per Month");
  }

  public static class Reduce1 implements ReduceFunction < Tuple5 < String, String, String, Integer, Integer >> {
    public Tuple5 < String,
            String,
            String,
            Integer,
            Integer > reduce(Tuple5 < String, String, String, Integer, Integer > current,
                             Tuple5 < String, String, String, Integer, Integer > pre_result) {
      return new Tuple5 < String, String, String, Integer, Integer > (current.f0,
              current.f1, current.f2, current.f3 + pre_result.f3, current.f4 + pre_result.f4);
    }
  }
  public static class Splitter implements MapFunction < String, Tuple5 < String, String, String, Integer, Integer >> {
    public Tuple5 < String,
            String,
            String,
            Integer,
            Integer > map(String value) // 01-06-2018,June,Category5,Bat,12
    {
      // print value in console
      System.out.println(value);
      String[] words = value.split(","); // words = [{01-06-2018},{June},{Category5},{Bat}.{12}
      System.out.println(words[1]);
      // ignore timestamp, we don't need it for any calculations
      //Long timestamp = Long.parseLong(words[5]);
      return new Tuple5 < String, String, String, Integer, Integer > (words[1], words[2], words[3], Integer.parseInt(words[4]), 1);

    } //    June    Category5      Bat                      12
  }
}
