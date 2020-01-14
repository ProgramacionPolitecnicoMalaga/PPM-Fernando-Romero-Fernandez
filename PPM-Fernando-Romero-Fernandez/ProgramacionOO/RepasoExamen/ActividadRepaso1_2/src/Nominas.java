import java.util.ArrayList;
import java.util.LinkedList;

public class Nominas {

    private Listas listas = new Listas();
    private LinkedList<Empleado> listaEmpleados = listas.getListaEmpleados();
    private LinkedList<Nomina> listaNominas = new LinkedList<>();

    public Nominas(){

    }

    public LinkedList<Nomina> generarNominas(){

        System.out.println(listaEmpleados.get(0).getListaTareas());

        for(int i = 0; i<listaEmpleados.size(); i++){
            double complementos = 0.0;
            double sueldoTotal = 0.0;
            Empleado empActual = listaEmpleados.get(i);
            System.out.println(empActual.getListaTareas());
            for(int j = 0; j < empActual.getListaTareas().size(); j++){

                System.out.println("hola");
                double fprod = empActual.getListaTareas().get(j).getProyecto().getFactorProduccion();
                double horas = empActual.getListaTareas().get(j).getProyecto().getFactorProduccion();

                complementos += fprod * horas;
                System.out.println(complementos);
                sueldoTotal = complementos + empActual.getListaTareas().get(j).getEmpleado().getCategoria().getSueldo();
            }

            System.out.println(complementos);
            Nomina nomina = new Nomina(empActual,complementos,sueldoTotal);
            listaNominas.add(nomina);
        }
        return listaNominas;
    }
}
