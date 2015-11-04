package one;

public class ThreadABC {
public String value="A";
public static void main(String ar[]){
	ThreadABC th = new ThreadABC();
	
	AA a=new AA(th);
	BB b=new BB(th);
	CC c=new CC(th);
	Thread a1=new Thread(a);
	Thread b1=new Thread(b);
	Thread c1=new Thread(c);
	a1.start();
	b1.start();
	c1.start();
	
	
	
}
}

class AA implements Runnable {
	ThreadABC abc;
	int i=0;
	AA(ThreadABC abc){
		this.abc= abc;
	}
	public void run() {
		synchronized (abc) {
			while(i<5){
				if(abc.value.equals("A")){
					
					System.out.println(abc.value);
					++i;
					abc.value="B";	
						
					
				}else{
					try {
						
						abc.wait();
						abc.notify();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
					
				}
			}
			
		}
		
}
}

class BB implements Runnable {
	ThreadABC abc;
	int i=0;
	BB(ThreadABC abc){
		this.abc= abc;
	}
	
	public void run() {
		synchronized (abc) {
			while(i<5){
				if(abc.value.equals("B")){
					
					System.out.println(abc.value);
					++i;
					abc.value="C";	
						
					
				}else{
					try {
						abc.notify();
						abc.wait();
						
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
					
				}
			}
			
		}
		
		
	}
}
class CC implements Runnable {
	
	ThreadABC abc;
	int i=0;
	CC(ThreadABC abc){
		this.abc= abc;
	}
	
	public void run() {
		synchronized (abc) {
			while(i<5){
				if(abc.value.equals("C")){
					
					System.out.println(abc.value);
					++i;
					abc.value="A";	
						
					
				}else{
					try {
						
						abc.wait();
						abc.notify();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
					
				}
			}
			
		}
		
	}
}