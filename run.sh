javac -d . partitionDriver.java partitionMapper.java partitionReducer.java
jar cfm pd.jar Manifest.txt assignment/*.class
$HADOOP_HOME/bin/hdfs dfs -rm -r /input
$HADOOP_HOME/bin/hdfs dfs -copyFromLocal ./input /
$HADOOP_HOME/bin/hdfs dfs -rm -r /output
$HADOOP_HOME/bin/hadoop jar pd.jar /input /output
$HADOOP_HOME/bin/hdfs dfs -cat /output/part-r-00000
