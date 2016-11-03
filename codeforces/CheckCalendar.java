/*
allowed +0, +2, +3
*/
import java.util.*;

public class CheckCalendar {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("monday", 0);
		map.put("tuesday", 1);
		map.put("wednesday", 2);
		map.put("thursday", 3);
		map.put("friday", 4);
		map.put("saturday", 5);
		map.put("sunday", 6);

		int one = map.get(s.next()), two = map.get(s.next()); if(one > two) two += 7;
		int diff = two - one;
		if(diff == 0 || diff == 2 || diff == 3) System.out.println("YES");
		else System.out.println("NO");
	}
}