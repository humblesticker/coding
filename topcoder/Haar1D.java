public class Haar1D {
	void process(int[] data, int end) {
		int[] t = new int[end];
		for(int i=0; i<end; i+=2) {
			t[i/2] = data[i] + data[i+1];
			t[end/2 + i/2] = data[i] - data[i+1];
		}
		
		for(int i=0; i<end; i++) data[i] = t[i];
	}
	
	public int[] transform(int[] data, int L) {
		int factor = 1;
		for(int i=0; i<L; i++, factor*=2) process(data, data.length/factor);
		return data;
	}
}