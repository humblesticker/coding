public class Stitch {
	public String[] stitch(String[] A, String[] B, int ol) {
		for(int i=0; i<A.length; i++) {
			char[] map = (A[i] + B[i].substring(ol)).toCharArray();

			for(int p=1; p<=ol; p++) {
				int j = A[i].length() - ol + p - 1;
				char a = map[j], b = B[i].charAt(p-1); 
				int div = (ol + 1 - p)*a + p*b;
				map[j] = (char)Math.round((double)div/(ol+1));
			}

			A[i] = new String(map);
		}
		return A;
	}
}