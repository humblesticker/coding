import java.util.*;

public class BridgeSort {
	private class Card implements Comparable<Card> {
		char suit;
		char value;
		
		private int toNum(char c) {
			switch(c) {
				case 'T': return 10;
				case 'J': return 11;
				case 'Q': return 12;
				case 'K': return 13;
				case 'A': return 14;
				default: return Character.getNumericValue(c);
			}
		}
		
		public Card(char s, char v) { suit = s; value = v; }
		
		public int compareTo(Card other) {
			if(suit == other.suit) return Integer.compare(toNum(value), toNum(other.value));		
			return Integer.compare(suit, other.suit);
		}
		
		public String toString() {
			return "" + suit + value;
		}
	}
	
	public String sortedHand(String s) {
		List<Card> cards = new ArrayList<Card>();
		for(int i=0; i<s.length(); i+=2) cards.add(new Card(s.charAt(i), s.charAt(i+1)));
		Collections.sort(cards);
		
		StringBuilder b = new StringBuilder();
		for(Card card : cards) b.append(card.toString());
		return b.toString();
	}
}
	