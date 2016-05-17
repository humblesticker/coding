public class GravityBomb {	
	public String[] aftermath(String[] g) {
		int clen = g[0].length(), rlen = g.length; int[] counts = new int[clen];
		for(int i=0; i<rlen; i++) 
			for(int j=0; j<clen; j++) if(g[i].charAt(j) == 'X') counts[j]++;
		
		int min = 1000; 
		for(int i=0; i<clen; i++) min = Math.min(min, counts[i]);
		
		char[][] grid = new char[rlen][clen];
		for(int i=0; i<rlen; i++) 
			for(int j=0; j<clen; j++) grid[i][j] = (i < rlen - counts[j] + min ? '.' : 'X');
		
		String[] out = new String[rlen];
		for(int i=0; i<rlen; i++) out[i] = new String(grid[i]);
		return out;
	}
}