/*
convert Last, First
sort
convert First Last
 */
public class ClientsList {
	public String[] dataCleanup(String[] names) {
		for(int i=0; i<names.length; i++) {
			if(names[i].indexOf(',') >= 0) continue;
			String[] tokens = s.split(" ");
			names[i] = tokens[0] + "," + tokens[1];
		}

		java.util.Arrays.sort(names);
		
		for(int i=0; i<names.length; i++) {
			String[] tokens = s.split(", ");
			names[i] = tokens[1] + " " + tokens[0];
		}
		return names;
	}
}