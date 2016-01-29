import java.util.*;

public class Interpreter {
	private int[] reg = new int[10];
	private int[] ram = new int[1000];

	private int id(int inst) { return inst/100; }
	private int first(int inst) { return (inst/10)%10; }
	private int second(int inst) { return inst%10; }
	public Interpreter(Scanner s) {
		int i = 0; String line;
		while(s.hasNextLine() && (line = s.nextLine()).length() > 0) { ram[i] = Integer.parseInt(line); i++; }
	}

	private int process(int inst, int i) {
		int id = id(inst), first = first(inst), second = second(inst), next = i + 1;
		switch(id) {
			case 1: next = 1000; break;
			case 2: reg[first] = second; break;
			case 3: reg[first] += second; reg[first] %= 1000; break;
			case 4: reg[first] *= second; reg[first] %= 1000; break;
			case 5: reg[first] = reg[second]; break;
			case 6: reg[first] += reg[second]; reg[first] %= 1000; break;
			case 7: reg[first] *= reg[second]; reg[first] %= 1000; break;
			case 8: reg[first] = ram[reg[second]]; break; 
			case 9: ram[reg[second]] = reg[first]; break;
			case 0: if(reg[second] != 0) next = reg[first]; break;
		}
		return next;
	} 
	
	public int process() {
		int i = 0, count = 0, inst;
		while(i < 1000) { i = process(ram[i], i); count++; }
		return count;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = Integer.parseInt(s.nextLine()); s.nextLine();
		for(int i=0; i<n; i++) {
			if(i > 0) System.out.println();
			System.out.println((new Interpreter(s)).process());
		}
	}
}