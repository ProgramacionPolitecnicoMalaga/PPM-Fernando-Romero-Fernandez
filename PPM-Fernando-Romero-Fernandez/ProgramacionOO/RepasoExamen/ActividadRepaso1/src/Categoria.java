public class Categoria {

    private int categoria;
    private double sueldo;

    private final static int CATEGORIA_TECNICO =  1;
    private final static int CATEGORIA_ADMINISTRADOR =  2;
    private final static int CATEGORIA_PROGRAMADOR =  3;
    private final static int CATEGORIA_JEFE_DE_PROYECTO =  4;
    private final static int CATEGORIA_JEFE_DE_OPERACIONES =  5;

    public Categoria(int categoria){
        this.categoria = categoria;
        switch (categoria){
            case CATEGORIA_TECNICO:
                sueldo = 900.0;
                break;
            case CATEGORIA_ADMINISTRADOR:
                sueldo = 1400.0;
                break;
            case CATEGORIA_PROGRAMADOR:
                sueldo = 1800.0;
                break;
            case CATEGORIA_JEFE_DE_PROYECTO:
                sueldo = 2500.0;
                break;
            case CATEGORIA_JEFE_DE_OPERACIONES:
                sueldo = 3500.0;
                break;
            default:
                System.out.println("Selecciona una categoría del 1 al 5");
        }

    }

    public String getCategoria() {
        switch (categoria){
            case CATEGORIA_TECNICO:
                return "Técnico";
            case CATEGORIA_ADMINISTRADOR:
                return "Administrador";
            case CATEGORIA_PROGRAMADOR:
                return "Programador";
            case CATEGORIA_JEFE_DE_PROYECTO:
                return "Jefe de Proyecto";
            case CATEGORIA_JEFE_DE_OPERACIONES:
                return "Jefe de Operaciones";
        }
        return null;
    }

    public double getSueldo() {
        return sueldo;
    }


}
