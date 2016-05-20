public class SpamDetector {
	private boolean matched(String word, String keyword) {
		int i=0, j=0, klen = keyword.length(), wlen = word.length();
		while(i<klen && j<wlen) {
			char c = keyword.charAt(i); int kcount = 0, wcount = 0;
			while(i<klen && keyword.charAt(i) == c) { i++; kcount++; }
			while(j<wlen && word.charAt(j) == c) { j++; wcount++; }
			if(kcount > wcount) return false;
		}
		return i == klen && j == wlen;
	}
	
	public int countKeywords(String subject, String[] keywords) {
		int count = 0;
		for(String s : subject.split("\\s+")) 
			for(String keyword : keywords) 
				if(matched(s.toLowerCase(), keyword.toLowerCase())) { count++; break; }
		return count;
	}
}