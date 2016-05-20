import java.util.*;

public class RegularSeason {
	private class Team implements Comparable<Team>{
		String name; int score = 0;
		Team(String n) { name = n; }

		public int compareTo(Team other) {
    		if(score == other.score) return name.compareTo(other.name);
    		return Integer.compare(other.score, score);
		}
	}

	private Team get(String s, int home, int[] scores, int rounds) {
		String[] tokens = s.split(" "); Team team = new Team(tokens[0]);

		for(int i=1; i<tokens.length; i++) {
			int away = i-1; if(away == home) continue;

			int p = Integer.parseInt(tokens[i]);
			scores[home] += p*rounds; scores[away] += (100-p)*rounds; 
		}
		return team;
	}

	public String[] finalStandings(String[] strs, int rounds) {
		Team[] teams = new Team[strs.length]; int[] scores = new int[strs.length];
		for(int i=0; i<strs.length; i++) teams[i] = get(strs[i], i, scores, rounds);

		for(int i=0; i<strs.length; i++) teams[i].score = scores[i];
		Arrays.sort(teams);

		for(int i=0; i<strs.length; i++) strs[i] = teams[i].name + " " + Math.round(teams[i].score/100.0);
		return strs;
	}
}