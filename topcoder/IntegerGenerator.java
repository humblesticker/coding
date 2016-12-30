/*
boolean array 0 ~ 9
check(n)
	if all digits are valid
	
if start is invalid return invalid
while 
	check (start+1) if valid return
*/
public class IntegerGenerator {
	boolean check(long n, boolean[] allowed) {
		while(n > 0) {
			int d = (int)(n%10); if(!allowed[d]) return false;
			n /= 10;
		}
		return true;
	}
	
	public String nextInteger(int[] allowed, String current) {
		if(current.charAt(0) == '0') return "INVALID INPUT";
		
		boolean[] flag = new boolean[10];
		for(int i : allowed) flag[i] = true;
		
		long n = Long.parseLong(current);
		if(!check(n, flag)) return "INVALID INPUT";
		
		do {
			if(check(++n, flag)) return "" + n;
		} while(n <= Long.MAX_VALUE);
		return ""; // NA
	}
}