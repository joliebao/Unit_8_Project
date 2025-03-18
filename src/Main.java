import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][] maze = getMaze("src/grid");

        MazeSolver m = new MazeSolver(maze);
//        Fork f = new Fork(maze, )

        int col = maze[0].length - 1;
        int row = maze.length - 1;

        while (!m.getLocation().equals("(" + row + ", " + col + ")")){
            System.out.println(row + ", " + col);
            System.out.println(m.getLocation());
            for (int i = 0; i < maze.length; i++){
                System.out.println(Arrays.toString(maze[i]));
            }
            m.runMaze();
        }

        System.out.println(m.path());
    }

    public static String[][] getMaze(String fileName) {
        File f = new File(fileName);
        Scanner s = null;
        try {
            s = new Scanner(f);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }

        ArrayList<String> fileData = new ArrayList<String>();
        while (s.hasNextLine())
            fileData.add(s.nextLine());

        int rows = fileData.size();
        int cols = fileData.get(0).length();

        String[][] maze = new String[rows][cols];

        for (int i = 0; i < fileData.size(); i++) {
            String d = fileData.get(i);
            for (int j = 0; j < d.length(); j++) {
                maze[i][j] = d.charAt(j) + "";
            }
        }
        return maze;
    }
}