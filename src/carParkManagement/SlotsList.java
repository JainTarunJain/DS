package carParkManagement;

import java.util.ArrayList;
import java.util.Arrays;


public class SlotsList {

	private Object[] store;
	private int size=0;
	private static int totalSize=6;
	public static ArrayList filled;
	public static ArrayList free;
	
	public SlotsList(){
		store = new Object[totalSize];
		filled = new ArrayList();
		free = new ArrayList();
		for(int i=0; i<totalSize; i++){
			free.add(i);
		}
	}
	
	public static int getMaxCapacity(){
		return totalSize;
	}
	
	public int numOfAvailableSlots(){
		return totalSize - filled.size();
	}
	
	public int numOfOccupiedSlots(){
		return filled.size();
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public int size(){
		return size;
	}
	
	public Object get(int i){
		return store[i];
	}
	
	public void add(Object obj){
		if(size-1 < totalSize){
			increaseListSize();
		}
		store[++size]=obj;
	}
	public void add(int i, Object obj){
		System.out.println("slot want to add on: "+i);
		store[i]=obj;
		//if(i <= totalSize)
		size++;
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
		store[index]=new Object();
		
		/*int temp=index;
		while(temp <= size){
			store[temp] = store[temp+1];
			store[temp+1]=null;
			temp++;
			size--;
		}*/
		return obj;
	}
	/*public static void main(String[] ar){
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
	}*/

}
