/* Name: Cory Lassila - Date: 9/28/13 - Assignment #2
 * This class contains the bulk of the rock paper scissors game.
 * It has functions to recieve user input, scan for correct input,
 * compare user v.s computer input and determine a winner.
 */
package rockPaperScissors;

import java.util.Scanner;
import java.util.ArrayList;

//The Rock Paper Scissors game class
public class RPSGame {
    private ArrayList<Integer> al = new ArrayList<Integer>();//This variable stores all user input choices
	private GameStat gstat = new GameStat();//New up a gamestat object
	private int playcount=0;//This variable counts how many times the the game has been played
	
	public boolean playOnce(Scanner scan)
	{
	    int choice,compchoice;
	    
	    System.out.print("Please pick a gesture, 1 for rock; 2 for paper; "
	            + "3 for scissors; 4 ends this run of competition: ");
	    //This try&catch block tests for correct user input
	    try
	    {
	        choice=scan.nextInt();//Scans for an integer in user input
	       
	        if(choice==1)//If user chooses rock
	        {
	            al.add(choice);
	            compchoice=getComputerGesture();
	            gameResult(choice,compchoice);
	            return true;
	            
	        }
	        else if(choice==2)//If user chooses paper
	        {
	            al.add(choice);
    	        compchoice=getComputerGesture();
                gameResult(choice,compchoice);
                return true;
    	    }
    	    else if(choice==3)//If user chooses scissor
    	    {
    	        al.add(choice);
    	        compchoice=getComputerGesture();
                gameResult(choice,compchoice);
                return true;
    	    }
    	    else if(choice==4)//If user wants to quit
    	    {
    	        printStat();
    	        return false;
    	    }
	        
	    }
        catch(Exception e)
        {
            System.out.print("Invalid value, please enter a correct value!\n");
            scan.nextLine();
        }
	    return true;
	}
	
	//This function gets a rock,paper, or scissor choice from the computer.
	//The function also contains an algorithm to look if the user inputs a 
	//3 in a row pattern to try and outplay the him/her.
	private int getComputerGesture()
	{
	    int gesture=0;//returned computer choice
	    int ndx=0;//keeps track of the index for algorithm
	    int count=0;//keeps a pattern count
	    playcount++;//increments number of matches played by 1
	    if(al.size()>4 && playcount<5)//If there are more than 4 matches played the algorithm kicks in
	    {
	        for(int i=0;i<=al.size()-3;i++)
	        {
	            for(int j=al.size()-3;j<al.size();j++)
	            {
	                if(al.get(i)==al.get(j))
	                {
	                    count++;
	                    if(count==3)//If there is a pattern
	                    {
	                        if(al.get(ndx+1)==1)
	                            gesture=2;
	                        else if(al.get(ndx+1)==2)
	                            gesture=3;
	                        else if(al.get(ndx+1)==3)
	                            gesture=1;
	                        return gesture;
	                    }
	                    ndx=i;
	                    i++;
	                }
	                else
	                    count--;
	            }
	            count=0;//reset count if no pattern is found in inner loop
	        }
	    }
	    
	    if(gesture==0 && playcount>=5)//Every 5th turn the computer outputs a random gesture
	    {
	        gesture=(int)(Math.random()*3+1);
	        playcount=0;
	    }
	    else if(gesture==0)//If algorithm didn't kick in yet
	        gesture=(int)(Math.random()*3+1);
	    return gesture;
	}
	
	//This function compares the user input v.s the computer, determines a 
	//winner for that match, and updates the gamestat object.
	private void gameResult(int userchoice, int compchoice)
	{
	    if(userchoice==1 && compchoice==2)
	    {
	        System.out.println("Go! Your gesture is rock. My gesture is paper. I win!");
	        gstat.update(1, 0, 0, 1, 2);
	    }
	    else if(userchoice==1 && compchoice==3)
	    {       
	        System.out.println("Go! Your gesture is rock. My gesture is scissors. You win!");
	        gstat.update(0, 1, 0, 1, 3);
	    }
	    else if(userchoice==2 && compchoice==1)
	    {
	        System.out.println("Go! Your gesture is paper. My gesture is rock. You win!");
	        gstat.update(0, 1, 0, 2, 1);
	    }
	    else if(userchoice==2 && compchoice==3)
	    {
	        System.out.println("Go! Your gesture is paper. My gesture is scissors. I win!");
	        gstat.update(1, 0, 0, 2, 3);
	    }
	    else if(userchoice==3 && compchoice==1)
	    {
	        System.out.println("Go! Your gesture is scissors. My gesture is rock. I win!");
	        gstat.update(1, 0, 0, 3, 1);
	    }
	    else if(userchoice==3 && compchoice==2)
	    {
	        System.out.println("Go! Your gesture is scissors. My gesture is paper. You win!");
	        gstat.update(0, 1, 0, 3, 2);
	    }
	    else if(userchoice==compchoice)
	    {
	        if(userchoice==1)
	        {
	            System.out.println("Go! Your gesture is rock. My gesture is rock. A tie!");
	            gstat.update(0, 0, 1, 1, 1);
	        }
	        else if(userchoice==2)
	        {
	            System.out.println("Go! Your gesture is paper. My gesture is paper. A tie!");
	            gstat.update(0, 0, 1, 2, 2);
	        }
	        else if(userchoice==3)
	        {
	            System.out.println("Go! Your gesture is scissors. My gesture is scissors. A tie!");
	            gstat.update(0, 0, 1, 3, 3);
	        }
	    }
	    else//This statement will never run but just in case magic occurs
	        System.out.println("You somehow managed to break the game!");
	}
	
	//returns the current GameStat object
	public GameStat getGameStat()
	{
	    return gstat;
	}
	
	//prints out the statistics summary after a game has ended
	public void printStat()
	{
	    System.out.println(gstat.getStatSummary());
	}
}//End of RPSGame class
