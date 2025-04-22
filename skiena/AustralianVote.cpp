#include <iostream>
#include <vector>
#include <queue>
#include <string>
#include <algorithm>
#include <iterator>
#include <sstream>
#include <cassert>
#include <utility>
using namespace std;

// return non-empty winners if decided
vector<int> winnersDecided(vector<vector<int>>& candidates, int most, int vcount) {
  bool tied = true;
  for(const auto& candidate : candidates) 
    if(!candidate.empty() && candidate.size() != most) { tied = false; break; }
  
  vector<int> winners;
  if(most * 2 > vcount || tied) {
    for (int i=0; i<candidates.size(); i++) 
      if(candidates[i].size() == most) winners.push_back(i);
  }
  return winners;
}

// return most, least
pair<int, int> count(vector<vector<int>>& candidates, int vcount) {
  int most = 0, least = vcount;
  for(const auto& candidate : candidates) {
    int count = candidate.size(); 
    if(count == 0) continue; // no need to handle 0 vote candidate
    
    most = max(most, count);
    least = min(least, count);
  }
  return make_pair(most, least);
}

vector<int> getWinner(vector<vector<int>>& candidates, vector<queue<int>>& votes, vector<bool>& dropped) {
  auto p = count(candidates, votes.size());
  auto winners = winnersDecided(candidates, p.first, votes.size());
  if(!winners.empty()) return winners;
  
  // remove candidate with least votes and reset count
  for (int i=0; i<candidates.size(); i++)
    if(candidates[i].size() == p.second) dropped[i] = true;
    
  for (int i=0; i<candidates.size(); i++) {
    if(!dropped[i] || candidates[i].empty()) continue;
    
    for(auto& vi : candidates[i]) {
      auto& vote = votes[vi]; assert(vote.front() == i+1);
      do vote.pop(); while(dropped[vote.front() - 1]);
      candidates[vote.front() - 1].push_back(vi);
    }
    candidates[i].clear();
  }
   
  return getWinner(candidates, votes, dropped);
}

// use vector<vector<int>> for candidates
// int point to votes index 
int main() {
    int t, n; cin >> t; cin.ignore();
    string line, choice; getline(cin, line); // remove blank line before
    while(t-- > 0) { 
      cin >> n; cin.ignore();
      vector<string> names(n); 
      for(int i=0; i<n; i++) getline(cin, names[i]);
  
      vector<queue<int>> votes;
      while(getline(cin, line) && !line.empty()) {
        stringstream ss(line); queue<int> vote;
        while(ss >> choice) vote.push(stoi(choice)); // index
        votes.push_back(vote);
      }
      
      vector<vector<int>> candidates(n, vector<int>());
      for(int i=0; i<votes.size(); i++) {
        assert(!votes[i].empty());
        candidates[votes[i].front() - 1].push_back(i);
      }
  
      vector<bool> dropped(n);
      vector<int> winner = getWinner(candidates, votes, dropped);
      for(int w : winner) cout << names[w] << endl;
      if(t > 0) cout << endl; 
    }
    return 0;
}
