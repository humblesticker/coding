/*
parse get A, B, C and D, E, F
if(AE-BD) == 0
	if(CE - BF) == 0 multi
	else no

x = CE-BF/AE-BD, y = AF-CD/AE-BD
reduce (later) GCD
*/
public class TwoEquations {
	/*
	if number and next is ) -
	*/
	int[] parse(String s) {
		int index = 0; int[] out = new int[3];
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(Character.isDigit(c)) {
				out[index] = c - '0';
				if(i+1 < s.length() && s.charAt(i+1) == ')') out[index] *= -1;
				index++;
			}
		}
		return out;
	}
	
	int GCD(int a, int b) {
		while(true) {
			int r = a%b; if(r == 0) break;
			a = b; b = r;
		}
		return Math.abs(b);
	}
	
	String wrap(int n) {
		if(n < 0) return String.format("(%d)", n);
		return "" + n;
	}
	
	boolean no(int[] f) {
		return f[0] == 0 && f[1] == 0 && f[2] != 0;
	}
	
	public String solve(String first, String second) {
		int[] f = parse(first), s = parse(second);
		int D = f[0]*s[1] - f[1]*s[0], Dx = f[2]*s[1] - f[1]*s[2], Dy = f[0]*s[2] - f[2]*s[0];
		if(no(f) || no(s)) return "NO SOLUTIONS";
		if(D == 0) {
			if(Dx == 0 && Dy == 0) return "MULTIPLE SOLUTIONS";
			else return "NO SOLUTIONS"; 
		}
		
		
		int X1 = Dx, X2 = D, Y1 = Dy, Y2 = D, Gx = GCD(Dx, D), Gy = GCD(Dy, D);
		if(Gx > 1) { X1 /= Gx; X2 /= Gx; } if(X2 < 0) { X2 *= -1; X1 *= -1; }
		if(Gy > 1) { Y1 /= Gy; Y2 /= Gy; } if(Y2 < 0) { Y2 *= -1; Y1 *= -1; }
		return String.format("X=%s/%d Y=%s/%d", wrap(X1), X2, wrap(Y1), Y2);
	}
}
