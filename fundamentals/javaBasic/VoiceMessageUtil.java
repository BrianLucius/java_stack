import java.util.Date;
import java.util.ArrayList;

class VoiceMessageUtil{
    public String greeting() {
        return "Hi, anonymous!";
    }

    public String greeting(String name){
        return "Hi, " + name;
    }

    public String greeting(int count){
        return "Hi, count: " + count;
    }

    public String getCurrentDate() {
        Date today = new Date();
        return "Today is "+today;
    }

    public int totalMessages(int[] numArr){
        int sum = 0;
        for(int i=0; i < numArr.length; i++) {
            sum+=numArr[i];
        }
        return sum;
    }

    public void printMessages(String[] msgArr){
        //standard for loop
        // for (int i=0; i<msgArr.length; i++) {
        //     System.out.println("Messages: " + msgArr[i]);
        // }

        //enhanced for loop
        for (String message: msgArr) {
            System.out.println("Enhanced Messages: " + message);
        }
    }

    public void printMessages(ArrayList<String> msgArr){
        //standard for loop
        // for (int i=0; i<msgArr.size(); i++) {
        //     System.out.println("Messages array list: " + msgArr.get(i));
        // }

        //enhanced for loop
        for (String message: msgArr) {
            System.out.println("Enhanced Messages array list: " + message);
        }
    }
}