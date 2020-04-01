import org.apache.commons.math3.analysis.function.Multiply;

public class Multiplicacion {
    private Multiply multiply;

    public Multiplicacion(){
        multiply = new Multiply();
    }

    public double multiplicar(double num1, double num2){
        double num = multiply.value(num1,num2);
        return num;
    }
}
