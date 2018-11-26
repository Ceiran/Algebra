public class Coords {
    private double x;
    private double y;

    public Coords(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Coords(double x){
        this(x, x);
    }

    public Coords(){
        this(0);
    }

    public Coords(Coords other){
        //Don't need this. for this method, but good for clarification.
        this.x = other.getX();
        this.y = other.getY();
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public String toString(){
        String theString = "";
        theString = "(" + x + ", " + y + ")";
        return theString;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public void reflectOnXAxis(){
        this.y = -y;
    }

    public void refltectOnYAxis(){
        this.x = -x;
    }

    public void reflectOnOrigin(){
        this.x = -x;
        this.y = -y;
    }

    public void translate(double horizontal, double vertical){
        this.x += horizontal;
        this.y += vertical;
    }

    public void dilate(double dilationFactor){
        this.x = (x * dilationFactor);
        this.y = (y * dilationFactor);
    }

    public double distanceFromOrigin(){
        return Math.sqrt((Math.pow(this.x, 2) + Math.pow(this.y, 2)));
        //return distanceFrom(new Coords());c
    }

    public double distanceFrom(Coords other){
        return Math.sqrt((Math.pow((this.x - other.x), 2) + Math.pow((this.y - other.y), 2)));
    }

    public boolean equals(Coords otherPoint){
        return this.x == otherPoint.x && this.y == otherPoint.y;
    }

    public double getSlopeOfLineSegment(Coords other){
        return (this.y - other.y) / (this.x - other.x);
    }

    public boolean slopeOfLineSegmentDefined(Coords other){
        return this.x != other.x;
    }
}
