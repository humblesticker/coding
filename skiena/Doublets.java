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
		public String toString() { return from + "|" + distance + "|" + visited; }
	}

	// BFS
	private static void shortest(int src, Node[] nodes) {
		LinkedList<Node> queue = new LinkedList<Node>();
		nodes[src].visited = true; nodes[src].distance = 0;
		queue.addLast(nodes[src]);

		while(queue.size() > 0) {
			Node node = queue.removeFirst();
			for(int i : node.list) {
				if(node.distance + 1 < nodes[i].distance) { nodes[i].from = node.id; nodes[i].distance = node.distance + 1; }
				if(!nodes[i].visited) { nodes[i].visited = true; queue.addLast(nodes[i]); }
			}
		} 
	}

	private static List<Integer> getDoublets(String s, Map<String, Integer> dictMap) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<s.length(); i++)
			for(char c='a'; c<='z'; c++) {
				if(c == s.charAt(i)) continue;
				String find = s.substring(0, i) + c + s.substring(i+1);
				if(dictMap.containsKey(find)) list.add(dictMap.get(find)); 
			}
		return list;
	}

	private static Map<Integer, List<Integer>> getmap(List<String> dict, Map<String, Integer> dictMap) {
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for(int i=0; i<dict.size(); i++) map.put(i, getDoublets(dict.get(i), dictMap));
		return map;
	}	

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		List<String> dict = new ArrayList<String>();
		Map<String, Integer> dictMap = new HashMap<String, Integer>();
		int index = 0;
		while(s.hasNextLine()) {
			String line = s.nextLine(); if("".equals(line)) break;
			dict.add(line); dictMap.put(line, index); index++;
		}
		Map<Integer, List<Integer>> map = getmap(dict, dictMap);

		while(s.hasNext()) {
			Node[] nodes = new Node[dict.size()];
			for(int i=0; i<nodes.length; i++) { nodes[i] = new Node(i, dict.get(i), map.get(i)); }

			int src = dictMap.get(s.next()), dest = dictMap.get(s.next());
			shortest(src, nodes);

			Node node = nodes[dest];
			if(node.visited) {
				LinkedList<String> stack = new LinkedList<String>();
				while(node.from >= 0) { stack.addFirst(node.word); node = nodes[node.from]; }
				stack.addFirst(dict.get(src));
				for(String word : stack) System.out.println(word);
			} else System.out.println("No solution.");

			if(s.hasNext()) System.out.println();
		}
	}
}	