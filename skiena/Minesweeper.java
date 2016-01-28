/*
	for each empty cell check neighbors 
*/
import java.util.*;

public class Minesweeper {
	private int mine(int i, int j, String[] field) {
		if(i >= 0 && i < field.length && j >= 0 && j < field[0].length())
			return field[i].charAt(j) == '*' ? 1 : 0;
		return 0;
	}

	private int count(int row, int col, String[] field) {
		int count = 0;
		for(int i=row-1; i<=row+1; i++) 
			for(int j=col-1; j<=col+1; j++) {
				if(i == row && j == col) continue;
				count += mine(i, j, field);
			}
		return count;
	}

	private String[] process(String[] field) {
		String[] out = new String[field.length];
		for(int i=0; i<field.length; i++) {
			StringBuilder b = new StringBuilder();
			for(int j=0; j<field[i].length(); j++) {
				if(field[i].charAt(j) == '*') b.append('*');
				else b.append(count(i, j, field));
			}

			out[i] = b.toString();
		}
		return out;
	}

	public static void print(String[] field, int number) {
		if(number > 1) System.out.println();
		System.out.println("Field #" + number + ":");
		for(String s : field) System.out.println(s);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Minesweeper sweeper = new Minesweeper();
		int count = 1;
		while(true) {
			int n = s.nextInt(), m = s.nextInt();
			if(n == 0 || m == 0) break;

			String[] field = new String[n];
			for(int i=0; i<n; i++) field[i] = s.next(); 
			print(sweeper.process(field), count++);
		}
	}
}