import java.util.HashMap;
import java.util.Set;

public class SongList {

    public static void main(String[] args) {

        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Walking on the sun","Might as well be walking on the sun");
        trackList.put("My Brother","He ain't heavy, he's my brother");
        trackList.put("Bibbity Bobbity Boo","Oh mairzy doats, and dozey dotes, and liddle lamzy divey");
        trackList.put("Dream On","California Dreaming");

        System.out.println(trackList.get("Dream On"));

        Set<String> songList = trackList.keySet();
        for (String title : songList) {
            System.out.printf("%s: %s\n", title, trackList.get(title));
        }
    }
}