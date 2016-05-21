import java.util.*;

public class Doublets {
	static class Node implements Comparable<Node> {
		int id;
		String word; 
		int from = -1; 
		int distance = Integer.MAX_VALUE; 
		boolean visited = false;
		List<Integer> list = null;

		Node(int i, String w, List<Integer> l) { id = i; word = w; list = l; }
		public int compareTo(Node other) { return Integer.compare(distance, other.distance); }
		public String toString() { return id + "," + word + "," + from + "," + distance + "," + visited; }
	}

	// min pq by distance
	private static Node shortest(int src, int dest, Node[] nodes) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		nodes[src].visited = true; nodes[src].distance = 0;
		pq.add(nodes[src]);

		while(pq.peek() != null) {
			Node node = pq.poll();
			if(node.id == dest) return node;

			for(int i : node.list) {
				if(nodes[i].visited) continue;
				nodes[i].from = node.id; nodes[i].visited = true; nodes[i].distance = nodes[src].distance + 1;
				pq.add(nodes[i]);
			}
		} 
		return null;
	}

	private static boolean doublet(String s1, String s2) {
		if(s1.length() != s2.length()) return false;
		int diff = 0;
		for(int i=0; i<s1.length(); i++) if(s1.charAt(i) != s2.charAt(i)) diff++;
		return diff == 1;
	}

	private static Map<Integer, List<Integer>> getmap(List<String> dict) {
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for(int i=0; i<dict.size(); i++) {
			List<Integer> list = new ArrayList<Integer>();
			for(int j=0; j<dict.size(); j++) if(i != j && doublet(dict.get(i), dict.get(j))) list.add(j);
			map.put(i, list);
		}
		return map;
	}	

	private static int find(String s, List<String> list) {
		for(int i=0; i<list.size(); i++) if(s.equals(list.get(i))) return i;
		return -1;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		List<String> dict = new ArrayList<String>();
		while(s.hasNextLine()) {
			String line = s.nextLine(); if("".equals(line)) break;
			dict.add(line);
		}
		Map<Integer, List<Integer>> map = getmap(dict);

		while(s.hasNext()) {
			Node[] nodes = new Node[dict.size()];
			for(int i=0; i<nodes.length; i++) { nodes[i] = new Node(i, dict.get(i), map.get(i)); }

			int src = find(s.next(), dict), dest = find(s.next(), dict);
			Node node = shortest(src, dest, nodes);

			if(node == null) System.out.println("No solution");
			else { 
				LinkedList<String> stack = new LinkedList<String>();
				while(node.from >= 0) { stack.addFirst(node.word); node = nodes[node.from]; }
				stack.addFirst(dict.get(src));
				for(String word : stack) System.out.println(word);
			} 

			if(s.hasNext()) System.out.println();
		}
	}
}	