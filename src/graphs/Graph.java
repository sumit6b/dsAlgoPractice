package graphs;

public interface Graph {
	public int[] getAdjacentVerticesOf(int vertex);
	public void addEdge(GraphEdge e);
	public boolean removeEdge(int a, int b);
	public boolean isEdge(int a, int b);
	public void display();
	public int size();
	public int getWeight(int a, int b);
}
