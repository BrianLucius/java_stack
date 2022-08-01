import java.util.Date;
import java.text.SimpleDateFormat;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        // YOUR CODE HERE
        return String.format("Hello, %s. Lovely to see you.", name);
    }

    // Ninja bonus
    public String guestGreeting(String name, String dayPeriod) {
        // YOUR CODE HERE
        return String.format("Good %s, %s. Lovely to see you.", dayPeriod, name);
    }

    // Sensei bonus
    public String guestGreeting() {
        String pattern = "H";
        SimpleDateFormat hourFormat =  new SimpleDateFormat(pattern);
        
        String hourStr = hourFormat.format(new Date());
        int hour = Integer.parseInt(hourStr);

        if (hour >= 0 && hour < 12) {
            return "Good morning, %s. Lovely to see you.";
        } else if (hour >= 12 && hour < 5) {
            return "Good afternoon, %s. Lovely to see you.";
        }
        return "Good evening, %s. Lovely to see you.";
    }
    
    public String dateAnnouncement() {
        // YOUR CODE HERE
        Date date = new Date();
        return "It is currently " + date;
    }
    
    public String respondBeforeAlexis(String conversation) {
        // YOUR CODE HERE
        if (conversation.indexOf("Alexis") > -1) {
            return "Right away, sir. She certainly isn't sophisticated enough for that.";
        } else if (conversation.indexOf("Alfred") > -1) {
            return "At your service. As you wish, naturally.";
        }
        return "Right. And with that I shall retire.";
    }
    
	// NINJA BONUS
	// See the specs to overload the guessGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}

