<<<<<<< HEAD
import java.util.*;

public class TableSeating {
	double expect(int size, int count, double[] expects, int[] probs) {
		double total = 0; int len = count-size;
		for(int i=0; i<=len; i++) {
			total += size;
			if(i>0) total += expects[i];
			if(i<len) total += expects[len-i];
		}
		return total * probs[size] / (len+1);
	}

	double expect(int count, double[] expects, int[] probs) {
		double total = 0.0;
		for(int size=1; size<=count; size++) {
			if(size>=probs.length || probs[size] == 0) continue;
			total += expect(size, count, expects, probs);
		}
		return total/100;
	}
	
	public double getExpected(int tcount, int[] ps) {
		int[] probs = new int[ps.length+1];
		for(int i=1; i<probs.length; i++) probs[i] = ps[i-1];
		
		double[] expects = new double[tcount+1];
		expects[1] = probs[1]/100.0;
		
		for(int count=2; count<=tcount; count++) expects[count] = expect(count, expects, probs);
		return expects[tcount];
	}
}