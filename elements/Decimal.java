/*
carry = 0
i from len-1 to 0 
	sum = digits[i] + 1 + carry
	if sum >= 10 carry = 1 sum -= 10
	digits[i] = sum
*/
import java.util.*;

public class Decimal {
	public int[] increment(int[] digits) {
		int len = digits.length; digits[len-1] += 1;

		for(int i=len-1; i>0; i--) {
			if(digits[i] >= 10) { digits[i] -= 10; digits[i-1] += 1; }
		}

		if(digits[0] >= 10) {
			digits[0] -= 10;
			int[] result = new int[len+1]; result[0] = 1; 
			System.arraycopy(digits, 0, result, 1, len);
			return result;
		} else return digits;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Decimal().increment(new int[] { 9, 9, 9 })));
	}
}