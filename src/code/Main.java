import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Scanner;

/**
 * Entry class to the program.
 *
 * @author Nikolas Rose
 * @version 1.0
 */
public class Main extends Application
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
                    WordGame wordGame;
                    wordGame = new WordGame();
                    break;

                case "N":
                    NumberGameGUI numberGame;
                    numberGame = new NumberGameGUI();
                    launch(args);
                    break;

                case "M":

                    break;

                default:
                    System.out.println("Invalid input. Try again.");
            }

        } while (!(userString.equalsIgnoreCase("Q")));


    }

    @Override
    public void start(final Stage stage)
    {
        final Label helloLabel = new Label("Hello, World!");
        final VBox root = new VBox(helloLabel);
        final Scene scene = new Scene(root, 300, 200);

        stage.setScene(scene);
        stage.setTitle("Hello JavaFX");
        stage.show();
    }
}
