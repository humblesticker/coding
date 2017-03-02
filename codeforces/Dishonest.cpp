#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Item { int a; int b; };

class Dishonest {
public:
	int min(vector<Item>& items, int k) {
		auto comp = [](Item i1, Item i2) { return i1.a - i1.b < i2.a - i2.b; };
		sort(items.begin(), items.end(), comp);

		int total = 0;
		for(int i=0; i<items.size(); ++i) 
			total += (i<k || items[i].a < items[i].b ? items[i].a : items[i].b);
		return total;
	}
};

int main() {
	int n, k; cin >> n >> k;
	vector<Item> items(n);
	for(int i=0; i<n; ++i) cin >> items[i].a; 
	for(int i=0; i<n; ++i) cin >> items[i].b; 

	Dishonest d;
	cout << d.min(items, k) << endl;
	return 0;
}
/*
i form 0 to n-1
	if i<k add a else b

if use pq you can nlogk, if k is small compare to n this might be an option
*/