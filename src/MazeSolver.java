import java.util.ArrayList;
import java.util.Arrays;

public class MazeSolver {
    private String[][] maze;
    private int playerX;
    private int playerY;
    private ArrayList<String> coordinates;

    public MazeSolver(String[][] m){
        coordinates = new ArrayList<String>();
        maze = m;
        playerX = 0;
        playerY = 0;
    }

    private void checkUp(){
        if (maze[playerY - 1][playerX].equals(".")){
            playerY--;
        }
        maze[playerY + 1][playerX] = "#";
        coordinates.add("(" + playerY + ", " + playerX + ")");
    }

    private void checkDown(){
        if (maze[playerY + 1][playerX].equals(".")) {
            playerY++;
            maze[playerY - 1][playerX] = "#";
            coordinates.add("(" + playerY + ", " + playerX + ")");
        }
    }

    private void checkRight(){
        if (maze[playerY][playerX + 1].equals(".")) {
            playerX++;
            maze[playerY][playerX - 1] = "#";
            coordinates.add("(" + playerY + ", " + playerX + ")");
        }
    }

    private void checkLeft(){
        if (maze[playerY][playerX - 1].equals(".")){
            playerX--;
            maze[playerY][playerX + 1] = "#";
            coordinates.add("(" + playerY + ", " + playerX + ")");
        }
    }

    public void runMaze(){
        if (playerX != 0){
            checkLeft();
        } else if (playerX != maze[0].length){
            checkRight();
        } else if (playerY != 0) {
            checkUp();
        } else {
            checkDown();
        }
    }

    public String getLocation(){
        return (playerY + ", " + playerX);
    }

    public ArrayList<String> path(){
        return coordinates;
    }
}
