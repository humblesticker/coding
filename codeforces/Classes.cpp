#include <vector>
#include <limits>
#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	int n, d, nstart = numeric_limits<int>::min(), nend = numeric_limits<int>::max();
	cin >> n;
	while(n--) {
		cin >> d; nstart = max(nstart, d);
		cin >> d; nend = min(nend, d);
	}

	int m, mstart = numeric_limits<int>::min(), mend = numeric_limits<int>::max();
	cin >> m;
	while(m--) {
		cin >> d; mstart = max(mstart, d);
		cin >> d; mend = min(mend, d);
	}
	
	int d1 = nstart - mend, d2 = mstart - nend;
	cout << max(d1 > 0 ? d1 : 0, d2 > 0 ? d2 : 0) << endl;
	return 0;
}
