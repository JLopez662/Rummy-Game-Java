/**
 * Represents the basic functionality of a set of cards.
 */
public interface SetInterface
{
	/*
	*    Must override the behavior of the SetInterface so that
	*   a Set only accepts a card if it is of the same rank.
	*/
    public void addCard( Card card ) ;
    
	/**
     *   returns the rankIndex of the set
	 @return int returns int corresponding to rank as defined in CardInterface
     */
	public int getRankIndex(char rank);
	
   /**
     *   returns the rank of the set
    *  @return char returns char of rank as defined in CardInterface
     */
	public char getRank();
  
	/**
     *  Determines whether Set is contains all four cards.
	 @return if true then no more Card may be added to the set
     */
	/**
	* Ranks the cards in a set according to their suit
	*/
	
	  /**
	   * Obtains the card stored at the specified location in the set.  Does not
	   * remove the card from the set.
	   * @param index position of card to be accessed.
	   * @return the card of interest, or the null reference if the index is out of
	   * bounds.
	   */
	   public Card getCard( int index ) ;


	  /**
	   * Removes the specified card from the current set.
	   * @param card the card to be removed.
	   * @return the card removed from the set, or null if the card
	   * was not present in the set.
	   */
	   public Card removeCard( Card card );

	  /**
	   * Removes the card at the specified index from the set.
	   * @param index position of the card to be removed.
	   * @return the card removed from the set, or the null reference if
	   * the index is out of bounds.
	   */
	   public Card removeCard( int index );

	 
	  /**
	   * The number of cards held in the set.
	   * @return number of cards currently held in the set.
	   */
	   public int getNumberOfCards() ;


	  /**
	   * Sorts the card in the set.
	   * Sort is performed according to the order specified in the {@link Card} class.
	   */
	   public void sort() ;


	  /**
	   * Checks to see if the set is empty.
	   * @return <code>true</code> is the set is empty.
	   */
	   public boolean isEmpty();


	  /**
	   * Determines whether or not the set contains the specified card.
	   * @param card the card being searched for in the set.
	   * @return <code>true</code> if the card is present in the set.
	   */
	   public boolean containsCard( Card card ) ;

	  /**
	   * Searches for the first instance of the specified card in the set.
	   * @param card card being searched for.
	   * @return position index of card if found, or <code>-1</code> if not found.
	   */
	   public int findCard( Card card ) ;
	   
	  /**
	   * Searches for the first instance of a set (3 or 4 Cards of the same rank) in the set.
	   * @return  returns Card [] of Cards found in deck or <code>-null </code> if not found.
	   */
	   //public Card [] findSet( );

	  /**
	   *  Compares two sets.
	   *  @param otherSetObject the set being compared.
	   *  @return < 0 if this set is less than the other set, 0 if the two set are
	   *  the same, or > 0 if this set is greater then the other set.
	   */
	   public int compareTo( Object otherSetObject );


	  /**
	   *  Evaluates the set.  Must be defined in the subclass that implements the set
	   *  for the game being written by the client programmer.
	   *  @return an integer corresponding to the rating of the set.
	   */
	  //not sure we have to do this.....because we are just laying down the cards.....
	   public int evaluateSet();


	  /**
	    * Returns a description of the set.
	    * @return a list of cards held in the set.
	    */
	    public String toString();
	    
	    /* Function used to check if the set is full */
		public boolean isFull();

	

}