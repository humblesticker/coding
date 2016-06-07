import java.util.*;

public class DrivingDirections {
	private final String Start = "Start on", Left = "Turn LEFT on", Right = "Turn RIGHT on";
	
	private String street(String s) {
		if(s.startsWith(Left)) return s.substring(Left.length()+1); 
		if(s.startsWith(Right)) return s.substring(Right.length()+1); 
		return s.substring(Start.length()+1);
	}

	private String nav(String[] d, int i) {
		if(i == d.length-1) return Start;
		if(d[i+1].startsWith(Left)) return Right;
		return Left;
	}

	public String[] reverse(String[] d) {
		String[] out = new String[d.length];
		for(int i=0; i<d.length; i++) out[i] = nav(d, d.length-1-i) + " " + street(d[d.length-1-i]);
		return out;
	}
}