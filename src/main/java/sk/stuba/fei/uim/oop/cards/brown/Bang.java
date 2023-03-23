package sk.stuba.fei.uim.oop.cards.brown;


import sk.stuba.fei.uim.oop.bang.Board;
import sk.stuba.fei.uim.oop.cards.Card;
import sk.stuba.fei.uim.oop.bang.Player;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class Bang extends Card {

    public Bang(String str,int i) {
        super(str,i);
    }

    public void play(Player p,Board board){
        writeOutPlayers(board);
        int playerIndex = 0;
        while(playerIndex <= 0 || playerIndex > board.getPlayers().size()) {
            playerIndex = ZKlavesnice.readInt("Choose a player (2-" + board.getPlayers().size() + "): ");
        }
        int lives = board.getPlayers().get(playerIndex).getLives();
        lives = lives-1;
        board.getPlayers().get(playerIndex).setLives(lives);
    }
}
