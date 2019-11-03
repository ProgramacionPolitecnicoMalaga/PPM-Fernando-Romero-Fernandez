import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ListaCompra {
    private JPanel ListaCompra, PSeleccionar, PTotal, PLista;
    private JTextArea txtContainer;
    private JTextField txtUnidades, txtTotal;
    private JButton btnComprar;
    private JComboBox cBoxProductos;
    private JButton btnIniciar;

    private String productoElegido = "";
    private String cadenaTotal = "";
    private double costeTotal = 0;


    public ListaCompra() {
        btnIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                iniciar();
            }
        });

        btnComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                comprar();
            }
        });
    }

    public void iniciar(){
        btnComprar.setEnabled(true);

        BufferedReader Lector = null;
        try {
            Lector = new BufferedReader(new FileReader("files/productos.csv"));
            String lineas = Lector.readLine();
            while (null != lineas) {
                String[] linea = lineas.split(";");
                lineas = Lector.readLine();
                String elemento = linea[1] + " " + linea[4];
                cBoxProductos.addItem(elemento);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        btnIniciar.setEnabled(false);
    }

    public void comprar(){
        if(txtUnidades.getText() != ""){
            String cadena = "";

            BufferedReader Lector = null;
            try {
                Lector = new BufferedReader(new FileReader("files/productos.csv"));
                String lineas = Lector.readLine();
                while (null != lineas) {
                    String[] linea = lineas.split(";");
                    lineas = Lector.readLine();
                    int nProductoSeleccionado = cBoxProductos.getSelectedIndex()+1;
                    if(nProductoSeleccionado == Integer.parseInt(linea[0])){
                        cadena = txtUnidades.getText() + " x " + linea[1] + " " + linea[4] + " €";
                        cadenaTotal += cadena + "\n";
                        String cambiado = linea[4].replace(",",".");
                        costeTotal += Integer.parseInt(txtUnidades.getText()) * Double.parseDouble(cambiado);

                    }

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            txtContainer.setText(cadenaTotal);
            txtTotal.setText(Double.toString(costeTotal) + " €");
            txtUnidades.setText("");
        } else{
            System.out.println("Introduce unidades!");
        }


    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lista de Compra con CSV y ComboBox");
        frame.setContentPane(new ListaCompra().ListaCompra);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
