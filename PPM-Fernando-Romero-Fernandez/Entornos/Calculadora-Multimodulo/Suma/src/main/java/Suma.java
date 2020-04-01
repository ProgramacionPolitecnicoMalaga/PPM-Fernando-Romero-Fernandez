import org.apache.commons.math3.stat.descriptive.summary.Sum;

public class Suma {
    private Sum sum;

    public Suma(){
        sum = new Sum();
    }

    public double sumar(double[] numeros, int inicio, int numerosASumar){
        double num = sum.evaluate(numeros,inicio,numerosASumar);
        return num;
    }

}
