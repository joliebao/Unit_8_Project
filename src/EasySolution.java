import java.util.ArrayList;
import java.util.Arrays;

public class EasySolution{
    private String[][] maze;
    private ArrayList<String> coordinates = new ArrayList<String>();

    private int playerX = 0;
    private int playerY = 0;

    public EasySolution(String[][] m){
        maze = m;
    }

    public void printMaze(){
        for (int i = 0; i < maze.length; i++){
            System.out.println(Arrays.toString(maze[i]));
        }
    }

    public void solveMaze() {
        int lastX = playerX;
        int lastY = playerY;
        move();
        if (lastY == playerY && lastX == playerX) {
            maze[playerY][playerX] = "#";

        }
    }

    public void move(){
        if (playerY + 1 < maze.length && maze[playerY + 1][playerX].equals(".")) {
            checkDown();
        } else if (playerY - 1 >= 0 && maze[playerY - 1][playerX].equals(".")) {
            checkUp();
        } else if (playerX - 1 >= 0 && maze[playerY][playerX - 1].equals(".")) {
            checkLeft();
        } else if (playerX + 1 < maze[0].length && maze[playerY][playerX + 1].equals(".")) {
            checkRight();
        }
    }


    private void checkUp(){
        maze[playerY][playerX] = "o";
        coordinates.add("(" + playerY + ", " + playerX + ")");
        playerY--;
        if (playerY < 0) {
            playerY = 0;
        }
    }

    private void checkDown(){
        maze[playerY][playerX] = "o";
        coordinates.add("(" + playerY + ", " + playerX + ")");
        playerY++;
        if (playerY > maze.length - 1) {
            playerY = maze.length - 1;
        }
    }

    private void checkRight(){
        maze[playerY][playerX] = "o";
        coordinates.add("(" + playerY + ", " + playerX + ")");
        playerX++;
        if (playerX > maze[0].length - 1) {
            playerX = maze[0].length - 1;
        }
    }

    private void checkLeft(){
        maze[playerY][playerX] = "o";
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
