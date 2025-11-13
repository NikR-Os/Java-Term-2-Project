import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Word
{
    private static char startingFileLetter  = 'a';
    private static char endingFileLetter    = 'z';

    private final Map<String, Country> countries;

    public  Word()
    {
        countries = new HashMap<>();

        for (char letter = startingFileLetter; letter <= endingFileLetter; letter++)
        {
            final Path path;

            path = Paths.get("src", "resources", letter + ".txt");

            try
            {
                final List<String> lines;
                lines = Files.readAllLines(path);
            }
            catch (final IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}