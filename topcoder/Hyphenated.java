import java.util.*;

public class Hyphenated {
	private List<String> join(String[] lines) {
		List<String> list = new ArrayList<String>(); String prev = lines[0];

		for(int i=1; i<lines.length; i++) {
			if(prev.charAt(prev.length()-1) == '-' && Character.isLetter(lines[i].charAt(0)))
				prev = prev.substring(0, prev.length()-1) + lines[i];
			else { list.add(prev); prev = lines[i]; }
		}
		
		if(prev != null) list.add(prev);
		return list;
	}
	
	public double avgLength(String[] lines) {
		List<String> list = join(lines); int sum = 0, count = 0;
		
		for(String line : list) 
			for(String str : line.split("[ \\.-]")) 
				if(str.length() > 0) { sum += str.length(); count++; }

		return (double)sum/count;
	}
}