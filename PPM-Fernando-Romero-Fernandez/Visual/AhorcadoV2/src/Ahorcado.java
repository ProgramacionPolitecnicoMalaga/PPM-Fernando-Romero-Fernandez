import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Ahorcado {
    private JPanel Ahorcado;
    private JLabel Letra;
    private JTextField txtLetra;
    private JButton butAñadir;
    private JLabel Palabra;
    private JTextField txtPalabra;
    private JLabel Intentos;
    private JTextField txtIntentos;
    private JLabel LetrasIntroducidas;
    private JTextField txtLetrasIntroducidas;
    private JButton butIniciar;

    static String letrasIntroducidas = "";
    private int intentos = -1;
    private int totalPalabras = 0;
    private int aleatorioInt = 0;



    //VARIABLES DEL INICIAR()
    private String palabraSeleccionada;
    private String[] palabraSplittedUni;
    private String[] palabraOcultaUni;
    private String palabraOcultaString = "";


    public Ahorcado() {
        butAñadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                añadirLetra();
            }
        });

        butIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                calcularAleatorio();
                obtenerPalabra();
                iniciar();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ahorcado");
        frame.setContentPane(new Ahorcado().Ahorcado);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void calcularAleatorio(){

        totalPalabras = 0;
        BufferedReader Lector = null;

        try {
            Lector = new BufferedReader(new FileReader("Files/palabras.csv"));
            String lineas = Lector.readLine();
            while (null != lineas) {
                String[] linea = lineas.split("\n");
                lineas = Lector.readLine();
                totalPalabras++;
            }

            double aleatorioDouble = Math.random()*totalPalabras;
            aleatorioInt = (int) aleatorioDouble;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void obtenerPalabra(){
        BufferedReader Lector = null;

        int contador = -1;

        try {
            Lector = new BufferedReader(new FileReader("Files/palabras.csv"));
            String lineas = Lector.readLine();
            while (null != lineas) {
                String[] linea = lineas.split("\n");
                lineas = Lector.readLine();
                contador++;

                if(contador == aleatorioInt){
                    palabraSeleccionada = lineas;
                    //DESMARCAR SI QUEREMOS SABER CUAL FUE LA PALABRA ELEGIDA
                    //System.out.println(palabraSeleccionada);
                }

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void iniciar(){
        butAñadir.setEnabled(true);
        txtLetra.setEditable(true);
        intentos = 5;
        txtIntentos.setText(Integer.toString(intentos));

        //SELECCIONAR LA PALABRA ALEATORIA


        //PALABRA A STRING Y CREACIÓN DE LA PALABRA OCULTA
        String palabraSplitted[] = palabraSeleccionada.split("");
        String palabraOculta[] = new String[palabraSplitted.length];
        String palabraOcultaString = "";

        //RECORRER EL SPLIT DE LA PALABRA ELEGIDA Y HACER ARRAY PARA MANEJAR Y STRING PARA MOSTRAR EN FORMU
        for(int i = 0; i < palabraSplitted.length; i++){
            palabraOculta[i] = "_";
            palabraOcultaString = Arrays.toString(palabraOculta);
        }

        //GUARDAR EN LAS VARIABLES "UNIVERSALES"
        palabraSplittedUni = palabraSplitted;
        palabraOcultaUni = palabraOculta;

        //ESCRIBIR EN EL FORMULARIO
        txtIntentos.setText(Integer.toString(intentos));
        txtPalabra.setText(palabraOcultaString);
        txtLetrasIntroducidas.setText("");


    }

    private void añadirLetra(){

        if(txtLetra.getText().equals("") || txtLetra.getText().length() > 1){
            System.out.println("Algo estás haciendo mal...");
            txtLetra.setText("");
        } else{
            String letraIntroducida = txtLetra.getText().toUpperCase();
            letrasIntroducidas += txtLetra.getText().toUpperCase();

            //COMPROBAR SI LA LETRA INTRODUCIDA APARECE EN LA PALABRA

            boolean esIgual = false;

            for(int i = 0; i < palabraSplittedUni.length; i++){
                if(letraIntroducida.equals(palabraSplittedUni[i].toUpperCase())){
                    palabraOcultaUni[i] = letraIntroducida;
                    palabraOcultaString = Arrays.toString(palabraOcultaUni);
                    esIgual = true;
                } else{
                    palabraOcultaString = Arrays.toString(palabraOcultaUni);
                }
            }

            //RESTAR INTENTOS EN CASO DE FALLO

            if(esIgual == true){
                txtIntentos.setText(Integer.toString(intentos));
            } else if(esIgual == false){
                intentos--;
                txtIntentos.setText(Integer.toString(intentos));
            }

            txtLetrasIntroducidas.setText(letrasIntroducidas);
            txtLetra.setText("");
            txtPalabra.setText(palabraOcultaString);


            comprobarFin();
        }



    }

    private void comprobarFin(){

        String palabraString = "";
        String palabraOcultaString = "";

        for(int i = 0; i < palabraSplittedUni.length; i++){
            palabraString += palabraSplittedUni[i].toUpperCase();
        }

        for(int i = 0; i < palabraOcultaUni.length; i++){
            palabraOcultaString += palabraOcultaUni[i];
        }

        if(palabraString.equals(palabraOcultaString)){
            butAñadir.setEnabled(false);
            txtLetra.setEditable(false);
            txtLetra.setText("Has ganado!");
        }

        if(intentos == 0){
            butAñadir.setEnabled(false);
            txtLetra.setEditable(false);
            txtLetra.setText("Has perdido :(");
        }


    }

}
