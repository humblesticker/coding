import java.util.*;

public class Converter {
	public int stringToInt(String s) {
		boolean negative = false;
		if(s.length() > 0 && s.charAt(0) == '-') { s = s.substring(1); negative = true; }

		int cur = 0, i = 0;
		while(i < s.length()) { cur = cur*10 + (s.charAt(i) - '0'); i++; }

		if(negative) cur *= -1;
		return cur;
	}

	public String intToString(int n) {
		boolean negative = false;
		if(n < 0) { negative = true; n *= -1; }

		StringBuilder cur = new StringBuilder();
		do { 
			char c = (char)('0' + n%10);
			cur.append(c); n /= 10; 
		} while (n > 0);			

		if(negative) cur.append('-');
		return cur.reverse().toString();
	}

	public static void main(String[] args) {
		Converter c = new Converter();
		System.out.println(c.stringToInt(args[0]));
		System.out.println(c.intToString(Integer.parseInt(args[0])));
	}
}
/*
string to int
	boolean negative = false;
	if size > 0 and first char is - 
		drop - and negative = true

	cur = 0
	loop char
		cur = cur*10 + char - '0'

	if negative cur *= -1
	return cur

case
""
"0"
"102"
"987654321"
"-1"



int to string
	boolean negative = false;
	if n < 0 nagative = true n *= -1

	cur = new StringBuilder
	do
		cur.append('0' + n%10)
		n /= 10
	while n > 0

	if negative cur.append('-')
	return cur.reverse().ToString();
		
0
908
123456789
-1

64bit or more?
*/