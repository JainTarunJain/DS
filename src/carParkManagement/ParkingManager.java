package carParkManagement;

import java.util.ArrayList;

public class ParkingManager implements Runnable {

	CarPark cpark = null;
	SlotsList sl = null;

	public ParkingManager() {
		sl = new SlotsList();
		cpark = new CarPark(sl);
	}

	public static void main(String ar[]) {
		ParkingManager p1 = new ParkingManager();
		Thread t1 = new Thread(p1, "Add");
		Thread t2 = new Thread(p1, "Remove");
		t1.start();
		t2.start();

	}

	@Override
	public void run() {
		
			if (Thread.currentThread().getName().equalsIgnoreCase("Add")) {
				for (int i = 0; i < 25; i++ ) {
					if(sl.free.size() > 0){
					Car c = new Car("i" + i, "Gray", 4);
					System.out.println("add: " + i + "   free.get[0]: "
							+ (int) sl.free.get(0));
					sl.filled.add(cpark.addVehicle(c, (int) sl.free.remove(0)));
					}else{
						i--;
					}
				}
			} else {
				while (true) {
				if (sl.filled.size() > 0) {
					int avlSlot = (int) sl.filled.remove(0);
					Vehicle v = cpark.removeVehicle(avlSlot);
					sl.free.add(avlSlot);
					System.out.println("----Removed---------");
					v.printDetails();
					System.out.println("###########################");
				}
						
			}
		}

	}

}
