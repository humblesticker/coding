/*
	first 5 only if more than 5 in order
	if tie
		compare 6th, if none, team with 6th wins
		by alphabetical order

	sort

*/
import java.util.*;

public class CrossCountry {
	// 0 = 'A', 25 = 'Z'
	class Team implements Comparable<Team> {
		public char name;
		public List<Integer> finish = new ArrayList<Integer>();
		public int first5;
		public Team(char n) { name = n; }

		@Override
		public int compareTo(Team team) {
			if(this.first5 == team.first5) {
				int size = this.finish.size(), osize = team.finish.size();

				if(size < 6 && osize < 6) // both doesn't have 6th
					return Character.compare(this.name, team.name);
				else if(size >= 6 && osize >= 6) // both has 6th
					return Integer.compare(this.finish.get(5), team.finish.get(5));
				else // only one of them has 6th
					return Integer.compare(osize, size);
			} else {
				return Integer.compare(this.first5, team.first5);
			}
		}
	}

	public String scoreMeet(int n, String finish) {
		Team[] teams = new Team[26]; 
		for(int i=0; i<26; i++) teams[i] = new Team((char)('A' + i));

		for(int i=0; i<finish.length(); i++) {
			Team team = teams[finish.charAt(i) - 'A'];
			team.finish.add(i+1);
			if(team.finish.size() <= 5) team.first5 += (i+1); 
		}

		// filter out size() < 5
		List<Team> list = new ArrayList<Team>();
		for(int i=0; i<teams.length; i++) if(teams[i].finish.size() >= 5) list.add(teams[i]);

		// sort 
		Collections.sort(list);

		// print
		StringBuilder b = new StringBuilder();
		for(Team team : list) b.append(team.name);
		return b.toString();
	}
}