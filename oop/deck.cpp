/*
design data structures for a generic deck
how you would subclass it to implement blackjack

ask questions
1. main stories in priority order (who, how)
2. implement method and refactor as needed
3. design based on requirement discussion

1.
a) user draw a card from deck
b) user refresh deck (shuffle)
c) hands for scoring

2. 
deck
	card cards[52]
	int current;

	deck() 
		for(int i=0; i<52; i++) {
			cards[i].number = i%13 + 1;
			cards[i].suit = i/13;
		}

	card draw()
		if(current >= 52) throw "no card to draw";
		return cards[current++];

	shuffle() 
		srand(unsigned(time(0)));
		random_shuffle(begin(cards), end(cards));
		current = 0;

card
	number
	suit


blackjack


*/