/*
	get the size of current slot
*/
public class CrossWord {
	public int countWords(String[] board, int size) {
		int count = 0;

		for(int i=0; i<board.length; i++) {
			int current = 0;
			for(int j=0; j<board[i].length(); j++) {
				if(board[i].charAt(j) == '.') current++;

				// count and reset
				if(j+1 > board[i].length()-1 || board[i].charAt(j+1) == 'X') {
					if(current == size) count++;
					current = 0;
				} 
			}
		} 
		return count;
	}
}