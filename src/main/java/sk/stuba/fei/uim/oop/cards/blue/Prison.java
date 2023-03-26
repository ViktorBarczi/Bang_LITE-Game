package sk.stuba.fei.uim.oop.cards.blue;

import sk.stuba.fei.uim.oop.bang.Board;
import sk.stuba.fei.uim.oop.bang.Player;
import sk.stuba.fei.uim.oop.cards.Card;


public class Prison extends Card {
    public Prison(String str) {
        super(str);
    }

    @Override
    public void play(Player player, Board board){
        int playerIndex = chooseAPlayer(player,board);
        for (int index = 0;index < board.getPlayers().get(playerIndex).getInfront().size();index++){
            if (board.getPlayers().get(playerIndex).getInfront().get(index).getName().equals(this.name)){
                System.out.println(board.getPlayers().get(playerIndex).getName() + " have allready have a " + this.name + " on the board !!!");
                return;
            }
        }
        player.getHand().remove(this);
        board.getPlayers().get(playerIndex).placeInfrontPlayer(this);
    }

    @Override
    public int effect(Player player,Board board, int playerIndex) {
        int chanse = (random.nextInt() % 4) + 1;

        if (chanse == 1) {
            playedCard(player, board);
            System.out.println(player.getName() + " has escaped Prison !!!");
            return playerIndex;
        }
        System.out.println(player.getName() + " is in Prison !!!");
        return ++playerIndex;
    }
}
