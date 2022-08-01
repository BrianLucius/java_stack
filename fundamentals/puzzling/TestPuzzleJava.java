import java.util.ArrayList;
import java.util.Random;

public class TestPuzzleJava{

    public static void main(String[] args) {
        PuzzleJava generator = new PuzzleJava();

        ArrayList<Integer> randomRolls = generator.getTenRolls();
        System.out.println("Ten Random Rolls: " + randomRolls);

        char randomLetter = generator.getRandomLetter();
        System.out.println("Random Letter: " + randomLetter);

        String randomPassword = generator.generatePassword();
        System.out.println("Your Random Password: " + randomPassword);

        ArrayList<String> passwordList = generator.getNewPasswordSet(10);
        System.out.println("Your password list is: " + passwordList);

        ArrayList<Object> myList = new ArrayList();
        myList.add("Sun");
        myList.add("Moon");
        myList.add(42);
        myList.add("Winter");
        myList.add(3.14159625);
        System.out.println("Non-randomized list: " + myList);

        ArrayList<Object> randomList = generator.shuffleArray(myList);
        System.out.println("Randomized list: " + randomList);
    }
}