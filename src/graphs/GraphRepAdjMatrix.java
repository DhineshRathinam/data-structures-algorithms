package graphs;

class Graph {
	int numOfVertices;
	int[][] adjMatrix;

	Graph(int numOfVertices) {
		this.numOfVertices = numOfVertices;
		adjMatrix = new int[numOfVertices][numOfVertices];
	}

	public void addEdgeWithWeight(int u, int v, int w) {
		adjMatrix[u][v] = w;
		adjMatrix[v][u] = w;
	}

	public void addEdge(int u, int v) {
		adjMatrix[u][v] = 1;
		adjMatrix[v][u] = 1;
	}

	public void printgraph() {
		for (int i = 0; i < adjMatrix.length; i++) {
			for (int j = 0; j < adjMatrix.length; j++) {
				System.out.print(adjMatrix[i][j]);
			}
			System.out.println("");
		}
	}
}

public class GraphRepAdjMatrix {

	public static void main(String[] args) {
		// Define the graph

		Graph graph = new Graph(4);

		graph.addEdgeWithWeight(0, 1, 9);
		graph.addEdgeWithWeight(0, 2, 7);
		graph.addEdgeWithWeight(1, 2, 8);
		graph.addEdgeWithWeight(2, 0, 3);
		graph.addEdgeWithWeight(2, 3, 5);

		graph.printgraph();

	}

}
