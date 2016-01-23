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
            card.printCard();
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
            card.printCard();
        }

    }

    @Test
    public void testPrintMethod()
    {
        Deck deck = new Deck();
        deck.shuffleDeck();
        for (int i = 0; i < 4; i++)
        {
            Cards card = deck.drawACard();
            card.printCard();
        }
    }
    @Test
    public void testPushStack()
    {
        Deck deck = new Deck();
        deck.shuffleDeck();
        Stack stack = new Stack();
        Cards aCard = deck.drawACard();
        stack.pushCard(aCard,0, 0);
        System.out.print(stack.top(0, 0).getValue()+ " " + stack.top(0, 0).getRank() + " " + stack.top(0, 0).getSuit() + "\n");
    }

    @Test
    public void testStackpopCorrect() {
        Stack Stack = new Stack();
        models.Cards card = new models.Cards(0, "2", "Hearts");
        models.Cards card1 = new models.Cards(0, "1", "Hearts");
        Stack.stack[0][0] = card;
        Stack.stack[1][0] = card1;
        System.out.print(Stack.stack[0][0].getRank() + " " + Stack.stack[0][0].getSuit() + "\n");
        System.out.print(Stack.stack[1][0].getRank() + " " + Stack.stack[1][0].getSuit() + "\n");
        Stack.popCard(0);
        System.out.print(Stack.stack[0][0].getRank() + " " + Stack.stack[0][0].getSuit() + "\n");
        System.out.print(Stack.stack[1][0].getRank() + " " + Stack.stack[1][0].getSuit() + "\n");
    }

    @Test
    public void testTopStack()
    {
        Deck deck = new Deck();
        deck.shuffleDeck();
        Stack stack = new Stack();
        stack.dealFour();
        for (int i = 0; i < 4; i++)
        {
            System.out.print(stack.top(0, i).getValue()+ " " + stack.top(0, i).getRank() + " " + stack.top(0, i).getSuit() + "\n");
        }
        stack.dealFour();
        for (int i = 0; i < 4; i++)
        {
            System.out.print(stack.top(0, i).getValue()+ " " +stack.top(1, i).getRank() + " " + stack.top(1, i).getSuit() + "\n");
        }
    }

}