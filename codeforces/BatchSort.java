/*
for 20x19 column swap
	check all rows to have <= 2 out of elements from 1 to m
*/
import java.util.*;

public class BatchSort {
	static boolean check(int[][] grid, int c1, int c2) {
		for(int i=0; i<grid.length; i++) {
			int count = 0;
			for(int j=0; j<grid[i].length; j++) {
				int col = j; 
				if(j == c1) col = c2;
				if(j == c2) col = c1;
				if(grid[i][col] != j+1) { count++; if(count > 2) return false; }
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(), m = s.nextInt();
		int[][] grid = new int[n][m];
		for(int i=0; i<n; i++) for(int j=0; j<m; j++) grid[i][j] = s.nextInt();

		for(int i=0; i<m; i++) 
			for(int j=i; j<m; j++)
				if(check(grid, i, j)) { System.out.println("YES"); return; }
		System.out.println("NO");
	}
}