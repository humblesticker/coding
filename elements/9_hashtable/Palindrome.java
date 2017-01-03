/*
Can string can be mutated to Palindrome?
all even count except for one
*/
public class Palindrome {
	public boolean permutate(String s) {
		s = s.toLowerCase();
		int[] count = new int[26];
		for(int i=0; i<s.length(); i++) count[s.charAt(i) - 'a']++;
		
		int odd = 0;
		for(int n : count) if(n%2 != 0 && ++odd > 1) return false;
		return true;
	}
}