package sk.stuba.fei.uim.oop.cards.blue;

import sk.stuba.fei.uim.oop.bang.Board;
import sk.stuba.fei.uim.oop.bang.Player;
import sk.stuba.fei.uim.oop.cards.Card;

public class Dynamit extends Card {
    public Dynamit(String str,int i) {
        super(str,i);
    }
    public void play(Player p, Board board){
        p.placeInfrontPlayer(this);

    }

    public int effect(Player player,Board board,String card) {
        int chanse = (random.nextInt() % 8) + 1;
        if (chanse == 1){
            player.setLives(player.getLives() - 3);
        }
        else {
            player.removeFromInfornt(this);
            int index = 0;
            for (index = 0;index<board.getPlayers().size();index++){
                if (board.getPlayers().get(index).getName().equals(player.getName())){

                    int nextPlayer = index+1;
                    if (nextPlayer >= board.getPlayers().size()){
                        nextPlayer = 0;
                    }
                    board.getPlayers().get(nextPlayer).placeInfrontPlayer(this);
                }
            }
        }
        return chanse;
    }
}
