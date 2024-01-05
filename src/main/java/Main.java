
public class Main
{
    public static void main( String[] args )
    {
        int[] startingPos = {1, 3};
        Game game = new Game(4, 8, startingPos, "up");
        game.growSnake(1, 2);
        game.growSnake(1, 1);
        game.growSnake(2, 1);
        game.growSnake(3, 1);
        game.growSnake(3, 0);
    }
}
