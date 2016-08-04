/*
1. start mode
2. Integer parse limit
 */
import java.util.*;

public class ParameterSubstitution {
	String translate(String str, String[] params) {
		int max = Math.min(2, str.length());
		for(int i=max; i>0; i--) {
			int num = Integer.parseInt(str.substring(0, i));
			if(num-1 < params.length) return params[num-1] + str.substring(i);
		}
		return '$' + str;
	}
	
	public String processParams(String code, String[] params) {
		int start = -1, len = code.length(); StringBuilder b = new StringBuilder();		
		
		for(int i=0; i<len; i++) {
			char c = code.charAt(i); 
			
			if(c == '$' && i+1 < len) {
				char n = code.charAt(i+1);
			 	if(Character.isDigit(n) && Character.getNumericValue(n) > 0) { 
					start = i+1; continue; 
				}
			}
			
			if(start >= 0) {
				if(i+1 >= len || !Character.isDigit(code.charAt(i+1))) {
					String t = translate(code.substring(start, i+1), params);
					b.append(t); start = -1; continue; 
				}
			} else b.append(c);
		}
		return b.toString();
	}
}