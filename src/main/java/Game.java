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
        int[] nextMove = new int[2]; //must be equal to head + dx/dy by end of fn
        int[] head = snake.getHead();
        String nextDirection = getMoveInput();
        if (nextDirection.equals("up") && upPossible()){
            nextMove[0] = head[0];
            nextMove[1] = head[1] + 1;
        } else if (nextDirection.equals("down") && downPossible()){
            nextMove[0] = head[0];
            nextMove[1] = head[1] - 1;
        } else if (nextDirection.equals("left") && leftPossible()) {
            nextMove[0] = head[0] - 1;
            nextMove[1] = head[1];
        } else if (nextDirection.equals("right") && rightPossible() ) {
            nextMove[0] = head[0] + 1;
            nextMove[1] = head[1];
        } else {
            nextMove[0] = head[0];
            nextMove[1] = head[1];
        }
        //todo fix head resetting to (0, 0) on out of bounds
        snake.move(nextMove);
        snake.setDirection(nextDirection);
        int[] newHead = snake.getHead();
        System.out.println("Previous head was at: ("+head[0] +", "+head[1]+")");
        System.out.println("After moving: " +nextDirection);
        System.out.println("New head is at: ("+newHead[0] +", "+newHead[1]+")");
        updateBoard(head, newHead);
        render();
    }

    public void updateBoard(int[] oldHead, int[] newHead){
        //board is [y][x];
        if (snake.getSize() == 1) {
            board[oldHead[1]][oldHead[0]] = " ";
        } else {
            board[oldHead[1]][oldHead[0]] = "0";
        }
        board[newHead[1]][newHead[0]] = "X";
    }
    public String getMoveInput(){
        String nextMove;
        String defaultDirection = snake.getDirection();
        String userInput = scanner.nextLine().toLowerCase().trim();
        switch(userInput){
            case "w":
                nextMove = "up";
                break;
            case "a":
                nextMove = "left";
                break;
            case "s":
                nextMove = "down";
                break;
            case "d":
                nextMove = "right";
                break;
            default:
                nextMove = defaultDirection;
                break;
        }
        return nextMove;
    }

    public boolean rightPossible(){
     return snake.getHead()[0] != width -1;
    }

    public boolean leftPossible(){
        return snake.getHead()[0] != 0;
    }

    public boolean upPossible(){
        return snake.getHead()[1] != height -1; // y = 0 is bottom of board; y = height-1 is top;
    }

    public boolean downPossible(){
        return snake.getHead()[1] != 0;
    }


    public void printSnake(){
        System.out.println(snake);
    }

}
