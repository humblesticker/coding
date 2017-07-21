#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

/*
3 50 
60 20 
100 50 
120 30

1 10 
500 30
*/
double get_optimal_value(int capacity, const vector<int>& weights, const vector<int>& values) {
  vector<int> order(weights.size()); for(int i=0; i<order.size(); i++) order[i] = i;
  auto comp = [&values, &weights] (int i, int j) { return (long)values[j]*weights[i] < (long)values[i]*weights[j]; };
  sort(order.begin(), order.end(), comp);

  double value = 0.0;
  for(auto o : order) {
    if(capacity < weights[o]) { value += (double)values[o]/weights[o]*capacity; break; }
    value += values[o]; capacity -= weights[o];
  }
  return value;
}

int main() {
  int n, capacity; std::cin >> n >> capacity;
  vector<int> values(n), weights(n);
  for (int i = 0; i < n; i++) { std::cin >> values[i] >> weights[i]; }

  double optimal_value = get_optimal_value(capacity, weights, values);
  std::cout.precision(10); std::cout << optimal_value << std::endl;
  return 0;
}
