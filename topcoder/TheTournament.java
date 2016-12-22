/*
parse 
both player add game count, only first player for win count
count and win map,
loop keys 
	track max by count and name
*/
import java.util.*;

public class TheTournament {
	class Player implements Comparable<Player> {
		String name; int win; int game; 
		Player(String n) { name = n; }
		public int compareTo(Player other) {
			int rate = win * other.game, orate = other.win * game;
			if(rate == orate) return name.compareTo(other.name);
			return Integer.compare(orate, rate);
		}
	}

	void update(Map<String, Player> map, String name, boolean win) {
		if(!map.containsKey(name)) map.put(name, new Player(name));
		Player p = map.get(name); p.game++; if(win) p.win++;
	}
	
	public String findLeader(String[] matches) {
		Map<String, Player> players = new HashMap<String, Player>();
			
		for(String m : matches) {
			String[] tokens = m.split(" ");
			update(players, tokens[0], true);
			update(players, tokens[2], false);
		}
		
		Player max = new Player(""); max.game = 1;
		for(Map.Entry<String, Player> e : players.entrySet()) {
			Player p = e.getValue();
			if(p.compareTo(max) < 0) max = p;
		}
		return max.name;
	}
}