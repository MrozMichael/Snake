
public class Main
{
    public static void main( String[] args )
    {
        int[] startingPos = {1, 3}; //{x, y}
        Game game = new Game(4, 8, startingPos, "down");
        game.moveSnake();
        game.render();
    }
}
