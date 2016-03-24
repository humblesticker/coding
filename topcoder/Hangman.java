/*
	for each word in words
		compare with feedback 
			if - skp
			else match
		if matched update matched and count++
		if count > 1 return ""
	if count == 0 return matched
	else reutrn ""
*/
public class Hangman {
	private boolean matched(String feedback, String word) {
		if(feedback.length() != word.length()) return false;
		for(int i=0; i<feedback.length(); i++) {
			char f = feedback.charAt(i), w = word.charAt(i);
			if(f == '-') { if(feedback.indexOf(w) >= 0) return false; }
			else if(f != word.charAt(i)) return false;
		}
		return true;
	}
	
	public String guessWord(String feedback, String[] words) {
		int count = 0; String matched = "";
		for(String word : words) {
			if(matched(feedback, word)) { matched = word; count++; }
			if(count > 1) return "";
		}
		if(count == 1) return matched;
		else return "";
	}
}