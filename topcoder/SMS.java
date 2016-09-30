public class SMS {
	final String vowels = "aeiouAEIOU";
	
	boolean internal(int pos, String msg) {
		boolean left = false, right = false;

		for(int i=pos-1; i>=0; i--) {
			if(msg.charAt(i) == ' ') return false;
			if(vowels.indexOf(msg.charAt(i)) < 0) { left = true; break; }
		}
		
		for(int i=pos+1; i<msg.length(); i++) {
			if(msg.charAt(i) == ' ') return false;
			if(vowels.indexOf(msg.charAt(i)) < 0) { right = true; break; }
		}
			
		return left && right;
	}
	
	public String compress(String msg) {
		StringBuilder b = new StringBuilder(); 
		for(int i=0; i<msg.length(); i++) 
			if(vowels.indexOf(msg.charAt(i)) < 0 || !internal(i, msg)) b.append(msg.charAt(i));
		return b.toString();
	}
}