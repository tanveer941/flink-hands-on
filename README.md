# flink-hands-on
Learn Flink and its underlying usage with examples

## WordCount Application
This is a simple WordCount application that reads text from a file, counts the occurrences of each word, and prints the results.

### Command to run the application locally
```mvn clean package
```
```/Users/tanveem/flink-test/flink-1.19.1/bin/flink run -c p1.WordCount /Users/tanveem/non_work/builder_winner_git/flink-hands-on/flink-hand-os/target/WordCount-0.0.1-SNAPSHOT.jar --input /Users/tanveem/non_work/builder_winner_git/flink-hands-on/flink-hand-os/wc.txt --output /Users/tanveem/non_work/builder_winner_git/flink-hands-on/flink-hand-os/output
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