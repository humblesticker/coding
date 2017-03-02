/*
std::sort( values.begin(), values.end(), [ ]( const MyStruct& lhs, const MyStruct& rhs )
{
   return 
});

// while parsing remmove all 0 entry?
struct event {
	int time; int count; bool enter;
}

add 0, 0, true in front
max = 0, index = 0

i from 1 to len-1
	track max and index

vector<int> v { events[index-1], events[index] }

count might be 0 ?
assume no negative total
*/
#include <vector>
#include <algorithm>
#include <string>
using namespace std;

struct event {
	int time; int count; string action;
};

class mall {
public:
	// assume first one exists and  is enter
	vector<int> busiest(vector<event> events) {
		sort(events.begin(), events.end(), [](const event& lhs, const event& rhs) {
			return lhs.time < rhs.time;
		});

		int max = events[0].count, index = 0, cur = max;
		for(int i=1; i<events.length; i++) {
			if(events[i].action == "enter") cur += events[i].count;
			else cur -= events[i].count;

			if(cur > max) { max = cur; index = i; }
		}

		vector<int> range = { 0, events[index].time; }
		if(index > 0) { range[0] = events[index-1].time; }
		return range;
	}
};
