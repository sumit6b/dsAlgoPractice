package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class LinkedListNode<T>{
	private T data;
	private LinkedListNode<T> nextNode;
	LinkedListNode(T data, LinkedListNode<T> node){
			this.data = data;
			this.nextNode = node;
	}
	public T getData(){
		return this.data;
	}
	public void setData(T data){
		this.data = data;
	}
	public LinkedListNode<T> getNextNode(){
		return this.nextNode;
	}
	public void setNextNode(LinkedListNode<T> node){
		this.nextNode = node;
	}
}

class LinkedListCustom<T>{
	private LinkedListNode<T> head=null;
	private int length=0;
	public void insert(int index, T data){
		length++;
		if(index==0){
			head = new LinkedListNode<T>(data, head);
		}else if(index==this.length()){
			LinkedListNode<T> temp = head;
			while(temp!=null){
				temp = temp.getNextNode();
			}
			temp = new LinkedListNode<T>(data, null);
		}else{
			LinkedListNode<T> temp = head;
			for(int i=0;i<index-1;i++){
				temp = temp.getNextNode();
			}
			temp.setNextNode(new LinkedListNode<T>(data, temp.getNextNode()));
		}
	}
	public T remove(int index) throws Exception{
		length--;
		LinkedListNode<T> old;
		if(index==0){
			if(head==null){
				throw new Exception("No elements in the linked List");
			}
			old = head;
			head = head.getNextNode();old.setNextNode(null);
		}else if(index==this.length()){
			LinkedListNode<T> temp = head;
			while(temp.getNextNode().getNextNode()!=null){
				temp = temp.getNextNode();
			}
			old = temp.getNextNode();
			temp.setNextNode(null);
		}else{
			LinkedListNode<T> temp = head;
			for(int i=0;i<index-1;i++){
				temp = temp.getNextNode();
			}
			old = temp.getNextNode();
			temp.setNextNode(temp.getNextNode().getNextNode());
		}
		return old.getData();
	}
	public int length(){
		return length;
	}
	public LinkedListNode<T> getHead(){
		return this.head;
	}
	public void display(){
		LinkedListNode temp = head;
		while(temp!=null){
			if(temp!=head){System.out.print(", ");}
			System.out.print(temp.getData());
		}
	}
}
class StackCustom<T>{
	LinkedListCustom<T> lc = new LinkedListCustom<T>();
	public void push(T data){
		lc.insert(lc.length(), data);
	}
	public T pop() throws Exception{
		return lc.remove(lc.length()-1);
	}
	public boolean isEmpty(){
		return lc.length()==0?true:false;
	}
}
class QueueCustom<T>{
	LinkedListCustom<T> lc = new LinkedListCustom<T>();
	public void enQueue(T data){
		lc.insert(lc.length(), data);
	}
	public T deQueue() throws Exception{
		return lc.remove(0);
	}
	public boolean isEmpty(){
		return lc.length()==0?true:false;
	}
}
class GraphEdge{
	private int u;
	private int v;
	private int weight;
	
	GraphEdge(int u, int v, int w){
		this.u=u;
		this.v=v;
		this.weight=w;
	};
	
	public int getU(){
		return u;
	}
	public void setU(int u){
		this.u=u;
	}
	public int getV(){
		return this.v;
	}
	public void setV(int v){
		this.v=v;
	}
	public int getWeight(){
		return this.weight;
	}
	public void setWeight(int w){
		this.weight=w;
	}
}
class GraphMatrix implements Graph{
	private int[][] matrix;
	private int size;
	public GraphMatrix(int size){
		this.size = size;
		matrix = new int[size][size];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
//				if(i==j){
//					matrix[i][j] = 1;
//				}else{
					matrix[i][j] = 0;
//				}
			}
		}
	}
	public int[] getAdjacentVerticesOf(int vertex) {
		int[] ans; int size=0;
		for(int i=0;i<matrix[0].length; i++){
			if(matrix[vertex][i]==1){
				size++;
			}
		}
		ans = new int[size];
		for(int j=0,i=0;i<matrix[0].length; i++){
			if(matrix[vertex][i]==1){
				ans[j]=i;
				j++;
			}
		}
		return ans;
	}
	public boolean removeEdge(int a, int b) {
		if(matrix[a][b]==1){
			matrix[a][b] = 0;
			return true;
		}
		return false;
		
	}
	public boolean isEdge(int a, int b) {
		if(matrix[a][b]>0){
			return true;
		}else{
			return false;
		}
	}
	public void display(){
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix.length;j++){
				if(j!=0){System.out.print(", ");}
				System.out.print(matrix[i][j]);
			}
			System.out.print('\n');
		}
	}
	public int size() {
		return this.size;
	}
	public void addEdge(GraphEdge e){
		matrix[e.getU()][e.getV()] = e.getWeight();
	}
	@Override
	public int getWeight(int a, int b) {
		return matrix[a][b];
	}
}

class GraphAdjacencyList implements Graph{
	ArrayList<LinkedListNode<GraphEdge>> holder;
	private int size;
	GraphAdjacencyList(int size){
		this.size = size;
		holder = new ArrayList<LinkedListNode<GraphEdge>>(); 
		for(int i=0;i<size;i++){
			holder.add(null);
		}
	}
	public int[] getAdjacentVerticesOf(int vertex) {
		LinkedListNode<GraphEdge> temp = holder.get(vertex);
		int size=0,i=0;
		while(temp!=null){
			size++;
			temp = temp.getNextNode();
		}
		int[] ans = new int[size];temp=holder.get(vertex);
		while(temp!=null){
			ans[i] = temp.getData().getV();i++;
			temp = temp.getNextNode();
		}
		return ans;
	}

	public void addEdge(GraphEdge e) {
		if(holder.get(e.getU())==null){
			LinkedListNode<GraphEdge> node = new LinkedListNode<GraphEdge>(new GraphEdge(e.getU(), e.getV(), e.getWeight()), null); 
			holder.set(e.getU(), node);
		}else{
			LinkedListNode<GraphEdge> temp = holder.get(e.getU());
			while(temp.getNextNode()!=null){
				temp = temp.getNextNode();
			}
			LinkedListNode<GraphEdge> node = new LinkedListNode<GraphEdge>(new GraphEdge(e.getU(), e.getV(), e.getWeight()), null); 
			temp.setNextNode(node);
		}
	}

	public boolean removeEdge(int a, int b) {
		LinkedListNode<GraphEdge> temp = holder.get(a);
		int index=0;
		while(temp.getNextNode()!=null){
			if(temp.getNextNode().getData().getV()==b){
				temp.setNextNode(temp.getNextNode().getNextNode());
				return true;
			}
		}
		return false;
	}

	public boolean isEdge(int a, int b) {
		LinkedListNode<GraphEdge> temp = holder.get(a);
		while(temp!=null){
			if(temp.getData().getV()==b){
				return true;
			}
			temp = temp.getNextNode();
		}
		return false;
	}

	public void display() {
		for(int i=0;i<holder.size();i++){
			LinkedListNode<GraphEdge> head = holder.get(i), temp=head;
			System.out.print(i+" : ");
			while(temp!=null){
				if(temp!=head){System.out.print(" -> ");}
				System.out.print(temp.getData().getV());
				temp = temp.getNextNode();
			}
			System.out.print('\n');
		}
	}
	public int size() {
		return this.size;
	}
	public int getWeight(int a, int b) {
		LinkedListNode<GraphEdge> temp = holder.get(a);
		while(temp!=null){
			if(temp.getData().getV()==b){
				return temp.getData().getWeight();
			}
			temp = temp.getNextNode();
		}
		return 0;
	}
}

public class GraphADT{
	private static void printArray(int[] a){
		for (int i = 0; i < a.length; i++) {
			if(i!=0){System.out.print(", ");}
			System.out.print(a[i]);
		}
		System.out.print('\n');
	}
	public static int[] dfs(Graph g) throws Exception{
		boolean [] visited = new boolean[g.size()];
		int[] ans=new int[g.size()];
		StackCustom<Integer> sc = new StackCustom<Integer>();
		sc.push(0);
		visited[0] = true;
		int i = 0;
		while(!sc.isEmpty()){
			int parent = sc.pop();
			ans[i] = parent;i++;
			int[] adjVertices = g.getAdjacentVerticesOf(parent);
			for(int j=0;j<adjVertices.length;j++){
				if(!visited[adjVertices[j]]){
					sc.push(adjVertices[j]);
					visited[adjVertices[j]]=true;
				}
			}
		}
		return ans;
	}
	public static int[] bfs(Graph g) throws Exception{
		int[] ans = new int[g.size()];
		boolean[] visited = new boolean[g.size()];
		QueueCustom<Integer> queue = new QueueCustom<Integer>();
		queue.enQueue(0);
		visited[0]=true;
		int i=0;
		while(!queue.isEmpty()){
			int parent = queue.deQueue();
			visited[parent] = true;
			ans[i] = parent; i++;
			int[] adjVertices = g.getAdjacentVerticesOf(parent);
			for(int j=0;j<adjVertices.length;j++){
				if(!visited[adjVertices[j]]){
					queue.enQueue(adjVertices[j]);
				}
			}
		}
		return ans;
	}
	public static int[] topologicalSort(Graph g) throws Exception{
		int[] ans=new int[g.size()];
		ArrayList<Integer> al = new ArrayList<Integer>();
		QueueCustom<Integer> queue = new QueueCustom<Integer>();
		int[] inDegree=new int[g.size()];
		for(int i=0;i<g.size();i++){
			boolean noEdge = true;
			for(int j =0;j<g.size();j++){
				if(g.isEdge(j, i)){
					inDegree[i]++;
					 noEdge=false;
				}
			}
			if(noEdge){
				al.add(i);
				queue.enQueue(i);
			}
		}
		int[] visited = new int[g.size()];
		int t=0;
		while(!queue.isEmpty()){
			int poped = queue.deQueue();
			ans[t]=poped; t++;
			int[] adjVertices = g.getAdjacentVerticesOf(poped);
			for(int i=0;i<adjVertices.length;i++){
					inDegree[adjVertices[i]]--;
					if(inDegree[adjVertices[i]]==0){
						queue.enQueue(adjVertices[i]);
					}
			}
		}
		for(int i=0;i<inDegree.length;i++){
			if(inDegree[i]>0){
				throw new Exception("Cycle exists in the graph");
			}
		}
		return ans;
	}
	
	public static int[] shortestPathUnweighted(Graph g, int v) throws Exception{
		QueueCustom<Integer> queue = new QueueCustom<Integer>();
		
		int[] weight = new int[g.size()];
		int[] visited = new int[g.size()];
		for(int i=0;i<weight.length;i++){weight[i] = Integer.MAX_VALUE;}
		weight[v]=0;
		queue.enQueue(v);
		while(!queue.isEmpty()){
			int poped = queue.deQueue();
			visited[poped]=1;
			int[] adjVertices = g.getAdjacentVerticesOf(poped);
			for(int i=0;i<adjVertices.length;i++){
				if(weight[adjVertices[i]]>weight[poped]+1){
					weight[adjVertices[i]] = weight[poped]+1;
				}
				if(visited[adjVertices[i]]==0){	
					queue.enQueue(adjVertices[i]);
					visited[adjVertices[i]]=1;
				}
			}
		}
		return weight;
	}
	public static int[] dijkstra(Graph g, int v) throws Exception{
		int[] weight=new int[g.size()];
		int[] parent=new int[g.size()];
		for(int i=1;i<weight.length;i++){weight[i]=Integer.MAX_VALUE;}
		QueueCustom<Integer> queue = new QueueCustom<Integer>();
		queue.enQueue(v);
		while(!queue.isEmpty()){
			int poped=queue.deQueue();
			int[] adjVertices = g.getAdjacentVerticesOf(poped);
			for(int i=0;i<adjVertices.length;i++){
				if(weight[adjVertices[i]]>weight[poped] + g.getWeight(poped,adjVertices[i])){
					weight[adjVertices[i]] = weight[poped] + g.getWeight(poped,adjVertices[i]);
					parent[adjVertices[i]] = poped;
				}
				queue.enQueue(adjVertices[i]);
			}
		}
		return weight; 
	}
	public static Graph prims(Graph g, int s){
		Graph mst = new GraphAdjacencyList(g.size());
		Set<Integer> reachSet = new HashSet<Integer>();
		Set<Integer> unReachSet = new HashSet<Integer>();
		reachSet.add(0);
		
		for(int i=1;i<g.size();i++){
			unReachSet.add(i);
		}
		class EdgeCompare implements java.util.Comparator<GraphEdge>{
			public int compare(GraphEdge o1, GraphEdge o2) {
				if(o1.getWeight() <= o2.getWeight()){
					return -1;
				}else{
					return 1;
				}
			};
		}
		PriorityQueue<GraphEdge> pq = new PriorityQueue<GraphEdge>(10, new EdgeCompare());
		int u=0;
		while(!unReachSet.isEmpty()){
			int[] adjVertices = g.getAdjacentVerticesOf(u);
			
			for(int i=0;i<adjVertices.length;i++){
				if(unReachSet.contains(adjVertices[i])){
					pq.add(new GraphEdge(u, adjVertices[i], g.getWeight(u, adjVertices[i])));	
				}
				
			}
			GraphEdge poped = pq.remove();
			mst.addEdge(new GraphEdge(poped.getU(), poped.getV(), poped.getWeight()));
			u=poped.getV();
			unReachSet.remove(u);
			reachSet.add(u);
		}
		return mst;
	}

	public static void main(String[] args) throws Exception{
		Graph gm = new GraphMatrix(4);
//		Graph gm = new GraphAdjacencyList(4);
		gm.addEdge(new GraphEdge(0,1,1));
		gm.addEdge(new GraphEdge(0,3,1));
		gm.addEdge(new GraphEdge(1,2,1));
		gm.addEdge(new GraphEdge(2,0,1));
		gm.addEdge(new GraphEdge(2,3,1));
		System.out.println("Graph representation:");
		gm.display();
		System.out.println("Adjecent vertices:");
		GraphADT.printArray(gm.getAdjacentVerticesOf(0));
		GraphADT.printArray(gm.getAdjacentVerticesOf(1));
		GraphADT.printArray(gm.getAdjacentVerticesOf(2));
		GraphADT.printArray(gm.getAdjacentVerticesOf(3));
		
		System.out.println("Depth First Search Algorithm:");
		int[] dfsAns = GraphADT.dfs(gm);
		GraphADT.printArray(dfsAns);
		
		System.out.println("Breadth First Search Algorithm:");
		int[] bfsAns = GraphADT.bfs(gm);
		GraphADT.printArray(bfsAns);
		
		try{
			System.out.println("Detecting cycle in a graph:");
			GraphADT.topologicalSort(gm);
		}catch(Exception e){
			System.out.println("Detected Cycle: "+e);
		}
		
		System.out.println("DAG:");
		Graph dag = new GraphAdjacencyList(8);
		dag.addEdge(new GraphEdge(0,3,1));
		dag.addEdge(new GraphEdge(1,3,1));
		dag.addEdge(new GraphEdge(1,4,1));
		dag.addEdge(new GraphEdge(2,4,1));
		dag.addEdge(new GraphEdge(2,7,1));
		dag.addEdge(new GraphEdge(3,5,1));
		dag.addEdge(new GraphEdge(3,6,1));
		dag.addEdge(new GraphEdge(3,7,1));
		dag.addEdge(new GraphEdge(4,6,1));
		dag.display();
		
		System.out.println("Topological Sort of DAG:");
		int[] topologicalOrder = GraphADT.topologicalSort(dag);
		GraphADT.printArray(topologicalOrder);
		
		System.out.println("DAG2:");
		Graph dag2 = new GraphAdjacencyList(8);
		dag2.addEdge(new GraphEdge(7,6,1));
		dag2.addEdge(new GraphEdge(6,5,1));
		dag2.addEdge(new GraphEdge(5,4,1));
		dag2.addEdge(new GraphEdge(4,3,1));
		dag2.addEdge(new GraphEdge(3,2,1));
		dag2.addEdge(new GraphEdge(2,1,1));
		dag2.addEdge(new GraphEdge(1,0,1));
		dag2.display();
		
		System.out.println("Topological Sort of DAG:");
		int[] topologicalOrder2 = GraphADT.topologicalSort(dag2);
		GraphADT.printArray(topologicalOrder2);
		
		System.out.println("Shortest path in unweighted graph: ");
		Graph ga = new GraphAdjacencyList(7);
		ga.addEdge(new GraphEdge(0,1,1));
		ga.addEdge(new GraphEdge(0,3,1));
		ga.addEdge(new GraphEdge(1,3,1));
		ga.addEdge(new GraphEdge(1,4,1));
		ga.addEdge(new GraphEdge(2,0,1));
		ga.addEdge(new GraphEdge(2,5,1));
		ga.addEdge(new GraphEdge(3,5,1));
		ga.addEdge(new GraphEdge(3,6,1));
		ga.addEdge(new GraphEdge(4,6,1));
		ga.addEdge(new GraphEdge(6,5,1));
		ga.display();
		int[] weights = GraphADT.shortestPathUnweighted(ga, 0);
		GraphADT.printArray(weights);
		
		System.out.println("Dijkstra Algorithm:");
		Graph g2 = new GraphAdjacencyList(5);
		g2.addEdge(new GraphEdge(0,2,1));
		g2.addEdge(new GraphEdge(0,1,4));
		g2.addEdge(new GraphEdge(1,4,4));
		g2.addEdge(new GraphEdge(2,1,2));
		g2.addEdge(new GraphEdge(2,3,4));
		g2.addEdge(new GraphEdge(3,4,4));
		g2.display();
		int[] weights2=GraphADT.dijkstra(g2, 0);
		GraphADT.printArray(weights2);
		
		System.out.println("Prims algorithm MST:");
		Graph mst = GraphADT.prims(g2, 0);
		mst.display();
	}
	
	
}


