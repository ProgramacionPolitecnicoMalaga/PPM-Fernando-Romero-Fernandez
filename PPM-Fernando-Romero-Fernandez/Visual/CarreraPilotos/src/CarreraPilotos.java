import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class CarreraPilotos {
    private JPanel CarreraPilotos;
    private JTable TInfo;
    private JButton btnNextIteracion;
    private JButton btnOrdNombre;
    private JButton btnOrdPosSalida;
    private JPanel PPrincipal;
    private JPanel PTabla;

    ArrayList<Piloto> listaPilotos;
    DefaultTableModel tableModel = new DefaultTableModel();


    public CarreraPilotos() throws IOException {
        RankingPilotos ranking = new RankingPilotos();
        listaPilotos = ranking.pilotos;
        iniciarTabla();



        btnNextIteracion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ranking.nosMoveran();
                actualizarTabla();
                ArchivoCSV arch1 = new ArchivoCSV();
                arch1.escribirCSV(listaPilotos);
            }
        });
        btnOrdNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ranking.ordenarPilotosPorNombre();
                actualizarTabla();

            }
        });
        btnOrdPosSalida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ranking.ordenarPilotosPorPosicionDeSalida();
                actualizarTabla();
            }
        });

    }

    public void iniciarTabla(){
        Object filaData[] = new Object[2];
        tableModel.addColumn("Piloto");
        tableModel.addColumn("PosicionSalida");
        TInfo.setModel(tableModel);

        for(int i = 0; i < listaPilotos.size(); i++){
            filaData[0] = listaPilotos.get(i).getNombre();
            filaData[1] = listaPilotos.get(i).getPosicionDeSalida();
            tableModel.addRow(filaData);
        }
    }


    public void actualizarTabla(){
        vaciarTabla();
        Object filaData[] = new Object[2];

        for(int i = 0; i < listaPilotos.size(); i++){
            filaData[0] = listaPilotos.get(i).getNombre();
            filaData[1] = listaPilotos.get(i).getPosicionDeSalida();
            tableModel.addRow(filaData);
        }
    }

    public void vaciarTabla(){

        int a = tableModel.getRowCount()-1;
        for (int i = a; i >= 0; i--) {
            tableModel.removeRow(tableModel.getRowCount()-1);
        }
    }



    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Ranking Pilotos");
        frame.setContentPane(new CarreraPilotos().CarreraPilotos);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
