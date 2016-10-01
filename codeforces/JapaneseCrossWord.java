import java.util.*;

public class JapaneseCrossWord {
	static void encrypt(String s) {
		int count = 0; List<Integer> list = new LinkedList<Integer>();
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == 'W') continue;
			count++; 
			if(count > 0 && (i+1>=s.length() || s.charAt(i+1) == 'W')) { 
				list.add(count); count = 0; 
			} 
		}

		String out = ""; for(int n : list) out += (out.length() > 0 ? " " + n : n)
		System.out.format("%d\n%s\n", list.size(), out);
	} 

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		s.nextInt(); encrypt(s.next());
	}
}