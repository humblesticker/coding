import java.util.*;

public class ExperimentalAnalyzer {
	public int[] getPredictors(String[] data) {
		int clen = data.split(" ").length;
		int[][] max = new int[2][clen], min = new int[2][clen];
		for(int i=0; i<2; i++) for(int j=0; j<clen; j++) { max[i][j] = -1; min[i][j] = -1; }

		for(int i=0; i<grid.length; i++) {
			String[] split = data.split(" ");
			for(int j=1; j<split.length; j++) {
				int pos = Integer.parseInt(split[0]), num = Integer.parseInt(split[j]);
				if(max[pos][j] < 0 || num > max[pos][j]) max[pos][j] = num;
				if(min[pos][j] < 0 || num < min[pos][j]) min[pos][j] = num;
			}
		}
				
		List<Integer> list = new ArrayList<Integer>();
		for(int j=1; j<clen; j++) {
			if(max[0][j] < 0 || max[1][j] < 0 || min[0][j] < 0 || min[1][j] < 0) continue;
			if(min[0][j] > max[1][j] || min[1][j] > max[0][j]) list.add(j);
		}

		int[] nums = new int[list.size()];
		for(int i=0; i<list.size(); i++) nums[i] = list.get(i);
		return nums;		
	}
}