import java.util.ArrayList;

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

    public void checkUp(){
        if (maze[playerY][playerX - 1].equals(".")){
            playerX--;
        }
        coordinates.add("(" + playerY + ", " + playerX + ")");
    }

    public void checkDown(){
        if (maze[playerY][playerX + 1].equals(".")){
            playerX++;
        }
        coordinates.add("(" + playerY + ", " + playerX + ")");
    }

    public void checkRight(){
        if (maze[playerY + 1][playerX].equals(".")){
            playerY++;
        }
        coordinates.add("(" + playerY + ", " + playerX + ")");
    }

    public void checkLeft(){
        if (maze[playerY - 1][playerX].equals(".")){
            playerY--;
        }
        coordinates.add("(" + playerY + ", " + playerX + ")");
    }

    public String getLocation(){
        return (playerY + ", " + playerX);
    }

    public ArrayList<String> path(){
        return coordinates;
    }
}
