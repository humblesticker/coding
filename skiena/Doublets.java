import java.util.*;

public class Doublets {
	static class Node {
		int id; int from = -1; boolean visited = false;
		Node(int i) { id = i; }
	}

	private static void shortest(int src, Node[] nodes, Map<Integer, List<Integer>> map) {
		LinkedList<Node> queue = new LinkedList<Node>();
		nodes[src].visited = true; queue.addLast(nodes[src]);

		while(queue.size() > 0) {
			Node node = queue.removeFirst();
			for(int i : map.get(node.id)) 
				if(!nodes[i].visited) { nodes[i].from = node.id; nodes[i].visited = true; queue.addLast(nodes[i]); }
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
		List<String> dict = new ArrayList<String>(); Map<String, Integer> dictMap = new HashMap<String, Integer>();
		int index = 0;
		while(s.hasNextLine()) {
			String line = s.nextLine(); if("".equals(line)) break;
			dict.add(line); dictMap.put(line, index); index++;
		}
		Map<Integer, List<Integer>> map = getmap(dict, dictMap);

		while(s.hasNext()) {
			Node[] nodes = new Node[dict.size()];
			for(int i=0; i<nodes.length; i++) { nodes[i] = new Node(i); }

			int src = dictMap.get(s.next()), dest = dictMap.get(s.next());
			shortest(src, nodes, map);

			Node node = nodes[dest];
			if(node.visited) {
				LinkedList<String> stack = new LinkedList<String>();
				while(node.from >= 0) { stack.addFirst(dict.get(node.id)); node = nodes[node.from]; }
				stack.addFirst(dict.get(src));
				for(String word : stack) System.out.println(word);
			} else System.out.println("No solution.");

			if(s.hasNext()) System.out.println();
		}
	}
}	