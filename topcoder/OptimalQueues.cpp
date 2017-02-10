/*

*/
#include <vector>
using namespace std;

class OptimalQueues {
public: 
	int minWaitingTime(vector<int>& a, int tcount, int stime) {
		sort(a.begin(), a.end(), greater<int>());
		int max = 0;
		for(int i=0; i<a.size(); ++i) max >?= (a[i] + (1/tcount + 1)*stime);
		return max;
	}
};