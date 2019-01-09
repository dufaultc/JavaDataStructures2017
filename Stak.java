// Programmer: Cameron Dufault
// Date: April 10 2017
// File: Stak.java
// Description: This program creates athe blueprint for a Stack object strcuture with various methods to utilize it
public class Stak
{
    //fields
    private Node top;  //for a stack, we only need to keep track fo the top object

    //contructors
    //instantiates a stack with one item
    public Stak (String data)
    {
	this.top = new Node (data);
    }


    //instantiates an empty stack
    public Stak ()
    {
	this.top = null;
    }


    //Accessors and mutators
    public Node getTop ()
    {
	return this.top;
    }


    public void setTop (Node top)
    {
	this.top = top;
    }


    //behavioural methods
    
    //checking if stack is empty
    public boolean isEmpty ()
    {
	if (this.top == null) //if the top is not null, its not empty
	    return true;
	else
	    return false;
    }//isEmpty method

    //determining how many nodes in the stack
    public int size ()
    {
	int count = 1; //initialzing count
	
	Node currentNode = this.top; //creating node to traverse stak
	
	while (currentNode.getNextNode () != null)//while the last node has not been reached
	{
	    currentNode = currentNode.getNextNode (); ///move to next node
	    count = count + 1;
	}//end while
	if (this.top == null)//if the stack is empty
	{
	    count = 0; 
	    return count;
	}//end if

	return count;
    }//size method

    //this method is used to remove a certain amount of nodes from the stak
    public void popLots (int numPop)
    {
	int count = 0; //initialzign count
	while (count != numPop) //while the last node to be popped hasnt been reached
	{
	    if (this.top != null) //if the queue is not empty
	    {
		this.top = this.top.getNextNode (); //assign the top node to the one under the current top
		count = count + 1;
	    }//end if
	    else //if queue is empty
	    {
		throw new IllegalStateException ("Can't pop an empty stack");
	    }//edn else
	}//end while
    }//popLots method

    //this method allows the user to see what popsition in the stak a certina node is
    public int viewItem (String data)
    {
	int count = 1; //initializing count
	Node currentNode = this.top; //creating node to traverse stak

	//while the currentnode is not the one being searched for and it has not already determined to not exist in stak
	while ((currentNode.getData () != data) && (count != -1))
	{
	    currentNode = currentNode.getNextNode (); //move to next node
	    count = count + 1;
	    if ((currentNode.getData () != data) && (currentNode.getNextNode () == null)) //if the end has been reached without firnding the node
		count = -1; //return a value of -1
	}//edn while

	return count;
    }//viewItem method

    //this method is used to remove a specific item from the stack
    public void popItem (String data)
    {
	int location = viewItem (data); //using the view item mehtod to determine wher in the stack the item is
	int count = 1; //current position within stack

	Stak tempStack = new Stak (); //temporary stak to hold popped nodes
	Node currentNode = this.top; //creating node to traverse stak

	while (count != location) //while the location of the desired node has not been reached
	{
	    tempStack.push (currentNode.getData ()); //created a copy of the current node in the tempStak
	    currentNode = currentNode.getNextNode (); //move to next node
	    count = count + 1;
	}//edn while
	popLots (location); //remove all nodes at and above location of node to be removed 

	currentNode = tempStack.top; //setting traversing ndoe to top of holding stak
	
	while (currentNode != null) //while the  node has not reached the end of the holding stak
	{
	    push(currentNode.getData()); //place copy of current node into original stak
	    currentNode = currentNode.getNextNode (); //move to next node in temp stak
	    
	}//end while

    }// popItem method

    //this method is used to add a node to the stak at a certain location
    public void pushItem (String data, int location)
    {
	int count = 1;  //current position within stack 
	Stak tempStack = new Stak (); //temporary stak to hold popped nodes
	Node currentNode = this.top; //creating node to traverse stak

	while (count != (location)) //while the desired location has not been reached
	{
	    count = count + 1;
	    tempStack.push (currentNode.getData ()); //place copy of currentNode in tempStak
	    currentNode = currentNode.getNextNode (); //move to next node
	    
	}

	popLots (location - 1 ); //remove all nodes above location of node to be added
	push (data); //add new noed to stak
	
	currentNode = tempStack.top; //setting traversing ndoe to top of holding stak

	while (currentNode != null) //while the  node has not reached the end of the holding stak
	{
	    push(currentNode.getData()); //place copy of current node into original stak
	    currentNode = currentNode.getNextNode (); //move to next node in temp stak
	}//end while
    }//pushItem method

    //add a new item(element) to the stack
    public void push (String data)
    {
	Node newItem = new Node (data);
	newItem.setNextNode (this.top);
	this.top = newItem; //make the top field refer to the new item
    }


    //remove the top item from the stack
    public void pop ()
    {
	//check that the stack isnt empty
	if (this.top != null)
	    this.top = this.top.getNextNode (); //assign the top node to the one under the current top
	else
	    throw new IllegalStateException ("Can't pop an empty stack");

    } //pop method


    //view the top item data
    public String peek ()
    {
	return this.top.getData ();

    } //peek


    public String toString ()
    {
	String string1 = "";
	Node currentItem = this.top;

	while (currentItem != null)
	{
	    string1 = string1 + currentItem.toString ();
	    currentItem = currentItem.getNextNode ();
	}
	return string1;
    }


    private class Node
    {
	//Fields
	private String data;  //data stored in the node
	private Node nextNode; //pointer

	//Contructors
	//First constructor will creare a node holding the data and pointing to null (likr the tail)
	//
	public Node (String data)
	{
	    this.data = data;
	    this.nextNode = null;
	}

	//second contstructor will create node holding data plus the poointer to the next node
	public Node (String data, Node nextNode)
	{
	    this.data = data;
	    this.nextNode = nextNode;
	}

	//Accessor and mutators
	public String getData ()
	{
	    return this.data;
	}

	public Node getNextNode ()
	{
	    return this.nextNode;
	}

	public void setData (String data)
	{
	    this.data = data;
	}

	public void setNextNode (Node nextNode)
	{
	    this.nextNode = nextNode;
	}

	public String toString ()
	{
	    String string2;
	    String string1 = "[" + this.data + "]\n" + "   V\n";
	    //check if displaying tail node
	    if (this.nextNode == null)
	    {
		string2 = "  NULL";
	    }
	    else
	    {
		//retrieving the data portion of the next node
		string2 = " ";
	    }

	    return string1 + string2;

	}



    } //node class
} //Stak class
