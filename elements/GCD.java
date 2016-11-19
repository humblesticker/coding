public class GCD {
	public static int get(int l, int s) {
		return s == 0 ? l : get(s, l%s);
	}

	public static void main(String[] args) {
		System.out.println(get(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
	}
}