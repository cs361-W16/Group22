package models;

/**
 * Created by Yizheng on 1/21/2016.
 */
public class Stack
{
    public Cards[][] stack = new Cards[13][4];
    public String[][] state = new String[13][4];
    public Integer c0, c1, c2, c3;
    public Deck currentDeck = new Deck();

    public Stack()
    {
        Cards card= new Cards(0,null,null);
        for (int i=0;i<13;i++)
        {
            for (int j=0;j<4;j++)
            {
                stack[i][j]=card;
            }
        }
        for (int i = 0; i < 13; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                state[i][j] = "";
            }
        }
        currentDeck.shuffleDeck();
        c0 = -1; c1 = -1; c2 = -1; c3 = -1;
    }
    public void cardToString()
    {
        for (int i = 0; i < 13; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                state[i][j] = stack[i][j].printCard();
            }
        }
    }
    public void incC0()
    {
        c0++;
    }

    public void incC1()
    {
        c1++;
    }

    public void incC2()
    {
        c2++;
    }

    public void incC3()
    {
        c3++;
    }

    public void dealFour()
    {
        incC0();
        incC1();
        incC2();
        incC3();

        Cards card0 = currentDeck.drawACard();
        pushCard(card0,0, c0);
        Cards card1 = currentDeck.drawACard();
        pushCard(card1,1, c1);
        Cards card2 = currentDeck.drawACard();
        pushCard(card2,2, c2);
        Cards card3 = currentDeck.drawACard();
        pushCard(card3,3, c3);

    }

    public void moveD(int n)
    {
        if (stack[0][n].getRank() != null)
        {
            for (int i = 0; i < 4; i++)
            {
                if (i != n && stack[0][i].getRank() == null)
                {
                    moveS(n, i);
                }
            }
        }
    }

    public void moveS(int n, int i)
    {
        stack[0][i] = stack[0][n];
        popCard(n);
    }

    public void pushCard(Cards card, int n, int c)
    {
        stack[c][n] = card;
    }

    public Cards top(int c, int n)
    {
        return stack[c][n];
    }


    public void popCard(int n)
    {
        int i;
        Cards card=new Cards(0,null,null);
        for (i=0;i<12;i++)
        {
            if (stack[i][n].getRank()==null)
            {
                break;
            }
        }
        for (int j=0;j<i;j++)
        {
            stack[j][n]=stack[j+1][n];
        }
        stack[i][n]=card;
    }
}

