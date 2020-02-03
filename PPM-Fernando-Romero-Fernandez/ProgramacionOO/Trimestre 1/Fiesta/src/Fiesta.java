import java.util.ArrayList;
import java.util.Iterator;

public class Fiesta implements Comparable<Invitado>{

    ArrayList<Invitado> invitados = new ArrayList<>();
    ArrayList<Invitado> fiesta = new ArrayList<>();


    public void añadirInvitado(Invitado invitado){
        invitados.add(invitado);
    }

    public void comprobarEdadInvitados(Invitado invitado){
        Iterator<Invitado> invitadoActual = invitados.iterator();
        while(invitadoActual.hasNext()){

        }
    }

    public void añadirALaFiesta(Invitado invitado){

    }

    @Override
    public int compareTo(Invitado invitado) {
        return 0;
    }
}
