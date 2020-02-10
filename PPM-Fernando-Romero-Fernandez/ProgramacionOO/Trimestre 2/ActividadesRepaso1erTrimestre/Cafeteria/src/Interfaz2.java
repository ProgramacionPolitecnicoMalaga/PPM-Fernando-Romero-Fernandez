import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Interfaz2 {
    private JTabbedPane pnlPrincipal;
    private JPanel Interfaz2, pnlMesas, pnlCuenta, pnlControlMesas, pnlControl, pnlCarta, pnlProductosCarta, pnlControlCarta;
    private JComboBox cmbProductos;
    private JButton btnAñadirProductoAMesa, btnCobrar, btnCrearProducto, btnMesa101, btnMesa102, btnMesa103, btnMesa104, btnMesa105;
    private JTextField txtImporteMesa, txtImporteTotal, txtNombreProducto, txtPrecio;
    private JTable tablaCarta;
    private JTable tablaMesa;
    private JTextField txtMesaActual;

    Cafeteria cafeteria;
    DefaultTableModel tableModelCarta;
    DefaultTableModel tableModelMesa;

    public Interfaz2(){
        cafeteria = new Cafeteria();

        tableModelCarta = new DefaultTableModel();
        tableModelCarta.addColumn("Producto");
        tableModelCarta.addColumn("Precio");
        tablaCarta.setModel(tableModelCarta);

        tableModelMesa = new DefaultTableModel();
        tableModelMesa.addColumn("Producto");
        tableModelMesa.addColumn("Precio");
        tablaMesa.setModel(tableModelMesa);

        btnMesa101.setBackground(new java.awt.Color(255,50,50));
        btnMesa102.setBackground(new java.awt.Color(255,50,50));
        btnMesa103.setBackground(new java.awt.Color(255,50,50));
        btnMesa104.setBackground(new java.awt.Color(255,50,50));
        btnMesa105.setBackground(new java.awt.Color(255,50,50));

        btnCrearProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String nombreProducto = txtNombreProducto.getText();
                double precioProducto = Double.parseDouble(txtPrecio.getText());

                Object filaDatos[] = new Object[2];
                filaDatos[0] = nombreProducto;
                filaDatos[1] = precioProducto;
                cafeteria.addProductoALaCarta(nombreProducto,precioProducto);
                cmbProductos.addItem(new Producto(nombreProducto,precioProducto));
                tableModelCarta.addRow(filaDatos);
                crearTablaCarta(cafeteria.carta);
            }
        });

        btnAñadirProductoAMesa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Producto producto = (Producto) cmbProductos.getSelectedItem();
                String mesaActual = txtMesaActual.getText();
                int numeroMesa = Integer.parseInt(String.valueOf(mesaActual.charAt(mesaActual.length()-1)));
                Mesa mesa = cafeteria.mesas.get(numeroMesa-1);
                mesa.addProducto(producto);
                mesa.setAbierta(true);
                txtImporteMesa.setText(String.valueOf(mesa.recalcularImporte()));
                mostrarTablaMesa(mesa);

                pintarBoton(numeroMesa-1,"verde");
            }
        });

        btnMesa101.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mostrarTablaMesa(cafeteria.mesas.get(0));
                mostrarImporteMesa(cafeteria.mesas.get(0));
                txtMesaActual.setText("Mesa 101");
            }
        });

        btnMesa102.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mostrarTablaMesa(cafeteria.mesas.get(1));
                mostrarImporteMesa(cafeteria.mesas.get(1));
                txtMesaActual.setText("Mesa 102");
            }
        });

        btnMesa103.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mostrarTablaMesa(cafeteria.mesas.get(2));
                mostrarImporteMesa(cafeteria.mesas.get(2));
                txtMesaActual.setText("Mesa 103");
            }
        });

        btnMesa104.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mostrarTablaMesa(cafeteria.mesas.get(3));
                mostrarImporteMesa(cafeteria.mesas.get(3));
                txtMesaActual.setText("Mesa 104");
            }
        });

        btnMesa105.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mostrarTablaMesa(cafeteria.mesas.get(4));
                mostrarImporteMesa(cafeteria.mesas.get(4));
                txtMesaActual.setText("Mesa 105");
            }
        });

        btnCobrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cafeteria.caja.totalCaja += Double.parseDouble(txtImporteMesa.getText());
                String mesaActual = txtMesaActual.getText();
                int numeroMesa = Integer.parseInt(String.valueOf(mesaActual.charAt(mesaActual.length()-1)));
                Mesa mesa = cafeteria.mesas.get(numeroMesa-1);
                mesa.setImporteMesa(0.00);
                ArrayList<Producto> listaProductos = new ArrayList<>();
                mesa.setProductosDeLaMesa(listaProductos);
                txtImporteMesa.setText(String.valueOf(mesa.recalcularImporte()));
                mostrarTablaMesa(mesa);
                txtImporteTotal.setText(String.valueOf(cafeteria.caja.totalCaja));
                pintarBoton(numeroMesa-1,"rojo");
            }
        });
    }

    public void pintarBoton(int numeroMesa, String color){
        if(color == "verde"){
            switch (numeroMesa){
                case 0: btnMesa101.setBackground(new java.awt.Color(58, 255, 41)); break;
                case 1: btnMesa102.setBackground(new java.awt.Color(58, 255, 41)); break;
                case 2: btnMesa103.setBackground(new java.awt.Color(58, 255, 41)); break;
                case 3: btnMesa104.setBackground(new java.awt.Color(58, 255, 41)); break;
                case 4: btnMesa105.setBackground(new java.awt.Color(58, 255, 41)); break;
            }
        } else if(color == "rojo"){
            switch (numeroMesa){
                case 0: btnMesa101.setBackground(new java.awt.Color(255,50,50)); break;
                case 1: btnMesa102.setBackground(new java.awt.Color(255,50,50)); break;
                case 2: btnMesa103.setBackground(new java.awt.Color(255,50,50)); break;
                case 3: btnMesa104.setBackground(new java.awt.Color(255,50,50)); break;
                case 4: btnMesa105.setBackground(new java.awt.Color(255,50,50)); break;
            }
        }

    }

    public void crearTablaMesa(ArrayList<Producto> listaProductos){
        vaciarTablaMesa();
        Object filaDatos[] = new Object[2];
        for(int i = 0; i < listaProductos.size(); i++){
            filaDatos[0] = listaProductos.get(i).getNombre();
            filaDatos[1] = listaProductos.get(i).getPrecio();
            tableModelMesa.addRow(filaDatos);
        }
    }

    public void vaciarTablaMesa(){
        int a = tableModelMesa.getRowCount()-1;
        for (int i = a; i >= 0; i--) {
            tableModelMesa.removeRow(tableModelMesa.getRowCount()-1);
        }
    }

    public void crearTablaCarta(ArrayList<Producto> listaProductos){
        vaciarTablaCarta();
        Object filaDatos[] = new Object[2];
        for(int i = 0; i < listaProductos.size(); i++){
            filaDatos[0] = listaProductos.get(i).getNombre();
            filaDatos[1] = listaProductos.get(i).getPrecio();
            tableModelCarta.addRow(filaDatos);
        }
    }

    public void vaciarTablaCarta(){
        int a = tableModelCarta.getRowCount()-1;
        for (int i = a; i >= 0; i--) {
            tableModelCarta.removeRow(tableModelCarta.getRowCount()-1);
        }
    }

    public void mostrarTablaMesa(Mesa mesa){
        crearTablaMesa(mesa.productosDeLaMesa);
    }

    public void mostrarImporteMesa(Mesa mesa){
        txtImporteMesa.setText(String.valueOf(mesa.recalcularImporte()));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Interfaz2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Interfaz2().Interfaz2);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }

}
