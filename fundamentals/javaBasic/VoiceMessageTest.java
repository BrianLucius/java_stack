import java.util.ArrayList;

class VoiceMessageTest{
    public static void main(String[] args) {
        VoiceMessageUtil myMachine = new VoiceMessageUtil();

        System.out.println(myMachine.greeting());

        System.out.println(myMachine.greeting("Alex"));

        System.out.println(myMachine.greeting(10));

        System.out.println(myMachine.getCurrentDate());

        int[] messagesPerDay1 = new int[5];
        messagesPerDay1[0] = 5;
        messagesPerDay1[1] = 8;
        messagesPerDay1[2] = 6;

        for(int i=0; i<messagesPerDay1.length; i++) {
            System.out.println(messagesPerDay1[i]);
        }

        int[] messagesPerDay2 = {5, 8 , 6};

        for(int i=0; i<messagesPerDay2.length; i++) {
            System.out.println("Length: "+ messagesPerDay2.length);
            System.out.println(messagesPerDay1[i]);
        }

        String[] messages = {"please call back!", "Make sure you install JDK"};
        for(int i=0; i<messages.length; i++) {
            System.out.println("Length: "+ messages.length);
            System.out.println(messages[i]);
        }

        System.out.println("Total messages: " + myMachine.totalMessages(messagesPerDay1));

        myMachine.printMessages(messages);

        ArrayList<String> messageArrayList = new ArrayList<String>();
        messageArrayList.add("Finish Alfred bot");
        messageArrayList.add("Finish Cafe Business Logic");
        messageArrayList.add("Read ahead for OOP");

        myMachine.printMessages(messageArrayList);

        int days = 7;
        double cost = 10.99; // days + cost

        double totalCost = days * cost;
        System.out.println("Total Cost: "+totalCost);

        int roundedTotalCost = days * (int)cost;
        // int roundedTotalCost = (int) (days * cost);
        System.out.println("Rounded total cost: " + roundedTotalCost);
    }
}