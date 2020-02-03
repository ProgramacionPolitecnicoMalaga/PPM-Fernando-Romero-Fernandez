import java.util.ArrayList;

public class Categorias {

    private ArrayList<Categoria> categorias;

    public Categorias(){
        categorias = new ArrayList<Categoria>();

    }

    public void añadirNuevaCategoria(String nombre){
        Categoria nuevaCategoria = new Categoria(nombre);
        categorias.add(nuevaCategoria);
    }

    public String mostrarCategorias(){
        String texto = "";
        for(int i = 0; i < categorias.size(); i++){
            texto += i+1 + ". " + categorias.get(i).getNombre() + "\n";
        }
        return texto;
    }

    public Categoria getCategoriaPorNombre(String nombreCategoria){
        for(int i = 0; i < categorias.size(); i++){
            if(categorias.get(i).getNombre().equals(nombreCategoria)){
                return categorias.get(i);
            }
        }
        return new Categoria("???");
    }
}
