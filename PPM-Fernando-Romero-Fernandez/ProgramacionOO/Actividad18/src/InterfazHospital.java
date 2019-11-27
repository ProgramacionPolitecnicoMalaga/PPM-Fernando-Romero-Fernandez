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
                Paciente nuevoPaciente = new Paciente(txtNombre.getText(),Integer.parseInt(txtEdad.getText()));
                Urgencia urg = new Urgencia(comboEspecialidades.getSelectedIndex(),txtDescripcion.getText(),urgenciaGraveCheckBox.isSelected(),nuevoPaciente);

                if(urgenciaGraveCheckBox.isSelected()){
                    urg.setGrave(true);
                }
                listaEspera.add(urg);
                actualizarJTextArea();

            }
        });

        btnSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if(!listaEspera.isEmpty()){
                    Iterator<Urgencia> it = listaEspera.iterator();
                    boolean algoGraveHaPasado = false;
                    while(it.hasNext()){
                        Urgencia urgActual = it.next();
                        if(urgActual.isGrave()){
                            int especialidad = urgActual.getEspecialidad();
                            urgActual.setEspecialidad(0);
                            String linea = urgActual.getPaciente().getNombre() + urgActual.getPaciente().getEdad()+ "Urgencia Grave"+listaEspecialidades.get(especialidad);
                            txtSiguiente.setText(linea);
                            listaEspera.remove(urgActual);
                            actualizarJTextArea();
                            algoGraveHaPasado = true;
                        }
                    }

                    if(!algoGraveHaPasado){
                        Urgencia urgActual2 = listaEspera.poll();
                        int especialidad = urgActual2.getEspecialidad();
                        String linea = urgActual2.getPaciente().getNombre() + urgActual2.getPaciente().getEdad()+ listaEspecialidades.get(especialidad);
                        txtSiguiente.setText(linea);
                        actualizarJTextArea();
                    }
                }


            }
        });


    }

    public void actualizarJTextArea(){
        Iterator<Urgencia> it = listaEspera.iterator();
        String linea = "";

        while(it.hasNext()){
            Urgencia urgActual =it.next();
            int especialidad = urgActual.getEspecialidad();
            linea += urgActual.getPaciente().getNombre() + urgActual.getPaciente().getEdad()+ listaEspecialidades.get(especialidad) + "\n";
        }
        txtAreaLista.setText(linea);
    }

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Ranking Pilotos");
        frame.setContentPane(new InterfazHospital().JPanelHospital);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
