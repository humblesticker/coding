/*
how to add 

*/
public class BuildBridge {
	public int howManyCards(int D, int L) {
		int count = 1; double sum = 0.0;
		do {
			sum += L/(count*2.0); count++;
		} while(sum < D);
		return count;
	}
}