/*
alternatively you can do
only update ace pos

if < n or >= len-n no change

if < h move forward pos + pos - n + 1 
else move backward pos - (h-n) + (pos-h) 

if - swap 
*/
import java.util.*;

public class Shuffling {
	List<Integer> shuffle(List<Integer> cards, int n) {
		int len = cards.size(), h = len/2;
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<n; i++) list.add(cards.get(i));
		for(int i=n; i<h; i++) { list.add(cards.get(h + i - n)); list.add(cards.get(i)); }
		for(int i=len-n; i<len; i++) { list.add(cards.get(i)); }
		return list;
	}
	
	void swap(List<Integer> list) {
		int h = list.size()/2;
		for(int i=0; i<h; i++) {
			int temp = list.get(i);
			list.set(i, list.get(i+h));
			list.set(i+h, temp);
		}
	}
		
	public int position(int cards, int[] shuffles) {
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<cards; i++) list.add(i);
		
		for(int n : shuffles) { 
			if(n<0) { swap(list); n = -n; }
			list = shuffle(list, n);
		}
		
		for(int i=0; i<list.size(); i++) if(list.get(i) == 0) return i;
		return -1;
	}
} 	