package tree;

class Node{
	private int data;
	private Node left;
	private Node right;
	
	Node(int data, Node left, Node right){
		this.data = data;
		this.left = left;
		this.right = right;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
}
class LinkedListNode<T>{
	T data;
	LinkedListNode<T> nextNode;
	
	LinkedListNode(T data, LinkedListNode<T> nextNode){
		this.data = data;
		this.nextNode = nextNode;
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public LinkedListNode<T> getNextNode() {
		return nextNode;
	}
	public void setNextNode(LinkedListNode<T> nextNode) {
		this.nextNode = nextNode;
	}
	
}
class LinkedListCustom<T>{
	LinkedListNode<T> head;
	private int length=0;
	public void insert(int index, T data){
		if(index==0){
			head = new LinkedListNode<T>(data, null);
		}else if(index==this.length()){
			LinkedListNode<T> temp = head;
			while(temp.getNextNode()!=null){
				temp = temp.getNextNode();
			}
			temp.setNextNode(new LinkedListNode<T>(data, null));
		}else{
			LinkedListNode<T> temp = head;
			for(int i=0;i<index-1;i++){
				temp = temp.getNextNode();
			}
			LinkedListNode<T> old = temp.getNextNode();
			temp.setNextNode(temp.getNextNode().getNextNode());
			old.setNextNode(null);
		}
		this.length++;
	}
	public T removeByIndex(int index){
		
		if(index==0){
			LinkedListNode<T> old = head;
			head = head.getNextNode();
			old.setNextNode(null);
			this.length--;
			return (T) old.getData();
		}else if(index==this.length()-1){
			LinkedListNode<T> temp = head;T oldData;
			if(temp.getNextNode()==null){
				oldData = temp.getData();
				head=null;
			}else{
				while(temp.getNextNode().getNextNode()!=null){
					temp = temp.getNextNode();
				}
				oldData = temp.getNextNode().getData();
				temp.setNextNode(null);
			}
			this.length--;
			return oldData;
		}else{
			LinkedListNode<T> temp = head;
			for(int i=0;i<index-1;i++){
				temp = temp.getNextNode();
			}
			LinkedListNode<T> old = temp.getNextNode();
			temp.setNextNode(temp.getNextNode().getNextNode());
			old.setNextNode(null);
			this.length--;
			return (T) old.getData();
		}
	
	}
	public int getIndexByValue(T data){
		LinkedListNode<T> ls = head;
		for(int i=0;i<this.length;i++){
			if(ls.getData() == data){
				return i;
			} 
		}
		return -1;
	}
	public T getValueByIndex(int index){
		LinkedListNode<T> temp =head;
		for(int i=0;i<index;i++){
			temp = temp.getNextNode();
		}
		return (T) temp.getData();
	}
	public int length(){
		return this.length;
	}
	public void display(){
		LinkedListNode<T> temp = head;
		while(temp!=null){
			if(temp!=head){System.out.print(", ");}
			System.out.print(temp.getData());
			temp = temp.getNextNode();
		}
		System.out.print('\n');
		
	}
}
class QueueCustom<T>{
	private LinkedListCustom<T> lc = new LinkedListCustom<T>();
	private int length=0;
	public void enQueue(T data){
		this.length++;
		lc.insert(lc.length(), data);
	}
	public T deQueue(){
		this.length--;
		return lc.removeByIndex(0);
	}
	public int length(){
		return this.length;
	}
	public boolean isEmpty(){
		return this.length()>0?false:true;
	}
	public void display(){
		lc.display();
	}
}
class StackCustom<T>{
	LinkedListCustom<T> lc = new LinkedListCustom<T>();
	private int length=0;
	public void push(T data){
		lc.insert(lc.length(), data);
		this.length++;
	}
	public T pop() throws Exception{
		if(length==0){
			throw new Exception("Stack underflow");
		}
		this.length--;
		return (T) lc.removeByIndex(lc.length()-1);
	}
	public T peek(){
		return (T) lc.getValueByIndex(lc.length());
	}
	public int length(){
		return this.length;
	}
	public boolean isEmpty(){
		return this.length()>0?false:true;
	}
	public void display(){
		lc.display();
	}
}

public class BinaryTree {
	private Node root;
	private int length;
	BinaryTree(){
		this.root = null;
		this.length = 0;
	}
	public void bstInsert(int data){
		this.bstInsert(data, this.root);
	}
	public Node getRoot(){
		return this.root;
	};
	public void bstInsert(int data, Node node){
		if(node==null){
			this.root = new Node(data, null, null);
		}else if(data<node.getData() && node.getLeft()==null){
			node.setLeft(new Node(data, null, null));
		}else if(data>node.getData() && node.getRight()==null){
			node.setRight(new Node(data, null, null));
		}else if(data<node.getData() && node.getLeft() !=null){
			bstInsert(data, node.getLeft());
		}else if(data>node.getData() && node.getRight() != null){
			bstInsert(data, node.getRight());
		}
		return;
	}
	
//	public boolean bstDelete(int data){
//		
//	}
	public void inOrderTraversalRecursive(Node node){
		if(node==null){
			return;
		}else{
			inOrderTraversalRecursive(node.getLeft());
			System.out.println(node.getData());
			inOrderTraversalRecursive(node.getRight());
		} 
	}
	public void postOrderTraversalRecursive(Node node){
		if(node==null){
			return;
		}else{
			postOrderTraversalRecursive(node.getLeft());
			postOrderTraversalRecursive(node.getRight());
			System.out.println(node.getData());
		}
	}
	public void  preOrderTraversalRecursive(Node node){
		if(node==null){
			return;
		}else{
			System.out.println(node.getData());
			preOrderTraversalRecursive(node.getLeft());
			preOrderTraversalRecursive(node.getRight());
		}
	}
	
	public void inOrderTraversalIterative(Node root) throws Exception{
		StackCustom<Node> sc = new StackCustom<Node>();
		sc.push(root);
		Node temp = root;
		while(!sc.isEmpty()){
			while(temp.getLeft()!=null){
				temp = temp.getLeft();
				sc.push(temp);
			}
			Node poped = sc.pop();
			System.out.println(poped.getData());
			if(poped.getRight()!=null){
				temp = poped.getRight();
				sc.push(temp);
			}
			
		}
	}
	public void preOrderTraversalIterative(Node root) throws Exception{
		StackCustom<Node> sc = new StackCustom<Node>();
		sc.push(root);
		Node temp = root;
		System.out.println(temp.getData());
		while(!sc.isEmpty()){
			while(temp.getLeft()!=null){
				temp = temp.getLeft();
				System.out.println(temp.getData());
				sc.push(temp);
			}
			Node poped = sc.pop();
			if(poped.getRight()!=null){
				temp = poped.getRight();
				System.out.println(temp.getData());
				sc.push(temp);
			}
		}
	}
	public void postOrderTraversalIterative(Node root) throws Exception{
		StackCustom<Node> sc = new StackCustom<Node>();
		sc.push(root);
		Node temp = root;
		while(!sc.isEmpty()){
			while(temp.getLeft()!=null){
				temp = temp.getLeft();
				sc.push(temp);
			}
			
		
			
		}
	}
	public LinkedListCustom<Integer> levelOrderTraversal(Node root) throws Exception{
		LinkedListCustom<Integer> lc = new LinkedListCustom<Integer>();
		QueueCustom<Node> qc = new QueueCustom<Node>();
		qc.enQueue(root);
		while(!qc.isEmpty()){
			Node poped = qc.deQueue();
			lc.insert(lc.length(), poped.getData());
			if(poped.getLeft()!=null){
				qc.enQueue(poped.getLeft());
			}
			if(poped.getRight()!=null){
				qc.enQueue(poped.getRight());
			}
		}
		return lc;
	}
	public LinkedListCustom<Integer> zigZagTraversal(Node root) throws Exception{
		LinkedListCustom<Integer> lc = new LinkedListCustom<Integer>();
		StackCustom<Node> sc = new StackCustom<Node>();
		sc.push(root);
		int length=0;
		while(!sc.isEmpty()){
			StackCustom<Node> tempStack = new StackCustom<Node>();
			while(!sc.isEmpty()){
				Node popped = sc.pop();
				lc.insert(lc.length(), popped.getData());
				if(length%2==0){
					if(popped.getLeft()!=null){
						tempStack.push(popped.getLeft());
					}
					if(popped.getRight()!=null){
						tempStack.push(popped.getRight());
					}
				}else{
					if(popped.getRight()!=null){
						tempStack.push(popped.getRight());
					}
					if(popped.getLeft()!=null){
						tempStack.push(popped.getLeft());;
					}
				}
			}
			length++;
			sc = tempStack;
		}
		return lc;
	}
	
	public static void main(String[] args) throws Exception{
		BinaryTree bt = new BinaryTree();
		bt.bstInsert(23);
		bt.bstInsert(76);
		bt.bstInsert(28);
		bt.bstInsert(34);
		bt.bstInsert(87);
		bt.bstInsert(10);
		bt.bstInsert(14);
		bt.bstInsert(90);
		System.out.println("In order traversal:");
		bt.inOrderTraversalRecursive(bt.getRoot());
		System.out.println("Post order traversal:");
		bt.postOrderTraversalRecursive(bt.getRoot());
		System.out.println("Pre order traversal:");
		bt.preOrderTraversalRecursive(bt.getRoot());
		
//		System.out.println("LinkedList:");
//		LinkedListCustom<Integer> lc = new LinkedListCustom<Integer>();
//		lc.insert(0, 1);
//		lc.display();
//		lc.insert(1, 2);
//		lc.insert(2, 3);
//		lc.display();
		
//		System.out.println("Stack::");
//		StackCustom<Integer> sc = new StackCustom<Integer>();
//		sc.push(1);
//		sc.push(2);
//		sc.push(3);
//		sc.push(4);
//		sc.display();
//		sc.pop();
//		sc.pop();
//		
//		sc.display();
//		sc.pop();
//		sc.display();
//		sc.pop();
//		sc.display();
		System.out.println("Queue Unit test");
		QueueCustom<Integer> qc = new QueueCustom<Integer>();
		qc.enQueue(1);
		qc.enQueue(2);
		qc.enQueue(3);
		qc.enQueue(4);
		qc.display();
		qc.deQueue();
		qc.deQueue();
		qc.display();
		qc.deQueue();
		qc.display();
		qc.deQueue();
		qc.display();
	
		
		
		System.out.println("In order traversal iterative");
		bt.inOrderTraversalIterative(bt.getRoot());
		
		System.out.println("Pre order traversal iteravtive");
		bt.preOrderTraversalIterative(bt.root);
		
//		System.out.println("Post order traversal iteravtive");
//		bt.postOrderTraversalIterative(bt.root);
		
		System.out.println("Level order traversal");
		LinkedListCustom<Integer> lc = bt.levelOrderTraversal(bt.getRoot());
		lc.display();
		
		System.out.println("Zig Zag traversal");
		LinkedListCustom<Integer> lz = bt.zigZagTraversal(bt.getRoot());
		lz.display();
	}
}
