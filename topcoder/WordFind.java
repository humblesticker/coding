/*
for row 0 to rlen
	for col 0 to clen 
		(row, col)
		try down, right, down-right

50x50x50x3 ~ 10^6
*/
public class WordFind {
	boolean find(String w, String[] g, int row, int col, int ri, int ci) {
		for(int i=0; i<w.length(); i++) {
			if(row >= g.length || col >= g[row].length()) return false;
			if(w.charAt(i) != g[row].charAt(col)) return false;
			row += ri; col += ci;
		}
		return true;
	}
	
	boolean find(String w, String[] g, int row, int col) {
		if(w.charAt(0) != g[row].charAt(col)) return false;
		return find(w, g, row, col, 0, 1) 
			|| find(w, g, row, col, 1, 0)
			|| find(w, g, row, col, 1, 1);
	}
	
	String find(String w, String[] g) {
		for(int i=0; i<g.length; i++) 
			for(int j=0; j<g[i].length(); j++) 
				if(find(w, g, i, j)) return i + " " + j;
		return "";
	}
	
	public String[] findWords(String[] g, String[] ws) {
		for(int i=0; i<ws.length; i++) ws[i] = find(ws[i], g);
		return ws;
	}
}
				