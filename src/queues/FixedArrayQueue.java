package queues;

class CustomException extends Exception{
	CustomException(String message){
		super(message);
	}
	CustomException(){}
	
}
public class FixedArrayQueue implements queue{
	private int[] array;
	int front = 0;
	int rear = 0;
	int size=0;
	
	public FixedArrayQueue(int size){
		array = new int[size];
	}
	
	@Override
	public void enQueue(int data) throws CustomException {
		if(size == array.length){
			throw new CustomException("Full Queue Exception");
		}else{
			array[rear] = data;
			rear = (rear+1)%array.length;
			size++;
		}
	}

	@Override
	public int deQueue() throws CustomException {
		if(size==0){
			throw new CustomException("Empty Queue Exception");
		}else{
			int oldFront = front;
			size--;
			front = front+1%array.length;
			return array[oldFront];
		}
	}
	
	public void display(){
		int temp = front;
		while(temp!=rear){
			if(temp!=front){System.out.print(", ");}
			System.out.print(array[temp]);
			temp++;
		}
		System.out.print('\n');
	}
	
	public static void main(String[] args) throws CustomException{
		FixedArrayQueue fq = new FixedArrayQueue(10);
		fq.enQueue(1);
		fq.enQueue(2);
		fq.enQueue(3);
		fq.enQueue(4);
		fq.display();
		fq.deQueue();
		fq.deQueue();
		fq.display();
		fq.enQueue(10);
		fq.display();
	}

}
