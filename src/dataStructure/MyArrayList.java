package dataStructure;

import java.util.Arrays;

public class MyArrayList {

	private Object[] store;
	private int size=0;
	private int totalSize=10;
	
	public MyArrayList(){
		store = new Object[totalSize];
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public int size(){
		return size;
	}
	
	public void add(Object obj){
		if(size-1 < totalSize){
			increaseListSize();
		}
		store[++size]=obj;
	}
	
	private void increaseListSize(){
		store = Arrays.copyOf(store, totalSize*2);
		totalSize*=2;
	}
	
	public Object remove(int index){
		if(index > size){
			throw new ArrayIndexOutOfBoundsException();
		}
		Object obj=store[index];
		store[index]=null;
		int temp=index;
		while(temp <= size){
			store[temp] = store[temp+1];
			store[temp+1]=null;
			temp++;
			size--;
		}
		return obj;
	}
	public static void main(String[] ar){
		MyArrayList arrayList= new MyArrayList();
		arrayList.add("1");
		arrayList.add("2");
		System.out.println(arrayList.size());
		System.out.println(arrayList.isEmpty());
		System.out.println(arrayList.remove(1));
		System.out.println(arrayList.remove(1));
		arrayList.add("3");
		arrayList.add("4");
		System.out.println(arrayList.remove(2));
		System.out.println(arrayList.size());
		System.out.println(arrayList.isEmpty());
	}

}
