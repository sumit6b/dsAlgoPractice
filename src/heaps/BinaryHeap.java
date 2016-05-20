package heaps;

public class BinaryHeap {
	private int[] array;
	private int size;
	private int capacity;
	
	BinaryHeap(int capacity){
		this.capacity = capacity;
		this.array = new int[capacity];
		this.size=0;
	}
	
	private int getParentIndex(int i){
			return (i-1)/2;
	}
	private int getLeftChild(int parentPosition){
		return parentPosition*2+1;
	}
	private int getRightChild(int parentPosition){
		return parentPosition*2+2;
	}
	private void heapify(int index){
		if(this.array[index] > this.array[this.getParentIndex(index)]){
			int temp = this.array[index];
			this.array[index] = this.array[this.getParentIndex(index)];
			this.array[this.getParentIndex(index)] = temp;
			heapify(this.getParentIndex(index));
		}
		
	}
	
	public void insert(int data) throws Exception{
		if(capacity==size){
			throw new Exception("Heap Overflow");
		}else{
			int initialsize = size;
			this.array[size] = data;
			size++;
			this.heapify(initialsize);
			
		}
	}
	private void swapInArray(int index, int index2){
		int temp = array[index2];
		array[index2] = array[index];
		array[index] = temp;
	}
	private void precolateDown(int index){
		
		int leftChild = array[this.getLeftChild(index)];
		int rightChild = array[this.getRightChild(index)];
		if(getLeftChild(index)<size && getRightChild(index)<size){
			if(array[index]<Math.max(leftChild, rightChild)){
				if(array[index]<leftChild && leftChild<rightChild){
					swapInArray(index, this.getRightChild(index));
					precolateDown(this.getRightChild(index));
				}else{
					swapInArray(index, this.getLeftChild(index));
					precolateDown(this.getLeftChild(index));
				}
			}
		}else if(getLeftChild(index)<size){
			swapInArray(index, this.getLeftChild(index));
		}
		
	}
	public int deleteMax() throws Exception{
		if(size==0){
			throw new Exception("Heap Underflow");
		}
		int toreturn = array[0];
		swapInArray(0,size-1);
		size--;
		precolateDown(0);
		return toreturn;
	}
	public void display(){
		for (int i = 0; i < size; i++) {
			if(i!=0){System.out.print(", ");}
			System.out.print(array[i]);
		}
		System.out.print('\n');
	}
	public void heapSort() throws Exception{
		while(size!=0){
			System.out.println(deleteMax());
		}
	}
	
	public static void main(String[] args) throws Exception{
		BinaryHeap bh = new BinaryHeap(100);
		bh.insert(31);
		bh.insert(10);
		bh.insert(21);
		bh.insert(9);
		bh.insert(12);
		bh.insert(18);
		bh.insert(3);
		bh.insert(2);
		bh.insert(8);
		bh.insert(7);
		bh.display();
//		bh.deleteMax();
//		bh.display();
//		bh.deleteMax();
//		bh.display();
//		bh.deleteMax();
//		bh.display();
//		bh.deleteMax();
//		bh.display();
		bh.heapSort();
	}
	
}
