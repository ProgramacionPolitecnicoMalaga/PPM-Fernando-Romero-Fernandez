public class Vehiculo {

    private String modelo, marca, color, combustion;
    private int añoFabricacion, precio;
    private boolean nuevo;

    public Vehiculo(String modelo, String marca, String color, int añoFabricacion, String combustion, boolean nuevo){
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
        this.añoFabricacion = añoFabricacion;
        this.combustion = combustion;
        this.nuevo = nuevo;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getColor() {
        return color;
    }

    public int getAñoFabricacion() {
        return añoFabricacion;
    }

    public String getCombustion() {
        return combustion;
    }

    public boolean isNuevo() {
        return nuevo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    @Override
    public String toString() {
        return "Vehiculo{" +
                "modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", color='" + color + '\'' +
                ", añoFabricacion='" + añoFabricacion + '\'' +
                ", combustion='" + combustion + '\'' +
                ", esNuevo=" + nuevo +
                '}';
    }
}
