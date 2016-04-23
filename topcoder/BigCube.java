/*
	10^5 long[]

*/
public class BigCube {
	public String largestCube(String[] ranges) {
		long[] starts = new long[ranges.length], ends = new long[ranges.length];
		for(int i=0; i<ranges.length; i++) {
			String[] splitted = ranges[i].split("-");
			starts[i] = Long.parseLong(splitted[0]);
			ends[i] = Long.parseLong(splitted[1]);
		}
		
		for(long i=100000; i>=0; i--) {
			long cube = i*i*i;
			for(int j=0; j<ranges.length; j++) {
				if(cube >= starts[j] && cube <= ends[j]) return "" + cube;
			}
		}
		return "";
	}
}