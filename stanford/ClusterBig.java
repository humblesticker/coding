/*
all nodes with distance 2 or less in the same cluster
merge all dist 0, 1, 2 return k ~ 500 operations total will be 10^8

build map<String, Integer>, string to node id

N = 2x10^5, k = N
node s 1 to N
	try dist 0
	try dist 1 ~ 24, toggle bit
	try dist 2 ~ 24*23, toggle bits
	if(union(s, t)) k-- 
return k
 */
import java.util.*;

public class ClusterBig {
	public static void main(String[] args) {
		
	}
}