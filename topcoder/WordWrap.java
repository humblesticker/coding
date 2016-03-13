import java.util.*;

public class WordWrap {
	public String[] justify(String[] lines, int width) {
		List<String> tokens = new ArrayList<String>();
		for(String line : lines) 
			for(String token : line.split(" ")) tokens.add(token);

		String line = tokens.get(0); List<String> justified = new ArrayList<String>();
		for(int i=1; i<tokens.size(); i++) {
			String test = line + " " + tokens.get(i);
			if(test.length() > width) {
				justified.add(line); line = tokens.get(i);
			} else {
				line = test;
			}
		}

		if(line.length() > 0) justified.add(line);
		return justified.toArray(new String[justified.size()]);
	}
}