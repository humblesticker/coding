/*
lazy union with rank, 1 based index
left into right, if rank is equal increase right by 1
 */
import java.util.*; 

public class UF {
	int[] nodes;
	int[] ranks;

	public UF(int n) { nodes = new int[n+1]; ranks = new int[n+1]; }

	boolean union(int s, int t) { 
		int sid = find(s), tid = find(t); //System.out.println(s + ":" + sid + "," + t + ":" + tid);
		if(sid == tid) { 
			//System.out.println(s + "," + t + " is connected via " + sid);
			return false; 
		}

		if(ranks[sid] <= ranks[tid]) {
			nodes[sid] = tid; if(ranks[sid] == ranks[tid]) ranks[tid]++;
		} else nodes[tid] = sid;
		//System.out.println(Arrays.toString(nodes));
		return true;
	}

	int find(int s) {
		while(nodes[s] > 0) s = nodes[s];
		return s;
	}
}