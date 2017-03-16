#include <vector>
#include <string>
#include <algorithm>
#include <iostream>
#include <sstream>
using namespace std;

class AustralianVote {
	int decided(vector<int>& counts, int vsize) {
		int m = 0, mcount = 0, bcount = 0; 
		for(auto c : counts) {
			if(c <= 0) continue;
			bcount++; 

			if(c == m) mcount++; 
			else if(c > m) { m = c; mcount = 1; }
		}
		return (2*m > vsize || mcount == bcount) ? m : -1;
	}

	void winner(int max, vector<int>& counts, vector<string>& names) {
		for(int i=0; i<counts.size(); i++) if(counts[i] == max) cout << names[i] << endl;
	} 

	vector<int> loser(vector<int>& counts) {
		int m = 2000; for(auto c : counts) if(c >= 0) m = min(m, c);
		vector<int> cands; for(int i=0; i<counts.size(); i++) if(counts[i] == m) cands.push_back(i);
		return cands;
	}

	int transfer(int cand, vector<int>& vote, vector<int>& counts) {
		if(vote[cand] != 1) return -1;

		int lowest = 100, index = -1;
		for(int i=0; i<counts.size(); i++) {
			if(counts[i] < 0) continue;
			if(vote[i] < lowest) { lowest = vote[i]; index = i; }
		}
		return index;
	}

public:
	void winner(vector<string>& names, vector<vector<int>>& votes) {
		vector<int> counts(names.size());
		for(auto& vote : votes) 
			for(int i=0; i<votes.size(); i++) if(vote[i] == 1) { counts[i]++; break; }

		int size = 0, vsize = votes.size();
		while(size < names.size()) {
			int max = decided(counts, vsize); if(max > 0) { winner(max, counts, names); break; }

			vector<int> losers = loser(counts); 
			for(auto l : losers) { counts[l] = -1; size++; }
			for(auto l : losers) for(auto& vote : votes) { 
				int t = transfer(l, vote, counts); if(t >= 0) counts[t]++; 
			}
		}
	}
};

int main() {
	int t, n, v; string s; getline(cin, s); istringstream ss(s); ss >> t; getline(cin, s); 
	AustralianVote avote; 

	while(t-- > 0) {
		getline(cin, s); istringstream ss(s); ss >> n;
		vector<string> names(n); for(int i=0; i<n; i++) getline(cin, names[i]);

		vector<vector<int>> votes;
	    while(getline(cin, s) && !s.empty()) {
	    	istringstream ss(s); vector<int> vote(n); for(int i=0; i<n; i++) ss >> vote[i];
	    	votes.push_back(vote);
	    } 

		avote.winner(names, votes); 
		if(t > 0) cout << endl;
	}
}