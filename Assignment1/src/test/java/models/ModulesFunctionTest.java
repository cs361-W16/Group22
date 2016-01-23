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

    @Test
    public void testDealMethod()
    {
        Deck deck = new Deck();
        deck.shuffleDeck();
        Cards[] card = deck.dealCards(deck);
        for (int i = 0; i < 4; i++)
        {
            Cards card2 = card[i];
            System.out.print(card2.getRank() + " " + card2.getSuit() + "\n");
        }
    }

    @Test

    public void testStackpopCorrect()
    {
        Stack Stack =new Stack();
        models.Cards card=new models.Cards(0,"2","Hearts");
        models.Cards card1=new models.Cards(0,"1","Hearts");
        Stack.stack[0][0]=card;
        Stack.stack[1][0]=card1;
        System.out.print(Stack.stack[0][0].getRank() + " " + Stack.stack[0][0].getSuit()+ "\n");
        System.out.print(Stack.stack[1][0].getRank() + " " + Stack.stack[1][0].getSuit()+ "\n");
        Stack.popCard(0);
        System.out.print(Stack.stack[0][0].getRank() + " " + Stack.stack[0][0].getSuit()+ "\n");
        System.out.print(Stack.stack[1][0].getRank() + " " + Stack.stack[1][0].getSuit()+ "\n");
    }

    @Test
    public void testDealToStack()
    {
        Deck deck = new Deck();
        deck.shuffleDeck();
        Cards[] card = deck.dealCards(deck);
        Stack Stack =new Stack();
        for (int i = 0; i < 4; i++)
        {
            Cards card2 = card[i];
            Stack.pushCard(card2,i);
            System.out.print(Stack.stack[0][i].getRank() + " " + Stack.stack[0][i].getSuit() + "\n");
        }
        Cards[] card3 = deck.dealCards(deck);
        for (int i = 0; i < 4; i++)
        {
            Cards card4 = card3[i];
            Stack.pushCard(card4,i);
            System.out.print(Stack.stack[0][i].getRank() + " " + Stack.stack[0][i].getSuit() + "\n");
        }
        for (int i = 0; i < 4; i++)
        {
            System.out.print(Stack.stack[1][i].getRank() + " " + Stack.stack[1][i].getSuit() + "\n");
        }
    }

    @Test
    public void testTopStack()
    {
        Deck deck = new Deck();
        deck.shuffleDeck();
        Cards[] card = deck.dealCards(deck);
        Stack Stack =new Stack();
        for (int i = 0; i < 4; i++)
        {
            Cards card2 = card[i];
            Stack.pushCard(card2,i);
            System.out.print(Stack.stack[0][i].getRank() + " " + Stack.stack[0][i].getSuit() + "\n");
        }
        Cards[] card3 = deck.dealCards(deck);
        for (int i = 0; i < 4; i++)
        {
            Cards card4 = card3[i];
            Stack.pushCard(card4,i);
            System.out.print(Stack.top(i).getRank() + " " + Stack.top(i).getSuit() + "\n");
        }

    }
@Test
    public void testPushcardCorrect() {
        stack stack = new stack();
        Cards card = new Cards(0, "2", "Hearts");
        Cards card1 = new Cards(0, "1", "Hearts");
        stack.stack[0][0] = card;
        System.out.print("Push Test:\n\n");
        System.out.print(stack.stack[0][0].getRank() + " " + stack.stack[0][0].getSuit() + "\n");
        System.out.print(stack.stack[1][0].getRank() + " " + stack.stack[1][0].getSuit() + "\n");
        stack.pushCard(card1, 0);
        System.out.print(stack.stack[0][0].getRank() + " " + stack.stack[0][0].getSuit() + "\n");
        System.out.print(stack.stack[1][0].getRank() + " " + stack.stack[1][0].getSuit() + "\n");
    }
    @Test
    public void testMoveCorrect() {
        stack stack = new stack();
        Cards card = new Cards(0, "2", "Hearts");
        Cards card1 = new Cards(0, "1", "Hearts");
        stack.stack[0][0] = card;
        System.out.print("Move Test:\n\n");
        System.out.print(stack.stack[0][0].getRank() + " " + stack.stack[0][0].getSuit() + "\n");
        System.out.print(stack.stack[0][1].getRank() + " " + stack.stack[0][1].getSuit() + "\n");

        stack.moveD(0);
        System.out.print(stack.stack[0][0].getRank() + " " + stack.stack[0][0].getSuit() + "\n");
        System.out.print(stack.stack[0][1].getRank() + " " + stack.stack[0][1].getSuit() + "\n");
    }
    @Test
    public void testRemoveCorrect() {
        stack stack = new stack();
        Cards card = new Cards(0, "2", "Hearts");
        Cards card1 = new Cards(0, "ACE", "Hearts");
        stack.stack[0][0] = card;
        stack.stack[0][1] = card1;
        System.out.print("Move Test:\n\n");

        System.out.print(stack.stack[0][0].getRank() + " " + stack.stack[0][0].getSuit() + "\n");
        System.out.print(stack.stack[0][1].getRank() + " " + stack.stack[0][1].getSuit() + "\n");
        stack.remove(0);
        System.out.print(stack.stack[0][0].getRank() + " " + stack.stack[0][0].getSuit() + "\n");
        System.out.print(stack.stack[0][1].getRank() + " " + stack.stack[0][1].getSuit() + "\n");
        stack.remove(1);
        System.out.print(stack.stack[0][0].getRank() + " " + stack.stack[0][0].getSuit() + "\n");
        System.out.print(stack.stack[0][1].getRank() + " " + stack.stack[0][1].getSuit() + "\n");
    }


}
