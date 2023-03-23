package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.bang.Board;
import sk.stuba.fei.uim.oop.bang.Player;

import java.util.ArrayList;
import java.util.Random;

public abstract class Card {
    protected String name;
    protected int type;
    protected Random random;

    public Card(String str,int i){
        this.name = str;
        this.type = i;
        this.random = new Random();
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

    public void effect(Player player,Board board,String card){System.out.println("This card has no effect!");}

    public void writeOutPlayers(Board board){
        System.out.println("Players in game !!!");
        for (int i = 0;i<board.getPlayers().size();i++){
            System.out.println("Player number: " + (i+1) + ", Name: " + board.getPlayers().get(i).getName());
        }
    }

}
