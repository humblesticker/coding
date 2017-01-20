import java.util.*;

public class FindTriangle {
	class Point {
		int x; int y; int z; char color;
		Point(char color, int x, int y, int z) {
			this.color = color; this.x = x; this.y = y; this.z = z; 
		}
		Point from(Point o) { return new Point(this.color, x - o.x, y - o.y, z - o.z); }
	}
	
	// don't change param
	long area(Point one, Point two, Point three) {
		Point p1 = two.from(one), p2 = three.from(one);
		long d1 = p1.x*p2.y - p1.y*p2.x, d2 = p1.x*p2.z - p1.z*p2.x,
			d3 = p1.y*p2.z - p1.z*p2.y;
		return d1*d1 + d2*d2 + d3*d3;
	}
	
	// loop 3 times 
	long max(List<Point> list) {
		long max = 0;
		for(int i=0; i<list.size(); i++)
			for(int j=i+1; j<list.size(); j++)
				for(int k=j+1; k<list.size(); k++) {
					Point p1 = list.get(i), p2 = list.get(j), p3 = list.get(k);
					if((p1.color == p2.color && p1.color == p3.color) ||
						(p1.color != p2.color && p1.color != p3.color && p2.color != p3.color)) {
						long area = area(list.get(i), list.get(j), list.get(k));
						//System.out.printf("%d, %d, %d, %d\n", i, j, k, area);
						max = Math.max(max, area);
					}
				}
		return max;
	}
	
	void parse(List<Point> list, String[] tokens) {
		list.add(new Point(tokens[0].charAt(0), Integer.parseInt(tokens[1]), 
			Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3])));
	}
	
	public double largestArea(String[] points) {
		List<Point> list = new ArrayList<>();
		for(String p : points) parse(list, p.split(" "));
		return Math.sqrt(max(list))/2; 
	}
}