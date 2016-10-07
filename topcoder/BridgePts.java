public class BridgePts {
	int suit(int[] hand) {
		int[] count = new int[4];
		for(int h : hand) count[(h-1)/13]++;
		
		int sum = 0; 
		for(int c : count) if(c<3) sum += (3 - c);
		return sum;
	}
	
	int number(int[] hand) {
		int sum = 0;
		for(int h : hand) {
			if(h%13 == 1) sum += 4;
			if(h%13 == 0) sum += 3;
			if(h%13 == 12) sum += 2;
			if(h%13 == 11) sum += 1;
		}
		return sum;
	}
	
	public int pointValue(int[] hand) {
		return suit(hand) + number(hand);
	}
}