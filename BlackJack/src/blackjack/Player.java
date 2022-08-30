/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

public class Player {
public String name;
public int Score;
//public int playerHand[];
public Card card[]=new Card[10];//kda by deafult kol player y2dar ykon m3ah 11 cards
boolean isBlackJack;
boolean Loser;
int index=0;

    public Player(String name) {
        this.name = name;
        //this.Score = Score;
    }
     public void AddCard(Card c) {
       
        card[index]=c;
        
        index++;
    }

    
}
