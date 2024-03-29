import java.util.*;

public class Snake {
    private ArrayList<int[]> body; //each sublist a body part containing (x, y);
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

    public String getDirection(){
        return direction;
    }

    public int[] getHead(){
        return body.get(0);
    }

    public void move(int[] position){
        //System.out.println("Inside snake.move(), position being added is: (" + position[0]+", " + position[1] +")" );
        body.add(0, position); //new head = (x +dx, y+dy);
        body.remove(body.size()-1);
        }

    public int getSize(){
        return body.size();
    }
    public String toString(){
        String output = "Snake has body parts at:\n";
        for(int[] node : body){
            output += "("+node[0]+", " + node[1]+")";
        }
        return output;
    }
}
