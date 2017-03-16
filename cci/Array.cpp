#include <string>
#include <unordered_set>
#include <algorithm>
using namespace std;

class Array {
public:
	// s can be large, character set ? 128 if it is only 26 lowercase you can use bit vector for int 32 bit
	bool unique(string s) {
		if(s.length() > 128) return false;
		
		unordered_set<char> set; // ~ up to char set
		for(auto& c : s) if(!set.insert(c).second) return false;
		return true;
	}	

	bool unique1(string s) {
		sort(s.begin(), s.end());
		for(int i=1; i<s.size(); i++) 
			if(s[i] == s[i-1]) return false;
		return true;
	}

};
/*
O(c), if you know domain context, for example only 128 bit ascii O(1)

abcd
abca
a
""
aaaa

BF: set
BF w/o data structure
	loop to check ~ O(n^2)

sort check prev ~ O(nlogn) 

assume only lower case a to z
int bit vector ~ 32 
*/