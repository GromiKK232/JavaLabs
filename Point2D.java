public class Point2D {
    private int x;
    private final int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void shiftX(int amount) {
        if (this.x >= 0) {
            this.x += amount;
        } else {
            this.x -= amount;
        }
    }

    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}
