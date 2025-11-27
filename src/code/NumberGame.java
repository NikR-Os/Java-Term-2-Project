import javafx.application.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class NumberGame extends Application implements Startable
{
    final static int BOARD_SIZE                 = 20;
    final static int INITIAL_SQUARE_VALUE       = 0;
    final static int MINIMUM_GENERATED_VALUE    = 1;
    final static int MAXIMUM_GENERATED_VALUE    = 1000;

    private final int[] board;
    private final Random random;

    private int currentNumber;

    public NumberGame()
    {
        board = new int[BOARD_SIZE];
        random = new Random();

    }

    @Override
    public void startLogic()
    {
        clearBoard();
        generateNextNumber();
    }

    private void clearBoard()
    {
        Arrays.fill(board, INITIAL_SQUARE_VALUE);
    }

    public boolean placeNumber(int location)
    {
        if(board[location] != INITIAL_SQUARE_VALUE)
        {
            return false;
        }
        board[location] = currentNumber;
        return true;
    }

    public void generateNextNumber()
    {
        currentNumber = random.nextInt(MAXIMUM_GENERATED_VALUE) + MINIMUM_GENERATED_VALUE;
    }

    public int getBoardValue(int location)
    {
        return board[location];
    }

    public int getCurrentNumber()
    {
        return currentNumber;
    }

    public boolean isBoardFull()
    {
        for(int number : board)
        {
            if(number != INITIAL_SQUARE_VALUE)
            {
                return false;
            }
        }
        return true;
    }

    public void setBoardSquare(final int location, final int value)
    {
        board[location] = value;
    }

    public boolean isAscending()
    {
        int last = INITIAL_SQUARE_VALUE;
        for (int number : board)
        {
            System.out.println("Number: " + number);
            if (number == INITIAL_SQUARE_VALUE)
            {
                continue;
            }
            else if (number < last)
            {
                return false;
            }
            last = number;
        }
        return true;
    }
}
