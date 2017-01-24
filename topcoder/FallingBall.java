/*
cache
*/
import java.util.*;

public class FallingBall {
	int[][] stored;

	int get(Cell cell) { return stored[cell.row][cell.col]; }
	void save(Cell cell, int n) { stored[cell.row][cell.col] = n; }

	int navigate(Cell cell, Cell target) {
		if(cell.row == target.row) return cell.col == target.col ? 1 : 0;
		if(!cell.path(target)) return 0;

		Cell cell1 = new Cell(cell.row+1, cell.col);
		int n1 = get(cell1); if(n1 < 0) { n1 = navigate(cell1, target); save(cell1, n1); }

		Cell cell2 = new Cell(cell.row+1, cell.col+1);
		int n2 = get(cell2); if(n2 < 0) { n2 = navigate(cell2, target); save(cell2, n2); }
		return n1 + n2;
	}
	
	public int howMany(String[] input, int n) {
		stored = new int[30][30]; 
		for(int i=0; i<30; i++) for(int j=0; j<30; j++) stored[i][j] = -1;

		Cell[] cells = parse(input);
		int count = navigate(new Cell(0, 0), cells[0]);
		
		for(int i=1; i<cells.length; i++) 
			count *= navigate(cells[i-1], cells[i]);
			
		int rest = n - cells[cells.length-1].row - 1;
		while(rest-- > 0) count *= 2;
		return count;
	}

	class Cell {
		int row; int col; Cell(int r, int c) { row = r; col = c; }
		boolean path(Cell to) {
			int h = to.row - row;
			if(col < to.col) return h >= to.col - col;
			else return h >= col - to.col + 1;
		}
		public String toString() { return String.format("(%d, %d)", row, col); }
	}
	
	Cell[] parse(String[] input) {
		Cell[] cells = new Cell[input.length];
		for(int i=0; i<cells.length; i++) { 
			String[] ts = input[i].split(" "); 
			cells[i] = new Cell(Integer.parseInt(ts[0]), Integer.parseInt(ts[1]));
		}

		Arrays.sort(cells, (c1, c2) -> {
			if(c1.row == c2.row) return c1.col - c2.col;
			return c1.row - c2.row;
		});
		return cells;
	}
}