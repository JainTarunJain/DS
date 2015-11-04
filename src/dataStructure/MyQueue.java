package dataStructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyQueue<Item> {
	private Node first;
	private Node last;
	private int size;
	
	private class Node{
		Item item;
		Node next;
	}
	
	public MyQueue(){
		first=null;
		last = null;
		size=0;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public int size(){
		return size;
	}
	
	public int length(){
		return size;
	}

	public void enque(Item item){
		Node n =new Node();
		n.item=item;
		n.next=null;
		if(isEmpty()){
			first=n;
			last=n;
		}else{
		last.next=n;
		last=n;
		}
		size++;
	}
	
	public Item deque(){
		if(isEmpty()){
			throw new NoSuchElementException();
		}
		Item item=first.item;
		first=first.next;
		size--;
		if(isEmpty()){
			last=null;
		}
		return item;
	}
	
	public Iterator<Item> iterator(){
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item>{
		private Node current=first;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		@Override
		public Item next() {
			if(!hasNext()) throw new NoSuchElementException();
			Item item=current.item;
			current=current.next;
			return item;// TO
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
			
		}
		
	}
	
	public static void main(String[] ar){
		MyQueue<String> m1 = new MyQueue<String>();
		m1.enque("hello");
		m1.enque("Hi");
		m1.enque("how");
		System.out.println(m1.deque());
		System.out.println(m1.size());
		m1.enque("are");
		m1.enque("you");
		
		System.out.println(m1.deque());
		System.out.println(m1.size());
		
	}
}
