//Importing all tools from java utilities
import java.util.*;

/* Class Mystack with functions used in inheritance 
 * for the rest of the .java files.
 */
public class MyStack {
	
/* Creating the list of cards */
private ArrayList<Card> list;

/* Defining size of the List */
private int size;

/*Defining the top of the list */
private int top;

/* Constructor of MyStack*/
public MyStack(int card) {
	/* Here is the list of Cards */
	list = new ArrayList<Card>(card);
	size = card;
	top = card;
}
	/* Defining size of the list */
  public int elemSize() {
	  return list.size();
  }

  /* Function used to check if list is empty */
  public boolean isEmpty() {
    return list.isEmpty();
  }
  
  /* Function used to check if list is full */
  public boolean isFull() {
	 return (list.size() == size);
  }
  /* Function used to check the current size of the list */
  public int getSize() {
    return top;
  }
  /* Function used to shuffle the positions of the elements in the list
   * if the list is not empty */
  public void shuffle() {
		if (!isEmpty()) {
		Collections.shuffle(list);
		}
	}
  /* Shows the top element of the list without discarding it */
  public Card peek(){
	  if (!isEmpty()) {
		  return list.get(list.size() - 1);
	  }
    return null;
  }
  /* Removes the top element of the list if it is not Empty */
  public Card pop(){
    if(!isEmpty()) {
	  Card card = list.get(list.size() - 1);
	  list.remove(list.size() - 1);
	  return card;
  }
    return null;
  }
  /* Inserts the element on the top of the list */
  public void push(Card card){
	  if (!isFull()) {
		  list.add(card);
		  
	  }
  }
  
  /* Function used to return elements as a string to print data results*/
  public String toString() {
    return "stack: " + list.toString();
  }


  /* Function that removes an element from the current index position
   * if the list is not empty */
  public Card remove(int index) {
	    if(!isEmpty()) {
		  Card n = list.get(list.size() - 1);
		  list.remove(list.size() - 1);
		  return n;
	  }
		return null;
	}

}


