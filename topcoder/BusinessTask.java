/*
linkedlist ? while removing
*/
public class BusinessTasks {
	int next(String[] list, int cur, int step, int len) {
		while(step > 0) {
			cur++; if(cur == list.length) cur = 0;
			if(list[cur] != null) step--;
		}
		return cur;
	}
	
	public String getTask(String[] list, int n) {
		int cur = 0, len = list.length; 
		while(len > 1) {
			cur = next(list, cur, (n-1)%len, len);
			list[cur] = null; len--;
			cur = next(list, cur, 1,len);
		}
		return list[cur];
	}
}