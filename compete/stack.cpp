#include <vector>
#include <string>
#include <fstream>
using namespace std;

ifstream cin("input.txt");
ofstream cout("output.txt");

template <typename T>
class stack {
	vector<T> list;

public: 
	void push(T data) {
		list.emplace_back(data);
	}

	T pop() {
		T data = list.back();
		list.pop_back();
		return data;
	}
};

int main() {
	int n, data; string op; stack<int> s;
	cin >> n;
	while(n-- > 0) {
		cin >> op;
		if(op == "+") { cin >> data; s.push(data); }
		else cout << s.pop() << "\n";
	}
	return 0;
}