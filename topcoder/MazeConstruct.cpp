#include <vector>
#include <string>
#include <iostream>
using namespace std;

class MazeConstruct {
	string empty(int n, int start, bool obstacle) {
		string out = "", empty = ".", occupied = "#";
		if(!obstacle) { empty = "#", occupied = "."; }

		for(int i=0; i<n; i++) out += (i < start ? empty : occupied);
		return out;
	}

public:
	vector<string> construct(int k) {
		vector<string> list;

		if(k < 50) list.push_back(construct(k+1, k+1, true));
		else if(k < 99) {
			int n = k%50 + 1;
			for(int i=0; i<=n; i++) list.push_back(construct(50, 50, true));
		} else {
			int end = 49, count = k - 97; if(k%2 == 0) { end++; count--; }
			for(int i=0; i<end; i++) {
				if(i%2 == 0) list.push_back(construct(50, 50, true));
				if(i%4 == 1) list.push_back(construct(50, 49, false));
				if(i%4 == 3) {
					int n = count > 98 ? 98 : count;
					list.push_back(construct(50, 50 - n/2, true)); 
					count -= n; if(count < 0) count = 0;
				}
			}
		}

		return list;
	}
};

int main(int argc, char* argv[]) {
	MazeConstruct maze;
	auto list = maze.construct(atoi(argv[1]));
	for (const auto& s : list) cout << s << endl;
}