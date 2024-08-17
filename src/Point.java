public class Point {
    char value;
    int x;
    int y;

    public Point(int x, int y, char value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + value + ")";
    }

}
