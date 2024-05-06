package KIP1;

import java.util.Scanner;

public class MonteCarloStarter {
    public static void main(String[] args) {

        Board mainBoard = new Board();



        while(true){



        }

    }

    private static int askNextAction(){

        int actionCode = 0;

        System.out.print("Next Action ? ");
        System.out.print("\t 1 - MakeMove");
        System.out.print("\t 2 - Simulate");
        System.out.print("\t 3 - Automatic\n>>");


        Scanner scanner = new Scanner(System.in);

        while(true) {
            actionCode = scanner.nextInt();
            if (actionCode<1||actionCode>3){
                System.out.println("Not Found. Please enter Actioncode 1-3");
                System.out.print(">>");
            }else{break;}
        }

        return actionCode;
    }







}


