package stacks;

class DynamicArray{
	int[] array = new int[0];
	int size=0;
	public void append(int data){
		setValueAtIndex(size,data);
		size++;
	}
	public int removeLast(){
		size-=1;
		return array[size];
	}
	public int getLast(){
		return array[size];
	}
	public void setValueAtIndex(int index, int value){
		if(index>=array.length/2){
			
			int incSize = 0;
			if(array.length==0){
				incSize = 2;
			}else{
				incSize = array.length*2;
			}
			int[] temp = new int[incSize];
			for(int i=0;i<array.length;i++){
				temp[i] = array[i];
			}
			array = temp;
		}
		array[index] = value;
		
	}
	public int getValueAtIndex(int index){
		return array[index];
	}
	public int getLength(){
		return array.length;
	}
	public void print(){
		for(int i=0;i<size;i++){
			if(i!=0){System.out.print(", ");}
			System.out.print(array[i]);
		}
		System.out.print('\n');
	}
}

public class ArrayStack implements Stack{
	DynamicArray da = new DynamicArray();
	@Override
	public void push(int data) {
		da.append(data);
	}

	@Override
	public int pop() {
		return da.removeLast();
	}

	@Override
	public int peek() {
		// TODO Auto-generated method stub
		return da.getLast();
	}
	public void display(){
		da.print();
	}
	
	
	public static void main(String[] args){
		ArrayStack as = new ArrayStack();
		as.push(1);
		as.push(2);
		as.push(3);
		as.push(4);
		as.display();
		as.pop();
		as.pop();
		as.display();
		as.push(5);
		as.display();
	}
	
}




