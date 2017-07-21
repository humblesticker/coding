#include <queue>
#include <vector>
#include <stack>
#include <iostream>
using namespace std;

struct TreeNode {
	int data;
	TreeNode* left;
	TreeNode* right;
};

struct Item {
	int depth;
	TreeNode* node;
	Item(TreeNode* n, int d) { node = n; depth = d; }
};

class Queue {
	stack<int> one, two;
public:
	vector<vector<int>> depth(TreeNode* root) {
		vector<vector<int>> result; queue<Item> q; q.push(new Item(root, 0));
		while(!q.empty()) {
			auto item = q.front();
			if(item.left) q.emplace(new Item(item.left, item.depth+1));
			if(item.right) q.push(new Item(item.right, item.depth+1));

			if(result.size() > item.depth) result[item.depth].push_back(item.data);
			else result.push_back()
		}
		return result;
	}

	// use 2 stacks to emulate queue behaviors efficiently
	void push(int data) {

	}

	int pop() {
		// if two is empty pop all items from one to two
	}
};

int main() {

	return 0;
}