/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

public class Card {
    private int suit;//el shakl(kol 13 object nsf el suit)
    private int rank;//trtebo kam(0 to 12)
    private int value;//el rkam nfso(el swar kolha b 10)

    public Card(Card c){
        this.suit =c.suit;
        this.rank =c.rank;
        this.value =c.value;
    }

    public Card(int suit, int rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }
        
   
}
