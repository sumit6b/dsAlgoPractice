package queues;

class Node{
	private int data;
	private Node nextNode;
	
	public Node(int data, Node nextNode){
		this.data = data;
		this.nextNode = nextNode;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getNextNode() {
		return nextNode;
	}
	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
}
class LinkedListCustom{
	private Node head;
	private int length;
	
	public LinkedListCustom(){
		this.length=0;
	}
	
	
	public void insert(int index, int data){
		if(index==0){
			head = new Node(data, head);
		}else if(index==this.length()){
			Node temp=head;
			while(temp.getNextNode()!=null){
				temp = temp.getNextNode();
			}
			temp.setNextNode(new Node(data, null));
		}else{
			Node temp = head;
			for(int i =0;i<index-1;i++){
				temp = temp.getNextNode();
			}
			Node old = temp;
			temp.setNextNode(new Node(data, temp.getNextNode().getNextNode()));
			old.setNextNode(null);
		}
		this.length++;
	}
	
	public int remove(int index){
		this.length--;
		if(index==0){
			Node old = head;
			head = head.getNextNode();
			old.setNextNode(null);
			return old.getData();
		}else if(index==this.length()){
			Node temp = head;
			if(temp.getNextNode()==null){
				int ans = head.getData();
				head=null;
				return ans;
			}else{
				while(temp.getNextNode().getNextNode()!=null){
					temp = temp.getNextNode();
				}
				int ans = temp.getNextNode().getData();
				temp.setNextNode(null);
				return ans;
			}
		}else{
			Node temp = head;
			for(int i =0;i<index-1;i++){
				temp = temp.getNextNode();
			}
			Node old = temp.getNextNode();
			temp.setNextNode(temp.getNextNode().getNextNode());
			old.setNextNode(null);
			return old.getData();
		}
		
	}
	
	public int getIndexByValue(int index){
		Node temp = head;
		for(int i =0;i<index;i++){
			temp = temp.getNextNode();
		}
		return temp.getData();
	}
	public int length(){
		return this.length;
	}
	
	public void print(){
		Node temp = head;
		while(temp!=null){
			if(temp!=head){System.out.print(", ");}
			System.out.print(temp.getData());
			temp = temp.getNextNode();
		}
		System.out.print('\n');
	}
}
public class LinkedListQueue implements queue{
	
	LinkedListCustom ls = new LinkedListCustom();
	@Override
	public void enQueue(int data) throws CustomException {
		ls.insert(ls.length(), data);
	}

	@Override
	public int deQueue() throws CustomException {
		ls.remove(0);
		return 0;
	}
	
	public void display(){
		ls.print();
	}
	
	public static void main(String[] args) throws CustomException{
		LinkedListQueue ls = new LinkedListQueue();
		ls.enQueue(1);
		ls.enQueue(2);
		ls.enQueue(3);
		ls.enQueue(4);
		ls.display();
		ls.display();
		ls.deQueue();
		ls.display();
		ls.deQueue();
		ls.display();
		ls.deQueue();
		ls.display();
		
	}

}
