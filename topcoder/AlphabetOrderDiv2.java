/*
100 * 100 ~ 10^4
loop words
	check all other words 

map for each words
consistent(w1, map) 
	loop w1
    	if cur < prev (map) return false
        
ac, bc
abc, acb
*/
import java.util.*;

public class AlphabetOrderDiv2 {
    // multiple characters: aba
    int[][] get(String[] words) {
        int[][] orders = new int[words.length][];
        for(int i=0; i<words.length; i++) {
        	orders[i] = new int[26];
            for(int j=0; j<words[i].length(); j++) {
            	int c = words[i].charAt(j) - 'a';
                if(orders[i][c] > 0 && orders[i][c] != j) return null; // continuous same char is fine
                orders[i][c] = j+1; // 1 based
            }
        }
        return orders;
    }
    
    // if one of them 0 not applied
    boolean consistent(String word, int[] order) {
        for(int i=1; i<word.length(); i++) {
            int cur = order[word.charAt(i)-'a'], prev = order[word.charAt(i-1)-'a'];
            if(cur > 0 && prev > 0 && cur < prev) return false;
        }
        return true;
   	}
    
    public String isOrdered(String[] words) {
        int[][] map = get(words); if(map == null) return "Impossible";
        
        int len = words.length;
        for(int i=0; i<len; i++) 
            for(int j=i+1; j<len; j++) if(!consistent(words[i], map[j])) return "Impossible";
        return "Possible";
    }
}