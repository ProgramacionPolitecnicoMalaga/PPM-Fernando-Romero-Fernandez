import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class MiMain {

    public static void main(String[] args) {

        Fiesta fiesta1 = new Fiesta();
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter miFormatoDeFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.println(fechaActual.format(miFormatoDeFecha));


        //Invitado invitado1 = new Invitado("Paco","Pérez",);
        //fiesta1.añadirInvitado();


    }
}
