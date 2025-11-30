package ca.bcit.comp2522.games;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WorldGame
{
    private final static int INITIAL_SCORE              = 0;
    private final static int INITIAL_INCORRECT_SCORE    = 0;
    private final static int INITIAL_ROUND              = 1;
    private final static int FINAL_ROUND                = 10;
    private final static int INITIAL_GAME_COUNTER       = 1;

    private final World word;
    private final Random rand;

    public WorldGame()
    {
        this.word = new World();
        this.rand = new Random();

        startGame();
    }

    public void startGame()
    {
        System.out.println("--- Welcome to World Game! ---");

        final Scanner input;
        boolean playing;
        int firstAttemptScore;
        int secondAttemptScore;
        int roundCounter;
        int gameCounter;

        input = new Scanner(System.in);
        playing = true;
        firstAttemptScore   = INITIAL_SCORE;
        secondAttemptScore  = INITIAL_SCORE;
        roundCounter        = INITIAL_ROUND;
        gameCounter         = INITIAL_GAME_COUNTER;

        while (playing == true)
        {
            while (roundCounter <= FINAL_ROUND)
            {
                System.out.println(System.lineSeparator() + "Round " + roundCounter + ":" + System.lineSeparator());

                final Country randomCountry;
                final WorldGameQuestion questionObj;
                final String currentQuestion;
                final String currentAnswer;
                String userAnswer;

                randomCountry = generateRandomCountry();
                questionObj = new WorldGameQuestion(randomCountry);
                currentQuestion = questionObj.getQuestion();
                currentAnswer = questionObj.getAnswer();

                System.out.println(currentQuestion);
                userAnswer = input.nextLine();

                System.out.println(currentAnswer);
                System.out.println(userAnswer);

                if (userAnswer.equalsIgnoreCase(currentAnswer))
                {
                    System.out.println("CORRECT");
                    firstAttemptScore++;
                } else
                {
                    System.out.println("Sorry, incorrect answer. One more attempt: ");
                    userAnswer = input.nextLine();
                    if (userAnswer.equalsIgnoreCase(currentAnswer))
                    {
                        System.out.println("CORRECT");
                        secondAttemptScore++;
                    } else
                    {
                        System.out.println("Sorry, no attempts remaining, moving to the next round.");

                    }
                }
                System.out.println(firstAttemptScore);
                System.out.println(secondAttemptScore);
                roundCounter++;
            }
        }
        System.out.println("Would you like to play the World Game again?" +
                            System.lineSeparator() +
                            "Enter \"yes\" or \"no\".");

        final String playAgain = input.nextLine();
        if (playAgain.equalsIgnoreCase("no"))
        {
            playing = false;
        }
        else
        {
            gameCounter++;
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
