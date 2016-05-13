import java.util.*;

public class FileFragmentation {
	private static int getLength(List<String> fragments) {
		if(fragments.size() == 0) return 0;
		int total = 0;
		for(String s : fragments) total += s.length();
		return 2*total/fragments.size();
	}

	/*
		find fragments with same length with diff

		get match with same pattern -- 8 possibilities

		if no such fragments

		3, 5 or 5, 3
		compare with 2, 6 or 6, 2

	*/
	private static boolean check(String s, List<String> fragments) {
		return false;
	} 

	private static String process(List<String> fragments) {
		int length = getLength(fragments);
		if(length == 0) return "";

		String item = fragments.get(0), other = null; 
		for(int i=1; i<fragments.size(); i++) 
			if(fragments.get(i).length() == length - item.length()) { 
				other = fragments.get(i); break; 
			}
		if(other == null) return "";

		// check
		return "";
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = Integer.parseInt(s.nextLine()); s.nextLine();

		while(T > 0) {
			List<String> fragments = new ArrayList<String>();
			while(s.hasNext()) {
				String fragment = s.nextLine(); if("".equals(fragment)) break;
				fragments.add(fragment);
			}

			System.out.println(process(fragments));
			T--; if(T > 0) System.out.println();
		}
	}
}