import java.util.*;

public class GeneralChess {
	String toString(int x, int y) { return x + "," + y; }

	List<String> get(String s) {
		String[] split = s.split(",");
		int x = Integer.parseInt(split[0]), y = Integer.parseInt(split[1]);

		List<String> points = new ArrayList<String>();
		points.add(toString(x - 2, y - 1));
		points.add(toString(x - 2, y + 1));
		points.add(toString(x - 1, y - 2));
		points.add(toString(x - 1, y + 2));
		points.add(toString(x + 1, y - 2));
		points.add(toString(x + 1, y + 2));
		points.add(toString(x + 2, y - 1));
		points.add(toString(x + 2, y + 1));
		return points;
	}

	private List<String> intersect(List<String> set1, List<String> set2) {
		List<String> common = new ArrayList<String>();
		for(String s1 : set1) for(String s2: set2) if(s1.equals(s2)) { common.add(s1); break; }
		return common;
	}

	public String[] attackPositions(String[] pieces) {
		List<String> points = get(pieces[0]);
		for(int i=1; i<pieces.length; i++) points = intersect(points, get(pieces[i]));
		return points.toArray(new String[points.size()]);
	}
}