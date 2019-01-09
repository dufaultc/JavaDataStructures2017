// Programmer: Cameron Dufault
// Date: April 10 2017
// File: queueClient.java
// Description: This program creates and utilizes a qeueu of numbers

public class queueClient
{
    public static void main (String [] args)
    {
	Queue numbers = new Queue (); //creating qeue
	System.out.println(numbers.isEmpty()); //checking if empty
	
	//adding radnom numbers to queue
	numbers.enqueue(String.valueOf(((int) (Math.round (Math.random () * (999 - 100 + 1) + 100)))));
	numbers.enqueue(String.valueOf(((int) (Math.round (Math.random () * (999 - 100 + 1) + 100)))));
	numbers.enqueue(String.valueOf(((int) (Math.round (Math.random () * (999 - 100 + 1) + 100)))));
	numbers.enqueue(String.valueOf(((int) (Math.round (Math.random () * (999 - 100 + 1) + 100)))));
	numbers.enqueue(String.valueOf(((int) (Math.round (Math.random () * (999 - 100 + 1) + 100)))));
	numbers.enqueue(String.valueOf(((int) (Math.round (Math.random () * (999 - 100 + 1) + 100)))));
	numbers.enqueue(String.valueOf(((int) (Math.round (Math.random () * (999 - 100 + 1) + 100)))));
	numbers.enqueue(String.valueOf(((int) (Math.round (Math.random () * (999 - 100 + 1) + 100)))));
	
	//outputting queue
	System.out.println(numbers);
	
	System.out.println(numbers.isEmpty()); //checking if empty
	
	System.out.println(numbers.size()); //outputting size of queue
	
	//viewing front and rear nodes 
	System.out.println(numbers.viewFront());
	System.out.println(numbers.viewRear());
	
	//removing three numbers
	numbers.dequeue();
	numbers.dequeue();
	numbers.dequeue();
	
	//outputting
	System.out.println(numbers);
	
	//adding two new numbers
	numbers.enqueue(String.valueOf(((int) (Math.round (Math.random () * (999 - 100 + 1) + 100)))));
	numbers.enqueue(String.valueOf(((int) (Math.round (Math.random () * (999 - 100 + 1) + 100)))));
	
	//outputting
	System.out.println(numbers);
    }//main method
}//queueCleint class
