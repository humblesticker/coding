#include <cmath>
#include <algorithm>
using namespace std;

struct Node {
	int data;
	Node *left, *right;
};

class BinaryTree {
public:
	int walk(Node* root) {
		if(!root) return 0;

		int l = walk(root->left), r = walk(root->right);
		if(l < 0 || r < 0 || abs(l-r) > 1) return -1;
		else return max(l, r) + 1;
	}
};
/*
height balanced?

*/