public class TippingWaiters {
	int start(double d) {
		int start = (int)d; if((d%1) != 0) start++;
		while(start%5 != 0) start++;
		return start;
	}
	
	int end(double d, int cash) {
		int end = Math.min((int)d, cash); 
		while(end%5 != 0) end--;
		return end;
	}
	
	public int possiblePayments(int bill, int cash) {
		int start = start(bill*20.0/19), end = end(bill*10.0/9, cash);
		if(start > end) return 0;
		return 1 + (end-start)/5;
	}
}