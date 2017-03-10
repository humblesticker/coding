#include <iostream>
using namespace std;

void rec(int n) {
	if(n == 200000) return;
	rec(n+1);
}

int main() {
	rec(0);
	return 0;
}