package algorithms.sorting.linearSorting;

/*
 * Radix sort using count sort as intermediate search
 */

public class RadixSort {
	public static void printArray(int[] arr){
		for(int i=0;i<arr.length;i++){
			if(i!=0){System.out.print(", ");}
			System.out.print(arr[i]);
		}
		System.out.print('\n');
	}
	public static int[] sort(int d, int[] arr){
		int[] a = new int[10];
		for(int i=0;i<arr.length;i++){
			a[(arr[i]%((int)Math.pow(10, d)))/(int)Math.pow(10, d-1)]++;
		}
		int[] count = new int[a.length];count[0]=a[0];
		for(int i=1,sum=a[0];i<a.length;i++){
			count[i]=sum+a[i];
			sum=count[i];
		}
		int[] ans = new int[arr.length];
		for(int i=0;i<arr.length;i++){
			int itr = (arr[i]%((int)Math.pow(10, d)))/(int)Math.pow(10, d-1);
			ans[count[itr]-a[itr]] = arr[i];
			a[itr]--;
		}
		return ans;
	}
	public static void main(String[] args){
		int[] arr = {23,43,65,77,85,29,47,12,90,24,87,28,36,100};
		arr = sort(1,arr);
		printArray(arr);
		arr = sort(2,arr);
		printArray(arr);
		arr = sort(3,arr);
		printArray(arr);
	}
}
