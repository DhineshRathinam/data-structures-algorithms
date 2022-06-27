package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

class GraphForDfs {

	Map<String, List<String>> map;
	int numOfVertices;
	Set<String> set = new HashSet<String>();

	GraphForDfs(List<String> vertices) {
		map = new HashMap<String, List<String>>();
		for (int i = 0; i < vertices.size(); i++) {
			map.put(vertices.get(i), new ArrayList<String>());
		}
	}

	public void addEdge(String u, String v) {
		map.get(u).add(v);
		map.get(v).add(u);
	}

	protected void printGraph() {
		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}
	}

	protected void dfs(String vertex) {
		set.add(vertex);
		System.out.print(vertex + " -> ");
		List<String> list = map.get(vertex);
		for (String v : list) {
			if (!set.contains(v)) {
				dfs(v);
			}
		}
	}

	protected void iterativeDfs(String vertex) {
		set = new HashSet<String>();
		set.add(vertex);
		Stack<String> stack = new Stack<String>();
		stack.push(vertex);
		
		while (!stack.isEmpty()) {
			String v = stack.pop();
			System.out.print(v + " -> ");
			for (String av : map.get(v)) {
				if (!set.contains(av)) {
					stack.push(av);
					set.add(av);
				}
			}
		}
	}

}

public class DFS {

	public static void main(String[] args) {

		List<String> vertices = new ArrayList<String>();
		vertices.add("A");
		vertices.add("B");
		vertices.add("C");
		vertices.add("D");
		vertices.add("E");
		GraphForDfs graph = new GraphForDfs(vertices);

		graph.addEdge("A", "D");
		graph.addEdge("A", "E");
		graph.addEdge("B", "E");
		graph.addEdge("B", "D");
		graph.addEdge("C", "D");
		graph.addEdge("C", "E");

		graph.printGraph();
		System.out.println("Recursive DFS:");
		graph.dfs("E");
		System.out.println("");
		System.out.println("Iterative DFS:");
		graph.iterativeDfs("E");

	}

}
