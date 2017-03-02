#include <iostream>
#include <vector>
using namespace std;

int main() {
	int n, count = 0, grade; cin >> n;
	vector<int> A(6), B(6);

	for(int i=0; i<n; i++) { cin >> grade; A[grade]++; }
	for(int i=0; i<n; i++) { cin >> grade; B[grade]++; }
	
	for(int i=1; i<A.size(); i++) {
		int d = abs(A[i] - B[i]);
		if(d%2 == 1) { count = -1; break; };
		if(A[i] > B[i]) count += d/2; // A side only
	}

	cout << count << endl;
	return 0;
}