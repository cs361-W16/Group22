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
<<<<<<< HEAD
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

=======
public void remove(int n){
        int count,rm;
        count = 1;
        rm=0;
        Cards card;
        card = stack[0][n];
        for (int i=0; i< 4; i++)
        if (stack[0][n].getSuit() == stack[0][i].getSuit() && n!=i){
            count++;
            if (compare(card, stack[0][i])==0){
                card = stack[0][i];
            }
        }
        if (count > 1){
            rm = 1;
        }
        for (int j=0;j<4;j++){
            if (count == 1){
                break;
            }
            if (stack[0][j].getRank() != card.getRank() && stack[0][j].getSuit() == card.getSuit()){
                popCard(j);
                count--;
            }
        }
        if (rm == 0){
            moveD(n);
        }
    }
    public int compare(Cards a, Cards b){
        if (a.getRank()=="ACE") {
            return 1;
        }
        int p=0,n=0;
        if (a.getRank() == "2"){
            p=2;
        }else if (a.getRank() == "3"){
            p=3;
        }else if (a.getRank() == "4"){
            p=4;
        }else if (a.getRank() == "5"){
            p=5;
        }else if (a.getRank() == "6"){
            p=6;
        }else if (a.getRank() == "7"){
            p=7;
        }else if (a.getRank() == "8"){
            p=8;
        }else if (a.getRank() == "9"){
            p=9;
        }else if (a.getRank() == "10"){
            p=10;
        }else if (a.getRank() == "Jack"){
            p=11;
        }else if (a.getRank() == "Queen"){
            p=12;
        }else if (a.getRank() == "King"){
            p=13;
        }else if (a.getRank() == "ACE"){
            p=14;
        }
        if (b.getRank() == "2"){
            n=2;
        }else if (b.getRank() == "3"){
            n=3;
        }else if (b.getRank() == "4"){
            n=4;
        }else if (b.getRank() == "5"){
            n=5;
        }else if (b.getRank() == "6"){
            n=6;
        }else if (b.getRank() == "7"){
            n=7;
        }else if (b.getRank() == "8"){
            n=8;
        }else if (b.getRank() == "9"){
            n=9;
        }else if (b.getRank() == "10"){
            n=10;
        }else if (b.getRank() == "Jack"){
            n=11;
        }else if (b.getRank() == "Queen"){
            n=12;
        }else if (b.getRank() == "King"){
            n=13;
        }else if (b.getRank() == "ACE"){
            n=14;
        }
        if (n>p) {
            return 0;
        }
        return 1;
    }
>>>>>>> refs/remotes/origin/master
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
    //n is column number
    //if suit is same and large value, return 1
    public int checkRemove(int n){

        for(int i=0;i<3;i++){
            if(i == n) {
                i++;
                //return 0;
            }
            else if(stack[0][i].getValue() > stack[0][n].getValue() && (stack[0][i].getSuit().equals(stack[0][n].getSuit()))){
                return 1;

            }
            else
                return 0;
        }
        return n;
    }

    public void removeTop(Stack cards,int n){
        int r = checkRemove( n);
        if(r == 1){
            popCard(n);
        }
        else
           return;
    }
}

