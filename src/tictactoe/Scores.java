package tictactoe;

/**
 * Scores class computes scores according to row, col, left diagonal and right diagonal
 * These methods determine the winner of the game.
 * @author Andrew Luwaga
 */
public class Scores {
    
    private static final int computerID = 10;
    private static final int humanID = 5;
    private Board board;
    private static ComputerPlayer comp;
    private int maxRowSum = Integer.MIN_VALUE;
    private int minRowSum = Integer.MAX_VALUE;
    private int rowSum = 0;
    private int maxColSum = Integer.MIN_VALUE;
    private int minColSum = Integer.MAX_VALUE;
    private int colSum = 0;
    private int leftDiagSum = 0;
    private int rightDiagSum = 0;
    
    
    public Scores( Board b, ComputerPlayer c){
        board = b;
        comp = c;
    }
    
    /**
     * Computes the sum of the marker values across the rows and updates the minRowSum and MaxRowSum
     */
    public final boolean checkForWinAcrossRow(){
        for (int i = 0; i < board.getRowSize(); i++) {
            for(int j = 0; j < board.getColSize(); j++){
               String str = board.getBoard()[i][j].replaceAll("[\\W|_]", "");
               if(str.compareTo(comp.getMarker()) == 0){                   
                   maxRowSum += computerID;
                   if(maxRowSum == computerID * board.getRowSize()){
                       System.out.println("Computer Wins!");
                       return true;
                   }
               }
               else if(str.compareTo(board.getMarker()) == 0){
                   minRowSum += humanID;
                   if(minRowSum == humanID * board.getRowSize()){
                       System.out.println("You Win!");
                     return true;  
                   }         
               }
            }
            maxRowSum = minRowSum = 0;
            
        }
        return false;
    }
    
     /**
     * Computes the sum of the marker values across the columns and updates the maxColSum and MinColSum
     */   
    public final boolean checkForWinAcrossCol(){
        for (int i = 0; i < board.getColSize(); i++) {
            for(int j = 0; j < board.getRowSize(); j++){
               String str = board.getBoard()[j][i].replaceAll("[\\W|_]", "");
               if(str.compareTo(comp.getMarker()) == 0){                   
                   maxColSum += computerID;
                   if(maxColSum == computerID * board.getRowSize()){
                       System.out.println("Computer Wins!");
                       return true;
                   }
               }
               else if(str.compareTo(board.getMarker()) == 0){
                   minColSum += humanID;
                   if(minColSum == humanID * board.getRowSize()){
                       System.out.println("You Win!");
                     return true;  
                   }         
               }
            }
            maxColSum = minColSum = 0;
            
        }
        return false;
    }
    
    /**
     * Computes the sum of the marker values across the left diagonal
     */
    public final boolean checkForWinleftDiag(){
       assert(board.getRowSize() == board.getColSize());
       
       leftDiagSum = 0;
        
        for(int i = 0; i < board.getRowSize(); i++){
            
             String str = board.getBoard()[i][i].replaceAll("[\\W|_]", "");
             
               if(str.compareTo(comp.getMarker()) == 0){
                   
                 leftDiagSum += computerID;
                 
                 if(leftDiagSum == computerID * board.getRowSize()){
                    System.out.println("Computer Wins!");
                    return true;
                   }
               }
                else if(str.compareTo(board.getMarker()) == 0){
                    
                   leftDiagSum += humanID;
                   
                   if(leftDiagSum == humanID * board.getRowSize()){
                     System.out.println("You Win!");
                     return true;  
                   }   
                }
        }
    
       return false;
    }
    
    /**
     * Computes the sum of the marker values across the right diagonal
     */
    public final boolean checkForWinRightDiag(){
        
        assert(board.getRowSize() == board.getColSize());
        
        int j = board.getColSize() - 1;
        rightDiagSum = 0;
        
        for(int i = 0; i < board.getRowSize(); i++){
            if(j < 0)
                break;
              
              String str = board.getBoard()[i][j].replaceAll("[\\W|_]", "");
              
              if(str.compareTo(comp.getMarker()) == 0){
                  
                 rightDiagSum += computerID;
                 
                 if(rightDiagSum == computerID * board.getRowSize()){
                    System.out.println("Computer Wins!");
                    return true;
                   }
               }
                else if(str.compareTo(board.getMarker()) == 0){
                    
                   rightDiagSum += humanID;
                   
                   if(rightDiagSum == humanID * board.getRowSize()){
                       System.out.println("You Win!");
                     return true;  
                   }      
                }
              --j;
         }

        return false;
    }

    public static int getComputerID() {
        return computerID;
    }

    public static int getHumanID() {
        return humanID;
    }
    
}
