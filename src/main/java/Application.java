import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Classes.Board;
import Classes.Game;
import Classes.Player;
import Classes.Position;

public class Application {
    public static void main(String[] args) {
        Board GameBoard = new Board();
        GameBoard.DisplayGameBoard();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            br.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
