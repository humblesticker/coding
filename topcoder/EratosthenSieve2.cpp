#include <vector>
#include <iostream>
using namespace std;

class EratosthenSieve2 {
	void remove(int j, vector<bool>& flag) {
		int count = 0;
		for(int i=1, count=0; i<flag.size(); i++) {
			if(flag[i]) continue;
			count++; if(count%j == 0) flag[i] = true;
		}
	}
	
public:
	int nthElement(int n) {
		vector<bool> flag(1001);
		for(int j=2; j<=10; j++) remove(j, flag);
		
		for(int i=1, count=0; i<flag.size(); i++) {
			if(flag[i]) continue;
			count++; if(count == n) return i;
		}
		return -1;
	}
};

int main() {
	EratosthenSieve2 e;
	cout << e.nthElement(3) << endl;
	return 0;
}