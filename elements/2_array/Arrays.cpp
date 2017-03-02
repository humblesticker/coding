#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

class Arrays {
	bool walk(int n, vector<int>& nums) {
		if(n == nums.size()-1) return true;
		if(n >= nums.size()) return false;

		for(int i=1; i<=nums[n]; i++) 
			if(walk(n+i, nums)) return true;

		return false;
	}

public:
	// even first and odd after inline
	void EvenOdd(vector<int>& A) {
		int oi = A.size() - 1, i = 0;
		while(i < oi) {
			if(A[i] % 2 == 0) { i++; continue; }
			swap(A[i], A[oi--]); 
		}
	}

	// advance up to max value from 0
	// 3, 3, 1, 0, 2, 0, 1
	// 3, 2, 0, 0, 2, 0, 1
	// last index reachable ?
	bool advance_recursive(vector<int>& nums) {
		return walk(0, nums);
	}

	// reachability: track max reach
	bool advance(vector<int>& nums) {
		int reach = 0;
		for(int i=0; i<nums.size(); i++) {
			if(i > reach) return false;
			reach = max(reach, i+nums[i]); 
		}
		return reach >= nums.size()-1;
	}
};

int main() {
	vector<int> A = { 3, 2, 0, 0, 2, 0, 1 };
	Arrays a; 
	cout << a.advance(A) << endl;
}