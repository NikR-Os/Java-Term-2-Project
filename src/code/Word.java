import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Word
{
    private final static char STARTING_FILE_LETTER = 'a';
    private final static char ENDING_FILE_LETTER = 'z';
    private final static List<Character> UNUSED_LETTERS = Arrays.asList('w', 'x');
    private final static int COUNTRY_NAME_INDEX = 0;
    private final static int COUNTRY_CAPITAL_INDEX = 1;

    private final Map<String, Country> countries;

    public  Word()
    {
        countries = new HashMap<>();
        boolean startNextCountry = false;

        for (char letter = STARTING_FILE_LETTER; letter <= ENDING_FILE_LETTER; letter++)
        {
            if (UNUSED_LETTERS.contains(letter))
            {
                continue;
            }

            final Path path;





            path = Paths.get("src", "resources", letter + ".txt");

            try (final BufferedReader reader = Files.newBufferedReader(path))
            {
                String line;
                while ((line = reader.readLine()) != null)
                {
                    if (line.isEmpty())
                    {
                        continue;
                    }
                    final String[] countryDetails;
                    final String countryName;
                    final String countryCapital;
                    final String factA;
                    final String factB;
                    final String factC;

                    countryDetails = line.split(":");
                    countryName = countryDetails[COUNTRY_NAME_INDEX];
                    countryCapital = countryDetails[COUNTRY_CAPITAL_INDEX];

                    factA = reader.readLine();
                    factB = reader.readLine();
                    factC = reader.readLine();

                    countries.put(countryName, new Country(countryName, countryCapital, factA, factB, factC));
                }
            }
            catch (final IOException e)
            {
                e.printStackTrace();
            }
        }
        for (Map.Entry<String, Country> entry : countries.entrySet()) {
            final String fact;
            fact = entry.getValue().getFacts()[0];
            System.out.println("Country: " + entry.getKey() + ", Values: " + entry.getValue().getCapitalCityName() + ", " + fact);
        }
    }
}