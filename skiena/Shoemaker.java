import java.util.*;

public class Shoemaker {
	static class Job implements Comparable<Job> {
		int id; int time; int fine;
		Job(int i, int t, int f) { id = i; time = t; fine = f; }
		public int compareTo(Job other) { 
			int sum1 = time * other.fine, sum2 = other.time * fine;
			if(sum1 == sum2) return Integer.compare(id, other.id);
			return Integer.compare(sum1, sum2); 
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		while(T > 0) {
			int N = s.nextInt();
			Job[] jobs = new Job[N];
			for(int i=0; i<N; i++) jobs[i] = new Job(i+1, s.nextInt(), s.nextInt());

			Arrays.sort(jobs);
			for(int i=0; i<N; i++) {
				if(i>0) System.out.print(" ");
				System.out.print(jobs[i].id);
			}
			System.out.println();

			T--; if(T > 0) System.out.println();
		}
	}
}