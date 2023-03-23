package sk.stuba.fei.uim.oop.cards.blue;

import sk.stuba.fei.uim.oop.bang.Board;
import sk.stuba.fei.uim.oop.bang.Player;
import sk.stuba.fei.uim.oop.cards.Card;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class Prison extends Card {
    public Prison(String str,int i) {
        super(str,i);
    }
    public void play(Player p, Board board){
        writeOutPlayers(board);
        int playerIndex = 0;
        while(playerIndex <= 0 || playerIndex > board.getPlayers().size()) {
            playerIndex = ZKlavesnice.readInt("Choose a player (2-" + board.getPlayers().size() + "): ");
        }
        board.getPlayers().get(playerIndex).placeInfrontPlayer(this);
    }

    public void effect(Player player,Board board,String card) {
        int chanse = (random.nextInt() % 4) + 1;

    }
}
