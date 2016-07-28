import java.util.*;

public class Mailbox {
	private int pos(char c) {
		if(Character.isDigit(c)) return Character.getNumericValue(c);
		return c-'A'+10;
	}
	
	private boolean possible(String addr, int[] count) {
		for(char c : addr.toCharArray()) {
			if(c == ' ') continue;
			int i = pos(c); if(count[i] == 0) return false;
			count[i]--;
		}
		return true;
	}
	
	public int impossible(String col, String[] addr) {
		int[] colCount = new int[36];
		for(char c : col.toCharArray()) colCount[pos(c)]++;
		
		int count = 0;
		for(String a : addr) if(!possible(a, Arrays.copyOf(colCount, colCount.length))) count++;
		return count;
	}
}		