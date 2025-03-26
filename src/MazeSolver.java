import java.util.ArrayList;

public class MazeSolver {
    private String[][] maze;
    private int playerX = 0;
    private int playerY = 0;
    private int paths = 0;
    private int savedX;
    private int savedY;
    private int savedIdx;
    private ArrayList<String> coordinates;

    // Constructor
    public MazeSolver(String[][] m){
        coordinates = new ArrayList<String>();
        maze = m;
    }

    //count num of possible paths
    public int getPaths(){
        // need to fix these conditions
        if (playerY > 0 && maze[playerY - 1][playerX].equals(".")) {
            paths++;
        } if (playerY < maze[0].length - 1 && maze[playerY + 1][playerX].equals(".")) {
            paths++;
        } if (playerX > 0 && maze[playerY][playerX - 1].equals(".")){
            paths++;
        } if (playerX < maze.length - 1 && maze[playerY][playerX + 1].equals(".")) {
            paths++;
        }
        return paths;
    }

    //go through entire maze one dead end at a time
    //if dead end, go back to check point, and then test everything else
    public void runMaze(){
        paths = 0;
        paths = getPaths();
        getLocation();
        if (paths == 1) {  // only one path
            move();
        } else if (paths > 1){ // more than one path
            savedX = playerX - 1;
            savedY = playerY - 1;
            savedIdx = coordinates.size();
            maze[savedX][savedY] = "#";
            move();
        } else if (paths == 0){    // dead end
            // Setting x and y location bounds
            if (savedX < 0){
                savedX = 0;
            } else if (savedX > maze[0].length - 1){
                savedX = maze[0].length - 1;
            }
            savedY = playerY - 1;
            if (savedY < 0){
                savedY = 0;
            } else if (savedY > maze.length - 1){
                savedY = maze.length - 1;
            }

            maze[playerY][playerX] = "#";   // close off that location
            for (int i = 0; i < coordinates.size() - savedIdx; i ++){
                coordinates.removeLast();
            }
            // bring player back to saved point
            maze[savedY][savedX] = ".";
            playerX = savedX;
            playerY = savedY;
        }
    }

    private void checkUp(){
        maze[playerY][playerX] = "#";
        coordinates.add("(" + playerY + ", " + playerX + ")");
        playerY--;
        if (playerY < 0) {
            playerY = 0;
        }
    }

    private void checkDown(){
        maze[playerY][playerX] = "#";
        coordinates.add("(" + playerY + ", " + playerX + ")");
        playerY++;
        if (playerY > maze.length - 1) {
            playerY = maze.length - 1;
        }
    }

    private void checkRight(){
        maze[playerY][playerX] = "#";
        coordinates.add("(" + playerY + ", " + playerX + ")");
        playerX++;
        if (playerX > maze[0].length - 1) {
            playerX = maze[0].length - 1;
        }
    }

    private void checkLeft(){
        maze[playerY][playerX] = "#";
        coordinates.add("(" + playerY + ", " + playerX + ")");
        playerX--;
        if (playerX < 0) {
            playerX = 0;
        }
    }

    public void move(){
        if (playerY > 0 && maze[playerY - 1][playerX].equals(".")) {
            checkUp();
        } else if (playerY < maze.length && maze[playerY + 1][playerX].equals(".")) {
            checkDown();
        } else if (playerX > 0 && maze[playerY][playerX - 1].equals(".")) {
            checkLeft();
        } else if (playerX < maze[0].length && maze[playerY][playerX + 1].equals(".")) {
            checkRight();
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