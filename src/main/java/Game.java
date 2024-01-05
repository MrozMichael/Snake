public class Game {
    private int height;
    private int width;
    private Snake snake;
    private String[][] board;
    public Game(int height, int width, int[] startingPos, String startingDir){
        this.height = height;
        this.width = width;
        this.snake = new Snake(startingPos, startingDir);
        this.board = new String[height][width];

    }
    public void render(){
        String border = "+";
        for (int i = 0; i < width; i++){
            border += "-";
        }
        border += "+";
        System.out.println(border);
        for (int i = 0; i < height; i++){
            System.out.print("|");
            for (int j = 0; j < width; j++){
                System.out.print(" ");
            }
            System.out.println("|\n");
        }
        System.out.println(border);
    }

}
