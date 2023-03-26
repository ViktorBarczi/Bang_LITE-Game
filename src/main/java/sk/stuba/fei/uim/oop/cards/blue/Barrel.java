package sk.stuba.fei.uim.oop.cards.blue;

import sk.stuba.fei.uim.oop.bang.Board;
import sk.stuba.fei.uim.oop.bang.Player;
import sk.stuba.fei.uim.oop.cards.Card;

public class Barrel extends Card {
    public Barrel(String str) {
        super(str);
    }

    @Override
    public void play(Player player, Board board){
        for (int index = 0;index < player.getInfront().size();index++){
            if (player.getInfront().get(index).getName().equals(this.name)){
                System.out.println("You have allready have a " + this.name + " on the board !!!");
                return;
            }
        }
        player.getHand().remove(this);
        player.placeInfrontPlayer(this);
    }

    @Override
    public int effect(Player player,Board board,int playerIndex) {
        return playerIndex;
    }

}
