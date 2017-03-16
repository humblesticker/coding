#include <iostream>
#include <vector>

using std::vector;
using std::cin;
using std::cout;
using std::endl;
using ll = long long;

int find(const vector<int>& top, int n) {
  int diff = 0, index = -1;
  for(int i=0; i<top.size(); ++i) {
    int local = n - top[i];
    if(local > diff) { diff = local; index = i; }
  }
  return index;
}

ll MaxPairwiseProductFast(const vector<int>& numbers) {
  vector<int> top(2);
  for(int i=0; i<numbers.size(); ++i) {
    int pos = find(top, numbers[i]);
    if(pos >= 0) top[pos] = numbers[i];
  }

  return (ll)top[0] * top[1]; // for now max 2
}

int MaxPairwiseProduct(const vector<int>& numbers) {
  int result = 0;
  int n = numbers.size();
  for (int i = 0; i < n; ++i) {
    for (int j = i + 1; j < n; ++j) {
      if (numbers[i] * numbers[j] > result) {
        result = numbers[i] * numbers[j];
      }
    }
  }
  return result;
}

int main() {
  int n; cin >> n;
  vector<int> numbers(n);
  for (int i = 0; i < n; ++i) cin >> numbers[i];
  cout << MaxPairwiseProductFast(numbers) << endl;
  return 0;
}
/*
get max twice and for 2nd exclude 1st one
sort and get last 2
*/
