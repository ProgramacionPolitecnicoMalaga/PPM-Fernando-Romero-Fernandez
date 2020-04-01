public class App {
    public static void main(String[] args) {
        Suma suma = new Suma();
        Resta resta = new Resta();
        Multiplicacion multiplicacion = new Multiplicacion();
        Division division = new Division();

        double[] numerosSuma = {4.5,3.6};

        double num1 = 4.5;
        double num2 = 2.5;

        System.out.println("Suma: " + suma.sumar(numerosSuma, 0, numerosSuma.length));
        System.out.println("Resta: " + resta.restar(num1,num2));
        System.out.println("Multiplicacion: " + multiplicacion.multiplicar(num1,num2));
        System.out.println("Division: " + division.dividir(num1,num2));
    }
}
