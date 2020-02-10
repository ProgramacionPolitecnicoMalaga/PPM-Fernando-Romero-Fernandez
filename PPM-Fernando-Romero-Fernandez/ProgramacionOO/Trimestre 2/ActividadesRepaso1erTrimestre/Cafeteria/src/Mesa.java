import java.util.ArrayList;

public class Mesa {

    private int numeroMesa;
    private boolean abierta;
    private double importeMesa = 0.00;
    ArrayList<Producto> productosDeLaMesa;

    public Mesa(int numeroMesa){
        this.numeroMesa = numeroMesa;
        this.abierta = false;
        productosDeLaMesa = new ArrayList<>();
    }

    public void addProducto(Producto producto){
        productosDeLaMesa.add(producto);
        if(this.abierta = false){
            this.abierta = true;
        }
    }

    public double recalcularImporte(){
        double importeActual = 0.00;
        for(int i = 0; i < productosDeLaMesa.size(); i++){
            importeActual += productosDeLaMesa.get(i).getPrecio();
        }
        importeMesa = importeActual;
        return importeMesa;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public boolean isAbierta() {
        return abierta;
    }

    public void setAbierta(boolean abierta) {
        this.abierta = abierta;
    }

    public double getImporteMesa() {
        return importeMesa;
    }

    public void setImporteMesa(double importeMesa) {
        this.importeMesa = importeMesa;
    }

    public ArrayList<Producto> getProductosDeLaMesa() {
        return productosDeLaMesa;
    }

    public void setProductosDeLaMesa(ArrayList<Producto> productosDeLaMesa) {
        this.productosDeLaMesa = productosDeLaMesa;
    }
}
