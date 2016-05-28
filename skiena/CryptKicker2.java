import java.util.*;

public class CryptKicker2 {
	private static String KNOWN = "the quick brown fox jumps over the lazy dog";
	
	private static char[] check(String encrypted) {
		if(KNOWN.length() != encrypted.length()) return null;

		char[] map = new char[26];
		for(int i=0; i<KNOWN.length(); i++) {
			char s = KNOWN.charAt(i), d = encrypted.charAt(i); 
			if(s == ' ') if(d == ' ') continue; else return null;

			char c = map[s-'a']; if(c == '\0') map[s-'a'] = d;
			if(c != d) return null;
		}
		return map;
	}

	private static String decrypt(char[] a, char[] map) {
		for(int i=0; i<a.length; i++) a[i] = map[a[i]-'a'];
		return new String(a);
	}

	private static char[] decrypt(List<String> list) {
		char[] map = null;
		for(String s : list) { map = check(s); if(map != null) break; }
		return map;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = Integer.parseInt(s.nextLine()); s.nextLine();
		while(N > 0) {
			List<String> list = new ArrayList<String>();
			while(s.hasNextLine()) {
				String line = s.nextLine(); if(line.length() == 0) break;
				list.add(line);	
			}

			char[] map = decrypt(list); 
			if(map == null) System.out.println("No solution.");
			else for(String line : list) System.out.println(decrypt(line.toCharArray(), map));
			N--; if(N > 0) System.out.println();
		} 
	}
}