package sk.stuba.fei.uim.oop.player;

import sk.stuba.fei.uim.oop.cards.Card;
import java.util.ArrayList;

public class Player {

    private final String name;
    private ArrayList<Card> hand;
    private int lives;

    public Player(String nm) {
        this.name = nm;
        this.lives = 4;
    }

    public String getName() {
        return name;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getHandSize(){
        return this.hand.size();
    }

    public void addCardToHand(Card c) {
        this.hand.add(c);
    }

    public void removeCardFromHand(int i){
        this.hand.remove(i);
    }

}