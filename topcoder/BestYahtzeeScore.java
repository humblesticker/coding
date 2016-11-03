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
		
		int st = 1, stBorder = 0, kind = 1, sum = r[0], border = 0; 
		for(int i=1; i<r.length; i++) {
			if(r[i] == r[i-1] + 1) st++; 
			else if(r[i] > r[i-1] + 1) stBorder = i;
			// same just continue e.g 12334

			if(r[i] == r[i-1]) kind++; else border = i;
			sum += r[i];
		}
		
		// check best to worst
		if(border == 0) return 50;
		if(st == 5) return 40;
		if(st == 4 && (stBorder != 2 && stBorder != 3)) return 30;
		if(kind == 4) return (border == 2 || border == 3) ? 25 : sum;
		return 0;
	}
		
	void comb(String rolls, String chosen, String rest, boolean last) {
		if(rolls.length() == 0) {
			int len = 5 - chosen.length(); rolls = chosen + rest.substring(0, len);
			if(last) {
				int best = best(rolls);
				//System.out.println(best + "," + rolls);
				max = Math.max(max, best);
			}
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

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println((new BestYahtzeeScore()).bestScore(s.next()));
	}
}