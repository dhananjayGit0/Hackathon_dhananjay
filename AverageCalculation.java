import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class AverageCalculation {
	ArrayList<Double> value = new ArrayList<Double>();
	double avg;
	double max;
	
	void fileToString() {
		int i;
		try {
			FileReader readfile = new FileReader("D:\\Hackathon\\Memory.txt");
			BufferedReader readbuffer = new BufferedReader(readfile);

			for (i = 1; i <= 1876; i++) {
				if (i % 2 == 0) {
					String data = readbuffer.readLine().strip();
					String val[] = data.split(" ");

					Double no = Double.parseDouble(val[3].strip());
					double d = no / 1000;
					double a = Math.floor(d * 100) / 100;

					value.add(a);
				} else
					readbuffer.readLine();
			}
			//added comment
			//kya bawal hai ye
			readbuffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void calculateAverage() {
		double total = 0;
		for(int i = 0; i < value.size(); i++) {
			total += value.get(i);
		}
		
		
		avg = total / value.size();
		
		DecimalFormat df = new DecimalFormat("#.##");
		avg = Double.parseDouble(df.format(avg));
		System.out.println(avg);
	}
	
	void calculateMaximum() {
		max = value.get(0);
		for(int i = 1; i < value.size(); i++) {
			if(value.get(i) > max) {
				max = value.get(i);
			}
		}
		System.out.println(max);
	}
	
}
