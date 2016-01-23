package models;

/**
 * Created by krisna on 1/21/2016.
 */
public class Cards
{
    private int value;
    private String rank;
    private String suit;

    public Cards(int value, String rank, String suit)
    {
        this.value = value;
        this.rank = rank;
        this.suit = suit;
    }
    public int getValue()
    {
        return this.value;
    }
    public String getRank()
    {
        return this.rank;
    }
    public String getSuit()
    {
        return this.suit;
    }
    public String printCard()
    {
        System.out.printf("%s of %s\n", rank, suit);
        return rank + " of " + suit;
    }
}