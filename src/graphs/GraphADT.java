package graphs;

import java.util.ArrayList;
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
	public void addEdge(int a, int b) {
		matrix[a][b] = 1;
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
}

class GraphAdjacencyList implements Graph{
	ArrayList<LinkedListNode<Integer>> holder;
	private int size;
	GraphAdjacencyList(int size){
		this.size = size;
		holder = new ArrayList<LinkedListNode<Integer>>(); 
		for(int i=0;i<size;i++){
			holder.add(null);
		}
	}
	public int[] getAdjacentVerticesOf(int vertex) {
		LinkedListNode<Integer> temp = holder.get(vertex);
		int size=0,i=0;
		while(temp!=null){
			size++;
			temp = temp.getNextNode();
		}
		int[] ans = new int[size];temp=holder.get(vertex);
		while(temp!=null){
			ans[i] = temp.getData();i++;
			temp = temp.getNextNode();
		}
		return ans;
	}

	public void addEdge(int a, int b) {
		if(holder.get(a)==null){
			LinkedListNode<Integer> node = new LinkedListNode<Integer>(b, null); 
			holder.set(a, node);
		}else{
			LinkedListNode<Integer> temp = holder.get(a);
			while(temp.getNextNode()!=null){
				temp = temp.getNextNode();
			}
			LinkedListNode<Integer> node = new LinkedListNode<Integer>(b, null); 
			temp.setNextNode(node);
		}
	}

	public boolean removeEdge(int a, int b) {
		LinkedListNode<Integer> temp = holder.get(a);
		int index=0;
		while(temp.getNextNode()!=null){
			if(temp.getNextNode().getData()==b){
				temp.setNextNode(temp.getNextNode().getNextNode());
				return true;
			}
		}
		return false;
	}

	public boolean isEdge(int a, int b) {
		LinkedListNode<Integer> temp = holder.get(a);
		while(temp!=null){
			if(temp.getData()==b){
				return true;
			}
			temp = temp.getNextNode();
		}
		return false;
	}

	public void display() {
		for(int i=0;i<holder.size();i++){
			LinkedListNode<Integer> head = holder.get(i), temp=head;
			System.out.print(i+" : ");
			while(temp!=null){
				if(temp!=head){System.out.print(" -> ");}
				System.out.print(temp.getData());
				temp = temp.getNextNode();
			}
			System.out.print('\n');
		}
	}
	public int size() {
		return this.size;
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
	
	public static void main(String[] args) throws Exception{
		Graph gm = new GraphMatrix(4);
//		Graph gm = new GraphAdjacencyList(4);
		gm.addEdge(0, 1);
		gm.addEdge(0, 3);
		gm.addEdge(1, 2);
		gm.addEdge(2, 0);
		gm.addEdge(2, 3);
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
		dag.addEdge(0, 3);
		dag.addEdge(1, 3);
		dag.addEdge(1, 4);
		dag.addEdge(2, 4);
		dag.addEdge(2, 7);
		dag.addEdge(3, 5);
		dag.addEdge(3, 6);
		dag.addEdge(3, 7);
		dag.addEdge(4, 6);
		dag.display();
		
		System.out.println("Topological Sort of DAG:");
		int[] topologicalOrder = GraphADT.topologicalSort(dag);
		GraphADT.printArray(topologicalOrder);
		
		System.out.println("DAG2:");
		Graph dag2 = new GraphAdjacencyList(8);
		dag2.addEdge(7, 6);
		dag2.addEdge(6, 5);
		dag2.addEdge(5, 4);
		dag2.addEdge(4, 3);
		dag2.addEdge(3, 2);
		dag2.addEdge(2, 1);
		dag2.addEdge(1, 0);
		dag2.display();
		
		System.out.println("Topological Sort of DAG:");
		int[] topologicalOrder2 = GraphADT.topologicalSort(dag2);
		GraphADT.printArray(topologicalOrder2);
		
	}
	
	
}


