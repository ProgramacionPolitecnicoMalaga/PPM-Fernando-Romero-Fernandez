import org.apache.commons.math3.analysis.function.Subtract;

public class Resta {
    private Subtract subtract;

    public Resta(){
        subtract = new Subtract();
    }

    public double restar(double num1, double num2){
        double num = subtract.value(num1, num2);
        return num;
    }
}
