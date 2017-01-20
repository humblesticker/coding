public class Complexity {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		long n = 0; while(n <= 10000000000000000L) n += 7;
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
}