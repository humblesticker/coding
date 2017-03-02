#include <iostream>
#include <vector>
#include <string>
using namespace std;

class Rounding {
	int nonzero(string s) {
		for(int i=s.length()-1; i>=0; i--) 
			if(s[i] != '0') return i;
		return -1;
	}

public:
	int round(string s, int k) {
		int count = 0;
		while(s.length() > 0) {
			int li = nonzero(s); 
			if(li < 0) { count += s.length()-1; break; }
			if(s.length() - li > k) return count;

			s = s.substr(0, li) + s.substr(li+1);
			count++;
		}
		return count;
	}
};

int main() {
	Rounding r; string s; int k;
	cin >> s >> k;
	cout << r.round(s, k) << endl;
	return 0;
}
/*
10203049 2
30020 3
100 9
0 9
1 9: invalid?


*/