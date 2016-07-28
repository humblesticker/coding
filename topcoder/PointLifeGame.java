import java.util.*;

public class PointLifeGame {
	class Point implements Comparable<Point> {
		int x; int y;
		Point(int x, int y) { this.x = x; this.y = y; }
		public int compareTo(Point other) {
			if(y == other.y) return Integer.compare(other.x, x);
			return Integer.compare(other.y, y);
		}
	}

	//get points from top y until you have at least 3. 
	// but include all points in the same y
	List<Point> getTop3(List<Point> points) {
		Collections.sort(points);
		List<Point> top3 = new ArrayList<Point>();
		for(int i=0; i<points.size(); i++) {
			if(i+1 < points.size()) {
				Point a = points.get(i), b = points.get(i+1);
				if(a.y == b.y && a.x == b.x) continue; 
			}
			top3.add(points.get(i)); 

			if(i+1 < points.size() && points.get(i).y != points.get(i+1).y) 
				if(top3.size() >= 3) break;
		}
		//print(top3);
		return top3;
	}

	List<Point> getNext(List<Point> points) {
		List<Point> next = new ArrayList<Point>();
		for(int i=0; i<points.size(); i++) 
			for(int j=i+1; j<points.size(); j++) {
				Point a = points.get(i), b = points.get(j), mid = new Point((a.x+b.x)/2, (a.y+b.y)/2);
				next.add(mid);
			}
		//print(next);
		return next;
	}
	
	void print(List<Point> points) {
		for(Point p : points) System.out.print(" (" + p.x + "," + p.y + ") ");
		System.out.println();
	}
	
	String to(int n) { return String.format("%04d", n/10000) + "." + String.format("%04d", n%10000); }
	
	public String simulate(int[] xs, int[] ys, int r) {
		List<Point> points = new ArrayList<Point>();
		for(int i=0; i<xs.length; i++) { points.add(new Point(xs[i]*10000, ys[i]*10000)); }
		
		while(r > 0) {
			points = getTop3(points);
			points = getNext(points);
			r--;
		}
		Collections.sort(points);
		return to(points.get(0).x) + " " + to(points.get(0).y);
	}
}