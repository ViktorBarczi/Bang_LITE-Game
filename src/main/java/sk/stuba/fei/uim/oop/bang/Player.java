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


    public Card addCardToHand(Board board) {
        if (board.getDeck().isEmpty()){
            board.reshuffleDeck();
        }
        Random rand = new Random();
        Card card = board.getDeck().get(rand.nextInt(board.getDeck().size()));
        board.getDeck().remove(card);
        this.hand.add(card);
        return card;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }
    public ArrayList<Card> getInfront() {
        return infront;
    }
    public void placeInfrontPlayer(Card card){
        this.infront.add(card);
    }
    public void removeFromInfornt(Card card){
        this.infront.remove(card);
    }

}
