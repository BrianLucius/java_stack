/*
1. file name = class name
2. filename/class = PascalCase
3. A file becomes a class
    Class contains:
    Attributes (variables)
    Methods

4. public - access modifier (alt: private)
    static - 
    void - not going to return anything
    main - always required
    String[] args - always required

5. Variables and methods are camelCase.
*/

public class JavaBasic {
    public static void main(String[] args) {
    System.out.println("Hello Java");

    String firstName = "Alex";
    String lastName = "Miller";
    int age = 42;
    boolean isStudent = true;
    double weight = 152.3;
    char grade = 'A';

    System.out.println(firstName +" "+ lastName);
    System.out.println(age);
    System.out.println(isStudent);
    System.out.println(weight);

    Integer age2 = 38;

    System.out.println(Integer.MAX_VALUE);

    if (weight < 100) {  //condition has to evaluate to boolean
        System.out.println("Gain some weight!");
    } else {
        System.out.println("You are perfect!");
    }

    System.out.println(weight < 100 ? "Gain some weight" : "You are perfect!");

    String name = "Alex Miller";
    System.out.println(name.length());
    System.out.println(firstName.concat(lastName));

    String greeting = String.format("Hi %s, you are %d years old.", firstName, age);
    System.out.println(greeting);

    System.out.printf("Hi %s, you are %d years old.\n", firstName, age);

    String firstName1 = "Martha";
    String firstName2 = new String("Martha");   //New instance of String, means different memory location
    String firstName3 = "Martha";

    System.out.println(firstName1 == firstName3);
    System.out.println(firstName1 == firstName2);  // Since firstName2 is an instance, the comparison is memory locations not memory contents
    System.out.println(firstName1.equals(firstName2));

    
    }
}
