package sk.stuba.fei.uim.oop.bang;

import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;

public class Game {
    private Board board;

    public Game(){
        setUp();
        runGame();
    }

    public void setUp(){
        int playersNum = 0;
        System.out.println("Hello this is my version of the game Bang.");
        System.out.println("Please insert how many players are going to play (only 2-4 players can play): ");

        ArrayList<Player> players = new ArrayList<>();

        do {
            playersNum = ZKlavesnice.readInt("");
            if (playersNum < 2 || playersNum > 4){
                System.out.println("Only 2-4 players can play !!!");
            }
        }
        while (playersNum < 2 || playersNum > 4);

        for(int i = 0;i<playersNum;i++){
            String name = ZKlavesnice.readString("Player " + (i+1) + " please type in your name: ");
            Player p = new Player(name);
            players.add(p);
        }

        System.out.println(playersNum + " players are ready !");
        System.out.println("LET THE GAME BEGIN !!!");

        this.board = new Board(players);
    }

    public void runGame(){
        int playerTurn = 0;
        do {
            if (playerTurn == this.board.getPlayers().size()){
                playerTurn = 0;
            }
            Player player = this.board.getPlayers().get(playerTurn);

            System.out.println("Now it is " + player.getName() + "'s turn");
            System.out.println("Lives: " + player.getLives());
            for(int index = 0;index < player.getHand().size();index++){
                System.out.println("[ " + player.getHand().get(index).getName() + " ]");
            }
            int choosenCardIndex = ZKlavesnice.readInt("Choose a card (by number): ");

            player.getHand().get(choosenCardIndex-1).play(player,this.board);

            playerTurn++;
        }
        while (this.board.getPlayers().size() != 1);
    }


}
