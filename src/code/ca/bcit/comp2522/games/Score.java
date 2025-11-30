package ca.bcit.comp2522.games;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Score
{
    private final int numberOfGames;
    private final int firstAttemptScore;
    private final int secondAttemptScore;
    private final int incorrectAnswers;



    public Score(final LocalDateTime now, final int numberOfGames, final int firstAttemptScore, final int secondAttemptScore, final int incorrectAnswers)
    {
        this.numberOfGames = numberOfGames;
        this.firstAttemptScore = firstAttemptScore;
        this.secondAttemptScore = secondAttemptScore;
        this.incorrectAnswers = incorrectAnswers;
    }

    public static void appendScoreToFile(final Score score, final String scoreFile)
    {

    }

    public int getScore()
    {
        return 5;
    }
}
