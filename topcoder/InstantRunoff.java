
import java.util.*;

public class InstantRunoff {
	// get max if > 50% return candidate with max
	private String candidateOver50(String candidates, String[] ballots) {
		int max = 0, index = -1;
		for(int i=0; i<candidates.length(); i++) {
			char c = candidates.charAt(i);
			int count = 0;
			for(int j=0; j<ballots.length; j++) if(ballots[j].charAt(0) == c) { count++; break; }
			if(count > max) { max = count; index = i; }
		}
		if((double)max/candidates.length() > 0.5) return candidates.substring(index, index+1);
		return "";
	}

	// get candidates with min-top
	private String getMins(String candidates, String[] ballots) {
		// build count array while checking min-tops count
		int[] tops = new int[candidates.length()];
		int min = Integer.MAX_VALUE;
		for(int i=0; i<candidates.length(); i++) {
			char c = candidates.charAt(i);
			for(int j=0; j<ballots.length; j++) if(ballots[j].charAt(0) == c) tops[i]++; 
			if(tops[i] > 0 && tops[i] < min) { min = tops[i]; }
		}
		System.out.println(Arrays.toString(tops));

		// build string
		StringBuilder b = new StringBuilder();
		for(int i=0; i<candidates.length(); i++) if(tops[i] == min) b.append(candidates.charAt(i));
		return b.toString();
	}

	// remove them from candidates and ballots
	private String remove(char c, String candidates, String[] ballots) {
		for(int i=0; i<candidates.length(); i++) 
			if(candidates.charAt(i) == c) { candidates = candidates.substring(0, i) + candidates.substring(i+1);  break; }

		for(int i=0; i<ballots.length; i++) 
		 	for(int j=0; j<ballots[i].length(); j++) 
		 		if(ballots[i].charAt(j) == 'c') { ballots[i] = ballots[i].substring(0, j) + ballots[i].substring(j+1); break; }

		return candidates;
	}

	private String update(String candidates, String[] ballots) {
		String mins = getMins(candidates, ballots);
		System.out.println(mins);
		for(char c : mins.toCharArray()) candidates = remove(c, candidates, ballots);
		return candidates;
	}

	public String outcome(String candidates, String[] ballots) {
		int count = 0;
		do {
			System.out.println(candidates + ":" + candidates.length());
			String c = candidateOver50(candidates, ballots);
			if(c.length() > 0) return c;

			candidates = update(candidates, ballots);
			count++; if(count > 5) break;
		} while(candidates.length() > 0);
		return "";
	}

	public static void main(String[] args) {
		System.out.println((new InstantRunoff()).outcome("ABC", new String[] { "ABC", "ABC", "BAC" }));
	}
}