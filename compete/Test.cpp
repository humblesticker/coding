#include <fstream>
#include <limits>
#include <cmath>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;

ifstream cin("input.txt");
ofstream cout("output.txt");

class Test {
	int count(int k, vector<bool>& factor) {
		int n = 0;
		for(int i=2; i*i<=k; i++) 
			if(k%i == 0) { 
				int j = k/i; factor[i] = true; factor[j] = true; 
				n++; if(j != i) n++;
			}
		return n;
	}

public:
	int maximal(int K) {
		vector<bool> factor(K);
		int max = numeric_limits<int>::min(), index = -1;
		for(int i=K; i>=2; i--) {
			if(factor[i]) continue;
			int local = count(i, factor); 
			if(local >= max) { index = i; max = local; }
		}
		return K - index + 1;
	}
};

int main() {
	int K; cin >> K; Test t;
	cout << t.maximal(K) << endl;
	return 0;
}