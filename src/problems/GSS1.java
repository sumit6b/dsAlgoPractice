package problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;


class SegmentTreeNode{
	private int arr[];
	private int i, j;
	private int value;
	
	SegmentTreeNode(int[] arr, int i, int j){
		this.arr = arr;
		this.i = i;
		this.j = j;
		calculateValue();
	}
	public int getValue(){
		return this.value;
	}
	public int geti(){
		return this.i;
	}
	public int getj(){
		return this.j;
	}
	private void calculateValue(){
		int globalSumMax=Integer.MIN_VALUE;
		for(int k=i;k<=j;k++){
			int localSum=0;
			for(int t=i;t<=k;t++){
				localSum+=arr[t];
			}
			globalSumMax = Math.max(globalSumMax, localSum);
		}
		this.value = globalSumMax;
	}
}

class SegmentTree{
	
	int[] arr = null;
	SegmentTreeNode[] tree;
	
	SegmentTree(int[] arr){
		this.arr = arr;
		buildTree();
	}
	
	private int getLeftChildIndex(int index){
		return 2*index+1;
	}
	
	private int getRightChildIndex(int index){
		return 2*index+2;
	}
	
	private void buildTree(){
		this.tree = new SegmentTreeNode[this.getSegmentTreeLength(this.arr.length)];
		buildTreeHelper(0, 0, arr.length-1);
	}
	
	private void buildTreeHelper(int index, int i, int j){
		this.tree[index] = new SegmentTreeNode(this.arr, i, j);
		buildTreeHelper(getLeftChildIndex(index), i, i-j/2);
		buildTreeHelper(getRightChildIndex(index), i-j/2, j);
	}
	
	public static int getSegmentTreeLength(int arraySize){
		int x = arraySize, a=0, b=0;
		for(int i=0;i<arraySize;i++){if(1<<i < arraySize && 1<<i+1 >= arraySize){a=1<<i; b=1<<i+1;}}
		return b;
	}
	
	public int query(int i, int j){
		return queryHelper(i, j, 0);
	}
	
	private int queryHelper(int i, int j, int index){
		SegmentTreeNode node = this.tree[index];
		if(i==node.geti() && j==node.getj()){
			return node.getValue();
		}else if(j<=this.tree[getLeftChildIndex(index)].getj()){
			return queryHelper(i, j, getLeftChildIndex(index));
		}else if(i>this.tree[getRightChildIndex(index)].geti()){
			return queryHelper(i, j, getRightChildIndex(index));
		}else{
			int leftAnswer = queryHelper(i, this.tree[getLeftChildIndex(index)].getj(), getLeftChildIndex(index));
			int rightAnswer = queryHelper(this.tree[getRightChildIndex(index)].geti(), j, getRightChildIndex(index));
			return combineResult(leftAnswer, rightAnswer);
		}
	}
	
	private int combineResult(int leftResult, int rightResult){
		return Math.max(leftResult, rightResult);
	}
}



public class GSS1 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String x = br.readLine();
		String[] ini = br.readLine().split(" ");
		int[] arr = new int[ini.length];
		for(int i=0;i<ini.length;i++){arr[i]=Integer.parseInt(ini[i]);}
		SegmentTree sgtree = new SegmentTree(arr);
		int t = Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++){
			String[] xy = br.readLine().split(" ");
			int a = Integer.parseInt(xy[0]);
			int b = Integer.parseInt(xy[1]);
			System.out.println(sgtree.query(a, b));
		}
	}
}
