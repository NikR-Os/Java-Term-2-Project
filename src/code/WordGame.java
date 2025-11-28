import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordGame
{


    private final World word;
    private final Random rand;
    private String answer;

    public WordGame()
    {
        this.word = new World();
        this.rand = new Random();

        startGame();
    }

    public void startGame()
    {
        boolean playing;
        final Country randomCountry;
        WordGameQuestion question;

        playing = true;
        randomCountry = generateRandomCountry();


        while (playing)
        {
            question = new WordGameQuestion(randomCountry);
            playing = false;
        }
    }

    private Country generateRandomCountry()
    {
        final List<Country> list;
        final Country randomCountry;

        list = new ArrayList<>(word.getCountries().values());
        randomCountry = list.get(rand.nextInt(list.size()));

        return randomCountry;
    }






}
