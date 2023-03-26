package sk.stuba.fei.uim.oop.cards.blue;

import sk.stuba.fei.uim.oop.bang.Board;
import sk.stuba.fei.uim.oop.bang.Player;
import sk.stuba.fei.uim.oop.cards.Card;

public class Dynamit extends Card {
    public Dynamit(String str) {
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
        int chanse = (random.nextInt() % 8) + 1;
        if (chanse == 1){
            System.out.println("BOOOOOOM");
            System.out.println(player.getName() + "'s Lives: " + player.getLives());
            player.setLives(player.getLives() - 3);
            playedCard(player,board);
        }
        else {
            player.removeFromInfornt(this);
            int index;
            for (index = 0;index<board.getPlayers().size();index++){
                if (board.getPlayers().get(index).getName().equals(player.getName())){

                    int nextPlayer = index+1;
                    if (nextPlayer >= board.getPlayers().size()){
                        nextPlayer = 0;
                    }
                    board.getPlayers().get(nextPlayer).placeInfrontPlayer(this);
                    System.out.println("Dynamit added to " + board.getPlayers().get(nextPlayer).getName());
                }
            }
        }
        return playerIndex;
    }
}
