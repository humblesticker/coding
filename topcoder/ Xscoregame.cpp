#include <vector>
using namespace std;

class Xscoregame {
public:
	int getscore(vector<int>& A) {

	}	
};
/*
1, 2, 3, 4
X += X^Y
A: 1 ~ 15 elemnets ( 0 ~ 50 )
unsigned short bit flag 

n = 2^15, 
X[n], O[n] init as -1

i from 0 to A.size()-1
	X[i+1] = A[i]

i from A.size() to 2^A.size()
	j from i-1 to 0
		k = i ^ j
		if X[j] + X[k] > X[i] update X[i], fill in O[n] if < 0 A[] ^  

return X[n-1]
*/