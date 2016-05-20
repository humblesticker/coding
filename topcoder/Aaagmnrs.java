public class Aaagmnrs {
	private String get(String s) {
		char[] array = s.replace(" ", "").toLowerCase().toCharArray();
		Arrays.sort(array);
		return new String(array);	
	}
	
	public String[] anagrams(String[] phrases) {
		List<String> list = new ArrayList<String>();
		Set<String> set = new HashSet<String>();
		
		for(String p : phrases) {
			String s = get(p);
			if(!set.contains(s)) { set.add(s); list.add(p); }
		}
		return list.toArray(new String[0]);
	}
}