package sk.stuba.fei.uim.oop.cards.blue;

import sk.stuba.fei.uim.oop.bang.Board;
import sk.stuba.fei.uim.oop.bang.Player;
import sk.stuba.fei.uim.oop.cards.Card;
import sk.stuba.fei.uim.oop.cards.brown.Bang;

public class Barrel extends Card {
    public Barrel(String str,int i) {
        super(str,i);
    }

    public void play(Player p, Board board){
        p.placeInfrontPlayer(this);

    }

    @Override
    public int effect(Player player,Board board,String card) {
        int chanse = (random.nextInt() % 4) + 1;
        if (card.equals("Bang") && chanse == 1){
            System.out.println("Player named: "+player.getName()+" hid behind the barrel !!!");
            player.setLives(player.getLives()+1);
        }
        return chanse;
    }
}
