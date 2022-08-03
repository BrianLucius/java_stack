package zookeeper_1;

public class Gorilla extends Mammal {
	public void throwSomething(String something) {
		System.out.printf("The Gorilla has flung %s...\n", something);
		super.setEnergyLevel(super.getEnergyLevel() - 5);
	}
	
	public void eatBananas() {
		System.out.println("The Gorilla has ate a bunch of bananas. They were a-peel-ing.");
		super.setEnergyLevel(super.getEnergyLevel() + 10);
		
	}
	
	public void climb() {
		System.out.println("Look up in the tree, the Gorilla has climbed sky high!");
		super.setEnergyLevel(super.getEnergyLevel() - 10);
		
	}

}
