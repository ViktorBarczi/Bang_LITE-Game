package sk.stuba.fei.uim.oop.cards.brown;
import sk.stuba.fei.uim.oop.bang.Board;
import sk.stuba.fei.uim.oop.bang.Player;
import sk.stuba.fei.uim.oop.cards.Card;

public class Miss extends Card {
    public Miss(String str) {
        super(str);
    }
    public void play(Player p, Board board){
        System.out.println("You cant play this card !!!");
        }
}
