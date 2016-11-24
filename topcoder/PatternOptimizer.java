public class PatternOptimizer {
	public String optimize(String p) {
		int len = p.length(), star = 0, question = 0; 
		StringBuilder b = new StringBuilder();
		
		for(int i=0; i<len; i++) {
			char c = p.charAt(i);
			if(Character.isLetter(c)) b.append(c);
			else { if(c == '*') star++; if(c == '?') question++; }
			
			if(i+1 >= len || Character.isLetter(p.charAt(i+1))) {
				if(star > 0) { b.append('*'); star = 0; }
				while(question > 0) { b.append('?'); question--; }
			}
		}
		
		return b.toString();
	}
}