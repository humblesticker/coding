import java.util.*;

public class MatchMaking {
	private int count(String a1, String a2) {
		int count = 0;
		for(int i=0; i<a1.length(); i++) if(a1.charAt(i) == a2.charAt(i)) count++;
		return count;
	}

	private String match(String wname, String wanswer, String[] mnames, Map<String, String> men) {
		int max = -1; String matched = null;
		for(String m : mnames) {
			if(men.get(m) == null) continue;
			int local = count(wanswer, men.get(m)); if(local > max) { max = local; matched = m; }
		}
		return matched;
	}

	public String makeMatch(String[] nw, String[] aw, String[] nm, String[] am, String name) {
		Map<String, String> men = new HashMap<String, String>(), women = new HashMap<String, String>();
		for(int i=0; i<nw.length; i++) { women.put(nw[i], aw[i]); men.put(nm[i], am[i]); }
		
		String[] wsorted = women.keySet().toArray(new String[women.size()]), 
			msorted = men.keySet().toArray(new String[men.size()]);
		Arrays.sort(wsorted); Arrays.sort(msorted);
		
		Map<String, String> matched = new HashMap<String, String>();
		for(String w : wsorted) {
			String m = match(w, women.get(w), msorted, men);
			matched.put(w, m); men.put(m, null);
		}
		
		return matched.get(name);
	}
}