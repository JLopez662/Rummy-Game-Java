//Class representing implementation of Pile
//Class will inherit from Pile Interface

public class Pile implements PileInterface {
	
	//Constructor of the Pile, with MyStack as the data type.
   private MyStack pile;

 
  
  /**
   * Creates an empty pile of cards.
   * Constructor
   */
   public Pile() {
      pile = new MyStack(52);
   }
  
  
  /**
   * Adds a card to the pile.
   * @param card card to be added to the pile.
   */
   public void addCard( Card card ) {
      pile.push( card );
   }
  
  
  /**
   * The size of a pile of cards.
   * @return the number of cards present in the full pile.
   */
   public int getSizeOfPile() {
      return pile.getSize();
   }
   
   
 
   
  /**
   * Deal one card from the pile.
   * @return a card from the pile, or the null reference if there
   * are no cards left in the pile.
   */
   public Card dealCard() {
     return pile.pop();
   }
   
   
  /**
   * Shuffles the cards present in the pile.
   */
   public void shuffle() {
      pile.shuffle();
   }
   
   
  /**
   * Looks for an empty pile.
   * @return true if there are no cards left to be dealt from the pile.
   */
   public boolean isEmpty() {
      return pile.isEmpty();
   }
   
  /**
   * Restores the pile to "full pile" status.
   */
   public void restorePile() {     
      for (int i = 0; i < pile.elemSize(); i++) {
    	 pile.pop();
    	 }
      }
   
  
   /* Removes a card from the pile */
   public Card removeCard() {
	   return pile.pop();
   }

   /* Shows the top card of the pile */
   public Card peek() {
	return pile.peek();
   }

   /* Indicates if the Pile is Full */
   public boolean isFull() {
	return pile.isFull();
   }
}

