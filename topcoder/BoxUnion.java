public class BoxUnion {
	class Rect {
		int L; int B; int R; int T;
		Rect(int l, int b, int r, int t) { L = l; B = b; R = r; T = t; }

		Rect intersect(Rect o) {
			return new Rect(Math.max(L, o.L), Math.max(B, o.B), 
				Math.min(R, o.R), Math.min(T, o.T));
		}

		int area() {
			if(R>L && T>B) return (R-L)*(T-B);
			return 0;
		}
	}

	public int area(String[] sa) {
		Rect[] rects = new Rect[sa.length];
		for(int i=0; i<sa.length; i++) {
			String[] ts = sa[i].split(" "); 
			rects[i] = new Rect(Integer.parseInt(ts[0]), Integer.parseInt(ts[1]), 
				Integer.parseInt(ts[2]), Integer.parseInt(ts[3]));
		}

		int len = rects.length;
		if(len == 1) return rects[0].area();
		if(len == 2) return rects[0].area() + rects[1].area() - rects[0].intersect(rects[1]).area();

		Rect r0 = rects[0], r1 = rects[1], r2 = rects[2];
		return r0.area() + r1.area() + r2.area() - r0.intersect(r1).area() - 
			r0.intersect(r2).area() - r1.intersect(r2).area() + r0.intersect(r1).intersect(r2).area();
	}
}