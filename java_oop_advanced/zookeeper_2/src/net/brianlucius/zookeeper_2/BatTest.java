package net.brianlucius.zookeeper_2;

public class BatTest {

	public static void main(String[] args) {
		Bat batman = new Bat(300);
		
		batman.displayEnergy();
		
		batman.fly();
		batman.attackTown(); 
		batman.eatHumans();
		batman.attackTown(); 
		batman.eatHumans();
		batman.fly();
		batman.attackTown(); 
		
		batman.displayEnergy();

	}

}
