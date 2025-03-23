import java.util.ArrayList;
import java.util.Arrays;

public class MazeSolver {
    private String[][] maze;
    private int playerX;
    private int playerY;
    private boolean forked;
    private ArrayList<String> coordinates;
    private boolean deadEnd;

    public MazeSolver(String[][] m){
        coordinates = new ArrayList<String>();
        maze = m;
        playerX = 0;
        playerY = 0;
        deadEnd = false;
        forked = false;
    }

    private void checkUp(){
        maze[playerY][playerX] = "#";
        coordinates.add("(" + playerY + ", " + playerX + ")");
    }

    private void checkDown(){
        maze[playerY][playerX] = "#";
        coordinates.add("(" + playerY + ", " + playerX + ")");
    }

    private void checkRight(){
        maze[playerY][playerX] = "#";
        coordinates.add("(" + playerY + ", " + playerX + ")");
    }

    private void checkLeft(){
        maze[playerY][playerX] = "#";
        coordinates.add("(" + playerY + ", " + playerX + ")");
    }

    //go through entire maze one dead end at a time
    //if dead end, go back to check point, and then test everything else

    public void runMaze(){
        takeFork();
        if (playerY > 0 && maze[playerY - 1][playerX].equals(".")) {
            checkUp();
            playerY--;
            if (playerY < 0) {
                playerY = 0;
            }
        } else if (playerY < maze.length && maze[playerY + 1][playerX].equals(".")) {
            checkDown();
            playerY++;
            if (playerY > maze.length - 1) {
                playerY = maze.length - 1;
            }
        } else if (playerX > 0 && maze[playerY][playerX - 1].equals(".")){
            checkLeft();
            playerX--;
            if (playerX < 0) {
                playerX = 0;
            }
        } else if (playerX < maze[0].length && maze[playerY][playerX + 1].equals(".")) {
            checkRight();
            playerX++;
            if (playerX > maze[0].length - 1) {
                playerX = maze[0].length - 1;
            }
        } else {
            forked = true;
        }
    }

    public void takeFork(){
        if (forked) {
            int savePoint = coordinates.size() - 1;
            int savedX = playerY;
            int savedY = playerX;
            for (int i = 0; i < coordinates.size() - savePoint; i++) {
                coordinates.remove(i);
            }
            // set player position back to the saved last point
            playerX = savedY;
            playerY = savedX;
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
