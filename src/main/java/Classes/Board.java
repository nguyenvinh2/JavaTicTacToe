package Classes;

public class Board {
    public String[][] Board = {
            {"1","2","3"},
            {"4","5","6"},
            {"7","8","9"}
    };
    public void DisplayGameBoard(){
        System.out.println();
        for (int i = 0; i<Board.length; i++){
            for(int j=0; j<Board[i].length; j++){
                System.out.print("["+Board[i][j]+"]");
            }
            System.out.println();
        }
    }

}
