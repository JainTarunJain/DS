package one;
public class ThreadAB  {

	public static void main(String ar[]){
	ThreadAB th = new ThreadAB();
	A a= new A(th);
	B b = new B(th);
	
	Thread th1 = new Thread(a,"--A");
	Thread th2 = new Thread(b,"--B");
	th1.start();
	th2.start();
	}
	
}

class A implements Runnable{
	
	ThreadAB abThread=null;
	
	A(ThreadAB thread){
		abThread = thread;
	}
	
	public void run(){
		synchronized (abThread) {
			for(int i=0; i<5;i++){
				System.out.println("A  "+Thread.currentThread().getName());
				try {
			 		
					abThread.wait();
					abThread.notifyAll();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
}


class B implements Runnable{
	ThreadAB abThread=null;
	
	B(ThreadAB thread){
		abThread = thread;
	}
	
	public void run(){
		synchronized (abThread) {
for(int i=0; i<5;i++){
	System.out.println("B  "+Thread.currentThread().getName());
	
	try {
		abThread.notifyAll();
		abThread.wait();
		
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			}
			
		}
		
	}
}