import java.util.*;

public class Tennis {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long n = s.nextLong(), cur = 2; int i = 1;
		for(; i<=64 && cur<n; i++) cur *= 2;
		System.out.println(i);
	}
}