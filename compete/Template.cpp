#include <fstream>
#include <limits>
#include <cmath>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;

ifstream cin("input.txt");
ofstream cout("output.txt");

class Template {
	int dist(char c1, char c2, vector<int>& X, vector<int>& Y) {
		return max(abs(X[c1] - X[c2]), abs(Y[c1] - Y[c2]));
	}

public:
	int parse(istream& cin, vector<int>& X, vector<int>& Y) {
		int cost = 0; string s; char prev = '\0';
		while(getline(cin, s)) {
			if(s == "%TEMPLATE-END%") break;

			for(char c : s) {
				if(X[c] == 0) continue; // not mapped to keyboard, whitespaces
				if(prev == '\0') { prev = c; continue; } // set prev 
				cost += dist(prev, c, X, Y);
				prev = c;
			}
		} 
		return cost;
	}
};

int main() {
	int W, H; cin >> W >> H;
	string s; getline(cin, s);

	vector<int> X(127), Y(127);
	for(int i=H; i>0; i--) {
		getline(cin, s); 
		for(int j=0; j<W; j++) { char c = s[j]; X[c] = i; Y[c] = j+1; }
	}

	string lang, optimal; int min = numeric_limits<int>::max(); Template t;
	while(getline(cin, lang)) {
		getline(cin, s); // remove template start
		int cost = t.parse(cin, X, Y); if(cost < min) { min = cost; optimal = lang; }
	}

	cout << optimal << endl << min << endl;
	return 0;
}