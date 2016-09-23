import java.util.*;
import edu.princeton.cs.algs4.StdDraw;

public class BouncingBalls {
	public static void main(String[] args) {
		Ball[] balls = new Ball[Integer.parseInt(args[0])];
		for(int i=0; i<balls.length; i++) balls[i] = new Ball();

		while(true) {
			StdDraw.clear();
			for(Ball ball : balls) { ball.move(0.5); ball.draw(); }
			StdDraw.show(); StdDraw.pause(50);
		}
	}
}