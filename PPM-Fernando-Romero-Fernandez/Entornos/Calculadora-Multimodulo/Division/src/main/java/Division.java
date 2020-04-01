import org.apache.commons.math3.analysis.function.Divide;

public class Division {
    private Divide divide;

    public Division(){
        divide = new Divide();
    }

    public double dividir(double num1, double num2){
        double num = divide.value(num1,num2);
        return num;
    }
}
