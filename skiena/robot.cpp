#include <vector>
using namespace std;

class robot {
public:
	/*
	bf: n points, choose n is n!
	
	*/

	/*
	heur: nearest 1D

	flags[]
	cur = 0, d = 0
	while(flags not checked) 
		next = find(start);
		d += (cur - next)
		cur = next

	d += (cur - 0) 
	return d

	~ n^2
	*/
	void nearest(vector<int>& nums) {

	}

	/*
	how to implement this?
	for n-1 times
		for each pair of endpoints (s, t) from all chains
			find closest

	connect first one and last one connected
	~ n^2 ( precompute distance )
	*/
	void closestPair() {

	}
};