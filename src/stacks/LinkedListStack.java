package stacks;
class Node{
	int data;
	Node next;
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getNextNode() {
		return next;
	}
	public void setNextNode(Node node) {
		this.next = node;
	}
	public Node(int data, Node nextNode) {
		super();
		this.data = data;
		this.next = nextNode;
	}
}
class LinkedListCustom{
	Node head;
	int length;
	public void insert(int index, int data){
		if(index==0){
			head = new Node(data, head);
		}else if(index==this.length()){
			Node temp = head;
			while(temp.getNextNode()!=null){
				temp = temp.getNextNode();
			}
			temp.setNextNode(new Node(data, null));
		}else{
			//somewhere in between
			Node temp = head;
			for(int i=0;i<index-1;i++){
				temp = temp.getNextNode();
			}
			temp.getNextNode().setNextNode(null);
			temp.setNextNode(new Node(data, temp.getNextNode().getNextNode()));
		}
		length++;
	}
	public int removeAtIndex(int index){
		int popedData;
		if(index==0){
			Node temp = head.getNextNode();
			head.setNextNode(null);
			popedData = head.getData();
			head = temp;
		}else if(index == this.length()-1){
			Node temp = head;
			for(int i=0;i<index-1;i++){
				temp = temp.getNextNode();
			}
			popedData = temp.getNextNode().getData();
			temp.setNextNode(null);
		}else{
			Node temp = head;
			for(int i=0;i<index-1;i++){
				temp = temp.getNextNode();
			}
			Node t = temp.getNextNode();
			temp.setNextNode(temp.getNextNode().getNextNode());
			t.setNextNode(null);
			popedData = t.getData();
		}
		length--;
		return popedData;
	}
	public int elementAtIndex(int index){
		Node temp = head;
		for(int i=0;i<index;i++){
			temp = temp.getNextNode();
		}
		return temp.getData();
	}
	public int length(){
		return this.length;
	}
	public void print(){
		Node temp = head;
		while(temp.getNextNode()!=null){
			System.out.println(temp.getData());
			temp = temp.getNextNode();
		}
	}
}
public class LinkedListStack implements Stack{
	LinkedListCustom ls = new LinkedListCustom();
	@Override
	public void push(int data) {
		ls.insert(ls.length(), data);
	}

	@Override
	public int pop() {
		return ls.removeAtIndex(ls.length());
	}

	@Override
	public int peek() {
		ls.elementAtIndex(ls.length());
		return 0;
	}
	
	public void display(){
		ls.print();
	}

	public static void main(String[] args){
		ArrayStack as = new ArrayStack();
		as.push(1);
		as.push(2);
		as.push(3);
		as.push(10);
		as.display();
		as.pop();
		as.pop();
		as.display();
		as.push(5);
		as.display();
	}
	
}
