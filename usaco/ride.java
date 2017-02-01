/*
ID: humblesticker
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.util.*;

class ride {
  static int hash(String s) {
    int n = 1;
    for(char c : s.toCharArray()) n *= c - 'A' + 1;
    return n%47;
  }

  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("ride.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
    if(hash(f.readLine()) == hash(f.readLine())) out.println("GO");
    else out.println("STAY");
    out.close();                                  
  }
}