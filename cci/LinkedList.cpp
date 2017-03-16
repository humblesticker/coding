#include <vector>
#include <unordered_set>
#include <iostream>

using namespace std;

struct Node {
	int data;
	Node* next = nullptr;
	Node(int d) { data = d; }
};

class LinkedList {
	Node* head = nullptr;

public:
	LinkedList() { head = new Node(-1); }

	// remove dups
	void removeDup() {
		unordered_set<int> set;
		Node* prev = head; Node* cur = prev->next;
		while(cur) {
			if(set.insert(cur->data).second) { prev = cur; cur = cur->next; }
			else { prev->next = cur->next; delete cur; cur = prev->next; }
		}
	}

	void add(int d) {
		Node* node = new Node(d);
		node->next = head->next;
		head->next = node;
	}

	void print() {
		Node* cur = head->next;
		while(cur) { cout << cur->data << ","; cur = cur->next; }
		cout << endl;
	}
};

int main() {
	LinkedList list;
	list.add(1);
	list.add(2);
	list.add(3);
	list.add(1);
	list.print();

	list.removeDup();
	list.print();
	return 0;
}
/*
1. 
data number, character or just any
1, 2, 3, 4, 1 -> 1, 2, 3, 4
1, 1 -> 1
[] -> []
size limit? each element is int? unsorted
singley linked, compare cur with next. if same remove next

range then use flag array or just set O(n) time, O(range) space


2. 
Node* prev = head; //sentinel
Node* cur = prev->next; 
while(cur) {
	if(set.insert(cur->data).second) { prev = cur; cur = cur->next; }
	else { prev->next = cur->next; delete cur; cur = prev->next; }
}

sort and 
*/