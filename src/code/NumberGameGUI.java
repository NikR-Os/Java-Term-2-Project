import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NumberGameGUI extends NumberGame
{
    private final Button[] buttons;
    private final Label numberLabel;

    public NumberGameGUI()
    {
        buttons = new Button[20];
        numberLabel = new Label();
    }

//    @Override
//    public void start(Stage stage)
//    {
//        GridPane grid = new GridPane();
//        grid.setHgap(10);
//        grid.setVgap(10);
//
//        for (int i = 0; i < 20; i++) {
//            int idx = i;
//            Button btn = new Button("");
//            btn.setMinSize(60, 40);
//            btn.setOnAction(e -> handleClick(idx));
//            buttons[i] = btn;
//
//            grid.add(btn, i % 5, i / 5);
//        }
//
//        startLogic();
//        numberLabel.setText("Place number: " + getCurrentNumber());
//
//        VBox root = new VBox(15, numberLabel, grid);
//        root.setStyle("-fx-padding: 20;");
//
//        stage.setScene(new Scene(root));
//        stage.setTitle("Number Game");
//        stage.show();
//    }

    private void handleClick(final int location)
    {

    }

}


