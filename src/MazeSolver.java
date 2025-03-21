import java.util.ArrayList;
import java.util.Arrays;

public class MazeSolver {
    private String[][] maze;
    private int playerX;
    private int playerY;
    private ArrayList<String> coordinates;
    private boolean deadEnd;

    public MazeSolver(String[][] m){
        coordinates = new ArrayList<String>();
        maze = m;
        playerX = 0;
        playerY = 0;
        deadEnd = false;
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

    public boolean runMaze(){
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
            deadEnd = true;
        }
        return deadEnd;
    }

    public void setPlayerX(int playerX) {
        this.playerX = playerX;
    }

    public void setPlayerY(int playerY) {
        this.playerY = playerY;
    }

    public String getLocation(){ // testing method --- where is maze solver at
        return ("(" + playerY + ", " + playerX + ")");
    }

    public ArrayList<String> path(){
        coordinates.add(getLocation());
        return coordinates;
    }
}
