package algorithms.sorting;


class BinaryHeap{
	private int[] array;
	private int size;
	private int capacity;
	BinaryHeap(int capacity){
		array = new int[capacity];
		size=0;
		this.capacity=capacity;
	}
	private void swap(int i,int j){
		int temp = array[j];
		array[j] = array[i];
		array[i] = temp;
	}
	private int getParentIndex(int index){
		return (index-1)/2;
	}
	private int getLeftChildIndex(int index){
		return index*2+1;
	}
	private int getRightChildIndex(int index){
		return index*2+2;
	}
	private void heapify(int index){
		if(index==0){return;}
		else{
			if(array[getParentIndex(index)]<array[index]){
				swap(getParentIndex(index), index);
				heapify(getParentIndex(index));
			}else{
				return;
			}
		}
	}
	private void prelocateDown(int index){
		if(getLeftChildIndex(index)<size && array[index]<array[getLeftChildIndex(index)]){
			if(getRightChildIndex(index)<size && array[this.getLeftChildIndex(index)]<array[getRightChildIndex(index)]){
				swap(index,getRightChildIndex(index));
				prelocateDown(getRightChildIndex(index));
			}else{
				swap(index, getLeftChildIndex(index));
				prelocateDown(getLeftChildIndex(index));
			}
		}else{
			if(this.getRightChildIndex(index)<size && array[index]<array[getRightChildIndex(index)]){
				swap(index,getRightChildIndex(index));
				prelocateDown(getRightChildIndex(index));
			}
		}
	}
	public void insert(int data) throws Exception{
		if(size>=capacity){
			throw new Exception("Heap overflow");
		}else{
			array[size] = data;
			heapify(size);
			size++;
		}
	}
	public int deleteMax() throws Exception{
		int ans;
		if(size==0){
			throw new Exception("Heap underflow");
		}else{
			ans = array[0];
			swap(0,size-1);
			size--;
			prelocateDown(0);
			
		}
		return ans;
	}
	public void display(){
		for(int i=0;i<this.size;i++){
			if(i!=0){System.out.print(", ");}
			System.out.print(array[i]);
		}
		System.out.print('\n');
	}
	public int[] heapSort() throws Exception{
		int[] ans=new int[size]; int i=0;
		while(size!=0){
			ans[i++] = this.deleteMax();
		}
		return ans;
	}
}
public class HeapSort {
	public static void printArray(int[] array){
		for(int i=0;i<array.length;i++){
			if(i!=0){System.out.print(", ");}
			System.out.print(array[i]);
		}
		System.out.print('\n');
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
		printArray(bh.heapSort());
	}

}
