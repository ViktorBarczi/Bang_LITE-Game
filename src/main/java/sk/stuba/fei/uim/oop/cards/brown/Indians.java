package sk.stuba.fei.uim.oop.cards.brown;


import sk.stuba.fei.uim.oop.bang.Board;
import sk.stuba.fei.uim.oop.bang.Player;
import sk.stuba.fei.uim.oop.cards.Card;

public class Indians extends Card {
    public Indians(String str) {
        super(str);
    }

    public void play(Player player, Board board){
        int lives;
        boolean miss;
        boolean barrel;
        for (int playerIndex = 0;playerIndex<board.getPlayers().size();playerIndex++){
            miss = false;
            barrel = false;
            Player choosenPlayer = board.getPlayers().get(playerIndex);
            if (choosenPlayer.getName().equals(player.getName())){
                continue;
            }
            for(int cardIndex = 0; cardIndex < choosenPlayer.getInfront().size() ;cardIndex++){
                if (!(choosenPlayer.getInfront().isEmpty()) && choosenPlayer.getInfront().get(cardIndex).getName().equals("Barrel")){
                    if (choosenPlayer.getInfront().get(cardIndex).hide(player,board) == 1) {
                        choosenPlayer.getInfront().get(cardIndex).playedCard(choosenPlayer,board);
                        System.out.println("Player " + choosenPlayer.getName() + "'s BARREL was HIT !!!");
                        barrel = true;
                        break;
                    }
                }
            }
            if (barrel)
                continue;

            for(int cardIndex = 0; cardIndex < choosenPlayer.getHand().size() ;cardIndex++){
                if (!(choosenPlayer.getHand().isEmpty()) && choosenPlayer.getHand().get(cardIndex).getName().equals("Miss")){
                    choosenPlayer.getHand().get(cardIndex).playedCard(choosenPlayer,board);
                    System.out.println("Player " + choosenPlayer.getName() + " was MISSED !!!");
                    miss = true;
                    break;
                }
            }
            if (miss)
                continue;
            System.out.println("Player " + choosenPlayer.getName() + " was HIT !!!");
            lives = choosenPlayer.getLives();
            lives = lives-1;
            if (lives == 0){
                System.out.println("Player " + choosenPlayer.getName() + " was KILLED !!!");
            }
            choosenPlayer.setLives(lives);
            System.out.println("Player " + choosenPlayer.getName() + "'s lives: " + choosenPlayer.getLives());
        }
        playedCard(player,board);
    }
}
