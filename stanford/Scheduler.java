import java.util.*;

public class Scheduler {
	static class Job {
		int weight; int length; 
		Job(int w, int l) { weight = w; length = l; }
		int objDiff() { return weight - length; }
		double objRatio() { return (double)weight/length; }
		public String toString() { return weight + "," + length; }
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Job[] jobs = new Job[s.nextInt()];
		for(int i=0; i<jobs.length; i++) jobs[i] = new Job(s.nextInt(), s.nextInt());

		// Arrays.sort(jobs, (j1, j2) -> {
		// 	int d1 = j1.objDiff(), d2 = j2.objDiff();
		// 	if(d1 == d2) return j2.weight - j1.weight;
		// 	return d2 - d1;
		// });
		Arrays.sort(jobs, (j1, j2) -> Double.compare(j2.objRatio(), j1.objRatio()));

		long sum = 0, ctime = 0;
		for(Job j : jobs) { ctime += j.length; sum += j.weight * ctime; }
		System.out.println(sum);
	}	
}
// 69119377652, 67311454237