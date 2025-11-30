package ca.bcit.comp2522.games;

import java.util.Random;

public class WorldGameQuestion
{
    private final static int COUNTRY_QUESTION_TYPE          = 0;
    private final static int CAPITAL_CITY_QUESTION_TYPE_2   = 1;
    private final static int COUNTRY_FACT_QUESTION_TYPE     = 2;
    private final static int NUMBER_OF_QUESTION_TYPES       = 3;

    private final Country country;
    private final int questionType;
    private final String question;
    private final String answer;

    public WorldGameQuestion(final Country country)
    {
        validateCountry(country);
        this.country        = country;

        this.questionType   = generateQuestionType();
        this.question       = selectQuestion(questionType);
        this.answer         = selectAnswer(questionType);
    }

    private static void validateCountry(final Country country)
    {
        if (country == null)
        {
            throw new IllegalArgumentException("Country cannot be null.");
        }
    }

    private static int generateQuestionType()
    {
        final Random rand;
        final int questionType;

        rand = new Random();
        questionType = rand.nextInt(NUMBER_OF_QUESTION_TYPES);

        return questionType;
    }

    private String selectQuestion(final int questionType)
    {
        final String question;

        question = switch (questionType)
        {
            case COUNTRY_QUESTION_TYPE          -> countryQuestion();
            case CAPITAL_CITY_QUESTION_TYPE_2   -> capitalCityQuestion();
            case COUNTRY_FACT_QUESTION_TYPE     -> countryFactQuestion();
            default -> throw new IllegalStateException("Unexpected value: " + questionType);
        };
        return question;
    }

    private String selectAnswer(final int questionType)
    {
        final String answer;

        answer = switch (questionType)
        {
            case COUNTRY_QUESTION_TYPE          -> countryAnswer();
            case CAPITAL_CITY_QUESTION_TYPE_2   -> capitalCityAnswer();
            case COUNTRY_FACT_QUESTION_TYPE     -> countryFactAnswer();
            default -> throw new IllegalStateException("Unexpected value: " + questionType);
        };
        return answer;
    }

    private String countryQuestion()
    {
        final String randomCountryCapitalCity;
        final StringBuilder questionBuilder;

        randomCountryCapitalCity = country.getCapitalCityName();
        questionBuilder = new StringBuilder("Which country has the capital city named ");

        questionBuilder.append(randomCountryCapitalCity);
        questionBuilder.append("?");

        return questionBuilder.toString();
    }

    private String capitalCityQuestion()
    {
        final String randomCountryName;
        final StringBuilder questionBuilder;

        randomCountryName = country.getName();
        questionBuilder = new StringBuilder("What is the capital city of ");

        questionBuilder.append(randomCountryName);
        questionBuilder.append("?");

        return questionBuilder.toString();
    }

    private String countryFactQuestion()
    {
        final String[] facts;
        final Random rand;
        final String fact;
        final StringBuilder questionBuilder;

        facts  = country.getFacts();
        rand = new Random();
        fact = facts[rand.nextInt(facts.length)];
        questionBuilder = new StringBuilder("Which country does the following fact belong to?");

        questionBuilder.append(System.lineSeparator());
        questionBuilder.append(fact);

        return questionBuilder.toString();
    }

    private String countryAnswer()
    {
        final String answer;

        answer = country.getName();

        return answer;
    }

    private String capitalCityAnswer()
    {
        final String answer;

        answer = country.getCapitalCityName();

        return answer;
    }

    private String countryFactAnswer()
    {
        final String answer;

        answer = country.getName();

        return answer;
    }

    public String getQuestion()
    {
        return question;
    }

    public String getAnswer()
    {
        return answer;
    }
}

