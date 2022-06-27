package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class GraphForBfs {

	Map<String, List<String>> map;
	int numOfVertices;

	GraphForBfs(List<String> vertices) {
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
	
	protected void bfs(String vertex) {
		Set<String> set = new HashSet<String>();
		set.add(vertex);
		Queue<String> queue = new LinkedList<String>();
		queue.add(vertex);
		while(!queue .isEmpty()) {
			String v = queue.poll();
			System.out.print(v+" -> ");
			for (String val : map.get(v)) {
				if(!set.contains(val)) {
					set.add(val);
					queue.add(val);
				}
			}
		}
	}
}

public class BFS {
	
	

	public static void main(String[] args) {

		List<String> vertices = new ArrayList<String>();
		vertices.add("A");
		vertices.add("B");
		vertices.add("C");
		vertices.add("D");
		vertices.add("E");
		GraphForBfs graph = new GraphForBfs(vertices);

		graph.addEdge("A", "B");
		graph.addEdge("A", "E");
		graph.addEdge("B", "C");
		graph.addEdge("B", "D");
		graph.addEdge("B", "E");
		graph.addEdge("C", "D");
		graph.addEdge("D", "E");

		graph.printGraph();
		
		graph.bfs("B");
	}

}
