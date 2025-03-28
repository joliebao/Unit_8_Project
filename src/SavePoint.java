public class SavePoint {
    private int x;
    private int y;

    public SavePoint (int pY, int pX){
        x = pX;
        y = pY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return ("(" + y + ", " + x + ")");
    }
}
