import java.util.*;
import java.util.regex.*;

public class Spreadsheets {
	Pattern RC = Pattern.compile("R(\\d+)C(\\d+)"), A1 = Pattern.compile("([A-Z]+)(\\d+)");

	String encode(int num) {
		String s = ""; int factor = 26;
		while(num > 0) {
			s = (char)('A' + (num-1)%26) + s;
			num = (num-1)/factor; 
		}
		return s;
	}

	int decode(String s) {
		int num = 0, len = s.length(), factor = 1;
		for(int i=len-1; i>=0; i--) {
			num += (s.charAt(i) - 'A' + 1) * factor;
			factor *= 26;
		}
		return num;
	}

	String parse(String s) {
    	Matcher m = RC.matcher(s);
    	if (m.find()) return encode(Integer.parseInt(m.group(2))) + m.group(1);
      	
      	m = A1.matcher(s);
      	if (m.find()) return "R" + m.group(2) + "C" + decode(m.group(1));
      	return "";
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Spreadsheets sheet = new Spreadsheets();
		int T = s.nextInt();
		while (T-- > 0) System.out.println(sheet.parse(s.next()));
	}	
}