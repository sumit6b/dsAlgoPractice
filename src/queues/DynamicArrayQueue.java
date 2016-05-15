package queues;
class DynamicArray{
	
	int[] array;
	int filled=0;
	
	public void insert(int data){
		
	}
	public int length(){
		return array.length;
	}
	public void expand(){
		
	}
	
}

public class DynamicArrayQueue implements queue{
	int size=0, front=0, rear=0;
	DynamicArray da = new DynamicArray();
	
	@Override
	public void enQueue(int data) throws CustomException {
		if(rear-front>=da.length()/2){da.expand();}
		da.insert(data);
		rear=(rear+1)%da.length();
	}

	@Override
	public int deQueue() throws CustomException {
		return 0;
	}
	
}
