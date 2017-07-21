#include <stack>
#include <vector>
#include <iostream>
using namespace std;

struct Node {
	int data;
	Node* next;
};

class Stack {
public:
	void reverse(Node* head) {
		stack<int> s;
		auto cur = head->next;
		while(cur) { s.push(cur->data); cur = cur->next; }

		while(!s.empty()) { cout << s.top() << ","; s.pop(); }
	}

	vector<int> sunset(istream& is) {
		stack<int> s; int h;
		while(is >> h) {
			while(!s.empty() && h >= s.top()) s.pop();
			s.push(h);
		} 

		vector<int> buildings;
		while(!s.empty()) { buildings.push_back(s.top()); s.pop(); }
		return buildings;
	}
};

int main() {
	Stack stack; auto buildings = stack.sunset(cin);
	for(auto b : buildings) cout << b << ","; cout << endl;
	return 0;
}