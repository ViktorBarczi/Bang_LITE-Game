package sk.stuba.fei.uim.oop.cards.brown;

import sk.stuba.fei.uim.oop.bang.Board;
import sk.stuba.fei.uim.oop.cards.Card;
import sk.stuba.fei.uim.oop.bang.Player;

import java.util.ArrayList;

public class MailCar extends Card {
    public MailCar(String str,int i) {
        super(str,i);
    }

    public void play(Player p,Board board){
        for (int i = 0;i<2;i++) {
            ArrayList<Card> deck = p.addCardToHand(board.getDeck());
            board.setDeck(deck);
        }
    }
}
