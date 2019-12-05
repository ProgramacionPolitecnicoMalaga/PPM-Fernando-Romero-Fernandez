import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibretaProfesor {
    private JPanel LibretaProfesor;
    private JTabbedPane PanelPestañas;
    private JComboBox comboBox1;
    private JTextField txtIdCurso;
    private JTextField txtNombreCurso;
    private JButton btnAñadirCurso;
    private JTextField txtIdCursoActual;
    private JTextField txtNombreCursoActual;
    private JTextField txtIDAsigActual;
    private JTextField txtNombreAsigActual;
    private JButton btnAñadirAsignatura;
    private JTextField txtIDAsigNueva;
    private JTextField txtAsigNombreNueva;
    private JTextField txtCursoActualAsig;
    private JComboBox comboBox2;
    private JTextField txtNombreAlumnoActual;

    public LibretaProfesor(){

        btnAñadirCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Colegio");
        frame.setContentPane(new LibretaProfesor().LibretaProfesor);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
