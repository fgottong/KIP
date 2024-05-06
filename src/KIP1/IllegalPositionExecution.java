package KIP1;

/**
 * Exception, to be thrown, when some field in game is already (is not available).
 */
public class IllegalPositionExecution extends IllegalArgumentException{

    public IllegalPositionExecution(){
    }
    public IllegalPositionExecution(String msg){
        super(msg);
    }

}
