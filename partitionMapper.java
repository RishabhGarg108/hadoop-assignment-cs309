package assignment;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class partitionMapper extends Mapper <IntWritable, Text, Text, LongWritable> {
	private LongWritable total = new LongWritable(0);
	private Text txid = new Text();
	private Text category = new Text();

	public void map(IntWritable key, Text value, Context context) throws IOException, InterruptedException {

		StringTokenizer itr = new StringTokenizer(value.toString());
		long sum = 0L;
		int count = 0;
		
		// Extracting the Transaction ID.
		String id = itr.nextToken();
		txid.set(id.substring(0, id.length() - 1));

		while (itr.hasMoreTokens())
		{
			count += 1;
			sum += Long.parseLong(itr.nextToken());
		}
		
		if (count >= 1 && count <= 10) category.set("class1");
		else if (count >= 11 && count <= 20) category.set("class2");
		else if (count >= 21 && count <= 30) category.set("class3");
		else if (count >= 31 && count <= 40) category.set("class4");
		else if (count >= 41 && count <= 50) category.set("class5");
		
		total.set(sum);

		context.write(category, total);
		
	}
}
