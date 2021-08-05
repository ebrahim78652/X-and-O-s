import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int a = 3;
        int b= 3;
        String[][] board= new String[a][b];
        for(int i=0; i<a; i++){
            for(int j=0; j<b; j++) {
                board[i][j] = "_";
            }
        }



        System.out.println("Welcome to X's and 0's");
        boolean stop= false;
        while(!stop){
            placeSymbol(board, "X");
            if(checkIfSymbolWon(board, "X")){
                stop=true;
                continue;
            }

            placeSymbol(board, "O");
            if(checkIfSymbolWon(board, "O")){
                stop=true;
                continue;
            }
        }


    }


    static void placeSymbol(String[][]board, String symbol){
        //Lets design the placing system and put it in a function.
        int a= (board.length);
        int b=a;


        System.out.println("where do you want to place "+symbol+ "? enter the row and column");

        Scanner s= new Scanner(System.in);
         int row= s.nextInt();
         int column= s.nextInt();

        board[row-1][column-1]=symbol;

        for(int i=0; i<a; i++){
            for(int j=0; j<b; j++){
                System.out.print("["+board[i][j]+"]");
            }
            System.out.print('\n');
        }
    }


    static boolean checkIfSymbolWon(String[][]board, String symbol){
        int columnTotal=0;
        int rowTotal=0;
        int noOfTimesSymbolAppeared=0;
        int a= board.length;
        int b=a;

        for(int i=0; i<(a); i++){
            for(int j=0; j<(b); j++) {
                if(board[i][j]==symbol){
                    rowTotal=rowTotal+i+1;
                    columnTotal=columnTotal+j+1;
                    noOfTimesSymbolAppeared=noOfTimesSymbolAppeared+1;
                }
            }
        }
        if(columnTotal!=0&& rowTotal!=0 && noOfTimesSymbolAppeared==3 && (columnTotal%3==0 && rowTotal%3==0)){
            System.out.println(symbol+ " won!!!!!!!!");
            return true;
        }
        return false;
    }
}
