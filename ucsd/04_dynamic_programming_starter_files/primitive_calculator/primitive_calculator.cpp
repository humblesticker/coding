#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> optimal_sequence_greedy(int n) {
  std::vector<int> sequence;
  while (n >= 1) {
    sequence.push_back(n);
    if (n % 3 == 0) {
      n /= 3;
    } else if (n % 2 == 0) {
      n /= 2;
    } else {
      n = n - 1;
    }
  }
  reverse(sequence.begin(), sequence.end());
  return sequence;
}

vector<int> optimal_sequence(int n) {
  vector<int> dp(n+1), from(n+1), sequence; dp[0] = 0; 

  for (int i=1; i<n+1; i++) {
    dp[i] = dp[i-1] + 1; from[i] = i-1;
    if (i%3 == 0 && dp[i/3] + 1 < dp[i]) { dp[i] = dp[i/3] + 1; from[i] = i/3; }
    if (i%2 == 0 && dp[i/2] + 1 < dp[i]) { dp[i] = dp[i/2] + 1; from[i] = i/2; }
  }

  while (n >= 1) { sequence.push_back(n); n = from[n]; }
  reverse(sequence.begin(), sequence.end());
  return sequence;
}

int main() {
  int n; cin >> n;
  vector<int> sequence = optimal_sequence(n);
  cout << sequence.size() - 1 << endl;
  for (size_t i = 0; i < sequence.size(); ++i) { std::cout << sequence[i] << " "; }
}
