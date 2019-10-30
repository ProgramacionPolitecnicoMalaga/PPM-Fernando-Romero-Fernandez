import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Productos {
    private JPanel Productos;
    private JTextField txtTexto;
    private JButton butBuscar;
    private JTextArea txtContainer;
    private String cadena = "";

    public Productos() {
        butBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(txtTexto.getText().equals("")){
                    txtContainer.setText("Introduce algo!");
                } else{
                    txtContainer.setText("");
                    cadena="";
                    String introducido = txtTexto.getText().toUpperCase();

                    BufferedReader Lector = null;
                    try {
                        Lector = new BufferedReader(new FileReader("files/productos.csv"));
                        String lineas = Lector.readLine();
                        while (null != lineas) {
                            String[] linea = lineas.split(";");
                            lineas = Lector.readLine();
                            for(int i = 0; i < linea.length;i++)
                                if (linea[i].toUpperCase().contains(introducido)) {
                                    cadena += linea[1] + "\n";
                                }
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    txtContainer.setText(cadena);
                }


            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Buscador de productos en CSV");
        frame.setContentPane(new Productos().Productos);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }
}


