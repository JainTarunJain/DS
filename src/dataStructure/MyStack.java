package dataStructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyStack<Item> implements Iterable<Item> {

	private int size;
	private Node first;
	
	private class Node{
		Node next;
		Item item;
	}
	
	public MyStack(){
		first =null;
		size=0;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public void push(Item item){
		Node oldNode = first;
		first=new Node();
		first.item=item;
		first.next=oldNode;
		size++;
	}
	
	public Item pop(){
		if(isEmpty())throw new RuntimeException("stack underflow");
		Item item=first.item;
		first=first.next;
		size--;
		return item;
	}
	
	public Item peek(){
		if(isEmpty())throw new RuntimeException("stack underflow");
		return first.item;
		
	}
	
	public Iterator<Item> iterator(){
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item>{
		private Node currentNode = first;
		public boolean hasNext() {
			return currentNode != null;
		}

		public void remove() {
			throw new UnsupportedOperationException("not allowed");
			
		}
	
		public Item next() {
			if(!(hasNext()))throw new NoSuchElementException();
			Item item = currentNode.item;
			currentNode=currentNode.next;
			return item;
		}

		
		
	}
	 public static void main(String[] args) {
	        MyStack<String> s = new MyStack<String>();
	       s.push("hello");
	       s.push("how");
	       s.push("are");
	       System.out.println(s.size);
	       System.out.println(s.pop());
	       s.push("you");
	       System.out.println(s.pop());
	       System.out.println(s.size);
	       System.out.println(s.pop());
	       System.out.println(s.pop());
	       System.out.println(s.size);
	    }
}
