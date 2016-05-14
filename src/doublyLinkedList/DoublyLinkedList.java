package doublyLinkedList;

public class DoublyLinkedList {
	private DLLNode head;
	private DLLNode tail;
	private int length;
	
	public DoublyLinkedList(){
		this.head = null;
		this.tail = head;
		this.length=0;
	}
	
	public int length(){
		return this.length;
	}
	
	public void insert(int data, int position){
		if(position==0){
			DLLNode dll = new DLLNode(data, null, head);
			head = dll;
		}else if(position == this.length() ){
			DLLNode dll = new DLLNode(data, tail, null);
			tail = dll;
		}else{
			DLLNode temp = head;
			for(int i=0;i<position-1;i++){
				temp = temp.getNextNode();
			}
			DLLNode dll = new DLLNode(data, temp, temp.getNextNode());
			temp.setNextNode(dll);
		}
	}
	public void delete(int position){
		if(position==0){
			DLLNode temp = head;
			head = head.getNextNode();
			temp.setNextNode(null);
		}else if(position == this.length()){
			DLLNode temp = tail;
			tail = tail.getPrevNode();
			temp.setPrevNode(null);
		}else{
			DLLNode temp = head;
			for(int i =0;i<position-1;i++){
				temp = temp.getNextNode();
			}
			DLLNode dll =  new DLLNode(data, temp, temp.getNextNode());
			temp.getNextNode().setPrevNode(dll);
			temp.setNextNode(dll);
		}
	}
	public void print(){
		
	}

}
