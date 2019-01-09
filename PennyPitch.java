// Programmer: Cameron Dufault
// Date: March 30 2017
// File: PennyPitch.java
// Description: This program simulates a game where the user throws pennies on a board

import java.io.*;
public class PennyPitch
{
    public static void main (String[] args) throws IOException 
    {
	BufferedReader kbi = new BufferedReader (new InputStreamReader (System.in));    
    
	int play = 1; //if the user wants to play or not 1- yes 0 - no
	int dollNum; //number of pennies on doll spots
	int yoyoNum; //number of pennies on yoyo spots
	int footballNum; //number of pennies on football spots
	int posterNum; //number of pennies on poster spots
	int kiteNum; //number of pennies on kite spots
 
	String pitchResult;//holds the result of the usrs most recent penny throw

	//creating and initializeing basic game board
	String[] [] gameBoard = {{"DOLL    ", "NOTHING ", "POSTER  ", "FOOTBALL", "NOTHING "}, {"YO-YO   ", "YO-YO   ", "NOTHING ", "KITE    ", "DOLL    "}, {"NOTHING ", "POSTER  ", "NOTHING ", "NOTHING ", "YO-YO   "}, {"FOOTBALL", "NOTHING ", "DOLL    ", "NOTHING ", "KITE    "}, {"NOTHING ", "KITE    ", "FOOTBALL", "POSTER  ", "NOTHING "}};
	//creating board which will begin as gameBoard but will fill with pennies
	String[] [] pennyBoard = new String [5] [5];

	System.out.println ("--------------THE PENNY PITCHING GAME----------------");
	System.out.println ("For $1 you can throw 10 pennies on the game board to win prizes!\nIf you get 3 pennies on the same proze in three different\nspots, you win the prize! Here is what the board looks like.\n");

	//displaying game board
	for (int row = 0 ; row < gameBoard.length ; row++)
	{
	    for (int col = 0 ; col < gameBoard [0].length ; col++)
	    {
		System.out.print (gameBoard [row] [col] + " ");
	    }//end for
	    System.out.println ();
	} //end for
	System.out.println ();
	 //determining if user wants to play
	System.out.print("Please enter 1 if you would like to play and be charges $1, if not, enter 0: ");
	play = Integer.parseInt(kbi.readLine());

	//this loop continually plays the game as long as the user wants to
	while (play == 1)
	{
	    //initializing counts
	    dollNum = 0;
	    yoyoNum = 0;
	    footballNum = 0;
	    posterNum = 0;
	    kiteNum = 0;

	    //restting pennyboard to basic gameboard
	    for (int row = 0 ; row < gameBoard.length ; row++)
	    {
		for (int col = 0 ; col < gameBoard [0].length ; col++)
		{
		    pennyBoard [row] [col] = gameBoard [row] [col];
		}//end for
	    } //end for
	    System.out.println ();

	    //pitching pennies 10 times and determining if any counts need to be incrementd repeatedly
	    for (int count = 0 ; count < 10 ; count++)
	    {
		pitchResult = pitch (pennyBoard); //pitchign penny

		//determining if and which counter to increment
		if (pitchResult.equals ("DOLL"))
		    dollNum = dollNum + 1;
		else if (pitchResult.equals ("YO-YO"))
		    yoyoNum = yoyoNum + 1;
		else if (pitchResult.equals ("FOOTBALL"))
		    footballNum = footballNum + 1;
		else if (pitchResult.equals("POSTER"))
		    posterNum = posterNum + 1;
		else if (pitchResult.equals ("KITE"))
		    kiteNum = kiteNum + 1;

	    } //end for

	    //outputting game bpard with pennies on it
	    for (int row = 0 ; row < pennyBoard.length ; row++)
	    {
		for (int col = 0 ; col < pennyBoard [0].length ; col++)
		{
		    System.out.print (pennyBoard [row] [col] + " ");
		}
		System.out.println ();
	    } //for loop
	    System.out.println ();
	    
	    //many if structures used as its possible to win more than one prize. 
	    //outputting result at end of play which states if the user won a prize
	    if (dollNum > 2)
		 System.out.println("You won a doll!");
	    if (yoyoNum > 2)
		 System.out.println("You won a yo-yo!");
	    if (footballNum > 2)
		 System.out.println("You won a football!");
	    if (posterNum > 2)
		 System.out.println("You won a poster!");
	    if (kiteNum > 2)
		 System.out.println("You won a kite!");
	    if ((dollNum < 3) && (yoyoNum < 3) && (footballNum < 3) && (posterNum < 3) && (kiteNum < 3)) //the user did not land pennies on three of the same type of prize
		System.out.println("You did not win any prizes :( ");
		
	    //determingin if the user wants to play again
	    System.out.print("If you would like to play again for $1, enter 1, if not, enter 0: ");
	    play = Integer.parseInt(kbi.readLine()); 


	} //while loop

    } //main method

    //this method randomly determines where on the gamebaord the user has thorwn their penny
    public static String pitch (String[] [] pBoard)
    {
	String result; //holds the name of the prize landed on
	int row = (int) (Math.random () * (4 - 0 + 1) + 0); 
	int col = (int) (Math.random () * (4 - 0 + 1) + 0);

	result = pBoard [row] [col].trim (); //name on board is trimmed for ease of comparison

	pBoard [row] [col] = "$Penny$ "; //resetting the name of the prize on the penny baord to let the user know they have a penny on the board

	return result;
    } //pitch method




} //pennypitch class


