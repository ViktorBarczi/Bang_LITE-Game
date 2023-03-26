package sk.stuba.fei.uim.oop.cards.brown;

import sk.stuba.fei.uim.oop.bang.Board;
import sk.stuba.fei.uim.oop.bang.Game;
import sk.stuba.fei.uim.oop.cards.Card;
import sk.stuba.fei.uim.oop.bang.Player;

public class Beer extends Card {
    public Beer(String str) {
        super(str);
    }

    @Override
    public void play(Player player, Board board){
        int lives = player.getLives();
        lives = lives+1;
        player.setLives(lives);
        System.out.println("Player " + player.getName() + "'s lives: " + player.getLives());
        playedCard(player,board);
    }
}
