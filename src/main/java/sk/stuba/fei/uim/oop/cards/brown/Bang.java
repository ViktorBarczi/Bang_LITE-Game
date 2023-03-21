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
        int i = ZKlavesnice.readInt("Choose a player (2-"+ board.getPlayers().size() + "): ");
        int lives = board.getPlayers().get(i).getLives();
        lives = lives-1;
        board.getPlayers().get(i).setLives(lives);
    }
}
