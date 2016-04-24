/*
	2d char array
		sentinel M+2, N+2, to lowercase

	top and left most

	for each char try following if char matches first char
		top-left, top, top-right 
		left, right
		bottom-left, bottom, bottom-right

	top-right: (-1, -1)

	20 x 50x50 x 8x50 ~ 25000000 max

*/
import java.util.*;

public class Waldorf {
	// (row, col) direction
	private static boolean checkOne(char[][] grid, char[] word, int row, int col) {
		return false;
	}

	private static int[] check(char[][] grid, char[] word) {
		return null;
	}

	// all lower cased
	private static int[] find(char[][] grid, char[] word) {
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[i].length; j++) {
				if(grid[i][j] == word[0]) {
					int[] pos = check(grid, word);
					if(pos != null) return pos;
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		while(T > 0) {
			int m = s.nextInt(), n = s.nextInt();
			int[][] grid = new int[m+2][n+2];
			for(int i=1; i<=m; i++) 
			T--;
		}	
	}
}