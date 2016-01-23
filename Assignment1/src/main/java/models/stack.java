package models;

/**
 * Created by Yizheng on 1/21/2016.
 */
public class stack {
    public Cards stack[][] = new Cards[13][4];

    public stack(){
        Cards card= new Cards(0,null,null);
        for (int i=0;i<13;i++){
            for (int j=0;j<4;j++){
                stack[i][j]=card;
            }
        }
    }
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
    public void moveD(int n) {
        if (stack[0][n].getRank() != null) {
            for (int i = 0; i < 4; i++) {
                if (i != n && stack[0][i].getRank() == null) {
                    moveS(n, i);
                }
            }
        }
    }

    public void moveS(int n, int i) {
        stack[0][i] = stack[0][n];
        popCard(n);
    }

    public void pushCard(Cards card,int n) {
        int i;
        for (i=0;i<13;i++){
            if (stack[i][n].getRank() == null ){
                break;
            }
        }
        for (int j=i;j>0;j--){
            stack[j][n]=stack[j-1][n];
        }
        stack[0][n]=card;
    }

    public Cards top(int n){
        for (int i=0;i<12;i++) {
            if (stack[i+1][n].getRank()==null)
            return stack[i][n];
        }
        return stack[12][n];
    }

    public void popCard(int n) {
        int i;
        Cards card=new Cards(0,null,null);
        for (i=0;i<12;i++){
            if (stack[i][n].getRank()==null){
                break;
            }
        }
        for (int j=0;j<i;j++){
            stack[j][n]=stack[j+1][n];
        }
        stack[i][n]=card;
    }
}

