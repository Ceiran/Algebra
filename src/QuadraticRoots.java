public class QuadraticRoots {
    private ComplexNumber root1;
    private ComplexNumber root2;

    public QuadraticRoots(double r1, double r2){
        root1 = new ComplexNumber(r1, 0);
        root2 = new ComplexNumber(r2, 0);
    }

    public QuadraticRoots(ComplexNumber r1){
        root1 = new ComplexNumber(r1);
        root2 = new ComplexNumber(r1.getRealMagnitude(), -r1.getImaginaryMagnitude());
    }

    public ComplexNumber getRoot1(){
        return root1;
    }

    public ComplexNumber getRoot2(){
        return root2;
    }

    public String toString(){
        return "{" + root1 + ", " + root2 + "}";
    }

    public boolean areValid(){
        return !(root1 == null || root2 == null);
    }
}
