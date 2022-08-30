/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Scanner;

/**
 *
 * @author Nada
 */
public class BlackJack {

    public static void main(String[] args) {

        GUI gui = new GUI();

        Game game = new Game();

        Scanner s = new Scanner(System.in);

        game.generateCards();
        Player player;
        for (int i = 0; i < 4; i++) {
            //
            System.out.print("Enter name of player no." + (i + 1) + ":");

            String name = s.next();
            player = new Player(name);
            game.PlayersInfo(player, i);
            for (int j = 0; j < 2; j++) {
                Card returned_card = game.randomCards();
                game.player[i].Score += returned_card.getValue();
                game.player[i].AddCard(returned_card);

            }

        }
        gui.runGUI(game.cards, game.player[0].card, game.player[1].card, game.player[2].card, game.player[3].card);

        int action;
        for (int i = 0; i < 3; i++) {
            System.out.print("Turn of player " + i + " :\n");

            do {
                if (game.player[i].Score == 21) {
                    game.player[i].isBlackJack = true;
                    break;
                }
                System.out.print("Enter your action 1 for Hit and 2 for Stand:");
                action = s.nextInt();
                if (action == 2) {
                    break;
                }
                Card returned_card = game.randomCards();
                game.player[i].Score += returned_card.getValue();
                game.player[i].AddCard(returned_card);
                System.out.print("Dealer will give you a card\n");
                gui.updatePlayerHand(returned_card, i);
            } while (action != 2 && game.player[i].Score <= 21);
            System.out.println("player Hand=" + game.player[i].Score);
        }

        int max = 0;
        for (int k = 0; k < 3; k++) {
            if (game.player[k].Score >= max && game.player[k].Score <= 21) {
                max = game.player[k].Score;
            }
        }
        game.UpdateScore(max);
       
        System.out.print("Turn of Dealer:\n");

        while (game.player[3].Score < game.HighScore) {

            Card return_card = game.randomCards();
            game.player[3].AddCard(return_card);
            game.player[3].Score += return_card.getValue();
            gui.updateDealerHand(return_card, game.cards);
            if (game.player[3].Score > 21) {
                break;
            }

        }
 if (game.player[3].Score >= max && game.player[3].Score <= 21) {
                max = game.player[3].Score;
            }
        
        game.UpdateScore(max);
        System.out.println("HighScore="+max);
        System.out.print("Dealer Hand: " + game.player[3].Score + "\n");
        
        if (game.player[3].Score >= game.HighScore && game.player[3].Score < 21) {
            System.out.println("Dealer is BLACKJACK");
        } else if (game.player[3].Score == 21) {
            System.out.println("Dealer is BLACKJACK");
        } else {
            System.out.println("Dealer Busted");
        }
        for (int p = 0; p < 3; p++) {

            if (game.player[p].isBlackJack == true) {
                System.out.println("player " + (p + 1) + " WON");
            } else if (game.player[p].Score >= game.HighScore && game.player[p].Score < 21) {
                System.out.println("player " + (p + 1) + " WON");
            } else {
                System.out.println("player " + (p + 1) + " BUSTED");
            }
        }
        for (int p = 0; p <= 3; p++) {
            for(int q=3;q>p;q--) 
            {
               if((game.player[p].isBlackJack == true && game.player[q].isBlackJack == true)||(game.player[p].Score == game.HighScore)&&(game.player[q].Score == game.HighScore))
                    System.out.println("player " + (p+1) +" & "+(q+1)+" Push");
              
            }
        }if(game.player[0].Score>21&&game.player[1].Score>21&&game.player[2].Score>21&&game.player[3].Score>21)
        {
            {
                 System.out.println("Tie");
            }
        }
        

    }
}
