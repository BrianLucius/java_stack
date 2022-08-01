class VoiceMessageTest{
    public static void main(String[] args) {
        VoiceMessageUtil myMachine = new VoiceMessageUtil();

        System.out.println(myMachine.greeting());

        System.out.println(myMachine.greeting("Alex"));

        System.out.println(myMachine.greeting(10));

        System.out.println(myMachine.getCurrentDate());
    }
}