package Classes;

public class Game {
    public Player PlayerOne;
    public Player PlayerTwo;
    public Board Gameboard;

    public Game(Player P1, Player P2){
        PlayerOne = P1;
        PlayerTwo = P2;
        Gameboard = new Board();
    }

    public Player Play(){
        int count = 0;
        while(CheckForWinner(Gameboard) == false && count<9){
            Gameboard.DisplayGameBoard();
            NextPlayer().TurnEvents(Gameboard);
            SwitchPlayer();
            count++;
        }
        Gameboard.DisplayGameBoard();
        if(CheckForWinner(Gameboard)==true){
            SwitchPlayer();
            return NextPlayer();
        }
        else {
            Player NoWinner = new Player();
            NoWinner.setName("There is no winner.");
            return NoWinner;
        }
    }

    public Boolean CheckForWinner(Board Gameboard){
        int[][] winners = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
                {1,4,7},
                {2,5,8},
                {3,6,9},
                {1,5,9},
                {3,5,7}
        };
        for (int i = 0; i < winners.length; i++) {
            Position P1 = Player.PositionToNumber(winners[i][0]);
            Position P2 = Player.PositionToNumber(winners[i][1]);
            Position P3 = Player.PositionToNumber(winners[i][2]);

            String a = Gameboard.Board[P1.Row][P1.Column];
            String b = Gameboard.Board[P2.Row][P2.Column];
            String c = Gameboard.Board[P3.Row][P3.Column];

            if ((a == b) && (b == c) && (a == c)) {
                return true;
            }
        }
        return false;
    }

    public Player NextPlayer(){
        return (PlayerOne.PlayerTurn)? PlayerOne: PlayerTwo;
    }

    public void SwitchPlayer(){
        if (PlayerOne.PlayerTurn) {
            PlayerOne.PlayerTurn = false;
            PlayerTwo.PlayerTurn = true;
        }
        else {
            PlayerOne.PlayerTurn = true;
            PlayerTwo.PlayerTurn = false;
        }
    }
}
