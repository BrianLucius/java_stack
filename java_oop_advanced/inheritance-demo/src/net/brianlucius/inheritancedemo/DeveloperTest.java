package net.brianlucius.inheritancedemo;

public class DeveloperTest {

	public static void main(String[] args) {
		System.out.println("----- Developer Test -----\n");
		
		Developer dev1 = new Developer("Alex Miller", 200000, 6);		
		dev1.addLanguages("Python");
		dev1.addLanguages("Java");
		dev1.displayStatus();
		
		Developer dev2 = new Developer("Martha Smith", 100000, 6);		
		dev2.addLanguages("Python");
		dev2.addLanguages("Java");
		dev2.displayStatus();
		
		Developer dev3 = new FrontEndDeveloper();
		dev3.displayStatus();
		
		Developer dev4 = new FrontEndDeveloper("Julie Andrews");
		((FrontEndDeveloper) dev4).raiseSalary(100000);
//		dev4.raiseSalary(100000);
		dev4.displayStatus();

		Developer dev5 = new Backenddeveloper();
		dev5.displayStatus();
	}

}
