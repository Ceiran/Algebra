public class ComplexNumber {
    //a + bi
    private double a;
    private double b;

    public ComplexNumber(double realPart, double imaginaryPart){
        a = realPart;
        b = imaginaryPart;
    }

    public ComplexNumber(ComplexNumber other){
        a = other.getRealMagnitude();
        b = other.getImaginaryMagnitude();
    }

    public double getRealMagnitude(){
        return this.a;
    }

    public double getImaginaryMagnitude(){
        return this.b;
    }

    @Override public String toString(){
        String theString = "";
        theString = this.a + " + " + this.b + "i";
        return theString;
    }

    public void add(double scalar){
        this.a = this.a + scalar;
    }

    public void add(ComplexNumber other){
        add(other.a);
        this.b = this.b + other.b;
    }

    public void subtract(double scalar){
        this.a = this.a - scalar;
    }

    public void subtract(ComplexNumber other){
        subtract(other.a);
        this.b = this.b - other.b;
    }

    public void multiply(double scalar){
        this.a = this.a * scalar;
    }

    public void multiply(ComplexNumber other){
        double tempA = this.a;
        double tempB = this.b;
        this.a = ((tempA * other.a) - (tempB * other.b));
        this.b = ((tempA * other.b) - (tempB * other.b));
    }

    public boolean divideBy(double scalar){
        if(scalar != 0){
            this.a = this.a / 4;
            this.b = this.b / 4;
            return true;
        }
        return false;
    }

    public boolean divideBy(ComplexNumber other){
        double tempA = this.a;
        double tempB = this.b;
        if(!(other.a == 0 && other.b == 0)){
            a = (((tempA * other.a) + (tempB * other.b)) / ((other.a * other.a) + (other.b * other.b)));
            b = ((-(tempA * other.b) + (tempB * other.a)) / ((other.a * other.a) + (other.b * other.b)));
            return true;
        }
        return false;
    }
}
