package algorithms.sorting;


class Merge{
	public static int[] sort(int[] arr){
		if(arr.length==1){
			return arr;
		}else{
			int fl = (int) Math.ceil(arr.length/2.0);
			int sl = (int) Math.floor(arr.length/2.0);
			int[] firstHalf = new int[fl];
			int[] secondHalf = new int[sl];
			for(int k=0;k<fl;k++){
				firstHalf[k] = arr[k];
			}
			for(int k=fl,t=0;k<arr.length;k++,t++){
				secondHalf[t] = arr[k];
			}
			firstHalf = sort(firstHalf);
			secondHalf = sort(secondHalf);
			
			//merge and return
			int[] ans=new int[arr.length];int a=0,b=0,k=0;
			for(;a<fl&&b<sl;k++){
				if(firstHalf[a]<=secondHalf[b]){
					ans[k]=firstHalf[a];a++;
				}else if(firstHalf[a]>secondHalf[b]){
					ans[k]=secondHalf[b];b++;
				}
			}
			if(a<fl){
				while(a!=fl){
					ans[k] = firstHalf[a];a++;k++;
				}
			}
			if(b<sl){
				while(b!=sl){
					ans[k] = secondHalf[b];b++;k++;
				}
			}
			return ans;
		}
		
	}
}
public class MergeSort {
	public static void printArray(int[] arr){
		for(int i=0;i<arr.length;i++){
			if(i!=0){System.out.print(", ");}
			System.out.print(arr[i]);
		}
		System.out.print('\n');
	}
	public static void main(String[] args){
		int[] arr = {23,43,65,77,85,29,47,12,90,24,87,28,36,100};
		printArray(Merge.sort(arr));	
	}
	
}
