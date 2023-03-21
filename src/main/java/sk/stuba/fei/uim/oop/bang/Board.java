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
        for (int i = 0;i<players.size();i++){
            for (int j = 0;j<players.get(i).getLives();j++){
                this.deck = players.get(i).addCardToHand(this.deck);
            }
        }

    }

    public ArrayList<Card> makeNewDeck(){
        ArrayList<Card> cardDeck = new ArrayList<>();
        int num = 0;
        for (int i = 0;i<2;i++){
            cardDeck.add(new Barrel("Barrel",num));
        }
        num++;
        cardDeck.add(new Dynamit("Dynamit",num));
        num++;
        for (int i = 0;i<3;i++){
            cardDeck.add(new Prison("Prison",num));
        }
        num++;
        for (int i = 0;i<30;i++){
            cardDeck.add(new Bang("Bang",num));
        }
        num++;
        for (int i = 0;i<15;i++){
            cardDeck.add(new Miss("Miss",num));
        }
        num++;
        for (int i = 0;i<8;i++){
            cardDeck.add(new Beer("Beer",num));
        }
        num++;
        for (int i = 0;i<6;i++){
            cardDeck.add(new CatBalou("CatBalou",num));
        }
        num++;
        for (int i = 0;i<4;i++){
            cardDeck.add(new MailCar("MailCar",num));
        }
        num++;
        for (int i = 0;i<2;i++){
            cardDeck.add(new Indians("Indians",num));
        }

        Collections.shuffle(cardDeck);

        return cardDeck;
    }


    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public ArrayList<Card> getSideDeck() {
        return sideDeck;
    }

    public void setSideDeck(ArrayList<Card> sideDeck) {
        this.sideDeck = sideDeck;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

}
