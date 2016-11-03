/*
search all ~ 2^15
choose 5 stop. everytime choose one at the end is not available
get max score for 5 dice, update max so far
*/
import java.util.*;

public class BestYahtzeeScore {
	int max = -1;
	
	int best(String rolls) {
		int[] r = new int[5];
		for(int i=0; i<rolls.length(); i++) r[i] = Character.getNumericValue(rolls.charAt(i));
		Arrays.sort(r);
		
		int st = 1, kind = 1, sum = r[0], border = 0; 
		for(int i=1; i<r.length; i++) {
			if(r[i] == r[i-1] + 1) st++; else st = 1;
			if(r[i] == r[i-1]) kind++; else border = i;
			sum += r[i];
		}
		
		// check best to worst
		if(border == 0) return 50;
		if(st == 5) return 40;
		if(st == 4) return 30;
		if(kind == 4) return (border == 2 || border == 3) ? 25 : sum;
		return 0;
	}
	
	
	void check() {
		
	}
	

	public int bestScore(String rolls) {
		search("", 0, rolls, rolls.length());
		return max;
	}
}