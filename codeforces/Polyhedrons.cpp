#include <string>
#include <iostream>
using namespace std;

int main() {
	int n, total = 0; string s; cin >> n;
	while(n--) {
		cin >> s; char c = s[0];
		switch(c) {
			case 'T': total += 4; break;
			case 'C': total += 6; break;
			case 'O': total += 8; break;
			case 'D': total += 12; break;
			case 'I': total += 20; break;
		}
	}
	cout << total << endl;
	return 0;;
}