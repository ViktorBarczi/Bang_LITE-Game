package sk.stuba.fei.uim.oop.bang;

import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;

public class Game {
    private Board board;
    private int playersNum;

    public Game(){
        System.out.println("Hello this is my version of the game Bang.");
        System.out.println("Please insert how many players are going to play (only 2-4 players can play): ");

        ArrayList<Player> players = new ArrayList<>();

        this.playersNum = 0;
        do {
            this.playersNum = ZKlavesnice.readInt("");
            if (this.playersNum < 2 || this.playersNum > 4){
                System.out.println("Only 2-4 players can play !!!");
            }
        }
        while (this.playersNum < 2 || this.playersNum > 4);

        for(int i = 0;i<playersNum;i++){
            String name = ZKlavesnice.readString("Player " + (i+1) + " please type in your name: ");
            Player p = new Player(name);
            players.add(p);
        }

        System.out.println(playersNum + " players are ready !");
        System.out.println("LET THE GAME BEGIN !!!");

        this.board = new Board(players);

        int i = 4;



    }



}
