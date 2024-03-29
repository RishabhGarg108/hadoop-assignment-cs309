package assignment;

import java.io.IOException;
import java.util.*;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class partitionReducer extends Reducer<Text, Text, Text, Text> {

	

	public void reduce(Text category, Iterable<Text> values, Context context
			) throws IOException, InterruptedException {
		Map<String, Long> categoryTotal = new HashMap<String, Long>();

		String strCategory = category.toString();
		if (!categoryTotal.containsKey(strCategory))
			categoryTotal.put(strCategory, 0L);
		
		for (Text val : values){
			// categoryTotal.put(strCategory, 10L);
			categoryTotal.put(strCategory, categoryTotal.get(strCategory) + Long.parseLong(val.toString()));
		}
		for (Map.Entry element : categoryTotal.entrySet())
		{
			String key = (String) element.getKey();
			Long val = (Long) element.getValue();
			String strVal = Long.toString(val);

			Text outputCategory = new Text(key);
			Text outputTotal = new Text(strVal); 
			context.write(outputCategory, outputTotal);

		}
	}
}
