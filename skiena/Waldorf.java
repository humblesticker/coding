import java.util.*;

public class Waldorf {
	private static boolean checkOne(char[][] grid, char[] word, int is, int js, int rd, int cd) {
		for(int i=0; i<word.length; i++) {
			if(word[i] != grid[is][js]) return false;
			is += rd; js += cd;
		}
		return true;
	}

	private static final int[] directions = new int[] { -1, -1, 0, -1, 1, -1, -1, 0, 1, 0, -1, 1, 0, 1, 1, 1 };

	private static boolean check(char[][] grid, char[] word, int is, int js) {
		if(grid[is][js] != word[0]) return false;
		for(int i=0; i<directions.length; i+=2)
			if(checkOne(grid, word, is, js, directions[i], directions[i+1])) return true;
		return false;
	}

	private static int[] find(char[][] grid, char[] word) {
		for(int i=1; i<grid.length-1; i++) for(int j=1; j<grid[i].length-1; j++) {
			if(check(grid, word, i, j)) return new int[] { i, j };
		}
		return null; // should not happen
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		while(T > 0) {
			s.nextLine();
			int m = s.nextInt(), n = s.nextInt();
			char[][] grid = new char[m+2][n+2];
			for(int i=1; i<=m; i++) grid[i] = ('\0' + s.next().toLowerCase() + '\0').toCharArray();

			int k = s.nextInt();
			for(int i=0; i<k; i++) {
				int[] pos = find(grid, s.next().toLowerCase().toCharArray());
				if(pos == null || pos.length != 2) continue;
				System.out.println(pos[0] + " " + pos[1]);
			}
			T--;
			if(T > 0) System.out.println();
		}	
	}
}

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