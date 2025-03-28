import java.util.ArrayList;
import java.util.Arrays;

public class MazeSolver {
    private String[][] maze;
    private ArrayList<String> coordinates = new ArrayList<String>();
    private ArrayList<SavePoint> saves = new ArrayList<SavePoint>();

    private int playerX = 0;
    private int playerY = 0;
    private int paths = 0;

    private int savedIdx;

    // Constructor
    public MazeSolver(String[][] m){
        maze = m;
    }

    public void printMaze(){
        for (int i = 0; i < maze.length; i++){
            System.out.println(Arrays.toString(maze[i]));
        }
    }

    //count num of possible paths
    public int getPaths(){
        // need to fix these conditions
        if (playerY - 1 >= 0 && maze[playerY - 1][playerX].equals(".")) {
            paths++;
        } if (playerY + 1 < maze.length && maze[playerY + 1][playerX].equals(".")) {
            paths++;
        } if (playerX - 1 >= 0 && maze[playerY][playerX - 1].equals(".")) {
            paths++;
        } if (playerX + 1 < maze[0].length && maze[playerY][playerX + 1].equals(".")) {
            paths++;
        }
        return paths;
    }

    // go through entire maze one dead end at a time
    // if dead end, go back to check point, and then test everything else
    public void runMaze(){
        paths = 0;  // reset paths
        paths = getPaths(); // find number of paths that can be taken
        if (paths == 1) {
            move();
        } else if (paths > 1){
            saves.add(new SavePoint(playerX, playerY));
            savedIdx = coordinates.size();
            maze[playerY][playerX] = "/";
            move();
        } else if (paths == 0){
            maze[playerY][playerX] = "/";   // close off that location
            for (int i = 0; i < coordinates.size() - savedIdx; i ++){
                coordinates.removeLast();
            }
            // bring player back to saved point
            SavePoint s = saves.getLast();
            maze[s.getY()][s.getX()] = ".";
            playerX = s.getX();
            playerY = s.getY();

            saves.removeLast();
        }
        System.out.println(getLocation());
    }

    public void move(){
        if (playerY - 1 >= 0 && maze[playerY - 1][playerX].equals(".")) {
            checkUp();
        } else if (playerY + 1 < maze.length && maze[playerY + 1][playerX].equals(".")) {
            checkDown();
        } else if (playerX - 1 >= 0 && maze[playerY][playerX - 1].equals(".")) {
            checkLeft();
        } else if (playerX + 1 < maze[0].length && maze[playerY][playerX + 1].equals(".")) {
            checkRight();
        }
    }

    private void checkUp(){
        maze[playerY][playerX] = "/";
        coordinates.add("(" + playerY + ", " + playerX + ")");
        playerY--;
        if (playerY < 0) {
            playerY = 0;
        }
    }

    private void checkDown(){
        maze[playerY][playerX] = "/";
        coordinates.add("(" + playerY + ", " + playerX + ")");
        playerY++;
        if (playerY > maze.length - 1) {
            playerY = maze.length - 1;
        }
    }

    private void checkRight(){
        maze[playerY][playerX] = "/";
        coordinates.add("(" + playerY + ", " + playerX + ")");
        playerX++;
        if (playerX > maze[0].length - 1) {
            playerX = maze[0].length - 1;
        }
    }

    private void checkLeft(){
        maze[playerY][playerX] = "/";
        coordinates.add("(" + playerY + ", " + playerX + ")");
        playerX--;
        if (playerX < 0) {
            playerX = 0;
        }
    }

    public String getLocation(){ // testing method --- where is maze solver at
        return ("(" + playerY + ", " + playerX + ")");
    }

    public ArrayList<String> path(){
        coordinates.add(getLocation());
        return coordinates;
    }
}