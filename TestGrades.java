// Programmer: Cameron Dufault
// Date: March 30 2017
// File: TestGrades.java
// Description: This program stores and analyzes five test marks earned by 20 students


public class TestGrades
{
    public static void main (String[] args)
    {
	int markArray[][] = new int[20][5]; //holds marks for each student for each test
	int avgArray[] = new int [5]; //holds the average of the classes mark son each test
	int high = 79; //the upper range of the range of mark required to be determined the number of
	int low = 70;  //the lower range of the range of mark required to be determined the number of
	
	//this method fills the markarray with marks
	fillTestMarks(markArray);
	
	//this loop displays the marks each student has fro each test
	for (int row = 0; row < markArray.length ; row ++)
	{
	    System.out.print(row + " ");
	    for (int col = 0; col < markArray[row].length ; col ++)
	    {
		System.out.print(markArray[row][col] + " ");
	    }//end for
	    
	    System.out.println("");
	}//end for
	
	//outputting the lowest mark earned by and student on test 2
	System.out.println ("Lowest Mark on test 2: " + findLowest(markArray, 2));
	//outputting the number of students who earned a mark within the specified range on test 2
	System.out.println("Number of tests in range " + low + " to " + high + " in test 2: " + howMany(markArray, 2, high, low));
	//outputting the average mark earned on each test
	System.out.println("The average marks for the 5 tests in order");
	avgArray = testAverages(markArray); //setting the main method array to hold the average marks
	
	for (int row = 0; row < avgArray.length ; row ++)
	{
	    System.out.println("Test " + (row + 1) +  ": " + avgArray[row]);
	}//edn for

    }//main method

    //this method fills the marks array with random marks
    private static void fillTestMarks (int[] [] mArr)
    {
	for (int row = 0 ; row < mArr.length ; row++)
	{
	    for (int col = 0 ; col < mArr [row].length ; col++)
	    {
		mArr [row] [col] = (int) (Math.random () * (100 - 40 + 1) + 40); //mark is random num between 40-100
	    }//end for
	}//end for
    }//fillTestMarks method

    //this method will return the lowest mark earned on a particular test.
    private static int findLowest (int[] [] mArr, int n)
    {
	int lowest = 101; //the lowest mark- intially set to 101 in order for next mark checked to always be below it
	for (int row = 0 ; row < mArr.length ; row++)
	{
	    //determining if the mark is lower than the previous lowest
	    if (mArr [row] [n-1] < lowest)
	    {
		lowest = mArr [row] [n-1]; //lowest is set to new mark
	    }//end if
	}//end for

	return lowest;
    }//findLowest method


    //this method determines how many students marks fall within a certain range
    private static int howMany (int[] [] mArr, int n, int high, int low)
    {
	int numInRange = 0; //hold the number of marks within range
	for (int row = 0 ; row < mArr.length ; row++)
	{   
	    //determines if the mark is within the range
	    if ((mArr [row] [n-1] >= low) && (mArr [row] [n-1] <= high))
	    {
		numInRange = numInRange + 1; //if the number is in the range increment count
	    }//end if
	}//end for

	return numInRange;
    }//howMany method
    
    //this method calculates the average mark on each test and places them in an array
    private static int[] testAverages (int[][] mArr)
    {
	int[] avgClassMark = new int[mArr[0].length]; //this array holds the avg marks
	int totalTest; //the class total marks on the test
	       
	for (int col = 0 ; col < avgClassMark.length ; col++)
	{
	    totalTest = 0;//for each test the total is reset to 0
	    
	    for (int row = 0 ; row < mArr.length ; row++)
	    {
		totalTest = totalTest + mArr[row][col]; //the total class marks on the test is added to for each student
	    }//end for
	    
	    avgClassMark[col] = totalTest / mArr.length;  //calculating average for test
	}//edn for
	
	return avgClassMark;   
    }//testAverages method
}//TestGrades class
