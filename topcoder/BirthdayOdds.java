public class BirthdayOdds {
	public int minPeople(int min, int days) {
		double current = 100.0;
		int num = 0;
		while(true) {
			current *= (double)(days-num)/days;
			if(current <= 100 - min) return num+1;
			num++;
		}
	}

	public static void main(String[] args) {
		System.out.println((new BirthdayOdds()).minPeople(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
	}
}