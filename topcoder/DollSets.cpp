#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

class DollSets {
	int find(vector<int>& sizes, vector<bool>& packaged, int src, int tsize) {
		for(int i=0; i<sizes.size(); i++) {
			if(i == src || packaged[i]) continue;
			if(sizes[i] == tsize) return i;
		}
		return -1;
	}

public:
	int maximumQuantity(vector<int> sizes, int K) {
		sort(sizes.begin(), sizes.end());
		vector<bool> packaged(sizes.size()); int count = 0;
		
		for(int i=0; i<sizes.size(); i++) {
			if(packaged[i]) continue;
			int found = find(sizes, packaged, i, sizes[i]*K);
			if(found >= 0) { packaged[i] = true; packaged[found] = true; count++; }
		}
		return count;
	}
};