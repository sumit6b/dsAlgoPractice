package linkedList;

public class ListNode {
	int data;
	ListNode next;
	
	public ListNode(int data){
		this.data = data;
	}
	public int getData(){
		return this.data;
	}
	public void setData(int data){
		this.data = data;
	}
	public void setNext(ListNode node){
		this.next = node;
	}
	public ListNode getNext(){
		return this.next;
	}
}
