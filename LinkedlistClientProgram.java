// Programmer: Cameron Dufault
// Date: April 4 2017
// File: LinkedlistClientProgram.java
// Description: This program creates and utilizes a linked list of names 

public class LinkedlistClientProgram
{
    public static void main (String[] args)
    {
	//adding names to new linked list
	Linkedlist names = new Linkedlist ("Michael");//michael is head node
	names.addNodeAtFront ("Connor");
	names.addNodeAtFront ("Adam");
	names.addNodeAtFront ("Tyler");
	names.addNodeAtFront ("Cameron");
	names.addNodeAtFront ("Josh");
	names.addNodeAtFront ("Austin");
	names.addNodeAtFront ("Bryce");
	names.addNodeAtFront ("Abeeku");
	names.addNodeAtFront ("Michael");
	names.addNodeAtFront ("Jakob");
	
	System.out.println(names);
	
	names.removeTail(); //last node is removed
	
	System.out.println ("\nThe number of names in the list: " + names.nodeCount()); //displaying the number of nodes in the list
	
	System.out.println ("The name Connor is at node number: " + names.nodeAt("Connor")); //displaying which link number connor is
	System.out.println ("The name Gilgamesh is at node number: " + names.nodeAt("Gilgamesh")); //displaying which link number Gilgamesh is
	names.addNodeAt ("John", 7); //adding john as the 7th node in the linked lsit
	
	names.removeNode("Michael"); //removing all nodes with the name michael
	
	System.out.println("\n" + names);
	
	
	
    }
}

