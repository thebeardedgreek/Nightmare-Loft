import static java.lang.System.out;

public class floorOne {
    static int monsterHeight = 2;
    static int monsterWidth = 13;

    public static void monsterMove(){
        if (monsterHeight > Game.playerHeight){
            monsterHeight -= 1;
        } else if(monsterHeight < Game.playerHeight){
            monsterHeight += 1;
        }
        if (monsterWidth > Game.playerWidth){
            monsterWidth -= 1;
        } else if(monsterWidth < Game.playerHeight){
            monsterWidth += 1;
        }
        out.println(monsterHeight + " " + monsterWidth);
    }

    public static void monsterCollision(){
        if (monsterWidth == Game.playerWidth && monsterHeight == Game.playerHeight){
            out.println("You lose! The monster gotcha! D:");
            Game.isPlaying = false;
        }
    }
}
