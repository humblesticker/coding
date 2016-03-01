public class FizzBuzz {
	private static String get(int i) {
		String out = "";
		if(i%3 == 0) out += "Fizz";
		if(i%5 == 0) out += "Buzz";
		if(out.length() == 0) out += i;
		return out;
	}

	public static void main(String[] args) {
		for(int i=1; i<=100; i++) {
			System.out.println(get(i));
		}
	}
}