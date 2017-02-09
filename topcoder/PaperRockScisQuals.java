/*
5 throws
	P, R, S
2, 1, 0
	first one if tied
	
	
let' see
{"RRRRR","PPPPP","RRRRR","PPPPP"}

simple 
	RRRRR 1
	PPPSR 3

int[] points

i from 0 to len-1
	j from 0 to len-1
		if i==j continue
		update points[i]

get index of first max
*/
public class PaperRockScisQuals {
	int point(char c1, char c2) {
		if(c1 == c2) return 1;
		if(c1 == 'P') return c2 == 'R' ? 2 : 0;
		if(c1 == 'R') return c2 == 'S' ? 2 : 0;
		if(c1 == 'S') return c2 == 'P' ? 2 : 0;
		return 0;
	}

	public int whoPassed(String[] players) {
		int len = players.length;
		int[] points = new int[len];
		for(int i=0; i<len; i++) for(int j=0; j<len; j++) {
			if(i == j) continue;
			points[i] += point(s.charAt(i), s.charAt(j));
		}

		int max = -1, pos = -1;
		for(int i=0; i<len; i++) if(points[i] > max) { max = points[i]; pos = i; }
		return pos; 
	}
}