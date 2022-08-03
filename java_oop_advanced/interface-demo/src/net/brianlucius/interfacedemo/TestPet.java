package net.brianlucius.interfacedemo;

public class TestPet {

	public static void main(String[] args) {
		Cat cat1 = new Cat("Boots");
		
		cat1.play(cat1.name);
		cat1.askForFood();
		cat1.showAffection();
		cat1.displayStatus();
		
		Dog dog1 = new Dog("Fido");
		
		dog1.play(dog1.name);
		dog1.askForFood();
		dog1.showAffection();
		dog1.displayStatus();

	}

}
