package net.brianlucius.inheritancedemo;

public class FrontEndDeveloper extends Developer {
	private boolean isArtistic;	
	
	public FrontEndDeveloper() {
		super("Anonymous Front End Developer"); // runs the constructor on the parent class
		this.setSalary(super.getSalary()+10000);   // must use getter/setter for private vars. Super is optional, but clarifies source
//		this.setSalary(100000);
		this.hoursOfSleep = 7;  //can update when var set to protected
		this.isArtistic = false;
		
	}
	
	public FrontEndDeveloper(String name) {
		super(name);
		this.isArtistic = true;
		this.setSalary(super.getSalary()+20000);
	}
	 
	public void displayStatus() {
		super.displayStatus();
		System.out.println("Artistic: " + this.isArtistic);
	}
	
	public void raiseSalary(int raise) {
		this.setSalary(getSalary() + raise); 
	}

	public boolean isArtistic() {
		return isArtistic;
	}

	public void setArtistic(boolean isArtistic) {
		this.isArtistic = isArtistic;
	}
	
}
