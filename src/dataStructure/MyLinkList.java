package dataStructure;

public class MyLinkList {
	public Node head;
	public int listCount;
	
	public MyLinkList(){
		head = new Node(null);
		listCount=0;
	}
	
	public void add(Object obj){
		Node newNode= new Node(obj);
		Node currentNode = head;
		while(currentNode.getNext() != null){
			currentNode = currentNode.getNext();
		}
		
		currentNode.setNext(newNode);
		listCount++;
	}
	
	public void add(Object obj, int index){
		Node newNode= new Node(obj);
		Node currentNode = head;
		for(int i=1; i<index && currentNode.getNext() != null ; i++){
			currentNode= currentNode.getNext();
		}
		newNode.setNext(currentNode.getNext());
		currentNode.setNext(newNode);
		listCount++;
	}
	
	public Node get(int index){
		if(index <= 0){
			return null;
		}
		Node temp = head.getNext();
		for(int i=1; i<index ; i++){
			if(temp.getNext() == null)
				return null;
			temp= temp.getNext();
			
		}
		return temp;
	}
	
	public boolean remove(int index){
		if(index <= 0 || index > size()){
			return false;
		}
		Node current = head;
		for(int i=1;i<index;i++){
			if(current.getNext() == null)
				return false;
			current =current.getNext();
		}
		current.setNext(current.getNext().getNext());
		listCount--;
		return true;
	}
	
	public int size(){
		return listCount;
	}
	
	public int length(){
		return length(head.getNext());
	}
	
	public int length(Node head){
		if(head == null) return 0;
		return 1 + length(head.getNext());
		
	}
	
	public boolean search(Object obj){
		return search(head.getNext(),obj);
	}
	
	public boolean search(Node head, Object obj){
		if(head == null) return false;
		if(head.getData().equals(obj)) return true;
		return search(head.getNext(),obj);
	}
	
	

	public void swap( Object key1, Object key2){
		Node prevx = null, currentx =null, prevy=null, currenty =null;
		Node n=head;
		Node prev= n;
		n=n.getNext();
		while(n!= null){
		
		if(n.getData().equals(key1)){
		prevx = prev;
		currentx = n;
		//System.out.println("11111111");
		}else if(n.getData().equals(key2)){
		prevy = prev;
		currenty = n;
		//System.out.println("2222222222222222222");
		}
			prev=n;
			n=n.getNext();
		
		}
		Node temp = currenty.getNext();
		currenty.setNext(currentx.getNext());
		currentx.setNext(temp);
		prevx.setNext(currenty);
		prevy.setNext(currentx);
		
		
		
	}
	
	public Node merge(Node m1, Node m2){
		
		Node finalNode = null;
		if(m1 == null)
			return m2;
		if(m2== null)
			return m1;
		if((int)m1.getData() <= (int)m2.getData()){
			finalNode = m1;
			finalNode.setNext(merge(m1.getNext(), m2));
		}else if ((int)m1.getData() > (int)m2.getData()){
			finalNode = m2;
			finalNode.setNext(merge(m1, m2.getNext()));
		}
		return finalNode;
	}

	private class Node{
		Node next;
		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Object getData() {
			return Data;
		}

		public void setData(Object data) {
			Data = data;
		}

		Object Data;	
	
		public Node(Object value){
			next=null;
			Data=value;
		}
		
		public Node(Node next, Object value){
			this.next=next;
			this.Data=value;
		}
		
	}
	
	public static void main(String[] ar){
		MyLinkList ml =new MyLinkList();
		ml.add(1);
		ml.add(3);
		ml.add(5);
		ml.add(7);
		ml.add(9);
		/*System.out.println("data: "+ml.get(2));
		System.out.println("data: "+ml.get(4));
		System.out.println("data: "+ml.length());
		System.out.println("is 3 exist "+ml.search(new String("3")));
		ml.swap(new String("2"), new String("5"));*/
		
		/*System.out.println("data: "+ml.get(2));
		System.out.println("data: "+ml.get(4));*/
		
		MyLinkList m2 =new MyLinkList();
		m2.add(2);
		m2.add(4);
		m2.add(6);
		m2.add(8);
		m2.add(10);
		
		ml.head = ml.merge(ml.get(1), m2.get(1));
		System.out.println("data: "+ml.head.getNext().getNext().getData());
		
		
	}
	
	

}
