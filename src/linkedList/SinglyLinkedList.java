package linkedList;

class SinglyLinkedList {
	ListNode head;
	public int length(){
		int count=0;
		ListNode temp = this.head;
		while(temp!=null){
			temp = temp.getNext();
			count++;
		}
		return count;
	}
	public void insert(int data, int position){
		if(position==0){
			ListNode listNode = new ListNode(data);
			listNode.setNext(this.head);
			this.head = listNode;
		}else if(position==this.length()){
			ListNode temp = this.head;
			while(temp.getNext()!=null){
				temp = temp.getNext();
			}
			temp.setNext(new ListNode(data));
		}else{
			ListNode temp = this.head;
			for(int t = 0;t<position-1;t++){
				temp = temp.getNext();
			}
			ListNode ln = new ListNode(data);
			ln.setNext(temp.getNext());
			temp.setNext(ln);
		}
	}
	public void append(int data){
		this.insert(data, this.length());
	}
	public void prepend(int data){
		this.insert(data, 0);
	}
	public void print(){
		ListNode temp = head;
		System.out.print("Length: "+ this.length() +" | ");
		while(temp.getNext()!= null){
			System.out.print(temp.getData()+ " -> ");
			temp = temp.getNext();
		}
		if(temp!=null){
			System.out.println(temp.getData());
		}
	}
	public void deleteByIndex(int index){
		ListNode ln = head;
		if(index > this.length()){
			System.out.println("Index must be less than the size of the linkedList");
			return;
		}
		if(index==0){
			ln = head;
			head = head.getNext();
			ln.setNext(null);
		}else if(index==this.length()){
			ListNode temp = head;
			for(int t=0;t<index-1;t++){
				temp = temp.getNext();
			}
			temp.setNext(null);
		}
		else{
			for(int t=0;t<index-1;t++){
				ln = ln.getNext();
			}
			ListNode tobeDeleted = ln.getNext();
			ln.setNext(tobeDeleted.getNext());
			tobeDeleted.setNext(null);
		}
	}
}