/*
loop dictionary 
create map of sorted key, actual word list
	L: dict len 
	W: longest word len
	~ LWlogW

for each word 
	get key 
	if not found return empty
	else return list

can you avoid sorting? is it worth to do that?
hash key ~ n
for each word you need check all word list [not good]
*/
#include <vector>
#include <string>
#include <map>
#include <algorithm>
using namespace std;

class anagram {
	map<string, vector<string>> maps; // using set instead?

public:
	anagram(vector<string>& dict) {
		for(auto& d : dict) {
			string orig = d;
			sort(d.begin(), d.end());
			maps[d].push_back(orig);
		}
	}

	vector<string> get(string word) {
		sort(word.begin(), word.end());
		return maps[word];
	}
};