public class Game {
    private int height;
    private int width;

    public Game(int height, int width){
        this.height = height;
        this.width = width;
    }

    public void render(){
        System.out.println("Height: " +height+"\nWidth: " +width);
    }

    public String[][] createBoard(){
        String[][] board = new String[height][width];
        System.out.println(board[0][1]);
        return board;
    }
}
