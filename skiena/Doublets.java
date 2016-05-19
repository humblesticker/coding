/*
	for each word
		build index of all doublets ~ n^2

	
	for given pair
		min list = { }, min = Integer.MAX_VALUE
		
		while(valid index available for doublets)
			if source == dest compare with min list
			recursively navigate all doublets from source
			source = doublet, 
			list.add(doublet)

	return min list
*/
