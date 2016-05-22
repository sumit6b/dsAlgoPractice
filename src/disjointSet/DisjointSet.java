package disjointSet;

public class DisjointSet {
	private int[] sizeArray;
	private int[] rootArray;
	DisjointSet(int size){
		this.sizeArray = new int[size];
		this.rootArray = new int[size];
		for (int i = 0; i < this.sizeArray.length; i++) {
			this.sizeArray[i]=1;
			this.rootArray[i] = i;
		}
	}
	private int rootOf(int index){
		return rootArray[index];
	}
	private int sizeOf(int index){
		return sizeArray[index];
	}
	public void union(int a, int b){
		if(a>rootArray.length || b>rootArray.length){
			System.out.println("Not a good value");
			return;
		}else{
			if(sizeOf(rootOf(a))>=sizeOf(rootOf(b))){
				sizeArray[rootOf(a)] += sizeArray[rootOf(b)];
				rootArray[rootOf(b)] = rootOf(a);
				
			}else{
				sizeArray[rootOf(b)] += sizeArray[rootOf(a)];
				rootArray[rootOf(a)] = rootOf(b);
				
			}
		}
	}
	public boolean find(int a, int b){
		if(rootOf(a)==rootOf(b)){
			return true;
		}else{
			return false;	
		}
	}
	public void display(){
		for (int i = 0; i < rootArray.length; i++) {
			System.out.println("sizeArray["+i+"] = "+sizeArray[i]);
		}
		System.out.print('\n');
		for (int i = 0; i < rootArray.length; i++) {
			System.out.println("rootArray["+i+"] = "+rootArray[i]);
		}
		System.out.print('\n');
		System.out.print('\n');
		System.out.print('\n');
		
	}
	public static void main(String[] args){
		DisjointSet ds = new DisjointSet(5);
		ds.display();
		ds.union(0, 1);
		ds.display();
		ds.union(0, 4);
		ds.display();
		ds.union(4, 3);
		ds.display();
		System.out.println(ds.find(0, 2));
		System.out.println(ds.find(0, 1));
		System.out.println(ds.find(0, 4));
	}
}
