import java.io.*;
import java.util.*;

/*
5 2
0 4

6 6
0 1 2 4 3 5
*/
public class FlatLand {
    static int distance(int[] sorted, int n) {
        int pos = Arrays.binarySearch(sorted, n);
        if(pos >= 0) return 0;
        
        pos = -(pos + 1);
        if(pos >= sorted.length) return n - sorted[pos-1];
        if(pos-1 < 0) return sorted[pos] - n;
        return Math.min(sorted[pos] - n, n - sorted[pos-1]);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); int[] stations = new int[in.nextInt()];
        for(int i=0; i<stations.length; i++) stations[i] = in.nextInt();
        Arrays.sort(stations);
        
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) max = Math.max(max, distance(stations, i));
        System.out.println(max);
    }
}
/*
sort space stations? binary search ~ nlogn
    >= 0 distance = 0
    < 0 +1 and *-1 get element in pos and pos+1, max distance
*/