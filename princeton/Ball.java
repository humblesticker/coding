import java.util.*;
import edu.princeton.cs.algs4.StdDraw;

public class Ball {
	private double rx, ry;        // position
    private double vx, vy;        // velocity
    private final double radius;  // radius

    public Ball() {  
    	Random r = new Random();
    	rx = r.nextDouble(); ry = r.nextDouble();
    	vx = r.nextDouble()/100; vy = r.nextDouble()/100; radius = 0.01;
    }

    // collision detection, wall and other balls
    public void move(double dt) {
    	double x = rx + vx*dt, y = ry + vy*dt;
    	if(x < radius || x > 1 - radius) vx = -vx; 
    	if(y < radius || y > 1 - radius) vy = -vy;
    	rx = x; ry = y;
    }

    public void draw() { StdDraw.filledCircle(rx, ry, radius);  }
}