public class Categoria {

    private int numeroCategoria;
    private double sueldo;

    private final static int TECNICO = 10;
    private final static int ADMINSITRADOR = 20;
    private final static int PROGRAMADOR = 30;
    private final static int JEFE_DE_PROYECTO = 40;
    private final static int JEFE_DE_OEPRACIONES = 50;


    public Categoria(int numeroCategoria){
        this.numeroCategoria = numeroCategoria;
        switch (numeroCategoria){
            case TECNICO:
                sueldo = 900.00;
                break;
            case ADMINSITRADOR:
                sueldo = 1400.00;
                break;
            case PROGRAMADOR:
                sueldo = 1800.00;
                break;
            case JEFE_DE_PROYECTO:
                sueldo = 2500.00;
                break;
            case JEFE_DE_OEPRACIONES:
                sueldo = 3500.00;
                break;
            default:
                System.out.println("No se ha introducido una categoría válida(10,20,30,40,50)");
        }
    }

    public int getNumeroCategoria() {
        return numeroCategoria;
    }

    public String getStringCategoria(){
        switch (numeroCategoria){
            case TECNICO:
                return "Técnico";
            case ADMINSITRADOR:
                return "Administrador";
            case PROGRAMADOR:
                return "Programador";
            case JEFE_DE_PROYECTO:
                return "Jefe de Proyecto";
            case JEFE_DE_OEPRACIONES:
                return "Jefe de Operaciones";
            default:
                System.out.println("No se ha introducido una categoría válida(10,20,30,40,50)");
        }
        return null;
    }

    public double getSueldo() {
        return sueldo;
    }

}
