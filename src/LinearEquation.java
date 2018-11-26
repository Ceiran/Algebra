public class LinearEquation {
    /*Standard Form:
      ax + by + c = 0

      Slope-intercept Form:
      y = -(a/b)x - (c/b)

      Direct Variation:
      y-intercept = 0
      x increases at same rate as y

      y - y1 = m(x - x1)
     */
    private double a;
    private double b;
    private double c;

    public static boolean areValidParams(double a, double b){
        return !(a == 0 && b == 0);
    }

    public LinearEquation(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public LinearEquation(double slope, Coords point){
        this(-slope, 1, slope * point.getX() - point.getY());
        /*
        a = slope;
        b = -1;
        c = (-(point.getY()) + (slope * point.getX()));
        */
    }

    public LinearEquation(LinearEquation other){
        this.a = other.getA();
        this.b = other.getB();
        this.c = other.getC();
    }

    public LinearEquation(Coords pt1, Coords pt2){
        if(pt1.getX() == pt2.getX()){
            a = 1;
            b = 0;
            c = -pt1.getX();
        } else{
            double slope = pt1.getSlopeOfLineSegment(pt2);
            a = slope;
            b = -1;
            c = (-(pt1.getY()) + (slope * pt1.getX()));
        }
    }

    public LinearEquation(LinearEquation other, Coords point){
        a = other.parallelLine(point).getA();
        b = other.parallelLine(point).getB();
        c = other.parallelLine(point).getC();
    }

    public double getA(){
        return this.a;
    }

    public double getB(){
        return this.b;
    }

    public double getC(){
        return this.c;
    }

    public boolean slopeDefined(){
        return (b != 0);
    }

    public boolean hasYIntercept(){
        return slopeDefined();
    }

    public boolean hasXIntercept(){
        return (a != 0);
    }

    public double slope(){
        return -(a/b);
    }

    public double yIntercept(){
        return c;
    }

    public double xIntercept(){
        return -(c/a);
    }

    public double slopeOfPerpendicularLine(){
        return (b/a);
    }

    public boolean isIncreasing(){
        return ((-a/b) > 0);
    }

    public boolean isDecreasing(){
        return ((-a/b) < 0);
    }

    public boolean isHorizontal(){
        return ((-a/b) == 0);
    }

    public  boolean isVertical(){
        return !(slopeDefined());
    }

    public boolean isAFunction(){
        return (slopeDefined());
    }

    public boolean isValidLinearEquation(){
        return (a != 0 | b != 0);
    }

    public boolean isDirectVariation(){
        return (c == 0);
    }

    public boolean equals(LinearEquation other){
        return (this.slope() == other.slope() && this.c == other.c);
    }

    public LinearEquation parallelLine(Coords point){
        return new LinearEquation(slope(), point);
    }

    public LinearEquation perpendicularLine(Coords point){
        return new LinearEquation(slopeOfPerpendicularLine(), point);
    }

    public double shortestDistanceFrom(Coords point){
        /*
        LinearEquation prep = perpendicularLine(point);
        Coords intersection = pointOfIntersection(prep);
        double distance = point.distanceFrom(points);
        return distance;
         */
        return point.distanceFrom(pointOfIntersection(perpendicularLine(point)));
    }

    public LinearEquation inverseFunction(){
        return new LinearEquation(b, a, c);
    }

    public Coords pointOfIntersection(LinearEquation other){
        if(!this.isValidLinearEquation() || !other.isValidLinearEquation()){
            return null;
        }
        if(this.isVertical() && other.isVertical()) {
            return null;
        }
        if(this.isVertical() && other.isHorizontal()){
            return new Coords(this.xIntercept(), other.yIntercept());
        }
        if(this.isHorizontal() && other.isVertical()){
            return new Coords(this.yIntercept(), other.xIntercept());
        }
        if(isParallel(other)){
            return null;
        }
        if(equals(other)){
            return null;
        }

        double d = other.getA();
        double e = other.getA();
        double f = other.getC();

        double y = -(c * d + (a * f)) / (d * b - (a * e));
        double x = -(b * y - c) / a;
        return new Coords(x, y);

    }

    public boolean isParallel(LinearEquation other){
        return ((isVertical() && other.isVertical() && !equals(other)) || (slope() == other.slope() && !equals(other)));
    }

    public boolean isPerpendicular(LinearEquation other){
        return ((isVertical() && other.isHorizontal()) || (isHorizontal() && other.isVertical()) || (this.slopeOfPerpendicularLine() == other.slope()));
    }

 @Override public String toString(){
        return a + "x + " + b + "y + " + c + " = 0";
    }

    public String getSlopeInterceptForm(){
        return "y = " + -(a/b) + "x - " + (c/b);
    }
}
