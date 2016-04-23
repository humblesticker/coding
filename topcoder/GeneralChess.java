import java.util.*;

public class GeneralChess {
	private class Point implements Comparable<Point> {
		int x; int y;
		public Point(String s) {
			String[] split = s.split(",");
			x = Integer.parseInt(split[0]); y = Integer.parseInt(split[1]);
		}
		public Point(int x, int y) { this.x = x; this.y = y; }	
		public int compareTo(Point other) {
			if(x == other.x) return Integer.compare(y, other.y);
			return Integer.compare(x, other.x);
		}
		
		public boolean equals(Object obj) {
        	if(!(obj instanceof Point)) return false;
      		Point other = (Point)obj;
      		return x == other.x && y == other.y;	 
    	}
		public int hashCode() { return x*100000 + y; }
		public String toString() { return x + "," + y; }

		Set<Point> get() {
			Set<Point> points = new HashSet<Point>();
			points.add(new Point(x + 2, y + 1));
			points.add(new Point(x + 2, y - 1));
			points.add(new Point(x + 1, y + 2));
			points.add(new Point(x + 1, y - 2));
			points.add(new Point(x - 2, y + 1));
			points.add(new Point(x - 2, y - 1));
			points.add(new Point(x - 1, y + 2));
			points.add(new Point(x - 1, y - 2));
			return points;
		}
	}

	public String[] attackPositions(String[] pieces) {
		Set<Point> points = (new Point(pieces[0])).get();
		for(int i=1; i<pieces.length; i++) points.retainAll((new Point(pieces[i])).get());
		
		Point[] arr = points.toArray(new Point[points.size()]);
		Arrays.sort(arr);

		String[] out = new String[arr.length];
		for(int i=0; i<arr.length; i++) out[i] = arr[i].toString();
		return out;
	}
}