/*
1. convert to binary and count 1
2. shift and count 1
*/
public class CountOne {
	static int count(int n) {
		int count = 0;
		while(n != 0) {
			count += (n & 1);
			n >>>= 1;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(count(Integer.parseInt(args[0])));
	}
}