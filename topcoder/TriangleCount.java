public class TriangleCount {
	public int count(int n) {
		int sum = 0; boolean nmode = n%2;
		for(int i=1; i<=n; i++) sum += (i%2 == nmode ? i*(i+1)/2 : i*(i+1));
		return sum;
	}
}