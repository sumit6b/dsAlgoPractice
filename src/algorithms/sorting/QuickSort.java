package algorithms.sorting;

public class QuickSort {
	private static void printArray(int[] arr){
		for(int i=0;i<arr.length;i++){
			if(i!=0){System.out.print(", ");}
			System.out.print(arr[i]);
		}
		System.out.print('\n');
	}
	private static void swap(int i, int j, int[] arr){
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	private static int partition(int i, int j, int[] arr){
		int q=i;
		for(int k=i;k<j;k++){
			if(arr[k]<arr[j]){
				swap(k,q,arr);
				q++;
			}
		}
		return q;
	}
	public static int[] sort(int i, int j, int[] arr){
		if(i==j || i<0 || j<0 || i>j){return arr;}
		int p = partition(i,j,arr);
		swap(p,j,arr);
		sort(i,p-1,arr);
		sort(p+1,j,arr);
		return arr;
	}
	public static void main(String[] args){
		int[] arr = {23,43,65,77,85,29,47,12,90,24,87,28,36,100};
		printArray(sort(0, arr.length-1, arr));
	}

}
