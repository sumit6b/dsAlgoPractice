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
	
	public static void main(String[] args){
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
		
	}
}
