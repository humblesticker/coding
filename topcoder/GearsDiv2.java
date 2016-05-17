/*
	try 
		len-1 + d
		d + 0
 */
public class GearsDiv2 {
	private int count(String d) {
		int count = 0; char[] ds = d.toCharArray();
		for(int i=1; i<ds.length; i++) if(ds[i] == ds[i-1]) { count++; ds[i] = ' '; }
		return count;
	}

	public int getmin(String d) {
		return Math.min(count(d + d.charAt(0)), count(d.charAt(d.length()-1) + d)); 
	}
}