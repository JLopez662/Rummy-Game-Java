/* Import tools like ArrayList and Collections from Java utilities */
import java.util.ArrayList;
import java.util.Collections;

//Class representing implementation of Set
//Class will inherit from Set Interface

public class Set implements SetInterface {
   private ArrayList<Card> set;
   private int size;
   private char rankValue;
 
  
  /**
   * Creates an empty Set of cards.
 * @param rank 
   */
   public Set(char rank) {
      set = new ArrayList<Card>();
      size = -1;
   }
  
   
   /**
    * Adds a card to the Set.
    * @param card card to be added to the set.
    */
	public void addCard( Card card ) {
		if(set.size() == size) {
			  
	      }
	      else
	    	  set.add( card );
	   }

 
 /**
   * Returns the rank of the card.
   * @return a Rank constant representing the rank value of the card.
   */
   public char getRank() {
	return rankValue;
   }
   
   /**
    *  Evaluates the rank of each card represented in a ArrayList
    *  each rank represents an index.
    *  
    */
   public int getRankIndex(char rank)
	{
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
    * Checks to see if the set is full.
    * @return <code>true</code> is the set is full.
    */
   public boolean isFull() {
		 return (set.size() == 4);
	  }
   
   /** 
    * The List of Cards in Set.
    * @param card card to be added to the current set.
    */
   public Card[] SetList(){
	   return set.toArray(new Card[getNumberOfCards()]);
   }


   /**
    * Removes the specified card from the current set.
    * @param card the card to be removed.
    * @return the card removed from the set, or null if the card
    */
   
	public Card removeCard(Card card) {
		int index = set.indexOf( card );
	    if ( index < 0 )
	       return null;
	    else
	       return set.remove( index );
	}
	
	 /**
	    * Removes the specified card from the current set.
	    * @param the card as Object be removed.
	    * @return the card removed from the set, or null if the card
	    * was not present in the set.
	    */
	public Card removeCard( Object card ) {
	   	  
	      
	      int index = set.indexOf( (Card) card );
	      if ( index < 0 )
	         return null;
	      else
	         return  set.remove( index );
	   }

	/**
	 * Removes the card at the specified index from the set.
	 * @param index position of the card to be removed.
	 * @return the card removed from the set, or the null reference if
	 * the index is out of bounds.
	 */
	 public Card removeCard( int index ) {
	    return set.remove( index );
	 }
	
	 /**
	   * The number of cards held in the set.
	   * @return number of cards currently held in the set.
	   */
	public int getNumberOfCards() {
		return set.size();
	}
	
	
	/**
	   * Sorts the card in the set.
	   * Sort is performed according to the order specified in the {@link Card} class.
	   */
	public void sort() {
		Collections.sort(set);
		
	}


	/**
	   * Checks to see if the set is empty.
	   * @return <code>true</code> is the set is empty.
	   */
	public boolean isEmpty() {
		return set.isEmpty();
	}
	
	


	/**
	   * Determines whether or not the set contains the specified card.
	   * @param card the card being searched for in the set.
	   * @return true if the card is present in the set.
	   */
	public boolean containsCard(Card card) {
		return set.contains(card);
	}


	/**
	   * Searches for the first instance of the specified card in the set.
	   * @param card card being searched for.
	   * @return position index of card if found, or <code>-1</code> if not found.
	   */
	public int findCard(Card card) {
		return set.indexOf(card);
	}





	/**
	   *  Evaluates the set.  Must be defined in the subclass that implements the set
	   *  for the game being written by the client programmer.
	   *  @return an integer corresponding to the rating of the set.
	   */
	public int evaluateSet() {
		  int score = 0;
		   char rank;
		   for (int i = 0; i < getNumberOfCards(); i++) {
			   rank = set.get(i).getRank();
			   if (rank=='a') {score+=1;}
			   else if (rank == 't' || rank == 'j' || rank == 'q' || rank == 'k')
			   			score +=10;
			   else score += getRankIndex(rank);
			   
		   }
		   return score;
	}



	/**
	   *  Compares two sets.  
	   *  @param otherSetObject the set being compared.
	   *  @return < 0 if this set is less than the other set, 0 if the two sets are
	   *  the same, or > 0 if this set is greater then the other set.
	   */
	public int compareTo(Object otherSetObject) {
		 Set otherSet = (Set) otherSetObject;
		  int rankDiff = evaluateSet() - otherSet.evaluateSet();
		  return rankDiff;
	}




	 /**
	   * Obtains the card stored at the specified location in the set.
	   * @return the card of interest, or the null reference if the index is out of
	   * bounds.
	   */
	public Card getCard(int index) {
		return (Card) set.get(index);
	}
	

}


   
