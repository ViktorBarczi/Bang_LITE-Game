package sk.stuba.fei.uim.oop.cards.brown;

import sk.stuba.fei.uim.oop.bang.Board;
import sk.stuba.fei.uim.oop.bang.Player;
import sk.stuba.fei.uim.oop.cards.Card;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class CatBalou extends Card {
    public CatBalou(String str) {
        super(str);
    }

    @Override
    public void play(Player player, Board board){
        int playerToRemove = chooseAPlayer(player,board);
        Player choosenPlayer = board.getPlayers().get(playerToRemove);
        int cardToRemove =  ZKlavesnice.readInt("Choose one: (1) remove form hand or (2) remove form the board: ");
        while (cardToRemove != 1 && cardToRemove != 2){
            cardToRemove =  ZKlavesnice.readInt("Please insert 1 or 2: ");
        }
        if (cardToRemove == 1 && choosenPlayer.getHand().isEmpty()){
            System.out.println("Choosen players hand is EMPTY, choosing from board !!!");
            cardToRemove = 2;
        }

        if (cardToRemove == 2 && choosenPlayer.getInfront().isEmpty()){
            System.out.println("Choosen players board is EMPTY, choosing from hand !!!");
            cardToRemove = 1;
        }

        if (cardToRemove == 1) {
            int randomCardIndex = this.random.nextInt(choosenPlayer.getHand().size())-1;
            System.out.println("A " + choosenPlayer.getHand().get(randomCardIndex).getName() + " was removed form " + choosenPlayer.getName() + "'s HAND !!!");
            choosenPlayer.getHand().get(cardToRemove).playedCard(choosenPlayer,board);
            choosenPlayer.getHand().remove(choosenPlayer.getHand().get(randomCardIndex));

        }

        if (cardToRemove == 2) {
            int randomCardIndex = this.random.nextInt(choosenPlayer.getInfront().size())-1;
            System.out.println("A " + choosenPlayer.getInfront().get(randomCardIndex).getName() + " was removed form " + choosenPlayer.getName() + "'s BOARD !!!");
            choosenPlayer.getInfront().get(cardToRemove).playedCard(choosenPlayer,board);
            choosenPlayer.getInfront().remove(choosenPlayer.getInfront().get(randomCardIndex));
        }

        playedCard(player,board);
    }
}
