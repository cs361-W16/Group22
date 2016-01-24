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
@Test
    public void testPushcardCorrect() {
        Stack Stack = new Stack();
        Cards card = new Cards(0, "2", "Hearts");
        Cards card1 = new Cards(0, "1", "Hearts");
        Stack.stack[0][0] = card;
        System.out.print("Push Test:\n\n");
        System.out.print(Stack.stack[0][0].getRank() + " " + Stack.stack[0][0].getSuit() + "\n");
        System.out.print(Stack.stack[1][0].getRank() + " " + Stack.stack[1][0].getSuit() + "\n");
        Stack.pushCard(card1,0, 0);
        System.out.print(Stack.stack[0][0].getRank() + " " + Stack.stack[0][0].getSuit() + "\n");
        System.out.print(Stack.stack[1][0].getRank() + " " + Stack.stack[1][0].getSuit() + "\n");
    }
    @Test
    public void testMoveCorrect() {
        Stack stack = new Stack();
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
        Stack stack = new Stack();
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

    @Test
    public void testEnd(){
        Deck deck = new Deck();
        deck.N=0;
        deck.shuffleDeck();
        Stack stack = new Stack();
        stack.stack[0][0] = new Cards(12,"Ace","poo");
        stack.stack[0][1] = new Cards(12,"Ace","poo");
        stack.stack[0][2] = new Cards(12,"Ace","poo");
        stack.stack[0][3] = new Cards(12,"Ace","poo");
        System.out.println(stack.checkwin(deck,stack));
        assertEquals(1,stack.checkwin(deck,stack));
    }

    @Test
    public void testLose(){
        Deck deck = new Deck();
        deck.N=0;
        deck.shuffleDeck();
        Stack stack = new Stack();
        stack.stack[0][0] = new Cards(12,"ace","poo");
        System.out.println(stack.checkwin(deck,stack));
        assertEquals(0,stack.checkwin(deck,stack));

    }
    @Test
    public void  ret(){
    Deck another = new Deck();
    another.shuffleDeck();
        Stack stack = new Stack();
    assertEquals(0,stack.checkwin(another,stack));
}


    @Test
    public void testCompares(){
        Stack stack = new Stack();
        Cards card = new Cards(0, "3", "Hearts");
        Cards card1 = new Cards(0, "2", "Hearts");
        stack.stack[0][0] = card;
        stack.stack[0][1] = card1;
        System.out.println(stack.compare(card,card1));
        card = new Cards(0, "4", "Hearts");
        card1 = new Cards(0, "3", "Hearts");
        stack.stack[0][0] = card;
        stack.stack[0][1] = card1;
        System.out.println(stack.compare(card,card1));
        card = new Cards(0, "5", "Hearts");
        card1 = new Cards(0, "4", "Hearts");
        stack.stack[0][0] = card;
        stack.stack[0][1] = card1;
        System.out.println(stack.compare(card,card1));
        card = new Cards(0, "6", "Hearts");
        card1 = new Cards(0, "5", "Hearts");
        stack.stack[0][0] = card;
        stack.stack[0][1] = card1;
        System.out.println(stack.compare(card,card1));
        card = new Cards(0, "7", "Hearts");
        card1 = new Cards(0, "6", "Hearts");
        stack.stack[0][0] = card;
        stack.stack[0][1] = card1;
        System.out.println(stack.compare(card,card1));
        card = new Cards(0, "8", "Hearts");
        card1 = new Cards(0, "7", "Hearts");
        stack.stack[0][0] = card;
        stack.stack[0][1] = card1;
        System.out.println(stack.compare(card,card1));
        card = new Cards(0, "9", "Hearts");
        card1 = new Cards(0, "8", "Hearts");
        stack.stack[0][0] = card;
        stack.stack[0][1] = card1;
        System.out.println(stack.compare(card,card1));
        card = new Cards(0, "10", "Hearts");
        card1 = new Cards(0, "9", "Hearts");
        stack.stack[0][0] = card;
        stack.stack[0][1] = card1;
        System.out.println(stack.compare(card,card1));
        card = new Cards(0, "Jack", "Hearts");
        card1 = new Cards(0, "10", "Hearts");
        stack.stack[0][0] = card;
        stack.stack[0][1] = card1;
        System.out.println(stack.compare(card,card1));
        card = new Cards(0, "Queen", "Hearts");
        card1 = new Cards(0, "Jack", "Hearts");
        stack.stack[0][0] = card;
        stack.stack[0][1] = card1;
        System.out.println(stack.compare(card,card1));
        card = new Cards(0, "King", "Hearts");
        card1 = new Cards(0, "Queen", "Hearts");
        stack.stack[0][0] = card;
        stack.stack[0][1] = card1;
        System.out.println(stack.compare(card,card1));
        card = new Cards(0, "ACE", "Hearts");
        card1 = new Cards(0, "King", "Hearts");
        stack.stack[0][0] = card;
        stack.stack[0][1] = card1;
        System.out.println(stack.compare(card,card1));
        card1 = new Cards(0, "ACE", "Hearts");
        stack.stack[0][1] = card1;
        System.out.println(stack.compare(card,card1));

    }
}