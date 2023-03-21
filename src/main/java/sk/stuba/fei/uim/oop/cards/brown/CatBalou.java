package sk.stuba.fei.uim.oop.cards.brown;

import sk.stuba.fei.uim.oop.bang.Board;
import sk.stuba.fei.uim.oop.bang.Player;
import sk.stuba.fei.uim.oop.cards.Card;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;
import java.util.Random;

public class CatBalou extends Card {
    public CatBalou(String str,int i) {
        super(str,i);
    }

    public void play(Player p, Board board){
        Random rand = new Random();

        int playerToRemove = ZKlavesnice.readInt("Choose a choosenPlayer (2-"+ board.getPlayers().size() + "): ");
        Player choosenPlayer = board.getPlayers().get(playerToRemove);

        int cardToRemove =  ZKlavesnice.readInt("Choose one: (1) remove form hand or (2) remove form the board: ");
        while (cardToRemove != 1 && cardToRemove != 2){
            cardToRemove =  ZKlavesnice.readInt("Please insert 1 or 2: ");
        }
        if (cardToRemove == 1 && choosenPlayer.getHand().isEmpty()){
            System.out.println("Choosen players hand is EMPTY, choosing from board");
            cardToRemove = 2;
        }

        if (cardToRemove == 2 && choosenPlayer.getInfront().isEmpty()){
            System.out.println("Choosen players board is EMPTY, choosing from hand");
            cardToRemove = 1;
        }

        if (cardToRemove == 1) {
            choosenPlayer.getHand().get(cardToRemove).playedCard(board);
            ArrayList<Card> helpHand = choosenPlayer.getHand();
            helpHand.remove(choosenPlayer.getHand().get(rand.nextInt(helpHand.size())));
            choosenPlayer.setHand(helpHand);
        }

        if (cardToRemove == 2) {
            choosenPlayer.getInfront().get(cardToRemove).playedCard(board);
            ArrayList<Card> helpInfront = choosenPlayer.getInfront();
            helpInfront.remove(choosenPlayer.getInfront().get(rand.nextInt(helpInfront.size())));
            choosenPlayer.setInfront(helpInfront);
        }

        //game.getPlayers().get(playerToRemove);
    }
}
