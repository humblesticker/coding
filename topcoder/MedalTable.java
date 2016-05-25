import java.util.*;

public class MedalTable {
	private class Country implements Comparable<Country> {
		String code; int[] medals = new int[3];
		Country(String c) { code = c; }
		public int compareTo(Country other) {
			for(int i=0; i<3; i++) 
				if(medals[i] != other.medals[i]) return Integer.compare(other.medals[i], medals[i]);
			return code.compareTo(other.code);
		}
	}

	public String[] generate(String[] results) {
		Map<String, Country> map = new HashMap<String, Country>();
		for(String s : results) {
			String[] ts = s.split(" ");
			for(int i=0; i<3; i++) {
				String code = ts[i];
				if(!map.containsKey(code)) map.put(code, new Country(code)); 
				map.get(code).medals[i]++;
			}
		}
		
		List<Country> list = new ArrayList<Country>();
		for(String code : map.keySet()) list.add(map.get(code));
		Collections.sort(list);
		
		String[] out = new String[list.size()];
		for(int i=0; i<out.length; i++) {
			Country c = list.get(i);
			out[i] = c.code + " " + c.medals[0] + " " + c.medals[1] + " " + c.medals[2];
		}
		return out;
	}
}