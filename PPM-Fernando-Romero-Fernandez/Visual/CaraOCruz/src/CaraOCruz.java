import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CaraOCruz {
    private JPanel CaraOCruz, PanelImg, PanelInfo, PanelControl;
    private JButton btnTirar, btnRepetir, btnReset;
    private JTextField txtNumTiradas, txtTiradas, txtCaras, txtCruces, txtPercentCaras, txtPercentCruces;
    private JLabel labelImagen;

    private int totalTiradas = 0;
    private int totalCaras = 0;
    private int totalCruces = 0;
    private double porcentajeCaras = 0;
    private double porcentajeCruces = 0;


    public static void main(String[] args) {
        JFrame frame = new JFrame("CaraOCruz");
        frame.setContentPane(new CaraOCruz().CaraOCruz);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }



    public CaraOCruz() {
        btnTirar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                realizarTirada();
            }
        });

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                reiniciarStats();
            }
        });

        btnRepetir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                tirarXVeces();
            }
        });
    }

    public void realizarTirada(){
        double aleatorioDouble =Math.random()*2;
        int aleatorioInt = (int) aleatorioDouble;

        totalTiradas++;
        txtTiradas.setText(Integer.toString(totalTiradas));
        btnReset.setEnabled(true);


        Image cara = new ImageIcon("files/cara.png").getImage();
        Image cruz = new ImageIcon("files/cruz.png").getImage();

        ImageIcon iconoCara = new ImageIcon(cara.getScaledInstance(100,100,Image.SCALE_SMOOTH));
        ImageIcon iconoCruz = new ImageIcon(cruz.getScaledInstance(100,100,Image.SCALE_SMOOTH));


        if(aleatorioInt == 0){
            labelImagen.setIcon(iconoCara);

            totalCaras++;
            txtCaras.setText(Integer.toString(totalCaras));

        } else{
            labelImagen.setIcon(iconoCruz);

            totalCruces++;
            txtCruces.setText(Integer.toString(totalCruces));
        }

        porcentajeCaras = (100 * totalCaras) / totalTiradas;
        porcentajeCruces = (100 * totalCruces) / totalTiradas;
        txtPercentCaras.setText(Double.toString(porcentajeCaras));
        txtPercentCruces.setText(Double.toString(porcentajeCruces));

    }

    public void tirarXVeces(){

        int numeroTiradas = Integer.parseInt(txtNumTiradas.getText());
        for(int i = 0; i < numeroTiradas; i++){
            realizarTirada();
        }
    }

    public void reiniciarStats(){
        txtTiradas.setText("");
        txtCaras.setText("");
        txtCruces.setText("");
        txtPercentCaras.setText("");
        txtPercentCruces.setText("");
        txtNumTiradas.setText("");
        btnReset.setEnabled(false);
    }
}
