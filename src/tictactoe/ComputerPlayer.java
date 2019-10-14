package tictactoe;

import java.util.Random;

/**
 * Computer player emulates a computer player at the beginner level difficulty
 * @author Andrew Luwaga
 */
public class ComputerPlayer {
    
    private String marker;
    private Board board;
    private Random random = new Random();
    
    public ComputerPlayer( String marker, Board board ){
        chooseMarker(marker);
        this.board = board;
    }
    
    /**
     * Used to pick a marker to use throughout the game. 
     * It picks a marker based on the user input
     * @param marker 
     */
    private final void chooseMarker( String marker){
        if( marker.compareToIgnoreCase("x") == 0){
            this.marker = "O";
        }
        else {
            this.marker = "X";
        }
    }

    /**
     * makeMove() uses Random-Int to pick an empty square on the board
     */
    public final void makeMove(){
        
        int row, col;
         
        do {
           row = random.nextInt((board.getRowSize()-1 - 0) + 1) + 0;
           col = random.nextInt((board.getColSize()-1 - 0) + 1) + 0;
        }while(board.isvalidMove(row, col));
            
        board.markBoard(row, col, marker);
        return;     
    }
    
     public String getMarker() {
        return marker;
    }
    

}
