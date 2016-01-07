/* 
	Y is vowel
		if not EY
		if not YHO
		
	upper and lower case letters


*/
public class WordForm {
	private char get(String word, int i) {
		word = word.toLowerCase();
		String c = "" + word.charAt(i); 
		if("aeiou".contains(c)) return 'V';

		if("y".equals(c) && i > 0 && get(word, i-1) != 'V') return 'V';
		return 'C';
	}

	public String getSequence(String word) {
		StringBuilder b = new StringBuilder();
		char prev = get(word, 0);
		b.append(prev);

		for(int i=1; i<word.length(); i++) {
			char c = get(word, i);
			if(c != prev) b.append(c);
			prev = c;
		}
		
		return b.toString();
	}
}

	