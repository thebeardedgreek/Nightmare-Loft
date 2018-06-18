import static java.lang.System.out;

public class Game {

    static int playerHeight = 5, playerWidth = 5;
    static boolean isPlaying = true;
    static boolean[] currentFloor = {true, true, true};

    public static void main(String[] args) {
        while (isPlaying) {
            while (currentFloor[0]) {
                String map = Map.createMap(playerHeight, playerWidth, 1);
                out.print(map);
                Map.nextMove();
                floorOne.monsterCollision();
            }
        }
    }
}
