package ca.bcit.comp2522.games;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NumberGameGUI extends NumberGame
{
    private final static int GAP_SIZING                 = 10;
    private final static int MIN_BUTTONS_SIZE_WIDTH     = 60;
    private final static int MIN_BUTTONS_SIZE_HEIGHT    = 40;
    private final static int OUTER_PADDING              = 20;
    private final static int ROW_LENGTH                 = 5;
    private final static int VERTICAL_BOX_HEIGHT        = 15;

    private final Button[] buttons;
    private final Label numberLabel;

    public NumberGameGUI()
    {
        buttons = new Button[BOARD_SIZE];
        numberLabel = new Label();
    }

    @Override
    public void start(Stage stage)
    {
        GridPane grid = new GridPane();
        grid.setHgap(GAP_SIZING);
        grid.setVgap(GAP_SIZING);

        for (int i = 0; i < BOARD_SIZE; i++) {
            int idx = i;
            Button btn = new Button("[ ]");
            btn.setMinSize(MIN_BUTTONS_SIZE_WIDTH, MIN_BUTTONS_SIZE_HEIGHT);
            btn.setOnAction(e -> assignNumber(idx));
            buttons[i] = btn;

            grid.add(btn, i % ROW_LENGTH, i / ROW_LENGTH);
        }

        startLogic();
        numberLabel.setText("Place number: " + getCurrentNumber());

        final VBox root;
        root = new VBox(VERTICAL_BOX_HEIGHT, numberLabel, grid);

        stage.setScene(new Scene(root));
        stage.setTitle("Number Game");
        stage.show();
    }

    private void assignNumber(final int location)
    {
        final int roundCurrentNumber = getCurrentNumber();

        buttons[location].setDisable(true);
        buttons[location].setText("[ " + roundCurrentNumber + " ]");

        setBoardSquare(location, roundCurrentNumber);

        System.out.println(isAscending());
        generateNextNumber();

        numberLabel.setText("Place number: " + getCurrentNumber());
    }
}


