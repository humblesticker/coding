import java.util.*;
public class GuessCard {
	public int whichRow(int w, int h, int[] columns) {
		Set<Integer> set = new HashSet<Integer>();
		int[] cards = new int[w*h];
		for(int i=0; i<cards.length; i++) { 
			cards[i] = i+1; if(i%w == columns[0]) set.add(i+1); 
		}
		
		for(int i=1; i<columns.length; i++) {
			Set<Integer> set1 = new HashSet<Integer>();
			int[] cards1 = new int[w*h]; int index = 0;

			for(int col=0; col<w; col++) 
				for(int row=col; row<cards1.length; row+=w) { 
					cards1[index] = cards[row]; 
					if(index%w == columns[i]) set1.add(cards1[index]);
					index++;
		 		}
		 		
		 	set.retainAll(set1);
		 	cards = cards1;
		}
		
		if(set.size() == 1) {
			int v = set.iterator().next(), i=0;
			for(i=0; i<cards.length; i++) if(cards[i] == v) break;
			return i/w;
		}
		return -1;
	}
}
		