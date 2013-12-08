/* Name: Cory Lassila - Date: 9/28/13 - Assignment #2
 * This program is a rock, paper, scissors game where
 * the user plays against the computer. A user enters a 
 * number corresponding to the choice they would like to use.
 * After the user is finished statistics are printed out.
 */
package rockPaperScissors;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Date;

//Class that contains main
public class RPSGameApp {

	public static void main(String[] args) 
	{
    HashMap<String,GameStat> hm = new HashMap<String,GameStat>(64); //Stores the date & game object from a game
   
	boolean playgame = true;//Variable to show if user wants to play a new game.
	
	System.out.println("Welcome to the Rock-Paper-Scissors game!\n");
	System.out.println("Let us start a competition.");
	
	while(playgame==true)//New game loop
	{
	    boolean playagain = true; //Variable to show the user wants another match.
	    Scanner user = new Scanner(System.in);//New up a scanner to read user input
	    RPSGame game = new RPSGame();//New up a game object
	    
	    while(playagain==true)//New match loop
 	    {
	        playagain=game.playOnce(user);//This enters into the actual Rock Paper Scissors game
	    }
	    Date date = new Date();//Get the current date
	    hm.put(date.toString(), game.getGameStat());//Use the date as a key and save the game object in map
	    playgame=newGame();//Checks if user wants to play a new game
	    
	    
	    if(playgame==false)
	        break;
	    else if(playgame==true)
	        System.out.println("\nLet us start a competition.");
	    
	}
	printMapResults(hm);//Prints out the final statistics
	
	
	}
	//This function asks the user if they want to to play
	//another game. It will not proceed until correct input is given.
	static public boolean newGame()
	{
	    String entry="";
	    Scanner scan = new Scanner(System.in);
	    
	    System.out.print("Do you want to play another competition?: ");
	    while(true)//This loop keeps asking for input until a correct choice is entered
	    {
	            entry=scan.next().toLowerCase();//Converts user input to lower case
	            if(entry.equals("y"))
	                break;
	            else if(entry.equals("n"))
	                break;
	            System.out.print("Invalid value, please enter a correct value!\n");
	            scan.nextLine();
	    }
	    
	    if(entry.equals("y"))
	        return true;
	    else
	        return false;
	    
	}
	//This function prints out the date and winner of each game
	static public void printMapResults(HashMap<String,GameStat> hm)
	{
	    System.out.println("************OVERALL SUMMARY***************");
	    for(String key: hm.keySet())//Loops through each key in HashMap
	    System.out.println(key+": The winner -- "+hm.get(key).getWinner());
	    System.out.println("******************************************");
	}
	
}//End of RPSGameApp class
