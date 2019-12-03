import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

public class AppAditivos {
    private JPanel AppAditivos;
    private JTextField txtBusqueda;
    private JButton btnBuscar;
    private JTable tablaAditivos;
    private JTextArea txtAreaAditivo;

    DefaultTableModel tableModel = new DefaultTableModel();
    ArrayList<Aditivo> listaAditivos = new ArrayList<>();

    public AppAditivos() throws IOException {
        JSONGenerator jsonGenerator = new JSONGenerator("files/aditivos.json");
        listaAditivos = jsonGenerator.cargarJSON();

        Object filaData[] = new Object[3];
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Peligrosidad");
        tableModel.addColumn("Comentario");
        tablaAditivos.setModel(tableModel);

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String introducido = "";
                for(int j = 0; j < tableModel.getRowCount();j++){
                    tableModel.removeRow(j);

                }
                for(int i = 0; i < listaAditivos.size(); i++){
                    introducido = txtBusqueda.getText();
                    if(listaAditivos.get(i).getNombre().contains(introducido) || listaAditivos.get(i).getPeligrosidad().contains(introducido) || listaAditivos.get(i).getComentario().contains(introducido) ){
                        filaData[0] = listaAditivos.get(i).getNombre();
                        filaData[1] = listaAditivos.get(i).getPeligrosidad();
                        filaData[2] = listaAditivos.get(i).getComentario();

                        tableModel.addRow(filaData);
                    }

                }
            }
        });
        tablaAditivos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int lineaSeleccionada = tablaAditivos.getSelectedRow();
                String lineaAEscribir = "";
                lineaAEscribir = tableModel.getValueAt(lineaSeleccionada,0).toString();
                lineaAEscribir += tableModel.getValueAt(lineaSeleccionada,1).toString();
                lineaAEscribir += tableModel.getValueAt(lineaSeleccionada,2).toString();

                txtAreaAditivo.setText(lineaAEscribir);
            }
        });
    }

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Aditivos");
        frame.setContentPane(new AppAditivos().AppAditivos);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500,500));
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
}
