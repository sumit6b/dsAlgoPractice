package linkedList;

public class SinglyLinkedListMain {
	public static void main(String[] args){
		SinglyLinkedList list = new SinglyLinkedList();
		list.append(1);
		list.append(2);
		list.append(4);
		list.append(5);
		list.append(6);
		list.print();
		list.insert(3, 2);
		list.print();
		list.deleteByIndex(0);
		list.print();
		list.prepend(1);
		list.print();
		list.deleteByIndex(1);
		list.print();
	}

	
}
