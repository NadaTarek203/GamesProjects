/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Scanner;
import java.util.Random;

public class Game {

    public Player player[] = new Player[4];//dealer at index[3]
    public Card cards[] = new Card[52];
    public int HighScore = 0;
    int index = 0;

    public void generateCards() {
        int card_index = 0;
        int value;
        for (int Ranks = 0; Ranks <= 3; Ranks++) { //i for suits
            for (int Suits = 0; Suits <= 12; Suits++) {//j for ranks
                if (Suits > 9) {
                    value = 10;
                } else {
                    value = Suits + 1;
                }
                cards[card_index] = new Card(Ranks, Suits, value);
                card_index++;
            }

        }
    }

    public Card randomCards() {
        Random random = new Random();
        //get random no from 0 to 51

        while (true) {
            int randomChoice = random.nextInt(52);

            if (cards[randomChoice] != null) {
                Card newCard = cards[randomChoice];
                cards[randomChoice] = null;
                return newCard;
            }

        }
    }

    public void PlayersInfo(Player player, int i) {

        this.player[i] = player;

    }

    public void UpdateScore(int value) {
        HighScore = value;
        
    }

}
