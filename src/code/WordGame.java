import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordGame
{
    private final static int NUMBER_OF_QUESTION_TYPES;

    static
    {
        NUMBER_OF_QUESTION_TYPES = 3;
    }

    private final Word word;
    private final Random rand;
    private String answer;

    public WordGame()
    {
        this.word = new Word();
        this.rand = new Random();
    }

    public String generateQuestion()
    {
        boolean playing  = true;


        final Country randomCountry = generateRandomCountry();
        final int questionType = rand.nextInt(NUMBER_OF_QUESTION_TYPES);
        final String question;

        question = switch (questionType)
        {
            case 0 -> countryQuestion(randomCountry);
            case 1 -> capitalCityQuestion(randomCountry);
            case 2 -> countryFactQuestion(randomCountry);
            default -> throw new IllegalStateException("Unexpected value: " + questionType);
        };

        return question;
    }

//    private static void setAnswer(final int questionType, final Country country)
//    {
//        this.a switch (questionType)
//        {
//            case 0 -> country.getName();
//            case 1 -> country.getCapitalCityName();
//            case 2 -> country.getName();
//        }
//    }

    private Country generateRandomCountry()
    {
        final List<Country> list;
        final Country randomCountry;

        list = new ArrayList<>(word.getCountries().values());
        randomCountry = list.get(rand.nextInt(list.size()));

        return randomCountry;
    }

    private String countryQuestion(Country randomCountry)
    {
        final String randomCountryCapitalCity;
        final StringBuilder question;

        randomCountryCapitalCity = randomCountry.getCapitalCityName();
        question = new StringBuilder("Which country has the capital city named ");

        question.append(randomCountryCapitalCity);
        question.append("?");

        return question.toString();
    }

    private String capitalCityQuestion(Country randomCountry)
    {
        final String randomCountryName;
        final StringBuilder question;

        randomCountryName = randomCountry.getName();
        question = new StringBuilder("What is the capital city of ");

        question.append(randomCountryName);
        question.append("?");

        return question.toString();
    }

    private String countryFactQuestion(Country randomCountry)
    {
        final String[] facts;
        final String fact;
        final StringBuilder question;

        facts  = randomCountry.getFacts();
        fact = facts[rand.nextInt(facts.length)];
        question = new StringBuilder("Which country does the following fact belong to?");

        question.append(System.lineSeparator());
        question.append(System.lineSeparator());
        question.append(fact);

        return  question.toString();
    }
}
