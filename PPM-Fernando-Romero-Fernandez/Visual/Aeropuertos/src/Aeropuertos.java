import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Aeropuertos {
    private JPanel Aeropuertos;
    private JPanel PControl;
    private JComboBox cBoxPaises;
    private JButton btnBuscar;
    private JLabel lblTotal;
    private JTextArea txtContainer;


    public Aeropuertos() {

        int contadorPaises = 0;

        ArrayList<String> paisLista = new ArrayList<String>();
        ArchivoXML cogerArchivo = new ArchivoXML("files/aeropuertos.xml", "aeropuertos");
        NodeList listaAeropuertos = cogerArchivo.ObtenerListaDeNodos();

        for (int n = listaAeropuertos.getLength() - 1; n >= 0; n--) {
            Node nodo = listaAeropuertos.item(n);

            if(nodo.getNodeType() == Node.ELEMENT_NODE){
                lblTotal.setText("(" + String.valueOf(contadorPaises) + ")");
                Element element = (Element) nodo;
                String pais = element.getAttribute("pais");

                if(!paisLista.contains(pais)){
                    contadorPaises++;
                    paisLista.add(pais);
                    cBoxPaises.addItem(pais);

                }
            }
        }

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                txtContainer.setText("");
                ArchivoXML cogerArchivo = new ArchivoXML("files/aeropuertos.xml", "aeropuertos");
                NodeList listaAeropuertos = cogerArchivo.ObtenerListaDeNodos();

                for (int n = listaAeropuertos.getLength() - 1; n >= 0; n--) {
                    Node nodo = listaAeropuertos.item(n);

                    if(nodo.getNodeType() == Node.ELEMENT_NODE){
                        Element element = (Element) nodo;
                        String nombrePais = cBoxPaises.getSelectedItem().toString();//País seleccionado en comboBox
                        String paisActual = element.getAttribute("pais");//País del nodo actual

                        if(paisActual.equals(nombrePais)){
                            String linea = element.getAttribute("nombreLargo") + "\n";
                            if(!linea.isEmpty()){
                                String lineas = txtContainer.getText();
                                lineas += linea;
                                txtContainer.setText(lineas);
                            }
                        }
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Aeropuertos");
        frame.setContentPane(new Aeropuertos().Aeropuertos);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,200);
        frame.setVisible(true);

    }
}
