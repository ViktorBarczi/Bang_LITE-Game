package sk.stuba.fei.uim.oop.bang;

import sk.stuba.fei.uim.oop.board.Board;
import sk.stuba.fei.uim.oop.player.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Scanner playersInput = new Scanner(System.in);;
    private int playersNum;
    private ArrayList<Player> players = new ArrayList<Player>();

    public Game(){
        System.out.println("Hello this is my version of the game Bang.");
        System.out.println("Please insert how many players are going to play (only 2-4 players can play): ");

        this.playersNum = 0;
        do {
            this.playersNum = this.playersInput.nextInt();
            if (this.playersNum < 2 || this.playersNum > 4){
                System.out.println("Only 2-4 players can play !!!");
            }
        }
        while (this.playersNum < 2 || this.playersNum > 4);


        for(int i = 0;i<playersNum;i++){
            System.out.println("Player " + (i+1) + " please type in your name: ");
            Scanner nameInput = new Scanner(System.in);
            Player p = new Player(nameInput.nextLine(), i+1);
            this.players.add(p);
        }

        System.out.println(playersNum + " players are ready !");
        System.out.println("LET THE GAME BEGIN !!!");

        new Board();

    }

    public int getPlayersNum() {
        return playersNum;
    }

}
