/*
collect points
sort by score 
if single winner done
else 
	for all tied get time for the score
	earliest wins
*/
import java.util.*;

public class Winner {
	static class Round {
		String name; int score; Round(String n, int s) { name = n; score = s; }
	}

	static int time(String name, int score, Round[] rounds) {
		int i = 0, current = 0;
		while(i < rounds.length) {
			if(rounds[i].name.equals(name)) {
				current += rounds[i].score; if(current >= score) break;
			}
			i++;
		}
		//System.out.println(name + ":" + i);
		return i;
	}

	public static void main(String[] args) {
		Map<String, Integer> players = new HashMap<String, Integer>();
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(); 

		Round[] rounds = new Round[n]; int i = 0;
		while(i < n) {
			String name = s.next(); int score = s.nextInt();
			rounds[i++] = new Round(name, score);

			if(!players.containsKey(name)) players.put(name, score);
			else players.put(name, players.get(name)+score);
		}

		List<String> names = new ArrayList<String>(); int max = Integer.MIN_VALUE;
		for(Map.Entry<String, Integer> e : players.entrySet()) {
			int value = e.getValue(); 
			if(value > max) { max = value; names = new ArrayList<String>(); names.add(e.getKey()); }
			else if(value == max) { names.add(e.getKey()); }
		}
		
		if(names.size() == 1) System.out.println(names.get(0));
		else {
			int min = Integer.MAX_VALUE; String winner = "";
			for(String name : names) {
				int local = time(name, max, rounds); if(local < min) { min = local; winner = name; }
			}
			System.out.println(winner);
		}
	}
}