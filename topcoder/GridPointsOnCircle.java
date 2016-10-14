public class GridPointsOnCircle {
	public int countPoints(int r2) {
		int count = 0; 
		for(int i=0; i*i<r2; i++) 
			if(Math.sqrt(r2 - i*i) % 1 == 0) count++;
		return 4*count;
	}
}