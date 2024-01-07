
public class Main
{
    public static void main( String[] args )
    {
        int[] startingPos = {0, 0}; //{x, y}
        Game game = new Game(4, 8, startingPos, "down");
        game.render();
        game.moveSnake();
    }
}
