#include <string>
#include <iostream>
#include <vector>
#include <utility> 
#include <unordered_map> 
#include <sstream>
using namespace std;

class bitwise {
	vector<string> parse(const string& s) {
		stringstream ss(s); string str; vector<string> list;
		while(ss >> str) list.push_back(str);
		return list;
	}

	int get(string s, unordered_map<string, int>& vars, int q, int pos) { return s == "?" ? q << pos : vars[s] & (1 << pos); }

	int get(vector<string>& tokens, unordered_map<string, int>& vars, int q, int pos) {
		int l = get(tokens[2], vars, q, pos);
		int r = get(tokens[4], vars, q, pos);
		string op = tokens[3];
		if(op == "AND") return (l & r) >> pos;
		if(op == "OR") return (l | r) >> pos;
		if(op == "XOR") return (l ^ r) >> pos;
		throw exception();
	}

	/*
	validation logic 
	*/
	int calculate(const vector<string>& eqs, int q, int pos) {
		unordered_map<string, int> vars; int sum = 0;
		for(auto& eq : eqs) {
			auto tokens = parse(eq); 
			if(tokens.size() == 3) vars[tokens[0]] = stoi(tokens[2], nullptr, 2);
			else if(tokens.size() == 5) { sum += get(tokens, vars, q, pos); }
			else throw exception();
		}
		return sum;
	}

public:
	vector<string> get(const vector<string>& eqs, int m) {
		string min(m, '0'), max(m, '0');
		for(int i=0; i<m; i++) {
			int zero = calculate(eqs, 0, i), one = calculate(eqs, 1, i);
			if(one < zero) min[i] = '1';
			if(one > zero) max[i] = '1';
		} 

		vector<string> list { min, max };
		return list;
	}
};

int main() {
	int n, m, i = 0; cin >> n >> m;

	vector<string> eqs(n);
	while(i++ < n) cin >> eqs[i];

	bitwise b;
	auto list = b.get(eqs, m);
	cout << list[0] << endl << list[1] << endl;
}