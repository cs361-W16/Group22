package models;

import java.util.ArrayList;
import models.Cards;
import models.Deck;

/**
 * Created by Yizheng on 1/21/2016.
 */
public class Stack
{
    public Cards stack[][] = new Cards[13][4];

    public Stack(){
        Cards card= new Cards(0,null,null);
        for (int i=0;i<13;i++)
        {
            for (int j=0;j<4;j++)
            {
                stack[i][j]=card;
            }
        }
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

    public void pushCard(Cards card,int n)
    {
        int i;
        for (i = 0; i < 13; i++)
        {
            if (stack[i][n].getRank() == null)
            {
                break;
            }
        }
        for (int j = i; j > 0; j--)
        {
            stack[j][n] = stack[j - 1][n];
        }
        stack[0][n] = card;
    }

    public Cards top(int n)
    {
        return stack[0][n];
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
    //n is column number
    //if suit is same and large value, return 1
    public int checkRemove(Cards card, int n){

        for(int i=0;i<3;i++){
            if(i == n) {
                i++;
                //return 0;
            }
            else if(stack[0][i].getValue() > card.getValue() && (stack[0][i].getSuit().equals(card.getSuit()))){
                return 1;

            }
            else
                return 0;
        }
        return n;
    }

    public void removeTop(Cards card,int n){
        int r = checkRemove(card, n);
        if(r == 1){
            popCard(n);
        }
        else
           return;
    }
}

