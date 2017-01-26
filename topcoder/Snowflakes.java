public class Snowflakes {
	void expand(int i, int j, char[][] square) {
		int end = square.length - 1;
		square[i][j] = '*';
		square[i][end-j] = '*';
		square[end-i][j] = '*';
		square[end-i][end-j] = '*';
	}
	
	public String[] flareOut(String[] flakes) {
		int flen = flakes.length, len = 2 * flen; 
		char[][] square = new char[len][len];
		for(int i=0; i<len; i++) for(int j=0; j<len; j++) square[i][j] = '.';
			
		for(int i=0; i<flen; i++) for(int j=0; j<flakes[i].length(); j++) 
			if(flakes[i].charAt(j) == '*') { 
				expand(i+flen, j+flen, square); 
				expand(j+flen, i+flen, square); 
			}
		
		String[] out = new String[len];
		for(int i=0; i<len; i++) out[i] = new String(square[i]);
		return out;
	}
}
/*
1. expand tri to square
2. tranform
3. expand to whole
*/