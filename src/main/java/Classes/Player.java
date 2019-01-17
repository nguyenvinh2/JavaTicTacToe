package Classes;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Player {
    public String Name;
    public String Marker;
    public Boolean PlayerTurn;

    public String getName(){
        return Name;
    }

    public void setName(String nameInput){
        Name = nameInput;
    }

    public String getMarker(){
        return Marker;
    }

    public void setMarker(String markerInput){
        Marker = markerInput;
    }

    public Boolean getPlayerTurn(){
        return PlayerTurn;
    }

    public void setPlayerTurn (Boolean turnInput) {
        PlayerTurn = turnInput;
    }
    /*detects user inputs for position number an retrieves coordinates*/
    public Position GetPosition () throws IOException {
        Position coordinate =  null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (coordinate == null) {
            System.out.println("Please select a location");

            String n = reader.readLine();
            coordinate = PositionToNumber(n);
        }
        return coordinate;
    }
    /*returns grid coordinates base on integer specified on game-board*/
    public static Position PositionToNumber(String position){
        switch (position){
            case "1": return new Position(0,0);
            case "2": return new Position(0,1);
            case "3": return new Position(0,2);
            case "4": return new Position(1,0);
            case "5": return new Position(1,1);
            case "6": return new Position(1,2);
            case "7": return new Position(2,0);
            case "8": return new Position(2,1);
            case "9": return new Position(2,2);
            default: return null;
        }
    }
    public void TurnEvents(Board Gameboard) throws IOException{
        PlayerTurn = true;
        System.out.println(Name+"!. It is your turn.");
        Position position = GetPosition();
        if(tryParseInt(Gameboard, position)){
            Gameboard.Board[position.Row][position.Column] = Marker;
        }
        else {
            System.out.println("This space is already occupied!");
        }

    }
    private boolean tryParseInt(Board Gameboard, Position value) {
        try {
            Integer.parseInt(Gameboard.Board[value.Row][value.Column]);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
