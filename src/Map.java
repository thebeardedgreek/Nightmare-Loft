import java.util.Scanner;
import static java.lang.System.out;

public class Map {

    protected static int MAP_HEIGHT = 10;
    protected static int MAP_WIDTH = 15;

    public static String createMap(int playerHeight, int playerWidth, int floor) {
        //initialize top wall level of map
        String map = " ___________________________\n";

        //create map
        //print a line for each of the maps height
        if(floor == 1){
            for (int i = 1; i < MAP_HEIGHT; i++) {

                //left wall
                map += "| ";

                //print astrix spaces for map, minus one space on both sides for walls
                for (int j = 1; j < MAP_WIDTH - 1; j++) {

                    //this prints where the player is
                    if (i == playerHeight && j == playerWidth) {
                        map += "O ";
                    }

                    //this prints the monster as an X
                    else if (i == floorOne.monsterHeight && j == floorOne.monsterWidth){
                        map += "X ";
                    }

                    //this is the astrix spaces for the map as well
                    else {
                        map += "* ";
                    }
                }
                //right wall
                map += "|";
                map += "\n";
            }
        }

        if(floor == 2){
            for (int i = 1; i < MAP_HEIGHT; i++) {

                //left wall
                map += "| ";

                //print astrix spaces for map, minus one space on both sides for walls
                for (int j = 1; j < MAP_WIDTH - 1; j++) {

                    //this prints where the player is
                    if (i == playerHeight && j == playerWidth) {
                        map += "O ";
                    }

                    //this is the astrix spaces for the map as well
                    else {
                        map += "* ";
                    }
                }
                //right wall
                map += "|";
                map += "\n";
            }
        }

        //bottom wall
        map += " ---------------------------\n";
        return map;
    }

    public static void nextMove() {
        String instruction = "Which way would you like to move?\n{up, left, right, down}\n";
        out.println(instruction);
        Scanner player = new Scanner(System.in);
        String nextMove = player.next();
        movePlayer(nextMove);
        floorOne.monsterMove();
    }

    public static void movePlayer(String direction) {
        if (direction.equalsIgnoreCase("up")) {
            if (Game.playerHeight != 1) {
                Game.playerHeight--;
                out.println(Game.playerWidth + " " + Game.playerHeight);
            } else {
                out.println("Invalid entry.");
            }
        } else if (direction.equalsIgnoreCase("down")) {
            if (Game.playerHeight != 9) {
                Game.playerHeight++;
                out.println(Game.playerWidth + " " + Game.playerHeight);
            } else {
                out.println("Invalid entry.");
            }
        } else if (direction.equalsIgnoreCase("right")) {
            if (Game.playerWidth != 13) {
                Game.playerWidth++;
                out.println(Game.playerWidth + " " + Game.playerHeight);
            } else {
                out.println("Invalid entry.");
            }
        } else if (direction.equalsIgnoreCase("left")) {
            if (Game.playerWidth != 1) {
                Game.playerWidth--;
                out.println(Game.playerWidth + " " + Game.playerHeight);
            } else {
                out.println("Invalid entry.");
            }
        }

    }
}

