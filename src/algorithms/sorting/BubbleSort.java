package algorithms.sorting;

public class BubbleSort {
	public static void swap(int i,int j, int[] arr){
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	public static int[] sort(int[] arr){
		boolean swapped=true;
		while(swapped){
			swapped=false;
			for(int i=1;i<arr.length;i++){
				if(arr[i-1]>arr[i]){
					swap(i-1,i,arr);
					swapped=true;
				}
			}
			System.out.println("After a complete swp:");
			display(arr);
			
		}
		return arr;
	}
	public static void display(int[] arr){
		for(int i=0;i<arr.length;i++){
			if(i!=0){System.out.print(", ");}
			System.out.print(arr[i]);
		}
		System.out.print('\n');
	}
	public static void main(String[] args){
		int[] arr = {98,34,56,31,90,26,73,78};
		display(sort(arr));
	}
}
