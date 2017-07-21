#include <fstream>
#include <limits>
#include <cmath>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;

ifstream cin("input.txt");
ofstream cout("output.txt");

class Win {
	const int maxt = 18000;

public:
	int maxwin(vector<int>& times) {
		int sum = 0, count = 0; 
		for(auto t : times) { 
			sum += t; if(sum > maxt) break;
			count++;
		}
		return count;
	}
};

int main() {
	int n; cin >> n; vector<int> times(n);
	for(int i=0; i<n; i++) cin >> times[i];
	sort(times.begin(), times.end());

	Win w;
	cout << w.maxwin(times) << endl;
	return 0;
}