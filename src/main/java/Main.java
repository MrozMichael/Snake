/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        int[] startingPos = {0, 35};
        Game game = new Game(10, 20, startingPos, "up");
        game.render();
    }
}
