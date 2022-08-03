package net.brianlucius.interfacedemo;

public interface Keepable {

	// default : usable in any class
	public default void play(String name) {
		System.out.println(name + " is playing....");
	}
	
	// abstract : incomplete, implement in class
	abstract void showAffection();
	abstract void askForFood();
}
