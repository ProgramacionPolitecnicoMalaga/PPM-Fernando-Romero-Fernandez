import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

public class InterfazHospital {
    private JPanel JPanelControl;
    private JTextField txtNombre;
    private JTextField txtEdad;
    private JComboBox comboEspecialidades;
    private JButton btnAñadirPaciente;
    private JTextArea txtAreaLista;
    private JTextField txtSiguiente;
    private JButton btnSiguiente;
    private JPanel JPanelInfo;
    private JPanel JPanelHospital;
    private JCheckBox urgenciaGraveCheckBox;
    private JTextField txtDescripcion;

    PriorityQueue<Urgencia> listaEspera = new PriorityQueue<Urgencia>(Urgencia.COMPARATOR_ESPECIALIDAD);
    ArrayList<String> listaEspecialidades;



    public InterfazHospital() throws IOException {

        ArchivoCSV arch1 = new ArchivoCSV();
        arch1.cargarCSV();
        listaEspecialidades = arch1.listaEspecialidadesArray;

        Iterator<String> it = listaEspecialidades.iterator();
        while(it.hasNext()){
            comboEspecialidades.addItem(it.next());
        }

        btnAñadirPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Urgencia urgencia = new Urgencia(comboEspecialidades.getSelectedIndex(),txtDescripcion.getText(),urgenciaGraveCheckBox.isEnabled());
                Paciente nuevoPaciente = new Paciente(txtNombre.getText(),Integer.parseInt(txtEdad.getText()) ,urgencia);

                String linea = nuevoPaciente.getNombre() + nuevoPaciente.getEdad() + listaEspecialidades.get(comboEspecialidades.getSelectedIndex());
                txtAreaLista.setText(linea);
            }
        });

        btnSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Ranking Pilotos");
        frame.setContentPane(new InterfazHospital().JPanelHospital);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
