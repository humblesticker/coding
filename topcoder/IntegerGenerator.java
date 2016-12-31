public class IntegerGenerator {
	int next(int n, boolean[] flag) {
		do { n++; n %= flag.length; } while(!flag[n]);
		return n;
	}

	boolean check(char[] array, boolean[] flag) {
		if(array[0] == '0') return false;
		for(char d : array) if(!flag[d - '0']) return false;
		return true;
	}
	
	public String nextInteger(int[] allowed, String current) {
		boolean[] flag = new boolean[10];
		for(int i : allowed) flag[i] = true;

		char[] array = current.toCharArray();
		if(!check(array, flag)) return "INVALID INPUT";
		
		int d = 0, next = 0;
		for(int i=array.length-1; i>=0; i--) {
			d = array[i] - '0'; next = next(d, flag);
			array[i] = (char)('0' + next); if(next > d) break;
		}

		// add non-zero first allowed digit 
		String out = new String(array); if(next <= d) out = next(0, flag) + out;
		return out;
	}
}