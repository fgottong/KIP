package KIP1;

import java.io.IOException;

public class GameStarter {

    public static void main(String[] args) {

        Game game;
        switch (Integer.parseInt(args[0])){
            case 0:
                game= new Game();
                break;
            case 1:
                Board board = new Board();
                board.setField(4,1);
                board.setField(3,-1);
                //board.setField(7,1);
                //board.setField(7,1);
                game = new Game(board);
                break;
            default:
                game= new Game();
                break;
        }
        game.loop();

        System.out.printf("Der Gewinner des Aktuellen Spiels ist: %s\n",game.getWinner());


    }

}
