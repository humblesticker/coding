#include <fstream>
#include <vector>
using namespace std;

ifstream cin("input.txt");
ofstream cout("output.txt");

class Inversion {
	// count inversion
	// when j incremented add first.size() - i
	int merge(int s, int mid, int e, vector<int>& nums) {
		auto b = nums.begin();
		vector<int> first(b+s, b+mid), second(b+mid, b+e);

		int i=0, j=0, pos = s, count = 0;
		while(pos < e) {
			if(j >= second.size()) { nums[pos++] = first[i++]; }
			else if(i >= first.size()) { nums[pos++] = second[j++]; }
			else {
				if(first[i] <= second[j]) { nums[pos++] = first[i++]; }
				else { nums[pos++] = second[j++]; count += first.size() - i; }
			}
		}
		return count;
	}

public:
	int sort(int i, int j, vector<int>& nums) {
		if(j - i < 2) return 0;
		int mid = (i + j)/2; 
		return sort(i, mid, nums) + sort(mid, j, nums) + merge(i, mid, j, nums);
	}
};

int main() {
	int n; cin >> n;
	vector<int> nums(n);
	for(int i=0; i<n; i++) cin >> nums[i];

	Inversion m; cout << m.sort(0, nums.size(), nums) << endl;
	return 0;
}