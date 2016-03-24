/*
	step 1: max-flow
		initialize map
		while(improvement)
			improvement = false
			for item in map 
				try to find improvement by different map (swap 2 items) 
				update and move to next, improvement = true

		categories
			1 ~ 6: number with bonus if sum of 1 ~ 6 >= 63
			8 ~ 10, 13: of kind (sum for 3 and 4, 50 for 5 of, 40 for full house)
			11 ~ 12: straight (25, 35)
			7: chance

	step 2: consider bonus

*/
import java.util.*;

public class Yahtzee {
	private static int sum(int[] run) {
		int score = 0;
		for(int r : run) score += r;
		return score;
	}

	private static int scoreNumber(int[] run, int number) {
		int score = 0;
		for(int r : run) if(r == number) score += r;
		return score;
	}

	private static int scoreKind(int[] run, int category) {
		int count = 1, max = 0;
		for(int i=1; i<run.length; i++) 
			if(run[i] == run[i-1]) { count++; max = Math.max(max, count); }
			else count = 1;

		if(max >= 3 && category == 8) return sum(run);
		if(max >= 4 && category == 9) return sum(run);
		if(max == 5 && category == 10) return 50;
		return 0;
	}

	private static int scoreFullHouse(int[] run) {
		if(run[0] == run[1] && run[3] == run[4]) 
			if(run[1] == run[2] || run[2] == run[3]) return 40;
		return 0;
	}

	private static int scoreStraight(int[] run, int category) {
		int count = 1;
		for(int i=1; i<run.length; i++) if(run[i] - run[i-1] == 1) count++; else break;
		if(count >= 4 && category == 11) return 25;
		if(count == 5 && category == 12) return 35;
		return 0;
	}

	private static int score(int[] run, int category) {
		if(category >= 1 && category <= 6) return scoreNumber(run, category);
		else if(category >= 8 && category <= 10) return scoreKind(run, category);
		else if(category == 11 || category == 12) return scoreStraight(run, category);
		else if(category == 13) return scoreFullHouse(run);
		else return sum(run);
	}

	// swap if better
	private static boolean swap(int i, int j, int[][] runs, int[] map, int[] scores) {
		int iscore = score(runs[i], map[j]), jscore = score(runs[j], map[i]);
		if(iscore + jscore > scores[map[i]] + scores[map[j]]) {
			int temp = map[i]; map[i] = map[j]; map[j] = temp;
			scores[map[i]] = iscore; scores[map[j]] = jscore;
			System.out.println(Arrays.toString(map) + "," + Arrays.toString(scores));
			return true; 
		}
		return false;
	}

	private static void max(int[][] runs) {
		int[] map = new int[runs.length], scores = new int[runs.length+1];

		// initial map
		for(int i=0; i<runs.length; i++) {
			Arrays.sort(runs[i]);
			scores[i+1] = score(runs[i], i+1); map[i] = i+1;
		}
		System.out.println(Arrays.toString(map) + "," + Arrays.toString(scores));

		// optimize
		boolean improved = true;
		while(improved) {
			improved = false;
			for(int i=0; i<runs.length; i++) {
				for(int j=0; j<runs.length; j++) {
					if(i == j) continue;
					if(swap(i, j, runs, map, scores)) { improved = true; break; }
				}
			}
		}

		int total = 0;
		for(int s : scores) total += s;
		System.out.println(total); 
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNextInt()) {
			int[][] runs = new int[13][5];
			for(int i=0; i<13; i++) for(int j=0; j<5; j++) runs[i][j] = s.nextInt();
			max(runs);
		}
	}
}