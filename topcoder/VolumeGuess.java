public class VolumeGuess {
	private int has(String s, int i) {
		String[] split = s.split(",");
		int a = Integer.parseInt(split[0]), b = Integer.parseInt(split[1]);
		if(a == i || b == i) return Integer.parseInt(split[2]);;
		return 0;
	}
	
	public int correctVolume(String[] q, int num, int i) {
		boolean[] flags = new boolean[501];
		for(String s : q) {
			int r = has(s, i);
			if(r > 0) {
				if(flags[r]) return r; else flags[r] = true;
			}
		}
		return 0;
	}
}