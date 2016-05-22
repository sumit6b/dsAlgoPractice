package graphs;

import java.util.ArrayList;

class GraphMatrix implements Graph{
	private int[][] matrix;
	public GraphMatrix(int size){
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
	public void removeEdge(int a, int b) {
		matrix[a][b] = 0;
	}
	public boolean isEdge(int a, int b) {
		if(matrix[a][b]==1){
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
}
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
//	public T[] toArray(Class<T> k){
//		return (T[]) Array.newInstance(k, this.length()); 
//	}
	public void display(){
		LinkedListNode temp = head;
		while(temp!=null){
			if(temp!=head){System.out.print(", ");}
			System.out.print(temp.getData());
		}
	}
}
class GraphAdjacencyList implements Graph{
	ArrayList<LinkedListNode<Integer>> holder;
	GraphAdjacencyList(int size){
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

	public void removeEdge(int a, int b) {
		
	}

	public boolean isEdge(int a, int b) {
		LinkedListNode<Integer> temp = holder.get(a);
		while(temp!=null){
			if(temp.getData()==b){
				return true;
			}
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
}

public class GraphADT{
	public static void main(String[] args){
//		GraphMatrix gm = new GraphMatrix(4);
		GraphAdjacencyList gm = new GraphAdjacencyList(4);
		gm.addEdge(0, 1);
		gm.addEdge(0, 3);
		gm.addEdge(1, 2);
		gm.addEdge(2, 0);
		gm.addEdge(2, 3);
		gm.display();
		GraphADT.printArray(gm.getAdjacentVerticesOf(0));
		GraphADT.printArray(gm.getAdjacentVerticesOf(1));
		GraphADT.printArray(gm.getAdjacentVerticesOf(2));
		GraphADT.printArray(gm.getAdjacentVerticesOf(3));
	}
	public static void printArray(int[] a){
		for (int i = 0; i < a.length; i++) {
			if(i!=0){System.out.print(", ");}
			System.out.print(a[i]);
		}
		System.out.print('\n');
	}
}


