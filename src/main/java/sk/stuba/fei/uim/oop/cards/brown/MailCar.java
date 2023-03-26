package sk.stuba.fei.uim.oop.cards.brown;

import sk.stuba.fei.uim.oop.bang.Board;
import sk.stuba.fei.uim.oop.cards.Card;
import sk.stuba.fei.uim.oop.bang.Player;

public class MailCar extends Card {
    public MailCar(String str) {
        super(str);
    }

    public void play(Player player,Board board){
        for (int i = 0;i<2;i++) {
            System.out.println("Card " + player.addCardToHand(board).getName() + " drawed");
        }
        playedCard(player,board);
    }
}
