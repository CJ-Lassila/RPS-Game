/* Name: Cory Lassila - Date: 9/28/13 - Assignment #2
 * This class keeps track of all the statistics from a game
 * such as computer wins, user wins, and how many of each choice
 */
package rockPaperScissors;
//GameStat class
public class GameStat {
    
private int tie,userwin,compwin; 
private int urock, upaper, uscissor;
private int crock, cpaper, cscissor;
    
public GameStat() { } //GameStat constructor
    
//This function takes in 5 ints based on whether the computer or user won,
//or there was a tie, and which choices the user and computer made to update 
//the stats accordingly.
public void update(int compWin, int userWin, int Tie, int userGesture, int compGesture)
{
    compwin+=compWin;
    userwin+=userWin;
    tie+=Tie;
    
    if(userGesture==1)
        urock++;
    else if(userGesture==2)
        upaper++;
    else if(userGesture==3)
        uscissor++;
    
    if(compGesture==1)
        crock++;
    else if(compGesture==2)
        cpaper++;
    else if(compGesture==3)
        cscissor++;
}

//This function returns the winner of a 
//game by comparing their win stats
public String getWinner()
{
    String winner=null;
    
    if(userwin>compwin)
        winner="user.";
    else if(compwin>userwin)
        winner="computer.";
    else 
        winner="tied.";
    return winner;
}

//This function returns a string of all the stats
public String getStatSummary()
{
    String summary=null;
    
    summary="* Summary for this competition\n"+
    "* You have tried "+urock+" rock, "+upaper+" paper, "+uscissor+" scissor. You won "+userwin+" times!\n"+
    "* The computer has tried "+crock+" rock, "+cpaper+" paper, "+cscissor+" scissor. The computer won "+
        compwin+" times!\n"+
    "* Number of ties: "+tie+".\n"+
    "* Winner: The "+getWinner();
    return summary;
    
    
}

//Get properties for private variables
public int getTie()
{
    return tie;
}

public int getUserwin()
{
    return userwin;
}

public int getCompwin()
{
    return compwin;
}
}//End of GameStat class
