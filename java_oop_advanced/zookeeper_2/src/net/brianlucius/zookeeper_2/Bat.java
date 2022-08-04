package net.brianlucius.zookeeper_2;

public class Bat extends Mammal{

	public Bat() {
		super();
	}
	
	public Bat(int energyLevel) {
		super(energyLevel);
	}

	public void fly() {
		System.out.println("Flitter, flitter, flitter, the bat is escaping the cave");
		super.setEnergyLevel(super.getEnergyLevel() - 50);
	}
	
	public void eatHumans() {
		System.out.println("I vant to suck yur bloood!");
		super.setEnergyLevel(super.getEnergyLevel() + 25);
	}
	
	public void attackTown() {
		System.out.println("The town is destroyed! Who's afraid of the big, bad bat?");
		super.setEnergyLevel(super.getEnergyLevel() - 100);
	}
}
