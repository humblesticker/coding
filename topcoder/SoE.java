/*
array of boolean bound+1
n from 2 to bound
	if(flag[n] is true) continue
	i from n to bound 
		flag[i] = true
		i*=n
 */

public class SoE {
	boolean[] find(int bound) {
		boolean[] flags = new boolean[bound+1];
		for(int n=2; n<flags.size; n++) {
			if(flags[n]) continue;
			for(int i=n; i<flags.size(); i*=n) flags[i] = true;
		}
	}

	public static void main(String[] args) {
		
	} 
}