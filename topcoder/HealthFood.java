/*
50 x 4 x 50
int[] cal
max or min: track p, c, f, t and index and compare
diet plan: 0 ~ 4
*/
public class HealthFood {	
	private int best(int[] ps, int[] cs, int[] fs, int[] ts, String plan) {
		int index = 0, psBest = ps[0], csBest = cs[0], fsBest = fs[0], tsBest = ts[0];
		for(int i=1; i<ps.length; i++) {
			for(char c : plan.toCharArray()) {
				int comp = 0;
				switch(c) {
					case 'P': comp = Integer.compare(psBest, ps[i]); break;
					case 'p': comp = Integer.compare(ps[i], psBest); break;
					case 'C': comp = Integer.compare(csBest, cs[i]); break;
					case 'c': comp = Integer.compare(cs[i], csBest); break;
					case 'F': comp = Integer.compare(fsBest, fs[i]); break;
					case 'f': comp = Integer.compare(fs[i], fsBest); break;
					case 'T': comp = Integer.compare(tsBest, ts[i]); break;
					case 't': comp = Integer.compare(ts[i], tsBest); break;
				}
				if(comp < 0) { index = i; psBest = ps[i]; csBest = cs[i]; fsBest = fs[i]; tsBest = ts[i]; break; }
				if(comp > 0) break;
			}
		}
		return index;
	}
	
	public int[] selectMeals(int[] ps, int[] cs, int[] fs, String[] plans) {
		int[] ts = new int[ps.length];
		for(int i=0; i<ts.length; i++) ts[i] = ps[i]*5 + cs[i]*5 + fs[i]*9;
		
		int[] best = new int[plans.length];
		for(int i=0; i<plans.length; i++) best[i] = best(ps, cs, fs, ts, plans[i]);
		return best;
	}
}
		