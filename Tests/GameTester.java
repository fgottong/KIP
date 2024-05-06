import KIP1.Board;
import KIP1.Game;
import KIP1.Gamer;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


public class GameTester {


    // Zulässiger Spielzustand, den A gewinnen wird.
    int[] ary1 = new int[]{ 1,-1,1  ,-1,0,-1,  1,-1,1};

    // Theoretischer unzulässig Spielzustand, den B gewinnen wird
    int[] ary2 = new int[]{ -1,1,1  ,1,0,1,  -1,1,-1};

    @Test
    public void TesteGame_WinnerA(){
        Board board = new Board(ary1);
        Game game = new Game(board);
        Gamer A = game.getGamerA();

        game.loop();
        assertEquals(A,game.getWinner());
    }
    @Test
    public void TesteGame_WinnerB(){
        // Theoretischer unzulässig Spielzustand
        Board board = new Board(ary2);
        Game game = new Game(board);
        Gamer B = game.getGamerB();
        Gamer A = game.getGamerA();

        int sum = Arrays.stream(board.getFields()).sum();


        game.loop();
        assertEquals(B,game.getWinner());
    }

}
