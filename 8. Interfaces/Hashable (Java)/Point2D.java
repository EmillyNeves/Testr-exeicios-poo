public class Point2D {
    private double x;
    private double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Point2D other = (Point2D) obj;
        return Double.compare(this.x, other.x) == 0 &&
                Double.compare(this.y, other.y) == 0;
    }

    @Override
    public int hashCode() {
        int hashX = Double.hashCode(x);
        int hashY = Double.hashCode(y);
        return hashX ^ hashY;
    }

}
