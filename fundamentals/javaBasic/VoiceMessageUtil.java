import java.util.Date;

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
}