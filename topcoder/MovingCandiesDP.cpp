#include <vector>
#include <string>
using namespace std;

class MovingCandies {
	vector<string> t;
	int candies[][];
	int empties[][];
	int m; int n;

	/*
	explore neighbor
	if visited 
		if empty from here < empty 
			update empty, candy
			explore ?

	else
		# or (. and if candy + empty + 1 <= total)
			update empties and candies 
			explore 

	*/
	void neighbor(int i, int j, int empty, int candy) {
		if(i < 0 || i >= m || j < 0 || j >= n) return;
		if(empty < 0) {
			if(t[i][j] == '#' || candy + empty + 1 <= total) walk(i, j);
		} else {
			int prevEmpty = empties[i][j];
			if(empty < prevEmpty) { empties[i][j] = empty; candies[i][j] = candy; }
				// walk again? 
			}
		}
	}

	void walk(int i, int j, int candy, int empty) {
		if(i == m-1 && j == n-1) return;
		neighbor(i-1, j, candy, empty);
		neighbor(i+1, j, candy, empty);
		neighbor(i, j-1, candy, empty);
		neighbor(i, j+1, candy, empty);
	}

public:
	int minMoved(vector<string>& t) {
		// initialize candies, empties

		walk(0, 0, t[0][0] == '#' ? 1 : 0, t[0][0] == '#' ? 0 : 1);
		int candy = candies[m-1][n-1], empty = empties[m-1][n-1];
		if(candy + empty <= total) return empty;
		return -1;
	}
};
/*
dp way?

##..##
#.##..

total = 7

0, 0, 1, 2, 2, 2
0, 1, 1, 1, 2, 3

track candy, empty 
if target's candy + empty <= 7 return empty
else return -1

shortest path?
*/