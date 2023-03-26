package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.bang.Board;
import sk.stuba.fei.uim.oop.bang.Player;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.Random;

public abstract class Card {
    protected String name;
    protected Random random;

    public Card(String str){
        this.name = str;
        this.random = new Random();
    }

    public void play(Player p,Board board){
       System.out.println("You played a card!");
    }

    public String getName() {
        return this.name;
    }

    public void playedCard(Player player,Board board){
        player.getHand().remove(this);
        player.getInfront().remove(this);
        board.getSideDeck().add(this);
    }

    public int effect(Player player,Board board,int playerIndex){System.out.println("This card has no effect!"); return -1;}

    public int chooseAPlayer(Player player,Board board){
        System.out.println("Players in game !!!");
        for (int index = 0;index<board.getPlayers().size();index++){
            if (board.getPlayers().get(index).getName().equals(player.getName())){
                continue;
            }
            System.out.println("Player number: " + (index+1) + ", Name: " + board.getPlayers().get(index).getName());
        }
        int choosenIndex = ZKlavesnice.readInt("Choose a player (by number): ");
        if (choosenIndex > board.getPlayers().size() || choosenIndex <= 0 || board.getPlayers().get(choosenIndex).getName().equals(player.getName())){
            while (choosenIndex > board.getPlayers().size() || choosenIndex <= 0 || board.getPlayers().get(choosenIndex).getName().equals(player.getName())){
                choosenIndex = ZKlavesnice.readInt("Wrong input, try again: ");
            }
        }

        return choosenIndex-1;
    }

    public int hide(Player player,Board board){
        int chanse = (random.nextInt() % 4) + 1;
        if (chanse == 1){
            playedCard(player,board);
        }
        return chanse;
    }



}
