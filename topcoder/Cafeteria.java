public class Cafeteria {
	String to(int n) { return n<10 ? "0" + n : "" + n; }
	String format(int min) {
		int h = min/60; if(h>12) h %= 12;
		return to(h) + ":" + to(min%60);
	} 
	int adjust(int n, int offset) {
		int r = n%10; if(r < offset) n -= 10;
		return n - r + offset;
	}
	public String latestTime(int[] offset, int[] wts, int[] dts) {
		int max = Integer.MIN_VALUE;
		for(int i=0; i<offset.length; i++) {
			int min = 870 - dts[i]; min = adjust(min, offset[i]) - wts[i];
			max = Math.max(max, min);
		}
		return format(max); 
	}
}