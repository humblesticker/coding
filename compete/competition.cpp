#include <fstream>
#include <vector>
using namespace std;

ifstream cin("input.txt");
ofstream cout("output.txt");

class competition {
public:
	int max(vector<int>& ps, vector<int>& ts) {
		bool tselected = false, pselected = false;
    	int tdiff = 1000, pdiff = 1000, sum = 0;

		for(int i=0; i<ps.size(); i++) {
			int t = ts[i], p = ps[i];
			if(t > p) { 
				tselected = true; sum += t;
				if(t-p < pdiff) pdiff = t-p; 
			} else {
				pselected = true; sum += p;
				if(p-t < tdiff) tdiff = p-t;
			}
		}

		if(!tselected) sum -= tdiff;
		if(!pselected) sum -= pdiff;
		return sum;
	}
};

int main() {
    int n; cin >> n;
    vector<int> ts(n), ps(n); 
    for(int i=0; i<n; i++) cin >> ps[i]; 
    for(int i=0; i<n; i++) cin >> ts[i]; 

    competition c;
	cout << c.max(ps, ts) << endl;
    return 0;
}
/*


2
1 2
2 1	

4

3
1 2 3
1 2 3	

6

2 
2 2
1 1
*/