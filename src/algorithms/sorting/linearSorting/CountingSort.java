package algorithms.sorting.linearSorting;

class Range{
	Range(int min, int max){
		this.max = max;
		this.min = min;
	}
	int max;
	int min;
}

public class CountingSort {
	private static void printArray(int[] arr){
		for(int i=0;i<arr.length;i++){
			if(i!=0){System.out.print(", ");}
			System.out.print(arr[i]);
		}
		System.out.print('\n');
	}
	public static Range getRange(int[] arr){
		int max=Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		for(int i=0;i<arr.length;i++){
			if(arr[i]<min){
				min = arr[i];
			}
			if(arr[i]>max){
				max = arr[i];
			}
		}
		return new Range(min, max);
	}
	public static int[] sort(int[] arr){
		Range range = getRange(arr);
		int[] a = new int[range.max-range.min+1];
		for(int i=0;i<arr.length;i++){
			a[arr[i]-range.min]++;
		}
		for(int i=1,sum=a[0];i<a.length;i++){
			a[i] = sum+a[i];
			sum=a[i];
		}
		int[] ans = new int[arr.length];
		for(int i=0;i<arr.length;i++){
			ans[a[arr[i]-range.min]-1] = arr[i];
			a[arr[i]-range.min]-=1;
		}	
		return ans;
	}
	public static void main(String[] args){
		int[] arr = {23,23,43,65,77,100,85,29,47,12,90,24,87,28,36,100};
		printArray(sort(arr));
	}
}
