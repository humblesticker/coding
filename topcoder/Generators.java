import java.util.*;

public class Generators {
	public int[] find(int p) {
		List<Integer> list = new ArrayList<Integer>();
		
		for(int a=2; a<p; a++) {
			boolean[] flags = new boolean[p]; flags[0] = true; flags[1] = true;
			boolean isGen = true; int cur = 1;
			
			for(int i=2; i<p; i++) {
				cur = (cur*a)%p;
				if(flags[cur]) { isGen = false; break; }
				else flags[cur] = true;
			}
			
			if(isGen) list.add(a);
		}
		
		return list.stream().mapToInt(i->i).toArray();
	}
}