package carParkManagement;

public class Vehicle {
private String model;
private String color;
private int numOfWheels;

public Vehicle(){
	
}
public Vehicle(String model,String color,int numOfWheels){
	this.model=model;
	this.color=color;
	this.numOfWheels=numOfWheels;
}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}


public int getNumOfWheels() {
	return numOfWheels;
}
public void setNumOfWheels(int numOfWheels) {
	this.numOfWheels = numOfWheels;
}
public void printDetails(){
	System.out.println("model: "+this.model+" color: "+this.color+" number Of Wheels: "+this.numOfWheels);
}

}
