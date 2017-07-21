#include <fstream>

std::ifstream cin("input.txt");
std::ofstream cout("output.txt");

  
int main() {
	int a, b; cin >> a;
    for(int i=0; i<a; i++) b = a;
    return 0;
}