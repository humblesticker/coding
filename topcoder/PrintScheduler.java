/*
out
for slice in slices
	parse thread index, time 
	for i=0 to time 
		out.add(hread.charAt(0));
		threads = thread.substring(1) + thread.charAt(0)
return out

using position array might work also
*/
import java.util.*;

public class PrintScheduler {
	public String getOutput(String[] ts, String[] slices) {
		StringBuilder b = new StringBuilder();
		
		for(String slice : slices) {
			String[] tokens = slice.split(" ");
			int ti = Integer.parseInt(tokens[0]), time = Integer.parseInt(tokens[1]);
			
			for(int i=0; i<time; i++) {
				b.append(ts[ti].charAt(0));
				ts[ti] = ts[ti].substring(1) + ts[ti].charAt(0);
			}
		}
		
		return b.toString();
	}
}