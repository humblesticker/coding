import java.util.*;

public class CryptKicker {
	private static boolean duplicate(char dest, char[] map) {
		for(int i=0; i<map.length; i++) if(map[i] == dest) return true;
		return false;
	}

	private static boolean consistent(char src, char dest, char[] map) {
		char mapped = map[src-'a']; 
		if(mapped < 'a') return !duplicate(dest, map);
		return mapped == dest;
	}

	private static char[] consistent(String word, String enc, char[] map) {
		if(word.length() != enc.length()) return null;
		char[] updated = Arrays.copyOf(map, map.length);
		for(int i=0; i<word.length(); i++) 
			if(consistent(word.charAt(i), enc.charAt(i), updated)) updated[word.charAt(i)-'a'] = enc.charAt(i);
			else return null;
		return updated;
	}

	private static char[] decrypt(int level, char[] map, String[] encrypted, String[] words) {
		String enc = encrypted[level];
		for(int i=0; i<words.length; i++) {
			char[] updated = consistent(words[i], enc, map);
			if(updated != null) {
				//System.out.println(level + "," + i + "," + Arrays.toString(updated));
				if(level+1 >= encrypted.length) return updated;
				updated = decrypt(level+1, updated, encrypted, words);
				if(updated != null) return updated;
			}
		}
		return null;
	}

	private static String decode(String line, char[] map) {	
		char[] reverse = new char[26]; for(int i=0; i<reverse.length; i++) reverse[i] = '*';
		if(map != null)
			for(int i=0; i<reverse.length; i++) 
				if(map[i] >= 'a') reverse[map[i]-'a'] = (char)('a' + i);
		
		StringBuilder b = new StringBuilder();
		for(char c : line.toCharArray()) {
			if(c == ' ') b.append(c); 
			else b.append(reverse[c-'a']);
		}
		return b.toString();
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = Integer.parseInt(s.nextLine());
		String[] words = new String[N];
		for(int i=0; i<N; i++) words[i] = s.nextLine();

		while(s.hasNextLine()) {
			String line = s.nextLine();
			String[] encrypted = line.split("\\s+");
			if(encrypted.length == 0) break;

			char[] map = new char[26], updated = decrypt(0, map, encrypted, words);
			System.out.println(decode(line, updated));
		}
	}	
}