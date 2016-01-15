public class InstantRunoff {
	private int[] getTops(String candidates, String[] ballots) {
		int[] tops = new int[candidates.length()];
		for(String ballot : ballots) 
			for(char c : ballot.toCharArray()) {
				int i = candidates.indexOf(c); if(i >= 0) { tops[i]++; break; }
			}
		return tops;
	}

	public String outcome(String candidates, String[] ballots) {
		while(candidates.length() > 0) {
			int[] tops = getTops(candidates, ballots);

			int min = Integer.MAX_VALUE, half = ballots.length/2;
			for(int i=0; i<tops.length; i++) {
				if(tops[i] > half) return "" + candidates.charAt(i);
				min = Math.min(min, tops[i]);
			}

			StringBuilder b = new StringBuilder();
			for(int i=0; i<tops.length; i++) if(tops[i] > min) b.append(candidates.charAt(i));
			candidates = b.toString();
		}
		return "";
	}

	public static void main(String[] args) {
		System.out.println((new InstantRunoff()).outcome("ABC", new String[] { "ABC", "ABC", "BAC" }));
	}
}