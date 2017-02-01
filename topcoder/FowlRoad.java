/*
prev = y[0]
i from 1 to len-1
	if y[i] == ry continue
	if (y[i] - ry)*(prev - ry) < 0 count++
	prev = y[i]
*/
public class FowlRoad {
	public int crossings(int ry, int[] x, int[] y) {
		int count = 0, prev = y[0];
		for(int i=1; i<y.length; i++) {
			if(y[i] == ry) continue; // on road
			if((y[i] - ry)*(prev - ry) < 0) count++; // crossed
			prev = y[i];
		}
		return count;
	}
}