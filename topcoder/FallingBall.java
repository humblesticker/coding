/*
cache
*/
import java.util.*;

public class FallingBall {
	int[][] stored;

	int navigate(Cell cell, Cell target) {
		if(cell.row == target.row) return cell.col == target.col ? 1 : 0;
		if(!cell.path(target)) return 0;

		int n = stored[cell.row][cell.col]; 
		if(n < 0) {
			n = navigate(new Cell(cell.row+1, cell.col), target) + navigate(new Cell(cell.row+1, cell.col+1), target); 
			stored[cell.row][cell.col] = n;
		}
		return n;
	}
	
	public int howMany(String[] input, int n) {
		stored = new int[30][30]; 
		for(int i=0; i<30; i++) for(int j=0; j<30; j++) stored[i][j] = -1;

		List<Cell> cells = parse(input); int count = 1;
		for(int i=1; i<cells.length; i++) count *= navigate(cells[i-1], cells[i]);
			
		int rest = n - cells[cells.length-1].row - 1;
		while(rest-- > 0) count *= 2; return count;
	}

	class Cell {
		int row; int col; Cell(int r, int c) { row = r; col = c; }
		boolean path(Cell to) {
			int h = to.row - row;
			return col < to.col ? h >= to.col - col : h >= col - to.col + 1;
		}
	}
	
	List<Cell> parse(String[] input) {
		List<Cell> cells = new ArrayList<>(); cells.add(new Cell(0, 0));
		for(int i=0; i<input.length; i++) { 
			String[] ts = input[i].split(" "); 
			cells.add(new Cell(Integer.parseInt(ts[0]), Integer.parseInt(ts[1])));
		}

		Collections.sort(cells, (c1, c2) -> {
			if(c1.row == c2.row) return c1.col - c2.col;
			return c1.row - c2.row;
		});
		return cells;
	}
}