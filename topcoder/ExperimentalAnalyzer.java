import java.util.*;

public class ExperimentalAnalyzer {
	public int[] getPredictors(String[] data) {
		String[][] grid = new String[data.length][];
		for(int i=0; i<data.length; i++) grid[i] = data[i].split(" ");
		
		List<Integer> list = new ArrayList<Integer>();
		for(int j=1; j<grid[0].length; j++) {
			int min0 = Integer.MAX_VALUE, max0 = Integer.MIN_VALUE, min1 = min0, max1 = max0;
			
			for(int i=0; i<grid.length; i++) {
				int num = Integer.parseInt(grid[i][j]);
				if("0".equals(grid[i][0])) { min0 = Math.min(min0, num); max0 = Math.max(max0, num); }
				else { min1 = Math.min(min1, num); max1 = Math.max(max1, num); }
			}
			
			if(min0 == Integer.MAX_VALUE || min1 == Integer.MAX_VALUE || 
				max0 == Integer.MIN_VALUE || max1 == Integer.MIN_VALUE) continue;
			if(min0 > max1 || min1 > max0) list.add(j);
		}
		
		int[] nums = new int[list.size()];
		for(int i=0; i<list.size(); i++) nums[i] = list.get(i);
		return nums;		
	}
}
/*
no need to have an array, only min, max array for 0 and 1
non-negative use -1 instead
 */