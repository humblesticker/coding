#include <memory>
#include <iostream>
using namespace std;

template<typename T>
struct Node {
	T data;
	shared_ptr<Node<T>> next; 
	Node<T>(T d, shared_ptr<Node<T>> n) { data = d; next = n; }
};

class LinkedList {
	shared_ptr<Node<int>> head; // dummy head

public:
	LinkedList() { head = make_shared<Node<int>>(-1, nullptr); }

	shared_ptr<Node<int>> find(int key) {
		auto cur = head->next;
		while(cur && cur->data != key) cur = cur->next;
		return cur;
	}

	void insert(int key) {
		head->next = make_shared<Node<int>>(key, head->next); 
	}

	void remove(int key) {
		auto cur = head->next, prev = head;
		while(cur && cur->data != key) { prev = cur; cur = cur->next; }
		prev->next = cur->next;
	}

	void print() {
		auto cur = head->next;
		while(cur) { cout << cur->data << " "; cur = cur->next; }
		cout << endl;
	}
};

/*

*/
Node<int>* common(Node<int>* l1, Node<int>* l2) {
	return null;
}

int main() {
	LinkedList list;
	list.insert(1);
	list.insert(2);
	list.insert(3);
	list.print();

	auto node = list.find(1);
	if(node) cout << node->data << endl;

	node = list.find(4);
	if(node) cout << node->data << endl;

	list.remove(2);
	list.print();
	return 0;
}