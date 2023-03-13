package sk.stuba.fei.uim.oop.board;

import sk.stuba.fei.uim.oop.cards.Card;
import sk.stuba.fei.uim.oop.cards.blue.*;
import sk.stuba.fei.uim.oop.cards.brown.*;

import java.util.ArrayList;
import java.util.Collections;

public class Board {
    private ArrayList<Card> playField;
    private ArrayList<Card> deck;

    public Board(){
        this.deck = makeNewDeck();

    }

    public ArrayList<Card> makeNewDeck(){
        ArrayList<Card> cardDeck = new ArrayList<>();

        for (int i = 0;i<2;i++){
            cardDeck.add(new Barrel());
        }
        cardDeck.add(new Dynamit());
        for (int i = 0;i<3;i++){
            cardDeck.add(new Prison());
        }
        for (int i = 0;i<30;i++){
            cardDeck.add(new Bang());
        }
        for (int i = 0;i<15;i++){
            cardDeck.add(new Miss());
        }
        for (int i = 0;i<8;i++){
            cardDeck.add(new Beer());
        }
        for (int i = 0;i<6;i++){
            cardDeck.add(new CatBalou());
        }
        for (int i = 0;i<4;i++){
            cardDeck.add(new MailCar());
        }
        for (int i = 0;i<2;i++){
            cardDeck.add(new Indians());
        }

        Collections.shuffle(cardDeck);

        return cardDeck;
    }


    public ArrayList<Card> getDeck() {
        return deck;
    }
}
