import java.util.HashMap;
import java.util.Map;

public class Word
{
    private final Map<String, Country> countries;

    public  Word()
    {
        countries = new HashMap<>();
        countries.put("USA", new Country("USA", "USA"));
    }
}
