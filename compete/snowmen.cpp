#include <fstream>
#include <vector>
using namespace std;

ifstream cin("input.txt");
ofstream cout("output.txt");

int main() {
	int n, src, m; long long total = 0; cin >> n;
	vector<int> man(n+1), from(n+1); 

	for(int i=1; i<=n; i++) {
		cin >> src >> m;
		if(m > 0) { man[i] = man[src] + m; from[i] = src; } // connect
		else { src = from[src]; man[i] = man[src]; from[i] = from[src]; } // clone
		total += man[i];
	}
	cout << total << endl;
	return 0;
}
/*
8
0 1
1 5
2 4
3 2
4 3
5 0
6 6
1 0

8
0 1
1 5
2 4
3 2
4 0 
4 0
3 0
1 0
*/