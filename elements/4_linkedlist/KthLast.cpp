#include <iostream>
using namespace std;

struct Node {
	int data;
	Node *next;
};

class KthLast {
	Node* head = nullptr;

public:
	KthLast() { head = new Node(); }

	void add(int d) {
		auto node = new Node(); node->data = d;
		node->next = head->next; head->next = node; 
	}

	// if len < k return first
	void removeKth(int k) {
		auto cur = head->next;
		while(k--) { if(!cur) break; cur = cur->next; }

		auto prev = head;
		while(cur) { cur = cur->next; prev = prev->next; }

		prev->next = prev->next->next;
		delete prev->next;
	}

	void print() {
		auto cur = head->next;
		while(cur) { cout << cur->data << " "; cur = cur->next; }
		cout << endl;
	}
};

int main() {
	KthLast last;
	last.add(1);
	last.add(2);
	last.add(3);
	last.add(4);
	last.print();
	last.removeKth(3);
	last.print();
	return 0;
}
/*
track k and k-1 th element from cur pos
k->next = k-1->next
delete k-1
*/