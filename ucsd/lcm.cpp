#include <iostream>

long long lcm_naive(int a, int b) {
  for (long l = 1; l <= (long long) a * b; ++l)
    if (l % a == 0 && l % b == 0)
      return l;

  return (long long) a * b;
}

int gcd(int a, int b) {
  while(b > 0) {
    int r = a % b;
    a = b; b = r;
  }
  return a;
}

int main() {
  int a, b;
  std::cin >> a >> b;
  std::cout << (long long)a * b / gcd(a, b) << std::endl;
  return 0;
}
