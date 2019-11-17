package C_16_Moderate;

public class Intersection {
    public static void main(String[] args) {
        Point p1 = new Point(5,10);
        Point p2 = new Point(8,6);
        Point p3 = new Point(5,5);
        Point p4 = new Point(15,10);

        Line line1 = new Line(p1,p2);
        Line line2 = new Line(p3,p4);

        double x = (line2.yIntercept - line1.yIntercept) / ( line1.slope - line2.slope);
        double y = (line1.slope * x) + line1.yIntercept;

        Point intersection = new Point(x,y);
        System.out.println(intersection.toString());
    }
    



}

class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class Line {
    double yIntercept;
    double slope;

    public Line(Point start, Point end){
        double deltaX = end.x - start.x;
        double deltaY = end.y - start.y;
        slope = deltaY / deltaX;
        yIntercept = end.y - (start.x * slope); 
    }
}
