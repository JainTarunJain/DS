package one;

public class ProducerConsumerTest {
	 public static void main(String[] args) {
	      Data d = new Data();
	      Producer p1 = new Producer(d, 1);
	      Consumer c1 = new Consumer(d, 1);
	      p1.start(); 
	      c1.start();
	   }
}
class Data {
	   private int contents;
	   private boolean available = false;
	   public synchronized int get() {
	      while (available == false) {
	         try {
	            wait();
	         }
	         catch (InterruptedException e) {
	         }
	      }
	      available = false;
	      notifyAll();
	      return contents;
	   }
	   public synchronized void put(int value) {
	      while (available == true) {
	         try {
	            wait();
	         }
	         catch (InterruptedException e) { 
	         } 
	      }
	      contents = value;
	      available = true;
	      notifyAll();
	   }
	}

	class Consumer extends Thread {
	   private Data data;
	   private int number;
	   public Consumer(Data d, int number) {
	      data = d;
	      this.number = number;
	   }
	   public void run() {
	      int value = 0;
	         for (int i = 0; i < 10; i++) {
	            value = data.get();
	            System.out.println("Consumer #" 
				+ this.number
	+ " got: " + value);
	}
	}
	}

	class Producer extends Thread {
	private Data data;
	private int number;

	public Producer(Data d, int number) {
	data = d;
	this.number = number;
	}

	public void run() {
	for (int i = 0; i < 10; i++) {
	data.put(i);
	System.out.println("Producer #" + this.number
	+ " put: " + i);
	try {
	sleep((int)(Math.random() * 100));
	} catch (InterruptedException e) { }
	}
	}
	}