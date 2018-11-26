public class QuadraticEquation {
    //y = ax^2 + bx + c
    // y = a(x - h)^2 + k
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public QuadraticEquation(QuadraticEquation other){
        a = other.a;
        b = other.b;
        c = other.c;
    }

    public QuadraticEquation(){
        a = 1;
        b = 0;
        c = 0;
    }

    public QuadraticEquation(double coefficient, Coords vertex){
        a = coefficient;
        b = 2 * vertex.getX();
        c = (vertex.getX() * vertex.getX()) + vertex.getY();
    }

    @Override public String toString(){
        return a + "x^2 + " + b + "x + " + c;
    }

    public double getDiscriminant(){
        return ((b * b) - (4 * a * c));
    }

    public boolean hasRealRoots(){
        return (getDiscriminant() > 0);
    }

    public boolean hasEqualRoots(){
        return (getDiscriminant() == 0);
    }

    public boolean hasMinimum(){
        return a > 0;
    }

    public boolean hasMaximum(){
        return a < 0;
    }

    public LinearEquation axisOfSymmetry(){
        return new LinearEquation(1, 0, b / (2 * a));
    }

    public Coords vertex(){
        double x = -b / (2 * a);
        return new Coords(x, a * x * x + b * x + c);
    }

    public LinearEquation derivative(){
        return new LinearEquation(2 * a, -1, b);
    }

    public QuadraticRoots getRoots(){
        if(hasRealRoots()){
            return new QuadraticRoots(((-b + Math.sqrt(getDiscriminant()) / 2 * a)), (-b - Math.sqrt(b * b - (4 * a * c))) / 2 * a);
        } else{
            ComplexNumber temp = new ComplexNumber(((-b) / 2 * a), ((Math.sqrt(Math.abs(getDiscriminant()))) / 2 * a));
            return new QuadraticRoots(temp);
        }
    }
}
