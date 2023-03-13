package sk.stuba.fei.uim.oop.cards.brown;


import sk.stuba.fei.uim.oop.bang.Game;
import sk.stuba.fei.uim.oop.cards.Card;

public class Bang extends Card {

    public void play(Game game, int i){
        int lives = game.getPlayers().get(i).getLives();
        lives = lives-1;
        game.getPlayers().get(i).setLives(lives);
    }
}
