public class Snowflakes {
	boolean marked(int i, int j, String[] flakes) {
		int len = flakes.length, end = 2*flakes.length-1;
		if(i<len) i = end-i; if(j<len) j = end-j;
		if(j > i) { int t = j; j = i; i = t; }
		return flakes[i-len].charAt(j-len) == '*';
	}	

	public String[] flareOut(String[] flakes) {
		String[] out = new String[2 * flakes.length];
		for(int i=0; i<out.length; i++) {
			out[i] = "";
			for(int j=0; j<out.length; j++) out[i] += marked(i, j, flakes) ? '*' : '.';
		}
		return out;
	}
}
/*
1. for given i, j map that to flakes index
	move to low, right quad and shift to up, left by len

2. process all i, j 
*/