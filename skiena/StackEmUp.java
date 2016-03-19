/*
	int[] set
		1: 0 to 51
		2: 52 to 103

	int[] applied
		1, 2

	int[] deck = initialized as 1 to 52
	for i=0 to applied.length-1
		apply(deck, set, appplied[i])

	apply
		for i=0 to deck.length-1
			deck[i] = deck[shuffle[i]]
		
*/
import java.util.*;

public class StackEmUp {
	private static int[] apply(int[] deck, int[] shuffle) {
		int[] shuffled = new int[53];
		for(int i=1; i<deck.length; i++) shuffled[i] = deck[shuffle[i]];
		return shuffled;
	}

	private final static String[] values = new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
	private static String value(int i) {
		return values[(i-1)%13];
	}

	private final static String[] suits = new String[] { "Clubs", "Diamonds", "Hearts", "Spades" };
	private static String suit(int i) {
		return suits[(i-1)/13];
	}

	private static void print(int[] deck) {
		//System.out.println(Arrays.toString(deck));
		for(int i=1; i<deck.length; i++) System.out.println(value(deck[i]) + " of " + suit(deck[i]));
	}

	private static int[] newDeck() {
		int[] deck = new int[53];
		for(int i=1; i<deck.length; i++) deck[i] = i;
		return deck;
	}

	private static int[][] getShuffles(Scanner s, int n) {
		int[][] sets = new int[n+1][53];
		for(int i=1; i<sets.length; i++) { 
			for(int j=1; j<53; j++) {
				sets[i][j] = s.nextInt();
 			}
 		}
		return sets;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = Integer.parseInt(s.nextLine()); s.nextLine(); 

		while(t > 0) {
			int[][] sets = getShuffles(s, s.nextInt()); s.nextLine();
			//for(int i=1; i<sets.length; i++) System.out.println(Arrays.toString(sets[i]));

			List<Integer> applied = new ArrayList<Integer>();
			while(s.hasNextLine()) {
				String line = s.nextLine();
				if("".equals(line)) break;
				applied.add(Integer.parseInt(line));
			}
			//for(int i=0; i<applied.size(); i++) System.out.println(applied.get(i));

			int[] deck = newDeck();
			for(int i=0; i<applied.size(); i++) deck = apply(deck, sets[applied.get(i)]);
			print(deck); if(t > 1) System.out.println();
			t--;
		} 
	}
}