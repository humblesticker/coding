import java.io.*;
import java.util.*;

public class Solution {
    static class Point { 
        double x; double y; 
        Point(double x, double y) { this.x = x; this.y = y; } 
        public String toString() { return String.format("%f\n%f\n", x, y); }
    }
    
    static Point center(int L1, double R) {
        double x = R*Math.cos(Math.asin(L1/(2*R)));
        return new Point(x, L1/2.0);
    }
        
    static double radius(int [] sides) {
        double l = 0.0, h = 100000.0, target = 2*Math.PI, e = 1E-8, mid = 0.0;
        while(Math.abs(l-h) > e) {
            mid = (l + h)/2; 
            double angle = angle(sides, mid);
            if(Math.abs(angle - target) < e) return mid;
            else if(angle < target) h = mid;
            else l = mid;
        }
        return mid; // closest possible
    }
            
    static double angle(int[] sides, double R) {
        double sum = 0.0;
        for(int side : sides) sum += (2*Math.asin(side/(2*R)));
        return sum;
    }
    
    static Point rotate(Point p, double angle, Point c) {
        double sin = Math.sin(angle), cos = Math.cos(angle);
        double tx = p.x-c.x, ty = p.y-c.y;
        return new Point(tx*cos + ty*sin + c.x, -tx*sin + ty*cos + c.y);
    }
    
    static void walk(int[] sides, double R) {
        Point c = center(sides[0], R); 
        Point p = new Point(0.0, 0.0); System.out.println(p);
        p = new Point(0.0, sides[0]); System.out.println(p);
        for(int i=1; i<sides.length; i++) {
            p = rotate(p, 2*Math.asin(sides[i]/(2*R)), c);
            System.out.println(p);
        }
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] sides = new int[10000];
        for(int i=0; i<sides.length; i++) sides[i] = 10000;
        walk(sides, radius(sides));
    }
}