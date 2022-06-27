package graphs;

class Graph {
	int numOfVertices;
	int[][] adjMatrix;

	Graph(int numOfVertices) {
		this.numOfVertices = numOfVertices;
		adjMatrix = new int[numOfVertices][numOfVertices];
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
		//Define the graph
		
		Graph graph = new Graph(4);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		
		graph.printgraph();
		
		
	}

}
