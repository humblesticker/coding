template<typename T>
struct Node {
	T data;
	unique_ptr<Node<T>> left,  right;
};

class BinaryTree {
	
};