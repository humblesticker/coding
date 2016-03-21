import java.util.*;

public class BridgeSort {
	public String sortedHand(String s) {
		String suits = "CDHS", values = "23456789TJQKA";

		List<Integer> cards = new ArrayList<Integer>();
		for(int i=0; i<s.length(); i+=2) {
			cards.add(suits.indexOf(s.charAt(i))*13 + values.indexOf(s.charAt(i+1)));
		}

		Collections.sort(cards); 

		StringBuilder b = new StringBuilder();
		for(int card : cards) b.append("" + suits.charAt(card/13) + values.charAt(card%13));
		return b.toString();
	}
}
