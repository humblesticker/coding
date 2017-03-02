#include <vector>
#include <iostream>
using namespace std;

class ZigZag {
public:
	int longestZigZag(vector<int> seq) {
		int n = seq.size();
		vector<int> S(n, 1), G(n, 0);
		for(int i=1; i<n; ++i)
			for(int j=i-1; j>=0; --j)
				if((G[j] == 0 && seq[j] != seq[i]) || 
					(G[j] > 0 && seq[j] > seq[i]) || (G[j] < 0 && seq[j] < seq[i])) {
					if(S[j] + 1 > S[i]) {
						S[i] = S[j] + 1;
						G[i] = seq[j] > seq[i] ? -1 : 1;
					}
				}
		return S[n-1];
	}
};
/*
S[n] init as 1, G[n] init as 0 (-1 for negative and 1 for positive)
i from 1 to n-1
	j from i-1 to 0
		if(G[j] == 0 || (G[j] > 0 && seq[j] > seq[i]) || (G[j] < 0 && seq[j] < seq[i]))
			S[i] = S[j] + 1 
return S[n-1]

1,7,4,9,2,5 
1,4,7,2,5
1,7,4,5,5
1, 1
1
*/