package KIP1;

import javax.lang.model.element.Name;
import java.util.List;
import java.util.Random;

public class Gamer {

    public static final String RED_CLUB = "\u001B[31m\u2663\u001B[m";//"♦";
    public static final String BLUE_SPADE = "\u001B[34m\u2660\u001B[m";

    private int value;
    private String name;
    private String symbol;
    private Board board;

    Random rand;

    public Gamer(String name, String symbol, int value, Board board) {
        this.name = name;
        this.symbol = symbol;
        this.value = value;
        this.board=board;
        this.rand = new Random();
    }

    /**
     * Randomly chose a possible free field.
     *
     * @return
     * @throws GameOverExecption
     */
    public int chooseRandomfield() throws GameOverExecption {

        List<Integer> possibleFields = board.getFreeFields();

        if (possibleFields.isEmpty()) {
            throw new GameOverExecption("no free Fields");
        }


        // Randomly chose a possible free field.
        return possibleFields.get(rand.nextInt(0, possibleFields.size() ));

    }

    public void moveRandomly() throws GameOverExecption, IllegalArgumentException {

        try {
            board.setField(chooseRandomfield(), value);
        } catch (GameOverExecption | IllegalArgumentException ex) {
            throw ex;
        }

    }

    //Checks if on of the players has won.
    // doesn't matter which one....
//    public boolean hasWon(){
//        int[] currentGameSituation = board.getFields();
//        //Check Lines
//        for (int l=0;l<=6;l+=3){
//            if(currentGameSituation[l]+currentGameSituation[l+1]+currentGameSituation[l+2]==Math.abs(3)){return true;}
//        }
//
//        //Check Columns
//        for(int c=0;c<3;c++){
//            if(currentGameSituation[c]+currentGameSituation[c+3]+currentGameSituation[c+6]==Math.abs(3)){return true;}
//        }
//
//
//        //Check Diagonals
//        if(currentGameSituation[0]+currentGameSituation[4]+currentGameSituation[8]==Math.abs(3)){return true;}
//        if(currentGameSituation[2]+currentGameSituation[4]+currentGameSituation[6]==Math.abs(3)){return true;}
//
//        return false;
//      }

    /**
     * Checks if the current Gamer hasWon.
     * It calculates the line,column and diagonal-Sum.
     * If its equel to 3 times (gamer) value (+1 oder -1) the current gamer has won.
     * @return
     */
    public boolean hasWon(){
        int[] currentGameSituation = board.getFields();
        //Check Lines
        for (int l=0;l<=6;l+=3){
            if(currentGameSituation[l]+currentGameSituation[l+1]+currentGameSituation[l+2]==value*3){return true;}
        }

        //Check Columns
        for(int c=0;c<3;c++){
            if(currentGameSituation[c]+currentGameSituation[c+3]+currentGameSituation[c+6]==value*3){return true;}
        }

        //Check Diagonals
        if(currentGameSituation[0]+currentGameSituation[4]+currentGameSituation[8]==value*3){return true;}
        if(currentGameSituation[2]+currentGameSituation[4]+currentGameSituation[6]==value*3){return true;}

        return false;
    }

    public int getValue() {
        return value;
    }

    public String getSymbol(){
        return symbol;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "Gamer{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}
