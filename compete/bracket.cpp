#include <fstream>
#include <stack>
#include <string>
using namespace std;

ifstream cin("input.txt");
ofstream cout("output.txt");

class bracket {
public:
	bool check(string& s) {
		stack<char> expr; 
		for(auto c : s) {
			if(c == '(' || c == '[') expr.push(c);
			else {
				if(expr.empty()) return false;

				char t = expr.top(); 
				if((t == '(' && c == ')') || (t == '[' && c == ']')) expr.pop();
				else return false;
			}
		}
		return expr.empty();
	}
};

int main() {
	bracket b; string s; int n; cin >> n;
	while(n-- > 0) {
		cin >> s;
		if(b.check(s)) cout << "YES\n"; else cout << "NO\n";
	}
	return 0;
}
/*
()()
([])
([)]
((]]
)(
)
*/