public class ThreeCardMonte {
	public String position(String swaps) {
		char ace = 'M';
		for(char swap : swaps.toCharArray()) 
			switch(swap) {
				case 'L':
					if(ace == 'M') ace = 'L';
					else if(ace == 'L') ace = 'M';
					break;
				case 'R':
					if(ace == 'M') ace = 'R';
					else if(ace == 'R') ace = 'M';
					break;
				case 'E':
					if(ace == 'R') ace = 'L';
					else if(ace == 'L') ace = 'R';
					break;
			}
		return ace + "";
	}
}