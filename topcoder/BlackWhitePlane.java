import java.util.*;

public class BlackWhitePlane {
	class Circle {
		int x; int y; int r2; boolean black;
		Circle(int x, int y, int r) { this.x = x; this.y = y; this.r2 = r*r; }
		boolean in(Circle o) { return (x - o.x)*(x - o.x) + (y - o.y)*(y - o.y) < o.r2; }
		int area() { return black ? -r2 : r2; }
	}
	
	Circle[] parse(String[] cs) {
		Circle[] circles = new Circle[cs.length];
		for(int i=0; i<cs.length; i++) {
			String[] t = cs[i].split(" ");	
			circles[i] = new Circle(Integer.parseInt(t[0]), Integer.parseInt(t[1]), Integer.parseInt(t[2]));
		}
		return circles;
	}

	public double area(String[] cs) {
		int sum = 0; Circle[] circles = parse(cs);
		Arrays.sort(circles, (c1, c2) -> c2.r2 - c1.r2);
		
		for(int i=0; i<circles.length; i++) {
			Circle c = circles[i];
			for(int j=0; j<i; j++) if(c.in(circles[j])) c.black = !circles[j].black;
			sum += c.area();
		}
		
		return Math.PI * sum;
	}
}