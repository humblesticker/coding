#include <fstream>
#include <vector>
using namespace std;

ifstream cin("input.txt");
ofstream cout("output.txt");

class MergeSort {
	void merge(int s, int mid, int e, vector<int>& nums) {
		auto b = nums.begin();
		vector<int> first(b+s, b+mid), second(b+mid, b+e);

		int i=0, j=0, pos = s;
		while(pos < e) {
			if(j >= second.size()) { nums[pos++] = first[i++]; }
			else if(i >= first.size()) { nums[pos++] = second[j++]; }
			else {
				if(first[i] <= second[j]) { nums[pos++] = first[i++]; }
				else { nums[pos++] = second[j++]; }
			}
		}

		cout << s+1 << " " << e << " " << nums[s] << " " << nums[e-1] << "\n";
	}

public:
	void sort(int i, int j, vector<int>& nums) {
		if(j - i < 2) return;
		int mid = (i + j)/2; 
		sort(i, mid, nums); sort(mid, j, nums);
		merge(i, mid, j, nums);
	}
};

int main() {
	int n; cin >> n;
	vector<int> nums(n);
	for(int i=0; i<n; i++) cin >> nums[i];

	MergeSort m; m.sort(0, nums.size(), nums);
	for(int i=0; i<nums.size(); i++) { if(i > 0) cout << " "; cout << nums[i]; } cout << "\n";
	return 0;
}