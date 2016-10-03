/*
without custom object and sort?
*/
import java.util.*;

public class Decipher {
	class Item {
		char c; int freq; 
		Item(char c, int f) { this.c = c; freq = f; }
	}
	
	String freq(String[] encoded) {
		int[] count = new int[26];
		for(String s : encoded)
			for(char c : s.toCharArray()) if(Character.isLetter(c)) count[c-'A']++;
		
		Item[] items = new Item[26];
		for(int i=0; i<items.length; i++) items[i] = new Item((char)('A' + i), count[i]);
		Arrays.sort(items, (i1, i2) -> {
			if(i1.freq == i2.freq) return i1.c - i2.c;
			return i2.freq - i1.freq; 	
		});
		
		StringBuilder b = new StringBuilder();
		for(Item item : items) b.append(item.c);
		return b.toString();
	}
	
	String decode(String encoded, String freq, String freqEncoded) {
		char[] array = encoded.toCharArray();
		for(int i=0; i<array.length; i++) {
			if(!Character.isLetter(array[i])) continue;
			int index = freqEncoded.indexOf(array[i]);
			array[i] = freq.charAt(index); 
		}
		return new String(array);
	}
	
	public String[] decipher(String[] encoded, String freq) {
		String freqEncoded = freq(encoded);
		for(int i=0; i<encoded.length; i++) encoded[i] = decode(encoded[i], freq, freqEncoded);
		return encoded;
	}
}