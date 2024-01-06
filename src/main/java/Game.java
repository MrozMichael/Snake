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
        initializeBoard();
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

    public void initializeBoard(){
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
    public void moveSnake(){
        int[] nextMove = new int[2]; //must be equal to head + dx/dy
        int[] head = snake.getHead();
        String defaultDirection = snake.getDirection();
        String userInput = "placeholder";
        String nextDirection = "";
        while (!userInput.isEmpty()){
            userInput = scanner.nextLine();
            if ("wasd".contains(userInput.toLowerCase().trim())){
                nextDirection = userInput;
            }
        }
        if (nextDirection.isEmpty()){
            nextDirection = defaultDirection.toLowerCase();
        }
        switch(nextDirection.toLowerCase().trim()){
            case "up":
                nextMove[0] = head[0];
                nextMove[1] = head[1] + 1;
                break;
            case "down":
                nextMove[0] = head[0];
                nextMove[1] = head[1] -1;
                break;
            case "left":
                nextMove[0] = head[0] -1;
                nextMove[1] = head[1];
                break;
            case "right":
                nextMove[0] = head[0] +1;
                nextMove[1] = head[1];
                break;
            default:
                break;
        }
        //todo check to make sure nextMove[x][y] doesnt go out of bounds
        snake.move(nextMove);
    }

    public void printSnake(){
        System.out.println(snake);
    }

}
