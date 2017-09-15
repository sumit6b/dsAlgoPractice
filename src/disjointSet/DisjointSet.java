package disjointSet;

public class DisjointSet {
	private int[] sizeArray;
	private int[] rootArray;
	DisjointSet(int size){
		this.sizeArray = new int[size];
		this.rootArray = new int[size];
		for (int i = 0; i < this.sizeArray.length; i++) {
			this.sizeArray[i]=1;
			this.rootArray[i]=i;
		}
	}
	private int find(int index, int originalIndex){
		if(rootArray[index]==index){
			rootArray[originalIndex] = index;
			return index;
		}else{
			return find(rootArray[index], originalIndex);
		}
	}
	private int sizeOf(int index){
		return sizeArray[index];
	}
	public int rootOf(int index){
		return find(index, index);
	}
	public void union(int a, int b){
		if(a>rootArray.length || b>rootArray.length){
			System.out.println("Not a good value");
			return;
		}else{
			if(sizeOf(find(a, a))>=sizeOf(find(b, b))){
				sizeArray[find(a, a)] += sizeArray[find(b, b)];
				rootArray[find(b, b)] = find(a, a);
			}else{
				sizeArray[find(b, b)] += sizeArray[find(a, a)];
				rootArray[find(a, a)] = find(b, b);
			}
		}
	}
	public boolean isConnected(int a, int b){
		if(find(a, a)== find(b, b)){
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
		System.out.println(ds.isConnected(0, 2));
		System.out.println(ds.isConnected(3, 2));
		System.out.println(ds.isConnected(0, 1));
		System.out.println(ds.isConnected(0, 4));
	}
}
