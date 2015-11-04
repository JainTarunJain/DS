package Sorting;

import java.util.Comparator;

public class MySelection {
	private MySelection(){}
	
	public static void sort(Comparable[] a){
		int n= a.length;
		for(int i=0; i<n;i++){
			int min = i;
			for(int j=i+1; j<n; j++){
				if(less(a[j], a[min])) min =j;
			}
			exchange(a, i, min);
			assert isSorted(a,0,i);
			
		}
		assert isSorted(a);
	}
	
	public static void sort(Object[] a, Comparator c){
		int n= a.length;
		for(int i=0; i<n;i++){
			int min = i;
			for(int j=i+1; j<n; j++){
				if(less(c,a[j], a[min])) min =j;
			}
			exchange(a, i, min);
			assert isSorted(a,c,0,i);
			
			
		}
		assert isSorted(a,c);
	}
	
	public static boolean less(Comparable v, Comparable w){
		return v.compareTo(w) < 0;
	}
	public static boolean less(Comparator c, Object v, Object w){
		return c.compare(v,w) < 0;
	}
	
	public static void exchange(Object[] a, int i, int j){
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static boolean isSorted(Comparable[] a){
		return isSorted(a,0, a.length-1);
	}
	public static boolean isSorted(Object [] a, Comparator c){
		return isSorted(a,c,0, a.length-1);
	}
	
	public static boolean isSorted(Comparable[] a, int lo,int hi){
		for (int i=lo+1; i<hi;i++){
			if(less(a[i], a[i-1])) return false;
		}
		return true;
	}
	public static boolean isSorted(Object[] a,Comparator c, int lo,int hi){
		for (int i=lo+1; i<hi;i++){
			if(less(c,a[i], a[i-1])) return false;
		}
		return true;
	}
	
	public static void show(Comparable[] a){
		for(int i=0; i<a.length; i++){
			System.out.println(a[i]);
		}
	}
	
	public static void main(String[] ar){
		MySelection m1 = new MySelection();
		String[] a ={"M","X","A","D","Z"};
		m1.sort(a);
		m1.show(a);
	}

}
