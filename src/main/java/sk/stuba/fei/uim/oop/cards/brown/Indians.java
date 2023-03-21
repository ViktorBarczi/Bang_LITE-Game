package sk.stuba.fei.uim.oop.cards.brown;


import sk.stuba.fei.uim.oop.bang.Board;
import sk.stuba.fei.uim.oop.bang.Player;
import sk.stuba.fei.uim.oop.cards.Card;

public class Indians extends Card {
    public Indians(String str,int i) {
        super(str,i);
    }

    public void play(Player p, Board board){
        int lives;
        int i = p.getNumber();
        for (int j = 0;j<board.getPlayers().size();j++){
            if (j == i){
                continue;
            }
            lives = board.getPlayers().get(j).getLives();
            lives = lives-1;
            board.getPlayers().get(j).setLives(lives);
        }
    }
}
