package sk.stuba.fei.uim.oop.bang;

import sk.stuba.fei.uim.oop.cards.Card;
import sk.stuba.fei.uim.oop.cards.blue.*;
import sk.stuba.fei.uim.oop.cards.brown.*;

import java.util.ArrayList;
import java.util.Collections;

public class Board {
    private ArrayList<Card> sideDeck;
    private ArrayList<Card> deck;
    private ArrayList<Player> players;

    public Board(ArrayList<Player> allPlayers){
        this.players = allPlayers;
        this.deck = makeNewDeck();
        this.sideDeck = new ArrayList<>();
        for (Player player : players) {
            for (int help = 0; help < player.getLives(); help++) {
                player.addCardToHand(this);
            }
        }

    }

    public ArrayList<Card> makeNewDeck(){
        ArrayList<Card> cardDeck = new ArrayList<>();
        for (int i = 0;i<2;i++){
            cardDeck.add(new Barrel("Barrel"));
        }

        cardDeck.add(new Dynamit("Dynamit"));

        for (int i = 0;i<3;i++){
            cardDeck.add(new Prison("Prison"));
        }
        for (int i = 0;i<30;i++){
            cardDeck.add(new Bang("Bang"));
        }
        for (int i = 0;i<15;i++){
            cardDeck.add(new Miss("Miss"));
        }
        for (int i = 0;i<8;i++){
            cardDeck.add(new Beer("Beer"));
        }
        for (int i = 0;i<6;i++){
            cardDeck.add(new CatBalou("Cat Balou"));
        }
        for (int i = 0;i<4;i++){
            cardDeck.add(new MailCar("Mail Car"));
        }
        for (int i = 0;i<2;i++){
            cardDeck.add(new Indians("Indians"));
        }

        Collections.shuffle(cardDeck);

        return cardDeck;
    }


    public ArrayList<Card> getDeck() {
        return deck;
    }

    public ArrayList<Card> getSideDeck() {
        return sideDeck;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void reshuffleDeck(){
        this.deck = this.sideDeck;
        sideDeck = new ArrayList<>();
        Collections.shuffle(this.deck);
    }



}
