//Importing all tools from java utilities
import java.util.*;


//Class that is representing an implementation of Hand
//Class that will inherit from Hand Interface
public class Hand implements HandInterface {
	
	/* Creating a list of elements in hand */
    private ArrayList<Card> hand;

    //Constructor of the Hand 
   public Hand() {
	   hand = new ArrayList<Card>();
	   
   }
   
   //Size of the Hand on the first turn for each player
   int size = 10;
   
  /** 
   * Adds a card to this hand.
   * @param card card to be added to the current hand.
   */
   public void addCard( Card card ) {
      if(hand.size() == size) {
	  
      }
      else
    	  hand.add( card );
   }

   /** 
    * The List of Cards in Hand.
    * @param card card to be added to the current hand.
    */
   public Card[] HandList(){
	   return hand.toArray(new Card[getNumberOfCards()]);
   }
   
  /**
   * Obtains the card stored at the specified location in the hand.
   * @return the card of interest, or the null reference if the index is out of
   * bounds.
   */
   public Card getCard( int index ) {
      return (Card) hand.get( index );
   }
    
  
  /**
   * Removes the specified card from the current hand.
   * @param card the card to be removed.
   * @return the card removed from the hand, or null if the card
   * was not present in the hand.
   */
   public Card removeCard( Card card ) {
      int index = hand.indexOf( card );
      if ( index < 0 )
         return null;
      else
         return hand.remove( index );
   }

   /**
    * Removes the specified card from the current hand.
    * @param the card as Object be removed.
    * @return the card removed from the hand, or null if the card
    * was not present in the hand.
    */
   public Card removeCard( Object card ) {
	   	  
	      
	      int index = hand.indexOf( (Card) card );
	      if ( index < 0 )
	         return null;
	      else
	         return  hand.remove( index );
	   }

  /**
   * Removes the card at the specified index from the hand.
   * @param index position of the card to be removed.
   * @return the card removed from the hand, or the null reference if
   * the index is out of bounds.
   */
   public Card removeCard( int index ) {
      return hand.remove( index );
   }

  /**
   * The number of cards held in the hand.
   * @return number of cards currently held in the hand.
   */
   public int getNumberOfCards() {
      return hand.size();
   }


  /**
   * Sorts the card in the hand.
   * Sort is performed according to the order specified in the {@link Card} class.
   */
   public void sort() {
      Collections.sort(hand);
   }


  /**
   * Checks to see if the hand is empty.
   * @return <code>true</code> is the hand is empty.
   */
   public boolean isEmpty() {
      return hand.isEmpty();
   }

   /**
    * Checks to see if the hand is full.
    * @return <code>true</code> is the hand is full.
    */
   public boolean isFull() {
	   return (hand.size() == size);
   }

  /**
   * Determines whether or not the hand contains the specified card.
   * @param card the card being searched for in the hand.
   * @return true if the card is present in the hand.
   */
   public boolean containsCard( Card card ) {
	  return hand.add(card);
   }


  /**
   * Searches for the first instance of the specified card in the hand.
   * @param card card being searched for.
   * @return position index of card if found, or <code>-1</code> if not found.
   */
   public int findCard( Card card ) {
      return hand.indexOf( card );
   }
  
    
  /**
   *  Compares two hands.  
   *  @param otherHandObject the hand being compared.
   *  @return < 0 if this hand is less than the other hand, 0 if the two hands are
   *  the same, or > 0 if this hand is greater then the other hand.
   */
   
   public int compareTo( Object otherHandObject ) {
	      Hand otherHand = (Hand) otherHandObject;
		  int rankDiff = evaluateHand() - otherHand.evaluateHand();
		  return rankDiff;
	   }
   
   
  /**
   *  Evaluates the hand.  Must be defined in the subclass that implements the hand
   *  for the game being written by the client programmer.
   *  @return an integer corresponding to the rating of the hand.
   */
   public int evaluateHand() {
	   int score = 0;
	   char rank;
	   for (int i = 0; i < getNumberOfCards(); i++) {
		   rank = hand.get(i).getRank();
		   if (rank=='a') {score+=1;}
		   else if (rank == 't' || rank == 'j' || rank == 'q' || rank == 'k')
		   			score +=10;
		   else score += getRankIndex(rank);
		   
	   }
	   return score;
	
}
   
   /**
    *  Evaluates the rank of each card represented in a ArrayList
    *  each rank represents an index.
    *  
    */
   private int getRankIndex(char rank) {
	   switch (rank){
		case 'a':
			return 0;
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			return Character.getNumericValue(rank) - 1;
		case 't':
			return 9;
		case 'j':
			return 10;
		case 'q':
			return 11;
		case 'k':
			return 12;
		default:
			return -1;

	}
}


/**
    * Returns a description of the hand.
    * @return a list of cards held in the hand.
    */
    public String toString() {
        return hand.toString();
    }
    
    
    
    

}