/*
Given a list of N coins, their values (V1, V2, … , VN), and the total sum S. 
Find the minimum number of coins the sum of which is S (we can use as many coins of one type as we want), 
or report that it’s not possible to select coins in such a way that they sum up to S.


P(s, n) = min( P(s-vn, n-1) + 1, P(s, n-1) )

*/
#include <vector>
#include <limits>
#include <iostream>
using namespace std;

class coins {
public:
	int min(vector<int> V, int S) {
		vector<int> P(S+1, INT_MAX);
		P[0] = 0;

		for(int i=1; i<=S; ++i) 
			for(int j=0; j<V.size(); ++j) 
				if(V[j] <= i && P[i - V[j]] < P[i] - 1) P[i] = P[i - V[j]] + 1;

		//for(auto p : P) cout << p << ",";
		return P[S];
	}		
};

int main() {
	coins c; vector<int> V = { 1, 3, 5 };
	int v = c.min(V, 11);
	cout << v << endl;
}
/*
bottom up
	vector<int> P(S, int.max)
	P[0] = 0;

	i from 1 to S
		j from 0 to N-1
			if(V[j] <= i && P[i - V[j]] < P[i] - 1) P[i] = P[i - V[j]] + 1 

	return P[S];
*/
/*
recursive top down
	min = integer.max
	int[][] cache // storing S, n value ~ O(S*n)

	walk(S, n, count) 
		if(S == 0) update min and return
		if(n < 0 || S < 0) return;

		// how do you allow multiple use of a coin
		walk(S-A[n], n, count+1);
		walk(S-A[n], n-1, count+1);
		walk(S, n-1, count);

	main
		walk(S, n, 0)
		if(min == int.max) return -1
		return count;
*/