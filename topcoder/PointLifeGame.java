import java.util.*;

public class PointLifeGame {
	class Point implements Comparable<Point> {
		int x; int y;
		Point(int x, int y) { this.x = x; this.y = y; } 
		String to(int n) { return String.format("%04d", n/10000) + "." + String.format("%04d", n%10000); }
		public String toString() { return to(x) + " " + to(y); }
		public int compareTo(Point other) {
			if(y == other.y) return Integer.compare(x, other.x);
			return Integer.compare(y, other.y);
		}
		Point mid(Point p) { return new Point((x + p.x)/2, (y + p.y)/2); }
	}

	private Point[] top3(int[] xs, int[] ys) {
		Point[] points = new Point[xs.length];
		for(int i=0; i<xs.length; i++) points[i] = new Point(xs[i]*10000, ys[i]*10000); 
		Arrays.sort(points);

		int len = points.length;
		return new Point[] { points[len-3], points[len-2], points[len-1] };
	}

	private Point[] next3(Point[] ps) {
		return new Point[] { ps[2].mid(ps[0]), ps[2].mid(ps[1]), ps[1].mid(ps[0]) };
	}
	
	public String simulate(int[] xs, int[] ys, int r) {
		Point[] top3 = top3(xs, ys);
		while(r > 0) { top3 = next3(top3); r--; }
		Arrays.sort(top3);
		return top3[2].toString();
	}

	public static void main(String[] args) {
		System.out.println((new PointLifeGame()).simulate(new int[] { 0, 0, 10, 10 }, new int[] { 0, 10, 0, 10 }, 10));
	}
}