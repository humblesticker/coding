/*
count bit ons
*/
class primary {
public:
	short CountBits(unsigned int x) {
		int count = 0;
		while(x > 0) {
			if(x & 0x01) count++;
			x >>= 1;
		}
		return count;
	}
};