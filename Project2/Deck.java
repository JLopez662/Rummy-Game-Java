 
//Class representing implementation of Deck
//Class will inherit from Deck Interface


public class Deck implements DeckInterface {
  
	//Constructor of the Deck, with MyStack as the data type.
	public MyStack deck;

	private int index; 
	
	
  /**
   * Creates an empty deck of cards with a possible max size of 52 cards.
   */
   public Deck() {
      deck = new MyStack(52);
   }
  
  
  /**
   * Adds a card to the deck.
   * @param card card to be added to the deck.
   */
   public void addCard( Card card ) {
      deck.push( card );
   }
  
  
  /**
   * The size of a deck of cards.
   * @return the number of cards present in the full deck.
   */
   public int getSizeOfDeck() {
      return deck.getSize();
   }
   
   
  /**
   * Deal one card from the deck.
   * @return a card from the deck, or the null reference if there
   * are no cards left in the deck.
   */
   public Card dealCard() {
     return deck.pop();
   }
   
   
  /**
   * Shuffles the cards present in the deck.
   */
   public void shuffle() {
      deck.shuffle();
   }
   
   
  /**
   * Looks for an empty deck.
   * @return true if there are no cards left to be dealt from the deck.
   */
   public boolean isEmpty() {
      return deck.isEmpty();
   }
   
  /**
   * Restores the deck to "full deck" status.
   */
   public void restoreDeck() {   
   for (int i = 0; i < deck.elemSize(); i++) {
 	 deck.pop();
 	 }
   }   
   
  
   /* Removes a card from the deck */
   public Card removeCard(int index) {
	   return deck.remove(index);
   }
	
	public Card removeCard() {
		return deck.remove(index);
	}

   /* Shows the top card of the deck */
   public Card peek() {
	return deck.peek();
   }

   /* Indicates if the Deck is Full */
   public boolean isFull() {
	return deck.isFull();
   }
}

