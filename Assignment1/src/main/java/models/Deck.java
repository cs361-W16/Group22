package models;

/**
 * Created by krisna on 1/21/2016.
 */
public class Deck
{
    String[] suit = { "Clubs", "Diamonds", "Hearts", "Spades" };
    String[] rank = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

    int SUITS = suit.length;
    int RANKS = rank.length;
    int N = SUITS * RANKS;

    Cards[] deck = new Cards[N];
    public Deck()
    {
        int suitsIdx = 0;
        for(int i = 0; i < N; i++)
        {
            if(i != 0 && i % 13 == 0)
            {
                suitsIdx++;
            }
            deck[i] = new Cards((i % 13), rank[i % 13], suit[suitsIdx]);
        }
    }

    public int getCardsLeft()
    {
        return N;
    }

    public Cards drawACard()
    {
        if(N-1 >= 0)
        {
            Cards card = deck[N-1];
            N--;
            return card;
        }
        else
        {
            return null;
        }
    }

    public void shuffleDeck()
    {
        for(int i=0; i<=N-1; i++)
        {
            int r = i + (int) (Math.random() * (52-i));
            Cards t = deck[r];
            deck[r] = deck[i];
            deck[i] = t;
        }
    }

}
