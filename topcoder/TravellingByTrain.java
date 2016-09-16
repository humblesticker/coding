public class TravellingByTrain {
	int find(String table, int cur) {
		String[] tokens = table.split(" ");
		int min = Integer.MAX_VALUE;
		for(String token : tokens) {
			String[] split = token.split("-");
			int start = minute(split[0]), end = minute(split[1]);
	
			int local = wait(cur, start) + move(start, end);
			min = Math.min(min, local);
		}
		return min;
	}
	
	int minute(String time) {
		String[] split = time.split(":");
		return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
	}
	
	int wait(int cur, int next) {
		if(next >= cur) return next - cur;
		else return 1440 + next - cur;
	}
	
	int move(int cur, int next) {
		if(next > cur) return next - cur;
		else return 1440 + next - cur;
	}
	
	String format(int n) {
		if(n<10) return "0" + n;
		return "" + n;
	}
	
	public String earliestArrival(String[] tables) {
		int cur = 9*60, total = cur;
		for(String table : tables) {
			int best = find(table, cur);
			cur = (cur + best)%1440; total += best;
		}
		
		int d = total/1440 + 1; total %= 1440;
		int h = total/60, m = total%60;
		return format(h) + ":" + format(m) + ", day " + d;
	}
}