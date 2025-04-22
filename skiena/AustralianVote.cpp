#include <iostream>
#include <vector>
#include <queue>
#include <string>
#include <algorithm>
#include <iterator>
#include <sstream>
#include <cassert>
using namespace std;

/*
only move to active candidates
track this separately 

*/
bool allTied(vector<vector<queue<int>>>&  candidates, int most) {
  for(const auto& candidate : candidates) 
    if(!candidate.empty() && candidate.size() != most) return false;
  
  return true;
}

void print(vector<vector<queue<int>>>& candidates) {
  cout << endl;
  for(int i=0; i<candidates.size(); i++) 
    for(auto vote : candidates[i]) {
      cout << i+1 << ": ";
      while(!vote.empty()) { cout << vote.front() << " "; vote.pop(); }
      cout << endl;
    }
}

void print(vector<bool>& dropped) {
  for(const auto& d : dropped) cout << d << " ";
  cout << endl;
}

vector<int> getWinner(vector<vector<queue<int>>>& candidates, vector<bool>& dropped, int vcount) {
  //print(candidates);
  
  int most = 0, least = vcount;
  for(const auto& candidate : candidates) {
    int count = candidate.size();
    if(count == 0) continue;
    most = max(most, count);
    least = min(least, count);
  }
  //cout << most << "," << least << "," << vcount << endl;    
  
  if(most * 2 > vcount || allTied(candidates, most)) {
    //cout << "winner decided:" << most << endl;
    vector<int> winners;
    for (int i=0; i<candidates.size(); i++) 
      if(candidates[i].size() == most) winners.push_back(i);
    return winners;
  }
  
  for (int i=0; i<candidates.size(); i++)
    if(candidates[i].size() == least) dropped[i] = true;
  //print(dropped);
    
  // remove candidate with least votes and reset count
  for (int i=0; i<candidates.size(); i++) {
    if(!dropped[i]) continue;
    
    // move votes to next candidates
    for(auto& vote : candidates[i]) {
      assert(vote.front() == i+1);
      do vote.pop();
      while(dropped[vote.front() - 1]);
      
      //cout << "move " << i+1 << " to " << vote.front() << endl;
      candidates[vote.front() - 1].push_back(vote);
    }
    candidates[i].clear();
  }
   
  return getWinner(candidates, dropped, vcount);
}

// candidates 
// vecotr<vector<queue<int>>>
// candidate 1 with 5 votes (vote is 20 candidates in order)
void process() {
  int n; cin >> n; cin.ignore();
  
  vector<string> names;
  vector<queue<int>> votes;
  string line, choice;
  while(n-- > 0) { getline(cin, line); names.push_back(line); }
  
  while(getline(cin, line) && !line.empty()) {
    stringstream ss(line); queue<int> vote;
    while(ss >> choice) vote.push(stoi(choice));
    votes.push_back(vote);
  }

  // vote should not be empty 
  // after max 18 iteration winner should be decided 
  vector<vector<queue<int>>> candidates(names.size(), vector<queue<int>>());
  for(const auto& vote : votes) {
    assert(!vote.empty());
    candidates[vote.front()-1].push_back(vote);
  }
  
  vector<bool> dropped(names.size());
  for(int w : getWinner(candidates, dropped, votes.size())) cout << names[w] << endl;
}

int main() {
    int t; cin >> t; cin.ignore();
    string line; getline(cin, line); // remove blank line before
    while(t-- > 0) { process(); if(t != 0) cout << endl; }
    return 0;
}
