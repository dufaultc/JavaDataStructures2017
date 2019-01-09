// Progammer: Cameron Dufault
// Date: April 10 2017
// File: StackClient.java
// Description: This program creates and utilizes a stak of names

public class StackClient
{
    public static void main (String[] args)
    {
	Stak presidents = new Stak(); //creating new stack
	
	System.out.println(presidents.isEmpty()); //outputting whether or not stak is empty
	
	//adding new nodes to stak
	presidents.push ("Ford");
	presidents.push("Carter");
	presidents.push("Reagan");
	presidents.push("Bush Sr");
	presidents.push("Clinton");
	presidents.push("Bush Jr");
	presidents.push("Obama");
	presidents.push("Trump");
	
	//outtputting stak and its size
	System.out.println(presidents);
	System.out.println(presidents.size());
	
	//removing top 3 nodes from stak
	presidents.popLots(3);
	
	//outputting
	System.out.println(presidents);
	
	//viewing where certian string is in stak
	System.out.println(presidents.viewItem("Reagan"));
	
	//removing certain node from stak
	presidents.popItem("Reagan");
	
	//outputting
	System.out.println(presidents);
	
	//adding new node to stak at spot 2
	presidents.pushItem("Joe", 2);
	
	//outputting
	System.out.println(presidents);
	
     
    }//main method
    
}//stackClient class
