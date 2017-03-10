#include <fstream>

std::ifstream cin("input.txt");
std::ofstream cout("output.txt");

  
int main() {
    long long a, b;
    cin >> a >> b;
    cout << a + b*b << std::endl;
    return 0;
}