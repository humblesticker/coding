public class Aquarium {
	boolean eat(int large, int small) { return large >= 2*small && large <= 10*small; }

	boolean safe(int n, int[] sizes) {
		for(int s : sizes) if(eat(n, s) || eat(s, n)) return false;
		return true;
	}
	
	public int peaceful(int min, int max, int[] sizes) {
		int count = 0; 
		for(int i=min; i<=max; i++) if(safe(i, sizes)) count++;
		return count;
	}
}