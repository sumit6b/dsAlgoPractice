package algorithms.sorting;
class BSTNode{
	private int data;
	private BSTNode leftChild;
	private BSTNode rightChild;
	
	BSTNode(int data, BSTNode leftChild, BSTNode rightChild){
		this.data = data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	public void setData(int data){
		this.data = data;
	}
	public int getData(){
		return this.data;
	}
	public void setLeftChild(BSTNode leftChild){
		this.leftChild = leftChild;
	}
	public BSTNode getLeftChild(){
		return this.leftChild;
	}
	public void setRightChild(BSTNode rightChild){
		this.rightChild = rightChild;
	}
	public BSTNode getRightChild(){
		return this.rightChild;
	}
	
}
class BST{
	private BSTNode root;
	private int length;
	BST(){
		length=0;
		root=null;
	}
	private void insert(int data, BSTNode node){
		if(root==null){
			this.root = new BSTNode(data,null,null);
		}else{
			if(data<node.getData()){
				if(node.getLeftChild()==null){
					length++;
					node.setLeftChild(new BSTNode(data,null,null));
				}else{
					insert(data,node.getLeftChild());
				}
			}else if(data>node.getData()){
				if(node.getRightChild()==null){
					length++;
					node.setRightChild(new BSTNode(data, null, null));	
				}else{
					insert(data, node.getRightChild());
				}
			}
		}
	}
	private void inorderTraversal(BSTNode node){
		if(node==null){
			System.out.println("empty tree");
		}else{
			if(node.getLeftChild()!=null){
				inorderTraversal(node.getLeftChild());
			}
			System.out.println(node.getData());
			if(node.getRightChild()!=null){
				inorderTraversal(node.getRightChild());
			}
		}
	}
	public int length(){
		return this.length;
	}
	public void insert(int data){
		insert(data, root);
	}
	public void inorderTraversal(){
		inorderTraversal(root);
	}
}
public class TreeSort {
	private static void printArray(int[] arr){
		for(int i=0;i<arr.length;i++){
			if(i!=0){System.out.print(", ");}
			System.out.print(arr[i]);
		}
		System.out.print('\n');
	}
	public static void main(String[] args){
		BST bst = new BST();
		bst.insert(23);
		bst.insert(43);
		bst.insert(65);
		bst.insert(77);
		bst.insert(85);
		bst.insert(29);
		bst.insert(47);
		bst.insert(12);
		bst.insert(90);
		bst.insert(24);
		bst.insert(87);
		bst.insert(28);
		bst.insert(36);
		bst.insert(100);
		bst.inorderTraversal();
	}
}
