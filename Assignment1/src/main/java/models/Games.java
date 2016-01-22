package models;

/**
 * Created by krisna on 1/21/2016.
 */
public class Games
{
    public Games()
    {
        Deck deck = new Deck();
        deck.shuffleDeck();
        Cards[] card = deck.dealCards(deck);
    }
}
