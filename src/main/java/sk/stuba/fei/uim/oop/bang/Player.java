package sk.stuba.fei.uim.oop.bang;

import sk.stuba.fei.uim.oop.cards.Card;
import java.util.ArrayList;
import java.util.Random;

public class Player {

    private final String name;
    private ArrayList<Card> hand;
    private ArrayList<Card> infront;
    private int lives;

    public Player(String nm) {
        this.name = nm;
        this.lives = 4;
        this.hand = new ArrayList<>();
        this.infront = new ArrayList<>();
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


    public ArrayList<Card> addCardToHand(ArrayList<Card> d) {
        Random rand = new Random();
        Card c =d.get(rand.nextInt(d.size()));
        d.remove(c);
        this.hand.add(c);
        return d;
    }

    public void removeCardFromHand(int i){
        this.hand.remove(i);
    }

    public Card playCard(int i,Board board){
        Card c = this.hand.get(i);
        c.play(this,board);
        this.hand.remove(i);
        return c;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public ArrayList<Card> getInfront() {
        return infront;
    }

    public void setInfront(ArrayList<Card> infront) {
        this.infront = infront;
    }

    public void placeInfrontPlayer(Card card){
        this.infront.add(card);
    }
    public void removeFromInfornt(Card card){
        this.infront.remove(card);
    }

}
