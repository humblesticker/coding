#include <iostream>
#include <cassert>
#include <vector>

using std::vector;

int binary_search(const vector<int> &a, int x) {
  int left = 0, right = (int)a.size()-1; 
  while(left <= right) {
    int mid = left + (right-left)/2;
    if(x < a[mid]) right = mid-1;
    else if(x > a[mid]) left = mid+1;
    else return mid;
  }
  return -1;
}

int linear_search(const vector<int> &a, int x) {
  for (size_t i = 0; i < a.size(); ++i) {
    if (a[i] == x) return i;
  }
  return -1;
}

int main() {
  int n;
  std::cin >> n;
  vector<int> a(n);
  for (size_t i = 0; i < a.size(); i++) {
    std::cin >> a[i];
  }
  int m;
  std::cin >> m;
  vector<int> b(m);
  for (int i = 0; i < m; ++i) {
    std::cin >> b[i];
  }
  for (int i = 0; i < m; ++i) {
    //replace with the call to binary_search when implemented
    std::cout << binary_search(a, b[i]) << ' ';
  }
}
/*
5 1 5 8 12 13 
5 8 1 23 1 11

while(left <= right)
  mid = left + (right - left)/2;
  if(x > a[mid]) left = mid + 1;
  else if(x < a[mid]) right = mid - 1; 
  else return mid;
return -1;
*/
