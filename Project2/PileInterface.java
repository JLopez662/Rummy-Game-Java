

public interface PileInterface {


	public Card peek();
 /**
   * this method is used to add Cards to a Pile.  The Pile is completely empty when it is initialized.
   */

   public void addCard( Card card ) ;

 /**
   * returns number of cards on the Pile
   * @return int
   */
   public int getSizeOfPile() ;

   /**
   * removes first card on a pile so equivalent to flipping the card off of a Pile that is faced down
   * @return <code>null</code> if there are no cards left on the Stack. Otherwise returns Card
   */
   public Card dealCard() ;

 /**
   * removes Card last card placed on a pile so equivalent to removing card from pile that is faced up
   * @return <code>null</code> if there are no cards left on the pile. Otherwise removes Card
   */
   public Card removeCard() ;

  /**
   * Shuffles the cards present in the pile.
   */
   public void shuffle() ;

  /**
   * Looks for an empty pile.
   * @return <code>true</code> if there are no cards left to be dealt from the pile.
   */
   public boolean isEmpty();

  /**
   * Restores the pile to being empty again and ready to add Cards 
   */
  public void restorePile() ;


}
