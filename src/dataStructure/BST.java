package dataStructure;

import java.util.NoSuchElementException;

public class BST<Key extends Comparable<Key>, Value> {
	private Node root;
	
	private class Node{
		Key key;
		Value value;
		Node left;
		Node right;
		int n;
		
		public Node(Key key, Value value, int n){
			this.key = key;
			this.value = value;
			this.n=n;
		
		}
		
	}
	//Initialize Empty Symbol Table
	
	public BST(){
		
	}
	
	private int size(Node x){
		if(x == null) return 0;
		return x.n;
	}
	
	public int size(){
		return size(root);
	}
	
	public boolean isEmpty(){
		return size() == 0;
	}
	
	public boolean contains(Key key){
		return get(key) != null;
	}
	
	public Value get(Key key){
		return get(root, key);
	}
	
	private Value get(Node x, Key key){
		if(x == null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp < 0) return get(x.left, key);
		else if (cmp > 0) return get(x.right, key);
		else return x.value;
	}
	
	public void delete(Key key){
		root = delete(root,key);
		
	}
	
	public Node delete(Node x, Key key){
		if(x == null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp < 0) return delete(x.left, key);
		else if (cmp > 0) return delete(x.right, key);
		else{
			if(x.right == null) return x.left;
			if(x.left == null) return x.right;
			Node t = x;
			x=min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
			
			
		}
		x.n = size(x.left)+size(x.right)+1;
		return x;
	}
	
	public Key min(){
		if (isEmpty()) throw new NoSuchElementException();
		return min(root).key;
	}
	
	public Node min(Node x){
		if(x.left == null) return x;
		else return min(x.left);
	}
	
	public void deleteMin(){
		if (isEmpty()) throw new NoSuchElementException();
		root = deleteMin(root);
		
	}
	
	public Node deleteMin(Node x){
		if(x.left == null ) return x.right;
		x.left=deleteMin(x.left);
		x.n = size(x.left)+size(x.right)+1;
		return x;
	}
	
	public void put(Key key, Value val){
		if(val == null){
			delete(key);
			return;
		}
		root  = put(root, key,val);
		
	}
	
	private Node put(Node x, Key key, Value val){
		if(x == null) return new Node(key,val,1);
		int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.value   = val;
        x.n = 1 + size(x.left) + size(x.right);
        return x;
	}

}
