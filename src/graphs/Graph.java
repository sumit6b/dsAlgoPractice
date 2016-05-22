package graphs;

public interface Graph {
	public int[] getAdjacentVerticesOf(int vertex);
	public void addEdge(int a, int b);
	public void removeEdge(int a, int b);
	public boolean isEdge(int a, int b);
	public void display();
}
