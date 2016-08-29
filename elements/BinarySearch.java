/*
edge cases:

 */
import java.util.*;

public class BinarySearch {
	public static int search(int i, ArrayList<Integer> A) {
		int low = 0, high = A.size()-1;
		while(low <= high) {
			int mid = low + (high-low)/2;
			if(A.get(mid) < i) low = mid + 1;
			else if(A.get(mid) > i) high = mid - 1;
			else return mid;
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(s.hasNext()) list.add(s.nextInt());
		System.out.println(search(Integer.parseInt(args[0]), list));
	}
}