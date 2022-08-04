package net.brianlucius.zookeeper_2;

public class Mammal {
	private int energyLevel;
	
	public Mammal() { 
		energyLevel = 100;
	}
	
	public Mammal(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
	public int displayEnergy() {
		System.out.printf("Energy level: %s\n", energyLevel);
		return energyLevel;
	}

	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
}
