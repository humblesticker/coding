import java.util.*;

/*
handle dup
return -insertion point - 1
*/
public class BinarySearch {
	int min(int[] sorted, int start) {
		for(int i=start; i>=0; i--) 
			if(i-1 < 0 || sorted[i-1] != sorted[start]) return i;
		return 0; // NA
	}

	int find(int[] sorted, int key) {
		int start = 0, end = sorted.length-1, mid = 0;
		while(start <= end) {
			mid = start + (end - start)/2;
			if(key < sorted[mid]) end = mid-1;
			else if(key > sorted[mid]) start = mid+1;
			else return min(sorted, mid);
		}
		return key < sorted[mid] ? -mid - 1 : -mid - 2;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] sorted = new int[n]; for(int i=0; i<n; i++) sorted[i] = s.nextInt();
		System.out.println((new BinarySearch()).find(sorted, Integer.parseInt(args[0])));
	}
}