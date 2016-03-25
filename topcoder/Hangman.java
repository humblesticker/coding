import java.util.*;

public class Hangman {
	private boolean matching(String feedback, String word) {
		if(feedback.length() != word.length()) return false; 
		for(int i=0; i<word.length(); i++) {
			char w = word.charAt(i), f = feedback.charAt(i);
			if(feedback.indexOf(w) >= 0) { if(w != f) return false; } 
			else { if(f != '-') return false; }
		}
		return true;
	}

	public String guessWord(String feedback, String[] words) {
		List<String> list = new ArrayList<String>();
		for(String word : words) if(matching(feedback, word)) list.add(word);

		if(list.size() == 1) return list.get(0);
		return "";
	}
}