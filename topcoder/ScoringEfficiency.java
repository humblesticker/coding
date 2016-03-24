public class ScoringEfficiency {
	public double getPointsPerShot(String[] log) {
		int total = 0; double totalAttempt = 0.0;
		for(String s : log) {
			String[] splitted = s.split(" ");
			
			int score = 1; double attempt = 0.5;
			if("2".equals(splitted[1])) { score = 2; attempt = 1; }
			else if("3".equals(splitted[1])) { score = 3; attempt = 1; }
			
			totalAttempt += attempt;
			if("Made".equals(splitted[0])) total += score; 
		}
		return total/totalAttempt;
	}
}