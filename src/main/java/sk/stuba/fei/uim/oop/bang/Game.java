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
        int playersNum;
        System.out.println("Hello this is my version of the game Bang.");
        System.out.println("Please insert how many players are going to play: ");

        ArrayList<Player> players = new ArrayList<>();

        do {
            playersNum = ZKlavesnice.readInt("Only 2-4 players can play !!!");
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
        int playerIndex = 0;
        do {
            if (playerIndex == this.board.getPlayers().size()) {
                playerIndex = 0;
            }
            Player player = this.board.getPlayers().get(playerIndex);

            System.out.println();
            System.out.println();
            if (player.getLives() == 0){
                removePlayer(player);
                continue;
            }
            System.out.println(player.getName() + "'s turn !!!!!!");
            System.out.println("Lives: " + player.getLives());
            System.out.println("Cards: ");
            for (int index = 0; index < player.getHand().size(); index++) {
                System.out.println(index+1 +". "+" [ " + player.getHand().get(index).getName() + " ]");
            }

            System.out.println("Board: ");
            if (player.getInfront().isEmpty()){
                System.out.println("{ Board is Empty }");
            }
            else{
                for (int index = 0;index < player.getInfront().size();index++){
                    System.out.print("{ " + player.getInfront().get(index).getName() + " }");
                }
                System.out.println();
            }

            int effectCount = 0;
            int oldIndex = playerIndex;
            for (int cardIndex = 0;  cardIndex < player.getInfront().size(); cardIndex++){
                playerIndex = player.getInfront().get(cardIndex).effect(player,this.board, playerIndex);
                effectCount++;
            }

            if (playerIndex != oldIndex){
                continue;
            }

            if (effectCount == 0){
                System.out.println("No effect has benn triggered !!!");
            }

            player = this.board.getPlayers().get(playerIndex);


            System.out.println("Card " + player.addCardToHand(this.board).getName() + " drawed");
            System.out.println("Card " + player.addCardToHand(this.board).getName() + " drawed");

            while (player.getHand().size() != player.getLives()) {
                if (player.getHand().size() < player.getLives())
                    break;
                playerTurn(player);
            }

            playerIndex++;
        }
        while (this.board.getPlayers().size() != 1);

        System.out.println("CONGRATULATIONS the winner is: " + this.board.getPlayers().get(0).getName());
    }

    public void playerTurn (Player player){
        /*if (player.getLives() > player.getHand().size()){
            while (player.getHand().size() < player.getLives()){
                player.addCardToHand(this.board);
            }
        }*/
            System.out.println("Lives: " + player.getLives());
            System.out.println("Cards: ");
            for (int index = 0; index < player.getHand().size(); index++) {
                System.out.println(index+1 +". "+" [ " + player.getHand().get(index).getName() + " ]");
            }
            int choosenCardIndex;
            do {
                choosenCardIndex = ZKlavesnice.readInt("Choose a card (by number): ");
            }
            while(choosenCardIndex > player.getHand().size() || choosenCardIndex <= 0);

            System.out.println("Card " + player.getHand().get(choosenCardIndex - 1).getName() + " was played");
            player.getHand().get(choosenCardIndex - 1).play(player, this.board);
    }

    public void removePlayer(Player player){
        this.board.getPlayers().remove(player);
        for (int index = 0;index < player.getHand().size();index++){
            player.getHand().get(index).playedCard(player,this.board);
        }
        for (int index = 0; index<player.getInfront().size();index++){
            player.getInfront().get(index).playedCard(player,this.board);
        }
    }


}
