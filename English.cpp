
// Given a number, print out the English representation
// 800 -> eight hundred
// 189319123 -> one hundred eighty nine million three hundred nineteen thousand one hundred twenty three
/*
int up to ~ 10 billions

123 > one hundred twenty three
123123123
*/
vector<int> ty { "", "", "twenty", "thirty", "fourty" }
// teen[] ten, eleven, twelve, thirteen ....
// single[] "", one, two, three, ....
// unit[] "", thousand, millions, billions, ...

// 123
// 123123
// 111
// 10
string hundred(int n) {
  string s = "";
  if(n/100) { s = single[n/100] + " hundred"; }
  n %= 100; 

  if(n < 20 && n >= 10) {
    s += " " + teen[n%10];
  } else {
    if(n/10) s += " " + ty[n/10];
    if(n%10) s += " " + single[n%10];
  }

  return s;
}
  
string english(int n) {
  int pos = 0; string s = "";

  while(n > 0) {
    string cur = hundred(n%1000); if(unit[pos] != "") cur += " " + unit[pos];
    if(s == "") s = cur; else s = cur + " " + s;
    n /= 1000; pos++;
  }

  return s;
}