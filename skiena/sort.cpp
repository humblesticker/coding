#include <vector>
#include <algorithm>
using namespace std;

class sort {
public:
	/*
	3 1 2 5 4
	2 4 5 1
	i from 1 to len-1
		check with prev and smaller swap
	*/
	void insertion(vector<int>& nums) {
		for(int i=1; i<nums.length; i++) {
			int pos = i;
			while(pos > 0 && nums[pos] < nums[pos-1]) { 
				swap(nums[pos], nums[pos-1]); pos--;
			}
		}
	}	
};