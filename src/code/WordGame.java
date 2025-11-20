import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WordGame
{
    final static int NUMBER_OF_QUESTION_TYPES;

    static
    {
        NUMBER_OF_QUESTION_TYPES = 3;
    }

    private final Word word;
    private final Scanner scanner;
    private final Random rand;


    public WordGame()
    {
        this.word = new Word();
        this.scanner = new Scanner(System.in);
        this.rand = new Random();

        startGameLoop();
    }

    private void startGameLoop()
    {
        System.out.println("--- Welcome to Word Game! ---");

        boolean playing  = true;

        while(playing)
        {
            final Country randomCountry = getRandomCountry();
            final int questionType = rand.nextInt(NUMBER_OF_QUESTION_TYPES);

            switch (questionType)
            {
                case 0 -> askCountryQuestion();
                case 1 -> askCountryQuestion();
                case 2 -> askCountryQuestion();
            }

        }
    }

    private Country getRandomCountry()
    {
        final List<Country> list;
        final Country randomCountry;

        list = new ArrayList<>(word.getCountries().values());
        randomCountry = list.get(rand.nextInt(list.size()));

        return randomCountry;
    }

    private void askCountryQuestion()
    {

    }

    private void askCapitalCityQuestion()
    {

    }

    private void askCountryFactQuestion()
    {

    }
}
