/*
l:0, r:len-1
while l < r if char at l and r not same return false
or you can use for loop
*/
public class Palindrom {
	public boolean is(String s) {
		int l = 0, r = s.length()-1;
		while(l < r) if(s.charAt(l++) != s.charAt(r--)) return false;
		return true;
	}
}