# flink-hands-on
Learn Flink and its underlying usage with examples

## WordCount Application
This is a simple WordCount application that reads text from a file, counts the occurrences of each word, and prints the results.

### Command to run the application locally

```angular2html
mvn clean package
```
### Command to run the application on Flink cluster
```angular2html
/Users/tanveem/flink-test/flink-1.19.1/bin/flink run -c p1.WordCount /Users/tanveem/non_work/builder_winner_git/flink-hands-on/flink-hand-os/target/WordCount-0.0.1-SNAPSHOT.jar --input /Users/tanveem/non_work/builder_winner_git/flink-hands-on/flink-hand-os/wc.txt --output /Users/tanveem/non_work/builder_winner_git/flink-hands-on/flink-hand-os/output
```
![img.png](img.png)


## Inner join example 
This example demonstrates how to perform an inner join between two datasets in Flink.
```angular2html
/Users/tanveem/flink-test/flink-1.19.1/bin/flink run -c p1.JoinExample /Users/tanveem/non_work/builder_winner_git/flink-hands-on/flink-hand-os/target/WordCount-0.0.1-SNAPSHOT.jar --input1 file:///Users/tanveem/non_work/builder_winner_git/flink-hands-on/flink-hand-os/person --input2 file:///Users/tanveem/non_work/builder_winner_git/flink-hands-on/flink-hand-os/location --output file:///Users/tanveem/non_work/builder_winner_git/flink-hands-on/flink-hand-os/innerJoinOutput
```

## Left Outer Join Example
This example demonstrates how to perform a left outer join between two datasets in Flink.
```angular2html
/Users/tanveem/flink-test/flink-1.19.1/bin/flink run -c p1.LeftOuterJoin /Users/tanveem/non_work/builder_winner_git/flink-hands-on/flink-hand-os/target/WordCount-0.0.1-SNAPSHOT.jar --input1 file:///Users/tanveem/non_work/builder_winner_git/flink-hands-on/flink-hand-os/person --input2 file:///Users/tanveem/non_work/builder_winner_git/flink-hands-on/flink-hand-os/location --output file:///Users/tanveem/non_work/builder_winner_git/flink-hands-on/flink-hand-os/LeftOuterJoinOutput
```

## Right Outer Join Example
This example demonstrates how to perform a right outer join between two datasets in Flink.
```angular2html
/Users/tanveem/flink-test/flink-1.19.1/bin/flink run -c p1.RightOuterJoin /Users/tanveem/non_work/builder_winner_git/flink-hands-on/flink-hand-os/target/WordCount-0.0.1-SNAPSHOT.jar --input1 file:///Users/tanveem/non_work/builder_winner_git/flink-hands-on/flink-hand-os/person --input2 file:///Users/tanveem/non_work/builder_winner_git/flink-hands-on/flink-hand-os/location --output file:///Users/tanveem/non_work/builder_winner_git/flink-hands-on/flink-hand-os/RightOuterJoinOutput
```
## Full Outer Join Example
This example demonstrates how to perform a full outer join between two datasets in Flink.
```angular2html
/Users/tanveem/flink-test/flink-1.19.1/bin/flink run -c p1.FullOuterJoin /Users/tanveem/non_work/builder_winner_git/flink-hands-on/flink-hand-os/target/WordCount-0.0.1-SNAPSHOT.jar --input1 file:///Users/tanveem/non_work/builder_winner_git/flink-hands-on/flink-hand-os/person --input2 file:///Users/tanveem/non_work/builder_winner_git/flink-hands-on/flink-hand-os/location --output file:///Users/tanveem/non_work/builder_winner_git/flink-hands-on/flink-hand-os/FullOuterJoinOutput
```

## Streaming WordCount Application
This is a streaming WordCount application that reads text from a socket, counts the occurrences of each word, and prints the results.
### Command to run the streaming application locally
```angular2html
mvn clean package
```
### Command to put the data into the socket
```angular2html
nc -l 9999
```
### Command to run the streaming application on Flink cluster
```angular2html
/Users/tanveem/flink-test/flink-1.19.1/bin/flink run -c streaming.DataStreamAPI /Users/tanveem/non_work/builder_winner_git/flink-hands-on/streaming-data/target/streaming-data-0.0.1-SNAPSHOT.jar
```

### Streaming application to use reduce to calculate Average Profit month wise
```angular2html
/Users/tanveem/flink-test/flink-1.19.1/bin/flink run -c streaming.AverageProfit /Users/tanveem/non_work/builder_winner_git/flink-hands-on/streaming-data/target/streaming-data-0.0.1-SNAPSHOT.jar
```

### Streaming application to use reduce to calculate Aggregation and Average Profit month wise
```angular2html
/Users/tanveem/flink-test/flink-1.19.1/bin/flink run -c streaming.Aggregation /Users/tanveem/non_work/builder_winner_git/flink-hands-on/streaming-data/target/streaming-data-0.0.1-SNAPSHOT.jar
```
Input file is avg1 and output is written in the folder `streaming-data/aggregation_output`

### Iterative Streaming Example
This example demonstrates how to perform iterative streaming in Flink.
```angular2html
/Users/tanveem/flink-test/flink-1.19.1/bin/flink run -c streaming.IterateDemo /Users/tanveem/non_work/builder_winner_git/flink-hands-on/streaming-data/target/streaming-data-0.0.1-SNAPSHOT.jar
```
## Windowing

### Tumbling Window Example for Processing Time
This example demonstrates how to use windowing in Flink to calculate the average profit over a sliding window.
```angular2html
/Users/tanveem/flink-test/flink-1.19.1/bin/flink run -c main.java.tumbling.AverageProfitTumblingProcessing /Users/tanveem/non_work/builder_winner_git/flink-hands-on/windowing-stream/target/windowing-stream-0.0.2-SNAPSHOT.jar
```
Run the above command and then run the following command to send data to the socket:
```angular2html
src/main/java/tumbling/DataServerProcessingTime.java in the IntelliJ project
```
