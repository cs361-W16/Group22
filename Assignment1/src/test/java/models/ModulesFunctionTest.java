package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by krisna on 1/21/2016.
 */
public class ModulesFunctionTest
{
    @Test
    public void testCreateDeck()
    {
        Deck deck = new Deck();
        assertEquals(52, deck.getCardsLeft());
    }

    @Test
    public void testDeckCardsCorrect()
    {
        Deck deck = new Deck();
        for (int i = 0; i < 52; i++)
        {
            Cards card = deck.drawACard();
            System.out.print(card.getValue() + " " + card.getRank() + " " + card.getSuit() + "\n");
        }
        System.out.print("\n");
    }

    @Test
 public void testDeckShuffleCorrect()
    {
        Deck deck = new Deck();
        deck.shuffleDeck();
        for (int i = 0; i < 52; i++)
        {
            Cards card = deck.drawACard();
            System.out.print(card.getRank() + " " + card.getSuit()+ "\n");
        }

    }
    public void testStackpopCorrect(){
        stack stack=new stack();
        Cards card=new Cards(0,"2","Hearts");
        Cards card1=new Cards(0,"1","Hearts");
        stack.stack[0][0]=card;
        stack.stack[1][0]=card1;
        System.out.print(stack.stack[0][0].getRank() + " " + stack.stack[0][0].getSuit()+ "\n");
        System.out.print(stack.stack[1][0].getRank() + " " + stack.stack[1][0].getSuit()+ "\n");
        stack.popCard(0);
        System.out.print(stack.stack[0][0].getRank() + " " + stack.stack[0][0].getSuit()+ "\n");
        System.out.print(stack.stack[1][0].getRank() + " " + stack.stack[1][0].getSuit()+ "\n");
    }

}
