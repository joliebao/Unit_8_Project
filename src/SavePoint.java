public class SavePoint {
    private int x;
    private int y;
    private int numPaths;

    public SavePoint (int pY, int pX, int nPaths){
        x = pX;
        y = pY;
        numPaths = nPaths;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getNumPaths(){
        return numPaths;
    }

    @Override
    public String toString() {
        return ("(" + y + ", " + x + ")");
    }
}
