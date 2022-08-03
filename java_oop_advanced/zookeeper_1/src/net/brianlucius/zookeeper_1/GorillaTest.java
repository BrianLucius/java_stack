package net.brianlucius.zookeeper_1;

public class GorillaTest {

	public static void main(String[] args) {
		Gorilla george = new Gorilla();
		george.displayEnergy();
		
		george.throwSomething("a turd");
		george.displayEnergy();
		
		george.eatBananas();
		george.displayEnergy();
		
		george.throwSomething("a pink flamingo");
		george.displayEnergy();
		
		george.eatBananas();
		george.displayEnergy();
		
		george.throwSomething("a bunch of bananas");
		george.displayEnergy();
		
		george.climb();
		george.displayEnergy();

	}

}
