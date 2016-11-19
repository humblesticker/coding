/*
map(name, score)
map(name, round)
map(name, max)	
 */
import java.util.*;

public class Winner {
	static class Player {
		String name; int score; int peak; int peakTime;
		Player(String n) { name = n; }
		void updatePeak(int time) { if(score > peak) { peak = score; peakTime = time; } }
	}

	public static void main(String[] args) {
		Map<String, Player> players = new HashMap<String, Player>();
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(); 
		while(n-- > 0) {
			String name = s.next(); if(!players.containsKey(name)) players.put(name, new Player(name));
			Player p = players.get(name);
			p.score += s.nextInt(); p.updatePeak(n);
		}

		List<Player> list = new ArrayList<Player>(players.values());
		Collections.sort(list, (p1, p2) -> {
			if(p1.score == p2.score) return p2.peakTime - p1.peakTime;
			return p2.score - p1.score;
		});
		System.out.println(list.get(0).name);
	}
}