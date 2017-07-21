#include <list>
#include <string>
#include <fstream>
#include <map>
using namespace std;

ifstream cin("input.txt");
ofstream cout("output.txt");

template <typename T>
class queue {
	list<T> items;
	map<T, int> sorted;

public: 
	void push(T data) {
		items.push_front(data);
		sorted[data]++;
	}

	T pop() {
		T data = items.back();
		items.pop_back();
		sorted[data]--; if(sorted[data] == 0) sorted.erase(data); 
		return data;
	}

	T getmin() {
		return sorted.begin()->first;
	}
};

int main() {
	int n, data; string op; queue<int> q;
	cin >> n;
	while(n-- > 0) {
		cin >> op;
		if(op == "+") { cin >> data; q.push(data); }
		else if(op == "-") q.pop();
		else cout << q.getmin() << "\n";
	}
	//const clock_t begin_time = clock();

	// queue<int> q;
	// for(int i=0; i<1000000; i++) {
	// 	if(i%10 == 1) q.pop(); else q.push(i);
	// 	cout << q.getmin() << "\n";
	// }

	// cout << float( clock () - begin_time ) /  CLOCKS_PER_SEC;
	return 0;
}