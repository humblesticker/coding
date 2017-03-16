#include <iostream>
using namespace std;
using ll = long long;

int search(ll n, ll m) {
	ll low = 1, high = 2000000000, mid = 0, sum = 0, target = n - m;
	while(low <= high) {
		mid = (low + high)/2; sum = mid*(mid+1)/2;

		if(sum > target) high = mid-1;
		else if(sum < target) low = mid+1;
		else return mid;
	}
	return low;
}

int main() {
	ll n, m, i = 1; cin >> n >> m;
	if(m >= n) cout << n << endl;
	else cout << m + search(n, m) << endl;
	return 0;
}
/*
5 2
8 1
10^18, 1 ?
*/