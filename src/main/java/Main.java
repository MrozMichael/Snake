/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {

        Game game = new Game(5, 5);
        game.render();
        game.createBoard();
        int[] startingPos = {0, 35};
        Snake snake = new Snake(startingPos, "up");
        System.out.println(snake);
    }
}
