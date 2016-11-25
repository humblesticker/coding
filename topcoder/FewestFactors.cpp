#include <vector>
#include <algorithm>
using namespace std;

class FewestFactors {
public:
	int number(vector<int> v) {
		sort(v.begin(), v.end());
		int min = 10E6, n = -1;
		do {
			int perm = 0; for(int i : v) perm = perm*10 + i;
			int local = factor(perm);
			if(local < min) { min = local; n = perm; } 
		}
		while(next_permutation(v.begin(), v.end()));
		return n;
	}

private:
	int factor(int n) {
		int count = 0; 
		for(int i=1; i<=n; i++) if(n%i == 0) count++;
		return count;
	}
};