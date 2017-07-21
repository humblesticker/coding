/*
dp bottom up, iterative
1, 5, 6 denomination
amount 76

int a[amount+1]
a[0] = 0
a[i] = a[i-d] + 1 for all d
...
a[amount+1] = a[amount+1-d] + 1 for all d
return a[amount+1]
*/
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class change {
	vector<int> denomination = { 1, 5, 6 };

	int min(int amount, vector<int>& a) {
		int min = amount;
		for(int d : denomination) 
			if(amount - d >= 0) min = std::min(min, a[amount - d] + 1);
		return min;
	}

public:
	int min(int amount) {
		vector<int> a(amount+1); a[0] = 0;
		for(int i=1; i<a.size(); i++) a[i] = min(i, a);
		return a[amount];
	}
};

int main() {
	int amount; cin >> amount;
	change c;
	cout << c.min(amount) << endl;
	return 0;
}