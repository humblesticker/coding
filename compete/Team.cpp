#include <fstream>
#include <vector>
#include <algorithm>
#include <sstream>
#include <string>
#include <cmath>
#include <iomanip>
using namespace std;

ifstream cin("input.txt");
ofstream cout("output.txt");

class Team {
	int efficiency(vector<int>& perm, vector<vector<int>>& data) {
		vector<bool> taken(data.size()); int sum = 0;
		for(auto j : perm) {
			int local = -1, index = -1;
			for(int i=0; i<data.size(); i++) 
				if(!taken[i] && data[i][j] > local) { local = data[i][j]; index = i; }
			sum += local*local; taken[index] = true; 	
		}
		return sum;
	}

public:
	double best(vector<vector<int>>& data) {
		vector<int> order = { 0, 1, 2 }; int best = -1;

		do {
    		best = max(best, efficiency(order, data));
  		} while(next_permutation(order.begin(), order.end()));

  		return sqrt(best);
	}
};

int main() {
	int n; string s; vector<vector<int>> data;
	while(getline(cin, s) && !s.empty()) {
    	istringstream ss(s); vector<int> score;
    	while(ss >> n) score.push_back(n); 
    	data.push_back(score);
    }

	Team t;
	cout << setprecision(10) << t.best(data) << endl; 
	return 0;
}
/*
for each category permutation
	for i from cats
		choose max member from available
	calculate ef and track max
*/