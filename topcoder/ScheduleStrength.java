import java.util.*;

public class ScheduleStrength {
	class Team implements Comparable<Team> {
		String name; double wp; Team(String n, double w) { name = n; wp = w; }
		public int compareTo(Team other) {
			if(wp == other.wp) return name.compareTo(other.name);
			return Double.compare(other.wp, wp);
		}
	}

	double getWP(int team, String[] results) {
		int w = 0, t = 0; String schedule = results[team];
		for(int i=0; i<schedule.length(); i++) {
			if(schedule.charAt(i) == '-') continue;

			String result = results[i];
			for(int j=0; j<result.length(); j++) {
				char c = result.charAt(j);
				if(j == team || c == '-') continue;
				t++; if(c == 'W') w++; 
			}
		}
		return (double)w/t;
	}
	
	public String[] calculate(String[] names, String[] results) {
		Team[] teams = new Team[names.length];
		for(int i=0; i<teams.length; i++) teams[i] = new Team(names[i], getWP(i, results));
		Arrays.sort(teams);
		return Arrays.stream(teams).map(t -> t.name).toArray(String[]::new);
	}
}