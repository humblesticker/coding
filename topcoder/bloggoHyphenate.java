public class bloggoHyphenate {
	private int closest(String d, int pos) {
		int minIndex = -1, min = Integer.MAX_VALUE, index = 0;
		for(int i=0; i<d.length(); i++) 
			if(d.charAt(i) == ' ') {
				int diff = Math.abs(index - pos);
				if(diff < min) { min = diff; minIndex = index; }
			} else index++;
		return minIndex;
	}
	
	private String correct(String d, String cr, int pos) {
		int index = closest(d, pos);
		if(index < 0) return cr;
		if(index == pos) return "correct";
		return cr.substring(0, index) + "-" + cr.substring(index);
	}

	public String[] correct(String[] dict, String[] cand) {
		String[] dremoved = new String[dict.length];
		for(int i=0; i<dremoved.length; i++) dremoved[i] = dict[i].replace(" ", "");
		
		for(int i=0; i<cand.length; i++) {
			String cr = cand[i].replace("-", "");
			for(int j=0; j<dremoved.length; j++) 
				if(cr.equals(dremoved[j])) cand[i] = correct(dict[j], cr, cand[i].indexOf('-'));
		}
		return cand;
	}
}