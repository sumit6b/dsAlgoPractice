package algorithms.sorting;

public class InsertionSort {
	public static void swap(int i, int j, int[] arr){
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	public static void printArray(int[] arr){
		for(int i=0;i<arr.length;i++){
			if(i!=0){System.out.print(", ");}
			System.out.print(arr[i]);
		}
		System.out.print('\n');
	}
	public static int[] sort(int[] arr){
		for(int i=1,j=0;i<arr.length;i++,j=0){
			while(j!=i){
				if(arr[j]>arr[i]){
					swap(i,j,arr);
				}
				j++;
			}
		}
		return arr;
	}
	public static void main(String[] args){
		int[] arr = {23,43,65,77,85,29,47,12};
		printArray(sort(arr));
	}
}
