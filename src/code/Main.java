import java.util.Scanner;

/**
 * Entry class to the program.
 *
 * @author Nikolas Rose
 * @version 1.0
 */
public class Main
{
    public static void main(final String[] args)
    {
        String userString;
        final Scanner userInputScan = new Scanner(System.in);

        userString = userInputScan.nextLine();

        do
        {
            System.out.println("Enter W to play the Word game.");
            System.out.println("Enter N to play the Number game.");
            System.out.println("Enter M to play the My game.");
            System.out.println("Enter Q to quit.");

            if(userString.equalsIgnoreCase("W"))
            {
                // play word game
            } else if(userString.equalsIgnoreCase("N"))
            {
                // play number game
            } else if(userString.equalsIgnoreCase("M"))
            {
                // Play my game
            } else
            {
                System.err.println("Please enter a valid character.");
            }

            userString = userInputScan.nextLine();

        } while(!(userString.equalsIgnoreCase("Q")));


    }
}
