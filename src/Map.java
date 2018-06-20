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

        for (int i = 1; i < MAP_HEIGHT; i++) {

            //left wall
            map += "| ";

            //print astrix spaces for map, minus one space on both sides for walls
            for (int j = 1; j < MAP_WIDTH - 1; j++) {
                map = floorDynamics(playerHeight, playerWidth, floor, map, i, j);

            }
            //right wall
            map += "|";
            map += "\n";
        }



        //bottom wall
        map += " ---------------------------\n";
        return map;
    }

    private static String floorDynamics(int playerHeight, int playerWidth, int floor, String map, int i, int j) {
        //this prints where the player is
        if (i == playerHeight && j == playerWidth) {
            map += "O ";
        }

        //this prints the monster as an X, if on floor one
        else if (i == floorOne.monsterHeight && j == floorOne.monsterWidth && floor == 1){
            map += "X ";
        }

        try{
            if (floorOne.horizontalWalls[j] == j){
                map += "- ";
                return map;
            }
        } catch (Exception e){
            map += "* ";
            return map;
        }

        try{
            if (floorOne.verticalWalls[i] == i){
                map += "| ";
                return map;
            }
        } catch (Exception e){
            map += "* ";
            return map;
        }

        //this is the astrix spaces for the map as well

        map += "* ";
        return map;
    }



    public static void nextMove() {
        String instruction = "Which way would you like to move?\n{up, left, right, down}\n";
        out.println(instruction);
        Scanner player = new Scanner(System.in);
        String nextMove = player.next();
        movePlayer(nextMove);
    }

    public static void movePlayer(String direction) {
        if (direction.equalsIgnoreCase("up")) {
            if (Game.playerHeight != 1) {
                Game.playerHeight--;
                out.println(Game.playerWidth + " " + Game.playerHeight);
                floorOne.monsterMove();
            } else {
                out.println("Invalid entry.");
            }
        } else if (direction.equalsIgnoreCase("down")) {
            if (Game.playerHeight != 9) {
                Game.playerHeight++;
                out.println(Game.playerWidth + " " + Game.playerHeight);
                floorOne.monsterMove();
            } else {
                out.println("Invalid entry.");
            }
        } else if (direction.equalsIgnoreCase("right")) {
            if (Game.playerWidth != 13) {
                Game.playerWidth++;
                out.println(Game.playerWidth + " " + Game.playerHeight);
                floorOne.monsterMove();
            } else {
                out.println("Invalid entry.");
            }
        } else if (direction.equalsIgnoreCase("left")) {
            if (Game.playerWidth != 1) {
                Game.playerWidth--;
                out.println(Game.playerWidth + " " + Game.playerHeight);
                floorOne.monsterMove();
            } else {
                out.println("Invalid entry.");
            }
        }

    }
}

