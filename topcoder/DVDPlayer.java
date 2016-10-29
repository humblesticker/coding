import java.util.*;

public class DVDPlayer {
	public String[] findMovies(String[] watched) {
		String in = watched[0]; 
		Map<String, String> map = new TreeMap<String, String>();
		
		for(int i=1; i<watched.length; i++) {
			String dvd = watched[i];
			if(map.containsKey(dvd)) {
				String dcase = map.get(dvd);
				map.remove(dvd);
				map.put(in, dcase);
			} else map.put(in, dvd);
			in = dvd;
		}

		List<String> list = new ArrayList<String>();
		map.forEach((k,v) -> {
			if(!k.equals(v)) list.add(String.format("%s is inside %s's case", k, v));
		});
		return list.toArray(new String[0]);
	}
}
/*
dvd, case map
begin with first dvd as in
dvd from 2nd to last
	if(map contains dvd) 
		case = map(dvd)
		remove dvd from map
		add in, case
	else
		add in, dvd
		
	in = dvd
		
get keys sorted and print
*/