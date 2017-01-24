import java.util.*;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(s == null || numRows <= 1) return s;
        
        StringBuilder[] rows = new StringBuilder[numRows]; 
        for(int i=0; i<rows.length; i++) rows[i] = new StringBuilder();
        
        int incr = 1, r = 0;
        for(int i=0; i<s.length(); i++) {
            rows[r].append(s.charAt(i));

            if(r == 0) incr = 1;
            if(r == rows.length-1) incr = -1;
            r += incr;
        }
        
        s = "";
        for(StringBuilder row : rows) s += row;
        return s;
    }
}