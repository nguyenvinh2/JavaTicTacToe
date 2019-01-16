import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Classes.Board;
import Classes.Game;
import Classes.Player;
import Classes.Position;

public class Application {
    public static void main(String[] args) {
        PlayGame();
    }

    public static void PlayGame() {
        Player PlayerOne = new Player();
        Player PlayerTwo = new Player();

        System.out.println("What is the name of player one?");
        PlayerOne.setName(ReadInput());
        PlayerOne.setMarker("X");
        PlayerOne.setPlayerTurn(true);

        System.out.println("What is the name of player two?");
        PlayerTwo.setName(ReadInput());
        PlayerTwo.setMarker("O");
        PlayerTwo.setPlayerTurn(false);

        System.out.println("Welcome " +PlayerOne.Name+"! You are " +PlayerOne.Marker+".");
        System.out.println("Welcome "+PlayerTwo.Name+"! You are "+PlayerTwo.Marker+".");
        System.out.println("Now let's play Tic Tac Toe. Press any key to continue...");
        ReadInput();

        Game Bamboozle = new Game(PlayerOne, PlayerTwo);
        //plays the game by trigger Bamboozle.Play;
        String winner = Bamboozle.Play().Name;
        if (winner != "There is no winner")
        {
            System.out.println("Congratulations "+winner+", you won!!!");
        }
        else
        {
            System.out.println("Nobody won :(");
        }

        ReadInput();
        System.out.println();
        System.out.println("The game is over. Press any key to exit...");
        ReadInput();
    }

    public static String ReadInput(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            return br.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
