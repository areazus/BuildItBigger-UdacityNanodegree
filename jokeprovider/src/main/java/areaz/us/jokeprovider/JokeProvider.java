package areaz.us.jokeprovider;

import java.util.Random;

public class JokeProvider {
    public static String[] jokes = {"This is a very funny joke",
            "Some joke about world", "A joke about bar", "A joke about some stuff",
            "Just funny"};

    public String getJoke(){
        return jokes[new Random().nextInt(jokes.length)];
    }

}
