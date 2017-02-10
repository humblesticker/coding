#include <string>
#include <vector>
using namespace std;

class BuildingStrings {
	string letters = "abcdefghijklmnopqrstuvwxyz";
	
	string get(int k) {
		for(int i=1; i*i<=k; i++) {
			if(i*i == k) return letters.substr(0, i);
			if(i*i*2 == k) return letters.substr(0, i) + letters.substr(0, i);
		}
		return "";
	}
	
public:
	vector<string> findAny(int K) {
		vector<string> ss;
		int count = K/1300; string s = letters.substr(0, 26) + letters.substr(0, 24);
		while(count-- > 0) ss.push_back(s);
		
		K %= 1300; count = K/512; s = letters.substr(0, 16) + letters.substr(0, 16);
		while(count-- > 0) ss.push_back(s);
		
		K %= 512; int f = 1;
		while(K > 0) {
			s = get((K & 0x01) * f); if(!s.empty()) ss.push_back(s);
			K >>= 1; f *= 2;
		}
		
		return ss;
	}
};