package sk.stuba.fei.uim.oop.cards.brown;

import sk.stuba.fei.uim.oop.bang.Board;
import sk.stuba.fei.uim.oop.bang.Game;
import sk.stuba.fei.uim.oop.cards.Card;
import sk.stuba.fei.uim.oop.bang.Player;

public class Beer extends Card {
    public Beer(String str,int i) {
        super(str,i);
    }

    public void play(Player p, Board board){
        int lives = p.getLives();
        lives = lives+1;
        p.setLives(lives);
    }
}
