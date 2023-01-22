package graphs;

import java.util.ArrayList;
import java.util.List;

class Graph1{
	private List<Node> vertices;
}

class Node{
	String name;
	List<Edge> edges;
	
	private void addEdges(String src, String dest, String weight) {
		edges = new ArrayList<>();
	}
}

class Edge{
	String src;
	String dest;
	String weight;
}

public class GraphRepHashmap {

}
