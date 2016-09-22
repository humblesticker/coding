import java.io.*;
import java.util.*;

public class Lighthouse { 
    static void check(char[][] grid, int i, int j, int x, int y, int[] squares, boolean[] blocked) {
        int px = i+x, py = j+y, d = x*x + y*y; if(d >= squares.length) return;
        if(px < 0 || px >= grid.length || py < 0 || py >= grid.length || grid[px][py] == '*') 
            blocked[squares[d]] = true;
    }
    
    static int circle(char[][] grid, int i, int j, int[] squares) {
        if(grid[i][j] == '*') return 0;
        boolean[] blocked = new boolean[25];
        
        for(int r=1; r<25; r++) {
            if(blocked[r]) break;
            
            int x=-r, y=-r;
            for(x=-r; x<=r; x++) check(grid, i, j, x, y, squares, blocked);
            
            x=r;
            for(y=-r; y<=r; y++) check(grid, i, j, x, y, squares, blocked);
            
            y=r;
            for(x=r; x>=-r; x--) check(grid, i, j, x, y, squares, blocked);
            
            x=-r;
            for(y=r; y>=-r; y--) check(grid, i, j, x, y, squares, blocked);
        }  
        
        int k=0;
        for(k=0; k<blocked.length; k++) if(k+1>=blocked.length || blocked[k+1]) break;
        return k; 
    }
    
    static int[] squares() {
        int num = 1, square = 1;
        int[] nums = new int[24*24 + 1];
        for(int i=1; i<nums.length; i++) {
            if(i>square) { num++; square = num*num; }
            nums[i] = num;
        }
        return nums;
    }
    
    static int max(char[][] grid) {
        int max = 0; int[] squares = squares();
        for(int i=0; i<grid.length; i++)
            for(int j=0; j<grid.length; j++) max = Math.max(max, circle(grid, i, j, squares));
        return max;
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        char[][] grid = new char[N][N];
        for(int i=0; i<N; i++) grid[i] = s.next().toCharArray();
        System.out.println(max(grid));
    }
}