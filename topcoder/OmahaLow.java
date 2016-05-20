import java.util.*;

public class OmahaLow {
	private String check(char[] a) {
		Set<Character> set = new HashSet<Character>(); for(char c : a) set.add(c);

		StringBuilder b = new StringBuilder(); 
		for(char c : "87654321".toCharArray()) if(set.contains(c)) b.append(c);
		return b.toString();
	}
	
	public String low(String shared, String hand) {
		int slen = shared.length(), hlen = hand.length(); String selected = "90000";

		for(int i=0; i<slen; i++) for(int j=i+1; j<slen; j++) for(int k=j+1; k<slen; k++)
			for(int l=0; l<hlen; l++) for(int m=l+1; m<hlen; m++) {
				String local = check(new char[] { shared.charAt(i), shared.charAt(j), shared.charAt(k), hand.charAt(l), hand.charAt(m) });
				if(local.length() == 5 && local.compareTo(selected) < 0) selected = local;
			}

		return selected == "90000" ? "" : selected;	
	}
}