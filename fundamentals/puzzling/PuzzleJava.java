import java.util.ArrayList;
import java.util.Random;

public class PuzzleJava{
    public ArrayList<Integer> getTenRolls() {
        ArrayList<Integer> tenRolls = new ArrayList();
        Random rando = new Random();

        for (int i=0; i<10; i++) {
            tenRolls.add(rando.nextInt(21));
        }
        return tenRolls;
    }

    public char getRandomLetter() {
        ArrayList<Character> alphabetList = new ArrayList();
        Random random = new Random();

        for (int i=97; i<123; i++) {
            alphabetList.add((char)i);
        }
        return alphabetList.get(random.nextInt(26));
    }

    public String generatePassword() {
        String password = "";
        PuzzleJava generator = new PuzzleJava();

        for (int i=0; i<8; i++) {
            char randomLetter = generator.getRandomLetter();
            password += randomLetter;
        }
        return password;
    }

    public ArrayList<String> getNewPasswordSet(int numWords){
        ArrayList<String> passwordList = new ArrayList();
        PuzzleJava randomPassword = new PuzzleJava();

        for (int i=0; i<numWords; i++) {
            passwordList.add(randomPassword.generatePassword());
        }
        return passwordList;
    }

    public ArrayList<Object> shuffleArray(ArrayList<Object> listToShuffle) {
        Random random = new Random();
        int scrambleCount = random.nextInt(100);
        for (int i=0; i<scrambleCount; i++) {
            int sourceIndex = random.nextInt(listToShuffle.size());
            int targetIndex = random.nextInt(listToShuffle.size());
            Object temp = listToShuffle.get(targetIndex);
            listToShuffle.set(targetIndex, listToShuffle.get(sourceIndex));
            listToShuffle.set(sourceIndex, temp);
            // System.out.println(listToShuffle);
        }
        System.out.printf("Scrambled the list %d times!\n", scrambleCount);
        return listToShuffle;
    }
}