import java.util.ArrayList;
import java.util.Random;

public class BlackJack {
//   Design the data structures for a generic deck of cards. Explain how you would
// subclass the data structures to implement blackjack.
// First, we need to recognize that a "generic" deck of cards can mean many things.
// Generic could mean a standard deck of cards that can play a poker-like game, or it
// could even stretch to Uno or Baseball cards. It is important to ask your interviewer what
// she means by generic.
// Let's assume that your interviewer clarifies that the deck is a standard 52-card set, like
// you might see used in a blackjack or poker game. If so, the design might look like this:
public enum Value{
  Two, Three, Four, Five, Six, Seven, Eight, Nice, Ten, Jack, King, Queen, Ace
}
public enum Suit {
   Club , Diamond , Heart , Spade ;
  }
public class Card{
  private Suit suit;
  private Value value;
  public Card(Suit suit, Value value)
  {
    this.value=value;
    this.suit=suit;
  }
}
public class Deck{
  private ArrayList<Card> cards;
  //construct;
  public Deck()
  {
      this.cards=new ArrayList<Card>();
  }
  public void createFullDeck()
  {
    for(Suit cardSuit: Suit.values())
    {
      for(Value cardValue: Value.values())
      {
        this.cards.add(new Card(cardSuit,cardValue));
      }
    }
  }
  public void shuffle()
  {
    ArrayList<Card> tmpDeck=new ArrayList<Card>();
    Random random=new Random();
    int randomCardIndex=0;
    int originalSize=this.cards.size();
    for(int i=0;i<originalSize;i++)
    {
      //nextInt(max-min+1)+min
      randomCardIndex = random.nextInt((this.cards.size()-1)+1);
      tmpDeck.add(this.cards.get(randomCardIndex));
    }
    this.cards=tmpDeck;
  }
  public int deckSize()
  {
    return this.cards.size();
  }
  public void removeCard(int i)
  {
    this.cards.remove(i);
  }
  public Card getCard(int i)
  {
    return this.cards.get(i);
  }
  public void addCard(Card addCard)
  {
    this.cards.add(addCard);
  }
  //Draw from Deck
  protected void draw(Deck comingFrom)
  {
    this.cards.add(comingFrom.getCard(0));
    comingFrom.removeCard(0);
  }
  public int deckValue()
  {
    return 1;
  }
}
public static void main(String[] args) {
  System.out.println("Welcime");
  Deck playingDeck = new Deck();
  playingDeck.createFullDeck();
  playingDeck.shuffle();
  Deck playerDeck = new Deck();
  Deck dealerDeck = new Deck();
   
  playerDeck.draw(playingDeck);
  playerDeck.draw(playingDeck);
  dealerDeck.draw(playingDeck);
  dealerDeck.draw(playingDeck);
  //keep drawing keep calculating value keep fighting
  // a lot of complexities can be added but this is nice easy way

}


}
