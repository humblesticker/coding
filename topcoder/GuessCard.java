import java.util.*;

public class GuessCard {
	int[][] convert(int[][] cards) {
		int count = 0, w = cards[0].length, h = cards.length;
		int[][] converted = new int[h][w]; 
		for(int j=0; j<w; j++) for(int i=0; i<h; i++) { converted[count/w][count%w] = cards[i][j]; count++; }
		return converted;
	}

	int[][] init(int w, int h) {
		int[][] cards = new int[h][w]; int count = 0;
		for(int i=0; i<h; i++) for(int j=0; j<w; j++) cards[i][j] = ++count;
		return cards;
	}

	Set<Integer> column(int[][] cards, int col) {
	    int w = cards[0].length, h = cards.length;
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0; i<h; i++) for(int j=0; j<w; j++) if(j==col) set.add(cards[i][j]);
		return set;
	}

	public int whichRow(int w, int h, int[] columns) {
		int[][] cards = init(w, h);
		Set<Integer> set = column(cards, columns[0]);
		
		for(int i=1; i<columns.length; i++) {
			cards = convert(cards);
			Set<Integer> local = column(cards, columns[i]);
		 	set.retainAll(local);
		}
		
		if(set.size() == 1) {
			int v = set.iterator().next();
			for(int i=0; i<h; i++) for(int j=0; j<w; j++) if(cards[i][j] == v) return i;
		}
		return -1;
	}
}		