public class ConsumidorCola {
    private static Cola cola;
    private static final int TAM_COLA = 5;

    public static void main(String[] args) {
        cola = new Cola(TAM_COLA);

        try{
            cola.sacar();
            cola.meter(10);
            cola.meter(30);
            cola.meter(60);
            cola.meter(12);
            System.out.println(cola);
            cola.sacar();
            System.out.println(cola);
            cola.sacar();
            System.out.println(cola);
            System.out.println(cola);
            cola.meter(66);
            cola.meter(98);
            System.out.println(cola);
            cola.meter(74);
            System.out.println(cola);
            cola.meter(37);

        } catch(ExcepcionCola e){
            System.out.println("Fallo");
        }


    }
}