package algorithms.sorting;

import java.util.ArrayList;

public class ShellSort {
	private static void printArray(int[] arr){
		for(int i=0;i<arr.length;i++){
			if(i!=0){System.out.print(", ");}
			System.out.print(arr[i]);
		}
		System.out.print('\n');
	}
	private static ArrayList<Integer> getGaps(int length){
		//calculating gaps of the form 2^p3^q:
		ArrayList<Integer> gaps = new ArrayList<Integer>();
		int gap=1;
		for(int i=0;i<20&&gap<length;i++){
			for(int j=0;j<=i&&gap<length;j++){
				gap = (int) (Math.pow(2, i)*Math.pow(3, j));
				if(gap<length){gaps.add(gap);}
				
				
			}
			gap=1;
		}
		return gaps;
	}
	private static void swap(int i, int j, int[] arr){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static int[] sort(int[] arr, int[] gaps){
		for (Integer gap : gaps) {
			for(int i=gap,j=0;i<arr.length;i+=gap,j=0){
				while(j!=i){
					if(arr[j]>arr[i]){
						swap(i,j,arr);
					}
					j+=gap;
				}
			}
			System.out.println(gap);
			printArray(arr);
		}
		return arr;
	}
	public static void main(String[] args){
		int[] arr = {23,43,65,77,85,29,47,12,90,24,87,28,36,100};
		int [] gaps = {701, 301, 132, 57, 23, 10, 4, 1};
		sort(arr, gaps);
//		printArray();
	}

}
