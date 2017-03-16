#include <fstream>
#include <cmath>
#include <iomanip>
using namespace std;

std::ifstream cin("input.txt");
std::ofstream cout("output.txt");
 
int main() {
    int a, b, c; cin >> a >> b >> c;
    cout << setprecision(10) << (a + b + c)/6.0 << endl;
    return 0;
}