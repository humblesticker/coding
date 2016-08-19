/*
DP ?
*/
public class ColorfulRoad {
	char[] parts = null;
	int min = Integer.MAX_VALUE;

	char getNext(char cur) {
		if(cur == 'R') return 'G';
		if(cur == 'G') return 'B';
		return 'R';
	}
	
	void walk(int ci, int pi, int cost, char next) {
		if(ci >= parts.length) return;

		char c = parts[ci]; 
		if(c == next) {
			int updated = cost + (ci-pi)*(ci-pi); 
			if(ci == parts.length-1) { min = Math.min(min, updated); return; }
			walk(ci+1, ci, updated, getNext(next));
		}
		walk(ci+1, pi, cost, next);
	}

	public int getMin(String road) {
		parts = road.toCharArray();
		walk(1, 0, 0, 'G');
		return min == Integer.MAX_VALUE ? -1 : min;
	}
}