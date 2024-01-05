import java.util.*;

public class Game {
    /*
    ***********************************************************************************
       IMPORTANT: when referencing board array, do board[y][x]. in all other places do (x, y)
    ***********************************************************************************
     */
    private int height;
    private int width;
    private Snake snake;
    private String[][] board; //input is: (x, y), board references are board[y][x]

    private Scanner scanner;
    public Game(int height, int width, int[] startingPos, String startingDir){
        this.height = height;
        this.width = width;
        this.scanner = new Scanner(System.in);
        this.snake = new Snake(startingPos, startingDir);
        this.board = new String[height][width];
        initialzeBoard();
    }
    public void render(){
        String border = "+";
        for (int i = 0; i < width; i++){
            border += "-";
        }
        border += "+";
        System.out.println(border);
        for (int i = height -1; i >= 0; i--){
            System.out.print("|");
            for (int j = 0; j < width; j++){
                System.out.print(board[i][j]);
            }
            System.out.println("|\n");
        }
        System.out.println(border);
    }

    public void initialzeBoard(){
        for (String[] row: board){
            Arrays.fill(row, " ");
        }
        int x = snake.getHead()[0];
        int y = snake.getHead()[1];
        board[y][x] = "X";
    }

    public void growSnake(int x, int y){
        //todo: replace hardcoding with position based on rest of body
        snake.grow(x, y);
        board[y][x] = "0";
    }

    public void printSnake(){
        System.out.println(snake);
    }

}
