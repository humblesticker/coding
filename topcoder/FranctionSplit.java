import java.util.*;

public class FractionSplit {
	public String[] getSum(int n, int d) {
		List<String> out = new ArrayList<String>();
		while(n > 0) {
			double f = (double)n/d;
			int i=2; while(1.0/i > f) i++;
			out.add("1/" + i);
			n = n * i - d; d *= i;
		}
		return out.toArray(new String[0]);
	}
}