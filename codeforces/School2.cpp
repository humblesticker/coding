int main() {
	return 0;
}
/*
int mod = 1000000007, ocount = 0, ccount = 0, total = 0;
vector<int> count[n];
i from 0 to n-1 
	if(s[i] == ')') { ccount++; count[i] = ccount; }
	else { ocount++; count[i] = ocount; }


size from 1 to n/2
	cprev = 0;
	i from 0 to n-1
		if(s[i] == ')') { cprev = count[i]; continue; } 
		if(count[i] < size) continue;
		int add = (ccount[i] choose size)*(ccount[i] - cprev choose size)
		total = (total + add) % mod

)(()()
((()))
()()()
(((
*/