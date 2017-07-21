#include <fstream>
#include <stack>
#include <utility>
#include <cctype>
using namespace std;

ifstream cin("input.txt");
ofstream cout("output.txt");

pair<int, int> get(stack<int>& s) {
	int second = s.top(); s.pop(); 
	int first = s.top(); s.pop();
	return make_pair(first, second);
}

int main() {
	int n, left, right; stack<int> s; char c; 
	cin >> n; 

	while(n-- > 0) {
		cin >> c;
		if(isdigit(c)) s.push(c - '0');
		else {
			auto p = get(s);
			if(c == '+') s.push(p.first + p.second);
			if(c == '-') s.push(p.first - p.second);
			if(c == '*') s.push(p.first * p.second);
		} 
	}
	cout << s.top() << endl;
	return 0;
}
/*
stack<int> s
while n-- > 0
	read token 
	if(token is op) pop top 2 and apply op and push it back
	else push token as num 
return top (only one)

- second - first
*/