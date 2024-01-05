import java.util.*;

public class Snake {
    private ArrayList<int[]> body; //each sublist a body part containing (y, x);
    private final int[] node = {0, 0};
    private String direction;
    public Snake(int[] startingPos, String startingDir) {

        this.body = new ArrayList<>();
        grow(0, 0);
        this.body.get(0)[0] = startingPos[0];
        this.body.get(0)[1] = startingPos[1];
        this.direction = startingDir.toLowerCase();
    }

    public void grow(int x, int y){
        int[] coords = {x, y};
        body.add(coords); //todo:new node shouldn't be hardcoded
    }

    public void setDirection(String direction){
        this.direction = direction.toLowerCase();
    }

    public int[] getHead(){
        return body.get(0);
    }

    public void move(int bodyPartIndex){
        int currentX = body.get(bodyPartIndex)[1];
        int currentY = body.get(bodyPartIndex)[0];
        switch(direction){
            //[x][y] TODO: add restrictions in game class to avoid moving off board
            case "up":
                body.get(bodyPartIndex)[0] = currentY + 1;
                return;
            case "down":
                body.get(bodyPartIndex)[0] = currentY -1;
                return;
            case "right":
                body.get(bodyPartIndex)[1] = currentX + 1;
                return;
            case "left":
                body.get(bodyPartIndex)[1] = currentX - 1;
                return;
            default: return;
        }
    }

    public String toString(){
        String output = "Snake has body parts at:\n";
        for(int[] node : body){
            output += "("+node[0]+", " + node[1]+")";
        }
        return output;
    }
}
