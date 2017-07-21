#include <algorithm>
#include <iostream>
#include <vector>

using std::vector;

// count
bool has_majority(vector<int> &a, int left, int right, int key) {
  int count = 0;
  for(int i=left; i<right; i++) if(a[i] == key) count++;
  return count > (right - left)/2;
}

int get_majority_element(vector<int> &a, int left, int right) {
  if (left == right) return -1;
  if (left + 1 == right) return a[left];
  
  int mid = left + (right-left)/2;

  int lc = get_majority_element(a, left, mid);
  if(lc >= 0 && has_majority(a, left, right, lc)) return lc;

  int rc = get_majority_element(a, mid, right);
  if(rc >= 0 && has_majority(a, left, right, rc)) return rc;
  
  return -1;
}

int main() {
  int n;
  std::cin >> n;
  vector<int> a(n);
  for (size_t i = 0; i < a.size(); ++i) {
    std::cin >> a[i];
  }
  std::cout << (get_majority_element(a, 0, a.size()) != -1) << '\n';
}
