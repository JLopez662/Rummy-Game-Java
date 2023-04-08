import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
*	This GUI assumes that you are using a 52 card deck and that you have 13 sets in the deck.
*	The GUI is simulating a playing table
*/
public class Table extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5524732512208011162L;
	final static int numDealtCards = 9;
	JPanel player1;
	JPanel player2;
	JPanel deckPiles;
	JLabel deck;
	JLabel stack;
	JList p1HandPile;
	JList p2HandPile;
	Deck cardDeck;
	Deck stackDeck;

	SetPanel [] setPanels = new SetPanel[13];
	JLabel topOfStack;
	JLabel deckPile;
	JButton p1Stack;
	JButton p2Stack;

	JButton p1Deck;
	JButton p2Deck;

	JButton p1Lay;
	JButton p2Lay;

	JButton p1LayOnStack;
	JButton p2LayOnStack;

	Hand p1Hand;
	Hand p2Hand;
	
	Card [] cardsPlayer1;
	Card [] cardsPlayer2;
	
	boolean Draw1;
	boolean Draw2;
	
	boolean p1Turn;
	boolean p2Turn;
	
	//Function that Deals Cards to Player 1 Hand and Player 2 Hand
	public void deal(Card [] cards)
	{
		for(int i = 0; i < cards.length; i ++)
			cards[i] = (Card)cardDeck.dealCard();
	
	}

	@SuppressWarnings("unchecked")
	public Table()
	{
		super("The Card Game of the Century");

		setLayout(new BorderLayout());
		setSize(1200,700);
 

		cardDeck = new Deck();
		
		
		for(int i = 0; i < Card.suit.length; i++){
			for(int j = 0; j < Card.rank.length; j++){
				Card card = new Card(Card.suit[i],Card.rank[j]);
				cardDeck.addCard(card);
			}
		}
		cardDeck.shuffle();
		stackDeck = new Deck();
		
		

		JPanel top = new JPanel();

		for (int i = 0; i < Card.rank.length;i++)
			setPanels[i] = new SetPanel(Card.getRankIndex(Card.rank[i]));


		top.add(setPanels[0]);
		top.add(setPanels[1]);
		top.add(setPanels[2]);
		top.add(setPanels[3]);

		player1 = new JPanel();

		player1.add(top);




		add(player1, BorderLayout.NORTH);
		JPanel bottom = new JPanel();


		bottom.add(setPanels[4]);
		bottom.add(setPanels[5]);
		bottom.add(setPanels[6]);
		bottom.add(setPanels[7]);
		bottom.add(setPanels[8]);

		player2 = new JPanel();




		player2.add(bottom);
		add(player2, BorderLayout.SOUTH);


		JPanel middle = new JPanel(new GridLayout(1,3));

		p1Stack = new JButton("Stack");
		p1Stack.addActionListener(this);
		p1Deck = new JButton("Deck ");
		p1Deck.addActionListener(this);
		p1Lay = new JButton("Lay  ");
		p1Lay.addActionListener(this);
		p1LayOnStack = new JButton("LayOnStack");
		p1LayOnStack.addActionListener(this);


		Card [] cardsPlayer1 = new Card[numDealtCards];
		deal(cardsPlayer1);
		p1Hand = new Hand();
		System.out.println("\n Initial Player 1: ");
		
		for(int i = 0; i < cardsPlayer1.length-1; i++) 
		{
		
			p1Hand.addCard(cardsPlayer1[i]);
			System.out.print(cardsPlayer1[i].toString() + ", ");
		}
			
		p1HandPile = new JList(p1Hand.HandList());


		middle.add(new HandPanel("Player 1", p1HandPile, p1Stack, p1Deck, p1Lay, p1LayOnStack));

		deckPiles = new JPanel();
		deckPiles.setLayout(new BoxLayout(deckPiles, BoxLayout.Y_AXIS));
		deckPiles.add(Box.createGlue());
		JPanel left = new JPanel();
		left.setAlignmentY(Component.CENTER_ALIGNMENT);


		stack = new JLabel("Stack");
		stack.setAlignmentY(Component.CENTER_ALIGNMENT);

		left.add(stack);
		topOfStack = new JLabel();
		topOfStack.setIcon(new ImageIcon(Card.directory + "blank.gif"));
		topOfStack.setAlignmentY(Component.CENTER_ALIGNMENT);
		left.add(topOfStack);
		deckPiles.add(left);
		deckPiles.add(Box.createGlue());

		JPanel right = new JPanel();
		right.setAlignmentY(Component.CENTER_ALIGNMENT);

		deck = new JLabel("Deck");

		deck.setAlignmentY(Component.CENTER_ALIGNMENT);
		right.add(deck);
		deckPile = new JLabel();
		deckPile.setIcon(new ImageIcon(Card.directory + "b.gif"));
		deckPile.setAlignmentY(Component.CENTER_ALIGNMENT);
		right.add(deckPile);
		deckPiles.add(right);
		deckPiles.add(Box.createGlue());
		middle.add(deckPiles);

		// A button for Stack
		p2Stack = new JButton("Stack");
		p2Stack.addActionListener(this);
		
		// A button for Deck
		p2Deck = new JButton("Deck ");
		p2Deck.addActionListener(this);
		
		// A button for Lay
		p2Lay = new JButton("Lay  ");
		p2Lay.addActionListener(this);
		
		// A button for LayOnStack
		p2LayOnStack = new JButton("LayOnStack");
		p2LayOnStack.addActionListener(this);
	
		Card [] cardsPlayer2 = new Card[numDealtCards];
		deal(cardsPlayer2);
		p2Hand = new Hand();
		System.out.println("\n Initial Player 2: ");

		for(int i = 0; i < cardsPlayer2.length-1; i++)
		{
			p2Hand.addCard(cardsPlayer2[i]);
			System.out.print(cardsPlayer2[i].toString() + ", ");
		}

		p2HandPile = new JList(p2Hand.HandList());

		middle.add(new HandPanel("Player 2", p2HandPile, p2Stack, p2Deck, p2Lay, p2LayOnStack));

		add(middle, BorderLayout.CENTER);

		JPanel leftBorder = new JPanel(new GridLayout(2,1));


		setPanels[9].setLayout(new BoxLayout(setPanels[9], BoxLayout.Y_AXIS));
		setPanels[10].setLayout(new BoxLayout(setPanels[10], BoxLayout.Y_AXIS));
		leftBorder.add(setPanels[9]);
		leftBorder.add(setPanels[10]);
		add(leftBorder, BorderLayout.WEST);

		JPanel rightBorder = new JPanel(new GridLayout(2,1));

		setPanels[11].setLayout(new BoxLayout(setPanels[11], BoxLayout.Y_AXIS));
		setPanels[12].setLayout(new BoxLayout(setPanels[12], BoxLayout.Y_AXIS));
		rightBorder.add(setPanels[11]);
		rightBorder.add(setPanels[12]);
		add(rightBorder, BorderLayout.EAST);
		
		Card topCard = cardDeck.dealCard();
		
		if (topCard != null)
		{
			topOfStack.setIcon(topCard.getCardImage());
			stackDeck.addCard(topCard);
		}
		else
		{
			topOfStack.setIcon(new ImageIcon(Card.directory + "blank.gif"));
		}
		Draw1 = false;
		Draw2 = false;
		p1Turn = true;
		p2Turn = false;

	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public void actionPerformed(ActionEvent e)
	{
		//First checking which turn is it
		Object src = e.getSource();
		if((p1Deck == src && !Draw1 && p1Turn) || (p2Deck == src && !Draw2 && p2Turn)) {
			

			Card card = cardDeck.dealCard();

			if (card != null ){

				if(p1Deck == src)
				{
					//Player 1 card(s) to the hand
					Draw1 = true;
					p1Hand.addCard(card);
					p1HandPile.setListData(p1Hand.HandList());
					
					System.out.println("\n Player 1: ");
					
				}
				else
				{
					//Player 2 card(s) to the hand
					Draw2 = true;
					Draw1 = false;
					p2Hand.addCard(card);
				    p2HandPile.setListData(p2Hand.HandList());
				    if(Draw1 == false && Draw2 == true) 
				    {
				    System.out.println("\n Player 2: ");
			
				    }
				} 
				
				System.out.print("\n Added " + card);

			}
			else
			{
				//If Player 2 Total Score from Hand is higher than Player 1
				if(p1Hand.evaluateHand() < p2Hand.evaluateHand()) 
				{
					System.out.println("\n Player 1 Wins!");
				}
				//If Player 1 Total Score from Hand is higher than Player 2
				if(p2Hand.evaluateHand() > p1Hand.evaluateHand())
				{
					System.out.println("\n Player 2 Wins!");
				}
				//If Player 2 Total Score from Hand is equal to Player 1
				else if (p1Hand.evaluateHand() == p2Hand.evaluateHand())
				{
				System.out.println("\n It is a tie!");
				}
			}
			
			//New Empty Deck
			if(cardDeck.getSizeOfDeck() == 0) {
				
			
				deckPile.setIcon(new ImageIcon(Card.directory + "blank.gif"));

				
			}
		}

		
		//If Player 1 Starts or Player 2 Starts
		if((p1Stack == src && !Draw1 && p1Turn) || (p2Stack == src && !Draw2 && p2Turn)){

			Card card = stackDeck.removeCard();
			

			if(card != null ){
				Card topCard = stackDeck.peek();
				if (topCard != null)
					topOfStack.setIcon(topCard.getCardImage());
				else
					topOfStack.setIcon(new ImageIcon(Card.directory + "blank.gif"));
				//If it is Player 1 turn
				if(p1Stack == src) {
					Draw2 = false;
					Draw1 = true;
					if(Draw1 == true && Draw2 == false) {
					p1Hand.addCard(card);
					p1HandPile.setListData(p1Hand.HandList());
					

					}
				}
				//If it is Player 2 turn
				else if (p2Stack == src) {
					Draw1 = false;
					Draw2 = true;
					if(Draw1 == false && Draw2 == true) {
					p2Hand.addCard(card);
					p2HandPile.setListData(p2Hand.HandList());
					
					}
				}


			}

			System.out.print("\n Added " + card);

		}
		//If Player1 lays a card
		if(p1Lay == src && Draw1 && p1Turn){
			@SuppressWarnings("deprecation")
			
			Object [] cards = p1HandPile.getSelectedValues();

			if (cards != null)
			{
				if(Compare(cards) && (cards.length == 3 || cards.length == 4))
				{
					
				
			
				for(int i = 0; i < cards.length; i++)
				{
					Card card = (Card)cards[i];
					layCard(card);
					p1Hand.removeCard(card);
					p1HandPile.setListData(p1Hand.HandList());
					if(p1Hand.isEmpty()) {
						System.out.println("\n Points " + p1Hand.evaluateHand() + " to " + p2Hand.evaluateHand() );
						System.out.println("\n Player 1 Wins!");
					}
				}
			}
		}
	}

		//If Player2 lays a card
		if(p2Lay == src && Draw2 && p2Turn){
			@SuppressWarnings("deprecation")
			Object [] cards = p2HandPile.getSelectedValues();
			if (cards != null) 
			{
				if(Compare(cards) && (cards.length == 3 || cards.length == 4))
				{

					for(int i = 0; i < cards.length; i++)
					{
						Card card = (Card)cards[i];
						layCard(card);
						p2Hand.removeCard(card);
						p2HandPile.setListData(p2Hand.HandList());
						if(p2Hand.isEmpty()) {
							System.out.println("\n Points " + p2Hand.evaluateHand() + " to " + p1Hand.evaluateHand() );
							System.out.println("\n Player 2 Wins!");
						}
					}
				}
			}
		}

		//If Player1 lays a card on the Stack
		if(p1LayOnStack == src && Draw1 && p1Turn){
			int [] num  = p1HandPile.getSelectedIndices();
			if (num.length == 1)
			{
				Object obj = p1HandPile.getSelectedValue();
				if (obj != null)
				{
					Draw1 = false;
					p1Turn = false;
					p2Turn = true;
					p1Hand.removeCard(obj);
					p1HandPile.setListData(p1Hand.HandList());
					Card card = (Card)obj;
					stackDeck.addCard(card);
					topOfStack.setIcon(card.getCardImage());
					System.out.println("\n Discarded " + card);
				}
			}
			if(p1Hand.isEmpty())
			{
				p1Turn = false;
				p2Turn = false;
			}
			System.out.println("\n Player 1 turn ends.");
			
			
			System.out.println("\n Hand now P1: ");
			
		
	
			System.out.print(p1Hand.toString() + "\n , ");
			
			
			System.out.println("\n Player 2 turn starts");
		}

		//If Player1 lays a card on the Stack
		if(p2LayOnStack == src && Draw2 && p2Turn){
			int [] num  = p2HandPile.getSelectedIndices();
			if (num.length == 1)
			{
				Object obj = p2HandPile.getSelectedValue();
				if (obj != null)
				{

					Draw2 = false;
					p2Turn = false;
					p1Turn = true;
					p2Hand.removeCard(obj);
					p2HandPile.setListData(p2Hand.HandList());
					Card card = (Card)obj;
					stackDeck.addCard(card);
					topOfStack.setIcon(card.getCardImage());
					System.out.println("\n Discarded " + card);
				}
			}
			if(p2Hand.isEmpty())
			{
				p1Turn = false;
				p2Turn = false;
			}
			System.out.println("\n Player 2 turn ends.");
			
			
			System.out.println("\n Hand now P2: ");
			
			
			System.out.print(p2Hand.toString() + "\n , ");
			
			System.out.println("\n Player 1 turn starts");
		}

	}
	
/* Compares the number of one card or hand score of Player 1
 * with one card or hand score of Player 2 */
	boolean Compare(Object[] obj)
	{
	boolean match = false;
	Card card = (Card) obj[0];
	Card compare;
	

	for (int i = 0; i < obj.length; i++)
	{
		compare = (Card)obj[i];
		match = card.getRank()== compare.getRank();
		if(card.getRank() != compare.getRank()) 
		{
			return match;
		}
	}
	
	return match;
	}

	//Main Function
	public static void main(String args[])
	{
		Table t = new Table();
		t.setVisible(true);
	}
	
	//Function of Laying a Card in the Pile
	boolean layCard(Card card)
	{
		char rank = card.getRank();
		char suit = card.getSuit();
		int suitIndex =  Card.getSuitIndex(suit);
		int rankIndex =  Card.getRankIndex(rank);
		boolean added = setPanels[rankIndex].getData().isEmpty();
		if(added)
		{
		//setPanels[rankIndex].array[suitIndex].setText(card.toString());
		System.out.println("\n is laying " + card);
		setPanels[rankIndex].array[suitIndex].setIcon(card.getCardImage());
		}
		return added;
	}

}



class HandPanel extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1392557479833254221L;

	public HandPanel(String name,JList<Card> hand, JButton stack, JButton deck, JButton lay, JButton layOnStack)
	{
		//model = hand.createSelectionModel();

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//		add(Box.createGlue());
		JLabel label = new JLabel(name);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(label);
		stack.setAlignmentX(Component.CENTER_ALIGNMENT);
//		add(Box.createGlue());
		add(stack);
		deck.setAlignmentX(Component.CENTER_ALIGNMENT);
//		add(Box.createGlue());
		add(deck);
		lay.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lay);
		layOnStack.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(layOnStack);
		add(Box.createGlue());
		add(hand);
		add(Box.createGlue());
	}

}
class SetPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -328410276432938919L;
	private Set data;
	JButton [] array = new JButton[4];

	public SetPanel(int index)
	{
		super();
		setData(new Set(Card.rank[index]));

		for(int i = 0; i < array.length; i++){
			array[i] = new JButton("   ");
			add(array[i]);
		}
	}

	public Set getData() {
		return data;
	}

	public void setData(Set data) {
		this.data = data;
	}
	
	public void addData(Card card)
	{
		data.addCard(card);
	}
	
	void print (String string)
	{
	System.out.println(string);
	}
	
	
	void print(boolean b)
	{
	System.out.println(b);
	}
	

}
