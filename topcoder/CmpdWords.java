import java.util.*;

public class CmpdWords {
	public int ambiguous(String[] lang) {
		Set<String> set = new HashSet<String>(Arrays.asList(lang)), count = new HashSet<String>();
		
		for(int i=0; i<lang.length; i++) 
			for(int j=0; j<lang.length; j++) 
				if(i != j && !set.add(lang[i] + lang[j])) count.add(lang[i] + lang[j]);
		
		return count.size();
	}
}