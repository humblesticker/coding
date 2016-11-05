import java.util.*;

public class BestYahtzeeScore {
	int max = -1;
	
	// tricky
	// 12345, 12346, 12234, 13456
	int straight(int[] rolls) {
		for(int i=1; i<
	}
	
	int best(String rolls) {
		int[] r = new int[5];
		for(int i=0; i<rolls.length(); i++) r[i] = Character.getNumericValue(rolls.charAt(i));
		Arrays.sort(r);
		
		// check best to worst
		if(r[4] == r[0]) return 50;
		int st = straight(r); if(r>0) return r*10;
		if((r[0] == r[2] && r[3] == r[4]) || (r[0] == r[1] && r[2] == r[4])) return 25;
		if(r[3] == r[0] || r[4] == r[1]) return r[0] + r[1] + r[2] + r[3] + r[4];
		return 0;
	}
		
	void comb(String rolls, String chosen, String rest, boolean last) {
		if(rolls.length() == 0) {
			int len = 5 - chosen.length(); rolls = chosen + rest.substring(0, len);
			if(last) max = Math.max(max, best(rolls));
			else comb(rolls, "", rest.substring(len), true);
			return;
		}
		comb(rolls.substring(1), chosen + rolls.charAt(0), rest, last);
		comb(rolls.substring(1), chosen, rest, last);
	}

	public int bestScore(String rolls) {
		comb(rolls.substring(0, 5), "", rolls.substring(5), false);
		return max;
	}
}