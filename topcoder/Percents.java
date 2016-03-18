import java.text.*;

public class Percents {
	public int minSamples(String p) {
		NumberFormat formatter = new DecimalFormat("00.00");   
		double percent = Double.parseDouble(p.substring(0, 5));
		
		for(int d=1; d<=10000; d++) {
			double yc = percent*d/100;
			int start = (int)Math.floor(yc), end = (int)Math.ceil(yc);
			
			for(int y=start; y<=end; y++) {
				double num = Math.round(10000.0*y/d) / 100.0;
				if(p.equals(formatter.format(num) + "%")) return d;
			}
		}
		
		return -1;
	}
}