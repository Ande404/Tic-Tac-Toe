package tictactoe;

import java.security.InvalidParameterException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Application class
 * manages input and passes it out to other classes for processing
 * @author Andrew-Luwaga
 */
public class TicTacToe {
  private static final Scanner input = new Scanner(System.in); 
  private static final Board b = new Board();
  
    public static void main(String[] args) {
        
        //Welcome message
        System.out.println("*** Tic Tac Toe ***\n" +"Enter your marker: ");
        
        //Get input from console
        String marker = input.nextLine();      
        
        //Cleans the input and stores it
        String updatedMarker = marker.toUpperCase().trim();
        
        //Sets the user marker
        b.setMarker(updatedMarker);
           
        
        ComputerPlayer computer = new ComputerPlayer( updatedMarker, b);  
        Scores score = new Scores(b, computer);
        
        int row, col;
        boolean iterate = true;
        
        
        while(iterate){
            try {
                System.out.print("Enter row: ");
                row = input.nextInt();
                System.out.print("Enter col: ");
                col = input.nextInt();
                
                //Mark board using user input
                b.markBoard(row, col, updatedMarker); 
                
                //Print board
                b.makeBoard();
                
                //check if there is a winner
                if(score.checkForWinAcrossRow() || score.checkForWinAcrossCol() || score.checkForWinRightDiag() || score.checkForWinleftDiag()){
                    iterate = false;
                    break;
                }
                       
                //Computer makes move
                computer.makeMove();  
                
                //Print Board
                b.makeBoard();
                
                //check if there is a winner
                if( score.checkForWinAcrossRow() || score.checkForWinAcrossCol() || score.checkForWinRightDiag() || score.checkForWinleftDiag()){
                    break;
                }
            }
            catch(InputMismatchException | IllegalArgumentException e){
              
                if( e instanceof InputMismatchException )
                    System.out.println("Invlaid Input, TRY AGAIN");     
                else if( e instanceof InvalidParameterException ){
                    System.out.println(e.getMessage());
                }
                else
                    System.out.println(e.getMessage());   
                    
            } 
        }      
        
    }
   

}
