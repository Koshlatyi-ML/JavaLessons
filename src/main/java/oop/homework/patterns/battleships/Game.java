package oop.homework.patterns.battleships;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Game {
    private Player player1;
    private Player player2;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public static int[] getShipsSizes() {
        return new int[] {1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
    }

    public static Game createGame(UserPlayer player) {
        Field field1 = Field.createField();
        Field field2 = Field.createField();

        player.setOwnField(field1);
        player.setEnemyField(field2);
        player.placeShips();

        Player enemy = new AIPLayer();
        enemy.setOwnField(field2);
        enemy.setEnemyField(field1);
        enemy.placeShips();

        return new Game(player, enemy);
    }

    public void play() {
        List<Player> players = Arrays.asList(player1, player2);
        int i = 0;
        while (player1.isСombating() && player2.isСombating()) {
            players.get(i % 2).takeTurn();
            i++;
        }
        String winner = player1.isСombating() ? "Player" : "Computer";
        System.out.println(winner + " has won");
    }

    public static void main(String[] args) {
        try (BufferedReader bufferedReader
                     = new BufferedReader(new InputStreamReader(System.in))) {
        UserPlayer nikolay = new UserPlayer(bufferedReader);
        Game game = Game.createGame(nikolay);
        game.play();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
