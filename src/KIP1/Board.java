package KIP1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * Game-board for a simple tic-tac-toe game.
 * Safes the moves/game state as integer array, with values 1 or -1 for each player or 0 for empty fields.
 *
 * @author fabian gottong fabian.gottong@haw-hamburg.de
 */
public class Board {

    private int[] fields;
    private boolean[] freeFields;
    private static int size = 3 ;

    /**
     * creates a new board with default size 3x3.
     */
    public Board(){
        this(size);
    }

    /**
     * Creats a new board with size n x n.
     * @param n length of board edges
     */
    public Board(int n){

        size = n;
        fields = new int[size*size];
        freeFields = new boolean[size*size];

        for (int i=0;i<size*size;i++){
            freeFields[i] = true;
        }

    }

    public Board(int[] aryFields){

        if(aryFields.length!=9){throw new IllegalArgumentException("Array size doesn't fit board size.");}

        this.fields=aryFields;

        freeFields = new boolean[aryFields.length];

        for (int i=0;i<aryFields.length;i++){
            if(aryFields[i]==0){
                freeFields[i] = true;
            }else{
                freeFields[i] = false;
            }
        }
    }

    /**
     * Places a symbol on the game board, changes the current game state.
     * @param index
     * @param value
     * @throws IllegalArgumentException
     * @throws IllegalPositionExecution
     */
    public void setField(int index,int value) throws IllegalArgumentException, IllegalPositionExecution {
        if(index<0||index> fields.length) throw new IllegalArgumentException("Index ouf of Field Size!");

        if(fields[index]!=0){
            throw new IllegalPositionExecution("Field already used!");
        }

        fields[index]=value;
        freeFields[index] = false;

    }

    /**
     * Returns a list of indexes currently free to be used.
     * Returns empty list if no fields available.
     * @return list of free fields.
     */

    public List<Integer> getFreeFields(){
        List<Integer> frees = new ArrayList<>();
        for (int i = 0; i < freeFields.length; i++) {
            if(freeFields[i]){
                frees.add(i);
            }
        }
        return frees ;
    }

    /**
     * Returns die current field, therefor the current game situation
     * @return Current game situation as Integer-array
     */
    public  int[] getFields(){
        return Arrays.copyOf(fields,fields.length);
    }

    /**
     * checks if there are free fields available.
     * @return
     */
    public boolean hasFreeFields() {
        return !getFreeFields().isEmpty();
    }



}
