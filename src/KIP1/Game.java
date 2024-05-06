package KIP1;

import java.util.Arrays;

public class Game {

    private final Gamer a;
    private final Gamer b;
    private Gamer current;
    private Gamer opponent;
    private final Board board;
    private Gamer winner ;

    public Game(){
        this(new Board());
    }

    public Game(Board board){
        this.board=board;
        a=new Gamer("A",Gamer.BLUE_SPADE,1,board);
        b=new Gamer("B",Gamer.RED_CLUB,-1,board);

        int sum = Arrays.stream(board.getFields()).sum();

        if(sum==0){
            current = a ;
            opponent = b ;
        }else{
            opponent = a ;
            current = b ;
        }



    }

    public void loop() {

        winner = new Gamer("Nobody","x",0,board);

        while( !current.hasWon() && !opponent.hasWon() && board.hasFreeFields() ){

            // Make Move
            try{
                current.moveRandomly();}
            catch (GameOverExecption goe){
                System.out.println("Spiel zuende, ohne sieger");
                break;
            }

            // Save the winner.
            if(current.hasWon()){winner = current;}


            // Change Current Player
            Gamer temp = current;
            current = opponent;
            opponent = temp;

            // Set Courser to the beginn of Console
            System.out.printf("%s","\033[0;0H");
            System.out.println("Currentplayer : " + current.getName());
            System.out.println("Opponentplayer: " + opponent.getName());
            // override current content with new board state.
            printCurrentBoard();

            try{
                Thread.sleep(500);
            }catch (InterruptedException iex){
                System.out.println("Schade beim warten ist was schiefgegegangen\n"+iex.getMessage());
            }


            //Für Testzwecke
            if(!board.hasFreeFields()){
                System.out.println("Keine Freien Felder Mehr vorhanden.");
            }



        }

        System.out.printf("Der Gewinner ist:%s[%s]\n",winner.getName(),winner.getSymbol());

    }

    /**
     * Prints the current board // the current Game State, using the Gamers symbols.
     */
    private void printCurrentBoard(){

        StringBuilder sb = new StringBuilder();

        int[] fields = board.getFields();
        for(int i=0;i<fields.length;i++){

            if(i % 3==0){sb.append("\n|");}

            if(fields[i]==current.getValue()){
                sb.append(current.getSymbol());
                sb.append("|");
            } else if (fields[i]==opponent.getValue()){
                sb.append(opponent.getSymbol());
                sb.append("|");
            } else {
                sb.append(" |");
            }


        }

        System.out.println(sb);
    }

    /**
     * Returns the Winne of this Game.
     * @return
     */
    public Gamer getWinner(){
        return winner;
    }



    public Gamer getGamerA(){
        return a;
    }
    public Gamer getGamerB(){
        return b;
    }

    @Override
    public String toString() {
        return "Game{" +
                "current=" + current +
                ", opponent=" + opponent +
                ", board=" + board +
                ", winner=" + winner +
                '}';
    }
}


