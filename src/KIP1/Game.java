package KIP1;

public class Game {


    private Gamer current;
    private Gamer opponent;
    private Board board;

    public Game(){

        this.board=new Board(9);

    }

    public void loop() {

        current=new Gamer("A",Gamer.BLUE_SPADE,1,board);

        opponent=new Gamer("B",Gamer.RED_CLUB,-1,board);

        Gamer winner = new Gamer("Nobody","x",0,board);



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
}


