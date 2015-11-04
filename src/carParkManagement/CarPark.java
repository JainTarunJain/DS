package carParkManagement;

public class CarPark {

	//public int token=0;
	public SlotsList c;
	
	public CarPark(SlotsList sl){
		this.c = sl;
	}
	
	
	
	public  int addVehicle(Vehicle vehicle,int slot){
		synchronized (c) {
		System.out.println("Add slot: "+slot+" available slots: "+c.numOfAvailableSlots());
		while(c.numOfAvailableSlots() < 0){
			System.out.println("going to wait");
			try {
				c.notifyAll();
				c.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		c.add(slot,vehicle);
		//c.notify();
		vehicle.printDetails();
		System.out.println("-------------------------------------------");
		return slot;
		}
	}
	
	public Vehicle removeVehicle(int slot){
		synchronized (c) {
			
		
		
		while(c.numOfOccupiedSlots() <0){
			System.out.println("remove occupied slot: "+c.numOfOccupiedSlots());
			try {
				
				c.wait();
				c.notifyAll();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("slot: "+slot);
		Vehicle v = (Vehicle)c.remove(slot);
		
		c.notifyAll();
		//parkArray.add(slot, null);
		
		return v;
		}
		
	}
	
}
