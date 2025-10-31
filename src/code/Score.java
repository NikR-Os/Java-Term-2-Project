import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Score
{
    private final LocalDate currentTime;
    private final DateTimeFormatter formatter;
    private final String formattedDateTime;

    public Score()
    {
        this.currentTime = LocalDate.now();
        this.formatter = DateTimeFormatter.ofPattern("yyyyy-MM-dd HH:mm:ss");
        this.formattedDateTime = this.currentTime.format(formatter);
    }

    void displayFormattedDateTime()
    {
        System.out.println(this.formattedDateTime);
    }

}
