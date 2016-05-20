import java.util.*;

public class Doublets {
	int min = Integer.MAX_VALUE; 
	List<Integer> minPath = null;

	// map is sorted doublets for each dict
	private void getmin(int src, int dest, Map<Integer, List<Integer>> map, List<Integer> path) {
		if(src == dest) { 
			path.add(dest); 
			if(path.size() < min) { min = path.size(); minPath = path; }
			return;
		}

		path.add(src);
		for(int i : map.get(src)) {
			if(i > dest) break;
			getmin(i, dest, map, path);
		}
	}

	private static boolean doublet(String s1, String s2) {
		if(s1.length() != s2.length()) return false;
		int diff = 0;
		for(int i=0; i<s1.length(); i++) if(s1.charAt(i) != s2.charAt(i)) diff++;
		return diff == 1;
	}

	// build index of all doublets ~ n^2
	private static Map<Integer, List<Integer>> getmap(List<String> dict) {
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for(int i=0; i<dict.size(); i++) {
			List<Integer> list = new ArrayList<Integer>();
			for(int j=i+1; j<dict.size(); j++) if(doublet(dict.get(i), dict.get(j))) list.add(j);
			map.put(i, list);
		}
		return map;
	}

	private static int find(String s, List<String> list) {
		for(int i=0; i<list.size(); i++) if(s.equals(list.get(i))) return i;
		return -1;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		List<String> dict = new ArrayList<String>();
		while(s.hasNextLine()) {
			String line = s.nextLine(); if("".equals(line)) break;
			dict.add(line);
		}

		while(s.hasNext()) {
			Doublets d = new Doublets();
			d.getmin(find(s.next(), dict), find(s.next(), dict), getmap(dict), new ArrayList<Integer>());
			if(d.minPath == null) System.out.println("No solution");
			else for(int i : d.minPath) System.out.println(dict.get(i)); 

			if(s.hasNext()) System.out.println();
		}
	}
}	