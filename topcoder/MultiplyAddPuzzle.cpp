#include <limits>
#include <algorithm>
#include <iostream>
using namespace std;
#define ll long long

class MultiplyAddPuzzle {
	ll multiple(ll f, ll b) {
		int count = 0;
		while(f > 1) {
			if(f%b > 0) return -1;
			f /= b; count++;
		}
		return count;
	}

	ll get(ll s, ll t, ll a, ll b) {
		ll v = 0; if(s == 0) { v++; s = a; }
		ll r = t%s;
		ll f = (t-r)/s, count = multiple(f, b); if(count < 0) return -1;
		//cout << s << "," << r << "," << f << "," << count << endl;
		v += count;
		
		if(r%a > 0) return -1;
		v += r/a;
		cout << r/a << endl;
		return v;
	}

	ll add(ll s, ll t, ll a) {
		if(t-s < a || (t-s)%a > 0) return -1;
		return (t-s)/a;
	}
	
public:
	ll minimalSteps(ll s, ll t, ll a, ll b) {
		if(s == t) return 0;
		if(s > t && b != 0) return -1;
		if(a == 0 && b == 1) return -1;
		if(a == 0 && b == 0) return t == 0 ? 1 : -1;
		
		if(a == 0) {
			ll r = t%s;
			if(t/s < b || r > 0) return -1;
			ll count = multiple(t/s, b); if(count < 0) return -1;
			return count;
		}

		if(b == 0) {
			ll first = add(0, t, a), second = add(s, t, a);
			//cout << first << "," << second << endl;
			if(first < 0 && second < 0) return -1;
			if(first < 0) return second;
			if(second < 0) return first + 1;
			return min(first + 1, second);
		}
		
		if(b == 1) return add(s, t, a);
		
		ll llmax = numeric_limits<long long>::max(), mval = llmax;
		for(ll i=s; i<=t; i+=a) {
			ll acount = (i-s)/a; if(mval < acount) break;
			ll val = get(i, t, a, b); if(val < 0) continue; 
			mval= min(mval, acount + val);
			cout << s << "," << acount + val << endl;
		}
		
		return mval == llmax ? -1 : mval;
	}
};
/*
{1, 1000000000000000000, 52579, 2}
*/