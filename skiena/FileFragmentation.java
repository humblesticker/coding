import java.util.*;

public class FileFragmentation {
	private static int getLength(List<String> fragments) {
		if(fragments.size() == 0) return 0;
		int total = 0; for(String s : fragments) total += s.length();
		return 2*total/fragments.size();
	}

	private static Map<Integer, Set<String>> buildMap(List<String> list) {
		Map<Integer, Set<String>> map = new HashMap<Integer, Set<String>>();
		for(String s : list) {
			int len = s.length(); if(!map.containsKey(len)) map.put(len, new HashSet<String>());
			map.get(len).add(s);
		}
		return map;
	}

	private static Set<String> getCombs(Set<String> left, Set<String> right) {
		Set<String> set = new HashSet<String>();
		for(String l : left) for(String r : right) set.add(l + r);
		for(String r : right) for(String l : left) set.add(r + l);
		return set;
	}

	private static Map<Integer, Set<String>> getCombsMap(Map<Integer, Set<String>> map, int length) {
		Map<Integer, Set<String>> combsMap = new HashMap<Integer, Set<String>>();
		for(int i=1; i<=length/2; i++) 
			if(map.containsKey(i)) combsMap.put(i, getCombs(map.get(i), map.get(length-i)));
		return combsMap;
	}

	private static boolean check(String comb, Map<Integer, Set<String>> map) {
		for (Set<String> set : map.values()) if(!set.contains(comb)) return false;
		return true;
	}

	private static String process(List<String> fragments) {
		int length = getLength(fragments); if(length == 0) return "";
		Map<Integer, Set<String>> map = getCombsMap(buildMap(fragments), length);

		Set<String> set = map.entrySet().iterator().next().getValue();
		for(String comb : set) if(check(comb, map)) return comb;
		return "";
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = Integer.parseInt(s.nextLine()); s.nextLine();

		while(T > 0) {
			List<String> fragments = new ArrayList<String>();
			while(s.hasNext()) {
				String fragment = s.nextLine(); if("".equals(fragment)) break;
				fragments.add(fragment);
			}

			System.out.println(process(fragments));
			T--; if(T > 0) System.out.println();
		}
	}
}