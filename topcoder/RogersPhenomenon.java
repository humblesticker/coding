public class RogersPhenomenon {
	public int countTriggers(int[] s1, int[] s2) {
		int sum1 = 0; for(int n : s1) sum1 += n;
		int sum2 = 0; for(int n : s2) sum2 += n;
		
		int count = 0;
		for(int n : s1) if(n*s1.length < sum1 && n*s2.length > sum2) count++;
		for(int n : s2) if(n*s2.length < sum2 && n*s1.length > sum1) count++;
			
		return count;
	} 
}