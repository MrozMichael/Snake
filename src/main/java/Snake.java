import java.util.*;

public class Snake {
    private ArrayList<int[]> body; //each sublist a body part containing x/y coords.
    private final int[] node = {0, 0};
    private String direction;
    public Snake(int[] startingPos, String startingDir) {

        this.body = new ArrayList<>();
        grow();
        this.body.get(0)[0] = startingPos[0];
        this.body.get(0)[1] = startingPos[1];
        this.direction = startingDir.toLowerCase();
    }

    public void grow(){
        body.add(node);
    }

    public void setDirection(String direction){
        this.direction = direction.toLowerCase();
    }

    public int[] getHead(){
        return body.get(0);
    }

    public void move(int bodyPartIndex){
        int currentX = body.get(bodyPartIndex)[0];
        int currentY = body.get(bodyPartIndex)[1];
        switch(direction){
            //[x][y] TODO: add restrictions in game class to avoid moving off board
            case "up":
                body.get(bodyPartIndex)[1] = currentY + 1;
                return;
            case "down":
                body.get(bodyPartIndex)[1] = currentY -1;
                return;
            case "right":
                body.get(bodyPartIndex)[0] = currentX + 1;
                return;
            case "left":
                body.get(bodyPartIndex)[0] = currentX - 1;
                return;
            default: return;
        }
    }

    public String toString(){
        String output = "";
        for(int[] node : body){
            output += "("+node[0]+", " + node[1]+")";
        }
        return output;
    }
}
