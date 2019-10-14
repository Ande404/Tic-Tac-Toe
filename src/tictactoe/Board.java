package tictactoe;

import java.security.InvalidParameterException;

/**
 * Board class controls setting up the board and printing the board
 * @author Andrew Luwaga
 */
public class Board {
    
  
    private static String[][] board;
    private static boolean[][] results;
    private String marker;
    private final int rowSize = 3;
    private final int colSize = 3;
    
    
    public Board(){
        board = new String[rowSize][colSize];
        results = new boolean[rowSize][colSize];
        intializeBoards();
    }
    
    /**
     * Controls printing the board on the console
     */
    public void makeBoard(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    
    /**
     * Initializes the Main board and the results board
     */
    private void intializeBoards(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                markBoard(i, j, " ");
                results[i][j] = false;
            }          
        }
        
    }
    
    /**
     * Controls the updating the board after a player makes a move
     * @param i
     * @param j
     * @param marker 
     */
    public void markBoard(int i, int j, String marker ){
        
        if( i >= rowSize || j >= colSize ){
            throw new InvalidParameterException("Point [" + i + "," + j + "] is out of bounds. TRY AGAIN!");
        }
        else if ( isvalidMove(i , j) ){
            throw new IllegalArgumentException("Square Already Marked. TRY AGAIN!");
        }
        
        StringBuilder str = new StringBuilder();
        int lastRow = rowSize - 1;
        int lastCol = colSize - 1;
        
        if( j == 0 || j == lastCol ){
            if(i == lastRow ){
                str.append(" "+ marker + " ");
                board[i][j] = str.toString();
            }
            else{
               str.append("_" + marker + "_");
               board[i][j] = str.toString();
            }    
        }
        else {
            if(i == lastRow ){
                str.append("| "+marker+ " |");
                board[i][j] = str.toString();
            }
            else {
             str.append("|_" + marker + "_|");
             board[i][j] = str.toString(); 
            }            
        }
        results[i][j] = true;      
    }
    
    /**
     * Use this method when debugging to check whether the results board and the main board is in sync
     */
    public void printBooleanBoard(){
       for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                System.out.print(results[i][j] + " ");
            }
            System.out.println();
        } 
    }
    
    /**
     * determines whether there is an empty square on the board
     * @param i
     * @param j
     * @return 
     */
    public boolean isvalidMove(int i, int j){   
        return results[i][j];
    }
    
    /**
     * Returns the boolean board Results that shows empty squares on the board
     * @return 
     */
    public boolean[][] getEmptySquaresBoard(){
        return results;
    }

    public int getRowSize() {
        return rowSize;
    }

    public int getColSize() {
        return colSize;
    }
    
    public String[][] getBoard(){
        return board;
    }
    
    public String getMarker(){
        return marker;
    }
    
    /**
     * Sets the user/human player marker
     * @param s 
     */
    public final void setMarker(String s){
        String str = s;
        marker = str;
    }
    
    
    
    

}
