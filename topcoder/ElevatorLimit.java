public class ElevatorLimit {	
	private boolean check(int current, int[] enter, int[] exit, int limit) {
		for(int i=0; i<exit.length; i++) {
			current -= exit[i]; if(current < 0) return false;
			current += enter[i]; if(current > limit) return false;
		}
		return true;
	}
	
	public int[] getRange(int[] enter, int[] exit, int limit) {
		int low = -1, high = -1;
		for(int i=0; i<=limit; i++) 
			if(check(i, enter, exit, limit)) { low = i; break; }
			
		for(int i=limit; i>=0; i--)
			if(check(i, enter, exit, limit)) { high = i; break; }
			
		if(low < 0 || high < 0) return new int[] {};
		return new int[] { low, high };
	}
}