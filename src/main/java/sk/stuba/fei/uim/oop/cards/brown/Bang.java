package sk.stuba.fei.uim.oop.cards.brown;


import sk.stuba.fei.uim.oop.bang.Board;
import sk.stuba.fei.uim.oop.cards.Card;
import sk.stuba.fei.uim.oop.bang.Player;

public class Bang extends Card {

    public Bang(String str) {
        super(str);
    }

    @Override
    public void play(Player player,Board board){
        int playerIndex = chooseAPlayer(player,board);
        Player choosenPlayer = board.getPlayers().get(playerIndex);
        for(int cardIndex = 0; cardIndex < choosenPlayer.getInfront().size() ;cardIndex++){
            if (!(choosenPlayer.getInfront().isEmpty()) && choosenPlayer.getInfront().get(cardIndex).getName().equals("Barrel")){
                if (choosenPlayer.getInfront().get(cardIndex).hide(player,board) == 1) {
                    choosenPlayer.getInfront().get(cardIndex).playedCard(choosenPlayer,board);
                    System.out.println("Player " + choosenPlayer.getName() + "'s BARREL was HIT !!!");
                    playedCard(player,board);
                    return;
                }
            }
        }

        for(int cardIndex = 0; cardIndex < choosenPlayer.getHand().size() ;cardIndex++){
            if (!(choosenPlayer.getHand().isEmpty()) && choosenPlayer.getHand().get(cardIndex).getName().equals("Miss")){
                choosenPlayer.getHand().get(cardIndex).playedCard(choosenPlayer,board);
                System.out.println("Player " + choosenPlayer.getName() + " was MISSED !!!");
                playedCard(player,board);
                return;
            }
        }
        System.out.println("Player " + choosenPlayer.getName() + " was HIT !!!");
        int lives = choosenPlayer.getLives();
        lives = lives-1;
        if (lives == 0){
            System.out.println("Player " + choosenPlayer.getName() + " was KILLED !!!");
        }
        choosenPlayer.setLives(lives);
        System.out.println("Player " + choosenPlayer.getName() + "'s lives: " + choosenPlayer.getLives());
        playedCard(player,board);
    }
}
