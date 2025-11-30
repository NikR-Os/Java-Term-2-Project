package ca.bcit.comp2522.games;

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

        do
        {
            System.out.println("Select an option:");
            System.out.println("Enter W to play the Word game.");
            System.out.println("Enter N to play the Number game.");
            System.out.println("Enter M to play the My game.");
            System.out.println("Enter Q to quit.");

            userString = userInputScan.nextLine();

            switch (userString.toUpperCase())
            {
                case "W":
                {
                    final WorldGame wordGame;

                    wordGame = new WorldGame();

                    break;
                }
                case "N":
                    //NumberGameLauncher.launchGUI();
                    break;

                case "M":
                    // MyGame not implemented
                    break;

                case "Q":
                    System.out.println("Good Bye!");
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
            }

        } while (!(userString.equalsIgnoreCase("Q")));


    }
}
