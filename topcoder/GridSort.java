public class GridSort {
	boolean check(int[] grid, int row, int m, int[] gap) {
		int max = 0, min = Integer.MAX_VALUE;
		for(int i=0; i<m-1; i++) {
			int pos = i + row*m; if(i+1<m && grid[pos+1] - grid[pos] != gap[i]) return false;
			max = Math.max(max, grid[pos]); min = Math.min(min, grid[pos]);
		}
		return max - min < m;
	}
	
	public String sort(int n, int m, int[] grid) {
		int[] gap = new int[m-1]; 
		for(int i=0; i<m-1; i++) gap[i] = grid[i+1] - grid[i];

		for(int r=1; r<n; r++) 
			if(!check(grid, r, m, gap)) return "Impossible";	
		return "Possible";
	}	
}