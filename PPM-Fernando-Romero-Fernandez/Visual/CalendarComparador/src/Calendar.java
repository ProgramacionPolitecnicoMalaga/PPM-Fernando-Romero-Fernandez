import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Calendar extends JFrame{
    private JPanel Calendar;
    private JPanel Calendar1;
    private JPanel Calendar2;
    private JButton btnComparar;
    private JTextField txtAnios;
    private JTextField txtDias;
    private JTextField txtHoras;
    private JTextField txtMinutos;
    private JTextField txtSegundos;
    private JTextField txtMeses;

    JDateChooser dateChoos1 = new JDateChooser();
    JDateChooser dateChoos2 = new JDateChooser();

    public Calendar(){
        setContentPane(Calendar);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(700,400);


        // calendar
        dateChoos1.setDateFormatString("dd/MM/yyyy");
        Calendar1.add(dateChoos1);
        dateChoos2.setDateFormatString("dd/MM/yyyy");
        Calendar2.add(dateChoos2);


        btnComparar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                Date fecha1 = dateChoos1.getDate();
                Date fecha2 = dateChoos2.getDate();

                //SI LA FECHA 1 ES MENOR A LA SEGUNDA NOS DARÍA NEGATIVO POR ELLO SE HACE UN IF PARA QUE ESTO NO PASE

                long enMinutos;

                if(fecha1.compareTo(fecha2) == -1){
                    enMinutos = fecha2.getTime()/60000 - fecha1.getTime()/60000;
                } else{
                    enMinutos = fecha1.getTime()/60000 - fecha2.getTime()/60000;

                }

                //CALCULAR LOS CAMPOS RESTANTES PASANDO DE MINUTOS A X

                long enSegundos = enMinutos*60;
                long enHoras = enMinutos/60;
                long enDias = enHoras/24;
                long enMeses = enDias/30;
                long enAnios = enDias/365;

                //ESCRIBIR EN EL FORMULARIO

                txtAnios.setText(Long.toString(enAnios));
                txtMeses.setText(Long.toString(enMeses));
                txtDias.setText(Long.toString(enDias));
                txtHoras.setText(Long.toString(enHoras));
                txtMinutos.setText(Long.toString(enMinutos));
                txtSegundos.setText(Long.toString(enSegundos));

            }
        });
    }

    public static void main(String[] args) {
        new Calendar().setVisible(true);

    }
}
