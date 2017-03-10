#include <string>
#include <iostream>
#include <cctype>
using namespace std;

/*
negative number?

*/
class base {
	// validate if char is >= base throw exception?
	// convert 'A' to 10 also
	long to_decimal(const string& s, int b) {
		long num = 0;
		for(int i=0; i<s.length(); i++) {
			char c = toupper(s[i]);
			int d = c - '0'; if(c >= 'A') d = c - 'A' + 10;
			if(d >= b) throw exception();

			num = num*b + d;
		}
		return num;
	}

	string to_string(long d, int b) {
		string s;
		while(d > 0) {
			s = getchar(d%b) + s;
			d /= b;
		}
		return s;
	}
	
	char getchar(int n) { 
		return n < 10 ? '0' + n : 'A' + n - 10;
	}

public:
	string convert_base(const string& s, int b1, int b2) {
		long d = to_decimal(s, b1);
		return to_string(d, b2);
	}	
};

int main() {
	base b;
	cout << b.convert_base("675", 7, 13) << endl;
	cout << b.convert_base("1A7", 13, 7) << endl;
	return 0;
}
/*
base conversion
base 2 to 16, A to 10
615, 7, 13 > 1A7
constraint: how large string is? < long
return n < 10 ? '0' + n : 'A' + n - 10

validation for char is in given base 
*/