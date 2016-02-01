public class CombinationLock {
	private int move(boolean counter, int diff, int size) {
		if((counter && diff > 0) || (!counter && diff < 0)) return Math.abs(diff);
		return size - Math.abs(diff);
	}

	public double degreesTurned(int[] combo, int size, int start) {
		boolean counter = true; int N = combo.length, rotates = 0, moves = 0;
		for(int i=0; i<combo.length; i++) {
			rotates += N; moves += move(counter, combo[i] - start, size);
			start = combo[i]; N--; counter = !counter;
		}
		return rotates*360.0 + moves*360.0/size;
	}
}