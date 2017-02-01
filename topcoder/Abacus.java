/*
add from least sig
one loop
*/
public class Abacus {
	int read(String s) { return 9 - s.indexOf('-'); }
	String repeat(char c, int n) { String s = ""; while(n-- > 0) s += c; return s; }
	String write(int n) { return repeat('o', 9-n) + "---" + repeat('o', n); }
	
	public String[] add(String[] orig, int val) {
		int carry = 0;
		for(int i=orig.length-1; i>=0; i--) {
			int n = read(orig[i]) + val%10 + carry;
			if(n >= 10) { n -= 10; carry = 1; } else carry = 0;
			orig[i] = write(n);
			val /= 10;
		}
		return orig;
	}
}