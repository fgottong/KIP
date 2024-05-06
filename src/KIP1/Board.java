package KIP1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    private int[] fields;
    private boolean[] freeFields;

    public Board(int size){

        fields = new int[size];
        freeFields = new boolean[size];

        for (int i=0;i<size;i++){
            freeFields[i] = true;
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
