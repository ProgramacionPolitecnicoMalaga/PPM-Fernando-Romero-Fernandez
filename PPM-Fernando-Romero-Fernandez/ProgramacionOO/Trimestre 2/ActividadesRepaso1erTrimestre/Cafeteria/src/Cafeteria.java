import java.util.ArrayList;

public class Cafeteria {

    ArrayList<Producto> carta;
    ArrayList<Mesa> mesas;
    Caja caja;

    public Cafeteria(){
        carta = new ArrayList<>();
        mesas = new ArrayList<>();
        caja = new Caja();
        añadirMesasPorDefecto();
    }

    public void añadirMesasPorDefecto(){
        Mesa mesa;
        for(int i = 1; i <= 5 ; i++){
            mesa = new Mesa(i);
            mesas.add(mesa);
        }
    }

    public void addProductoALaCarta(String nombre, double precio){
        Producto producto = new Producto(nombre,precio);
        carta.add(producto);
    }


}
