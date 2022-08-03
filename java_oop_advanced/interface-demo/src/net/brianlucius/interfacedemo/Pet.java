package net.brianlucius.interfacedemo;

public class Pet {
	protected String name;
	protected String type;
	
	public Pet () {
		this.name = "random pet";
	}	
	
	public Pet(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}	
	
	public void displayStatus() {
		System.out.println("Name: "+name);
		System.out.println("Type: "+type);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	
	
}
