public class Hyphenated {
	private void join(String[] lines) {
		for(int i=1; i<lines.length; i++) {
			String prev = lines[i-1], cur = lines[i]; 
			if(prev.charAt(prev.length()-1) == '-' && Character.isLetter(cur.charAt(0))) {
				lines[i] = prev.substring(0, prev.length()-1) + cur; 
				lines[i-1] = "";
			}
		}
	}
	
	public double avgLength(String[] lines) {
		join(lines);
		int count = 0, sum = 0;
		for(String l : lines) 
			for(String t : l.split("[ \\.-]")) if(!"".equals(t)) { sum += t.length(); count++; }
		return (double)sum/count;
	}
}