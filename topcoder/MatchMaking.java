import java.util.*;

public class MatchMaking {
	private int count(String a1, String a2) {
		int count = 0; 
		for(int i=0; i<a1.length(); i++) if(a1.charAt(i) == a2.charAt(i)) count++;
		return count;
	} 

	private String matched(String wname, String wanswer, String[] mnames, Map<String, String> men) {
		int max = -1; String matched = null;
		for(String mname : mnames) {
			String manswer = men.get(mname); if(manswer == null) continue;
			int local = count(wanswer, manswer);
			if(local > max) { max = local; matched = mname; }
		}
		men.put(matched, null);
		return matched;
	}
	
	public String makeMatch(String[] nw, String[] aw, String[] nm, String[] am, String q) {
		Map<String, String> women = new HashMap<String, String>(), 
			men = new HashMap<String, String>(), map = new HashMap<String, String>();
		for(int i=0; i<nw.length; i++) { women.put(nw[i], aw[i]); men.put(nm[i], am[i]); }
		
		String[] wnames = women.keySet().toArray(new String[nw.length]), 
			mnames = men.keySet().toArray(new String[nm.length]);
		Arrays.sort(wnames); Arrays.sort(mnames);
		
		for(String wname : wnames) 
			map.put(wname, matched(wname, women.get(wname), mnames, men));
		return map.get(q);
	}
}	