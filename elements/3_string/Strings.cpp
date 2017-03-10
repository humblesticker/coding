class Strings {
public:
	/*
	int l, h
	while(l < h) compare if not same return alse
	*/
	bool IsPalindromic(const string& s) {
		int l=0, h=s.size()-1;
		while(l < h) 
			if(s[l++] != s[h--]) return false;
		return true;
	}	

	/*
	Find the first occurrence of a substring, s in t
	
	*/


	/*
	compute all valid ip address

	0123456789

	vector<string> addrs
	p from 0 to len-4 
		if c == 0 continue

		i from 1 to 3
			int first = part(s, p, i); if(first < 0) break;

			j from 1 to 3
				int second = part(s, p + i, j); if(first < 0) break;

				k from 1 to 3
					int third = part(s, p + i + j, k); if(first < 0) break;

					l from 1 to 3
						int fourth = part(s, p + i + j + k, l); if(first < 0) break;

						stringstream ss; ss << first << "." << second << "." <<  third << "." << fourth;
						list.add(ss.str())
						

	part(s, p, i) 
		if(p+i>=s.length()) return -1;
		int d = stoi(s.substr(p, i));
		return d > 255 ? -1 : d

	*/
	vector<string> get(string s) {

	}
};