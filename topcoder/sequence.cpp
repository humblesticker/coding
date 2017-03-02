#include <vector>
#include <iostream>
using namespace std;

class sequence {
public:
	int longest(vector<int>& A) {
		vector<int> S(A.size(), 1);
		for(int i=1; i<A.size(); ++i) 
			for(int j=i-1; j>=0; --j) 
				if(A[j] <= A[i] && S[j] + 1 > S[i]) S[i] = S[j] + 1;
			
		return S[A.size()-1];
	}
};

int main() {
	sequence s; vector<int> A = { 1, 3, 4, 5, 3, 7 };
	int v = s.longest(A);
	cout << v << endl;
}
/*
Given a sequence of N numbers – A[1] , A[2] , …, A[N] . Find the length of the longest non-decreasing sequence.
~ O(n^2)
*/