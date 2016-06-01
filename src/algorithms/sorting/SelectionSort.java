package algorithms.sorting;

public class SelectionSort {
	private static void swap(int i, int j, int[] arr){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j]=temp;
	}
	private static void printArray(int[] arr){
		for(int i=0;i<arr.length;i++){
			if(i!=0){System.out.print(", ");}
			System.out.print(arr[i]);
		}
		System.out.print('\n');
	}
	public static int[] sort(int[] arr){
		for(int j=0;j<arr.length-1;j++){
			int index=j;
			for(int i=j+1;i<arr.length;i++){
				if(arr[i]<arr[index]){
					index=i;
				}
			}
			swap(j,index,arr);
		}
		return arr;
	}
	public static void main(String[] args){
		int[] arr = {23,43,65,77,85,29,47,12,90,24,87,28,36,100};
		printArray(sort(arr));
	}
}
