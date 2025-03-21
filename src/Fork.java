import java.util.ArrayList;
import java.util.Arrays;

public class Fork {
    // set a checkpoint at a specific point and get it back there
    private String[][] maze;
    private ArrayList<String> points;

    public Fork (String[][] m, ArrayList<String> coords){
        maze = m;
        points = coords;
    }

    public void takeFork(){
        int lastPoint = points.size();
        MazeSolver m = new MazeSolver(maze);
        points = m.path();
        if (m.runMaze()){
            // clear arraylist of those points
            for (int i = 0; i < points.size() - lastPoint; i++) {
                points.remove(i);
            }
            // set player position back to the saved last point

        }
    }
}
