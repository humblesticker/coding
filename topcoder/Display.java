public class Display {
	public String[] transform(int[] x, int[] y) {
		int xmin = Integer.MAX_VALUE, xmax = Integer.MIN_VALUE, 
			ymin = Integer.MAX_VALUE, ymax = Integer.MIN_VALUE;
		for(int i=0; i<x.length; i++) {
			xmin = Math.min(xmin, x[i]); xmax = Math.max(xmax, x[i]);
			ymin = Math.min(ymin, y[i]); ymax = Math.max(ymax, y[i]);
		}
		
		double xr = 1000.0/Math.abs(xmax-xmin), yr = 1000.0/Math.abs(ymax-ymin);
		String[] result = new String[x.length];
		for(int i=0; i<x.length; i++) {
			x[i] = (int)Math.round((x[i] - xmin)*xr); y[i] = (int)Math.round((y[i] - ymin)*yr);
			result[i] = x[i] + " " + y[i];
		}
		return result;
	}
}