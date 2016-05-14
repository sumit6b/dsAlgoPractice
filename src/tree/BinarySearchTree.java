package tree;

class BSTNode{
	private BSTNode leftChild;
	private BSTNode rightChild;
	private int data;
	
	BSTNode(int data, BSTNode leftChild, BSTNode rightChild){
		this.data = data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
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
	public int getData(){
		return this.data;
	}
	public void setData(int data){
		this.data = data;
	}
}

public class BinarySearchTree {
	private BSTNode root;
	
	public void insertElement(int data){
		if(root==null){
			root = new BSTNode(data, null, null);
		}else {
			BSTNode temp = this.root;
			while(true){
				if(data<temp.getData()){
					if(temp.getRightChild()!=null){
						temp = temp.getLeftChild();
					}else{
						temp.setLeftChild(new BSTNode(data, null, null));
						break;
					}
					
				}else if(data>temp.getData()){
					if(temp.getRightChild()!=null){
						temp = temp.getRightChild();	
					}else{
						temp.setRightChild(new BSTNode(data, null, null));
						break;
					}
				}else{
					break;
				}
			}
			
		}
	}
	
	public void deleteElement(int id){
		BSTNode current = this.root;
		BSTNode parent = this.root;
		while(current.getData()!=id){
			parent = current;
			if(id<current.getData()){
				current = current.getLeftChild();
			}else if(id>current.getData()){
				current = current.getRightChild();
			}
		}
		if(current.getLeftChild()==null && current.getRightChild()==null){
			if(parent.getLeftChild().getData()==id){
				parent.setLeftChild(null);
			}else{
				parent.setRightChild(null);
			}
		}else if(current.getLeftChild()!= null && current.getRightChild()==null){
			if(parent.getLeftChild().getData()==id){
				parent.setLeftChild(current.getLeftChild());
			}else{
				parent.setLeftChild(current.getLeftChild());
			}
		}else if(current.getRightChild()!=null && current.getLeftChild()==null){
			if(parent.getLeftChild().getData()==id){
				parent.setLeftChild(current.getRightChild());
			}else{
				parent.setRightChild(current.getRightChild());
			}
		}else{
			//when we have both the child present in the node to be deleted:
			BSTNode successor = getSuccessor(current.getRightChild());
			if(parent.getLeftChild().getData()==id){
				parent.setLeftChild(successor);
			}else{
				parent.setRightChild(successor);
			}
		}
		
	}

	private BSTNode getSuccessor(BSTNode current) {
		if(current.getLeftChild()==null){
			return current;
		}else{
			current = current.getLeftChild();
			return getSuccessor(current);
		}
	}
}
