package doublyLinkedList;

public class DLLNode {
	private int data;
	private DLLNode prevNode;
	private DLLNode nextNode;
	
	public DLLNode(int data, DLLNode prevNode, DLLNode nextNode){
		this.data = data;
		this.prevNode = prevNode;
		this.nextNode = nextNode;
	}
	
	public void setData(int data){
		this.data = data;
	}
	
	public int getData(){
		return this.data;
	}
	
	public void setNextNode(DLLNode node){
		this.nextNode = node;
	}
	
	public void setPrevNode(DLLNode node){
		this.prevNode = node;
	}
	
	public DLLNode getNextNode(){
		return this.nextNode;
	}
	
	public DLLNode getPrevNode(){
		return this.prevNode;
	}
}
