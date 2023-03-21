package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.bang.Board;
import sk.stuba.fei.uim.oop.bang.Game;
import sk.stuba.fei.uim.oop.bang.Player;

import java.util.ArrayList;

public abstract class Card {
    protected String name;
    protected int type;

    public Card(String str,int i){
        this.name = str;
        this.type = i;
    }

    public void play(Player p,Board board){
       System.out.println("You played a card!");
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Board playedCard(Board board){
        ArrayList<Card> sideDeck = board.getSideDeck();
        sideDeck.add(this);
        board.setSideDeck(sideDeck);
        return board;
    }


}
