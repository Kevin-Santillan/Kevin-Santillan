import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Font;

public class Ventana2 extends JDialog {

    public static List<Producto> listaProductos;

    private static final long serialVersionUID = 1L;

    private final JPanel contentPanel = new JPanel();

    String[] cabezera = { "CODIGO", "PRODUCTO", "CANTIDAD", "PRECIO U.", "PRECIO T" };

    private JTextField Cantidad1;
    private JTextField Cantidad2;
    private JTextField Cantidad3;
    private JTextField Cantidad4;
    private JTextField Cantidad5;
    private JTextField Cantidad6;
    private JTextField Cantidad7;
    private JTextField Cantidad8;
    private JTextField Cantidad9;
    private JTextField Cantidad10;
    private JTextField Cantidad11;
    private JTextField Cantidad12;
    private JTextField Cantidad13;
    private JTextField Cantidad14;
    private JTextField Cantidad15;

    // chekbox
    public static JCheckBox Producto1;
    private JCheckBox Producto2;
    private JCheckBox Producto3;
    private JCheckBox Producto4;
    private JCheckBox Producto5;
    private JCheckBox Producto6;
    private JCheckBox Producto7;
    private JCheckBox Producto8;
    private JCheckBox Producto9;
    private JCheckBox Producto10;
    private JCheckBox Producto11;
    private JCheckBox Producto12;
    private JCheckBox Producto13;
    private JCheckBox Producto14;
    private JCheckBox Producto15;
    private boolean estados[];

    /*
     * public static void main(String[] args) { try { Ventana2 dialog = new
     * Ventana2(); dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
     * dialog.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
     */

    public Ventana2() {
        estados = new boolean[15];
        listaProductos = new ArrayList<>();

        CANTIDAD();
        ESCOGER();
        BOTONESV2();
        setModal(true);
        setTitle("PRODUCTOS");
        setBounds(100, 100, 600, 350);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(145, 235, 221));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        estblecerCantidad();
    }

    public void estblecerCantidad() {
        Cantidad1.setText("0");
        Cantidad2.setText("0");
        Cantidad3.setText("0");
        Cantidad4.setText("0");
        Cantidad5.setText("0");
        Cantidad6.setText("0");
        Cantidad7.setText("0");
        Cantidad8.setText("0");
        Cantidad9.setText("0");
        Cantidad10.setText("0");
        Cantidad11.setText("0");
        Cantidad12.setText("0");
        Cantidad13.setText("0");
        Cantidad14.setText("0");
        Cantidad15.setText("0");

    }

    public void estableceDatos(List<Producto> listaProductos) {
        int cantidades[] = { Integer.parseInt(Cantidad1.getText().trim()), Integer.parseInt(Cantidad2.getText().trim()),
                Integer.parseInt(Cantidad3.getText().trim()), Integer.parseInt(Cantidad4.getText().trim()),
                Integer.parseInt(Cantidad5.getText().trim()), Integer.parseInt(Cantidad6.getText().trim()),
                Integer.parseInt(Cantidad7.getText().trim()), Integer.parseInt(Cantidad8.getText().trim()),
                Integer.parseInt(Cantidad9.getText().trim()), Integer.parseInt(Cantidad10.getText().trim()),
                Integer.parseInt(Cantidad11.getText().trim()), Integer.parseInt(Cantidad12.getText().trim()),
                Integer.parseInt(Cantidad13.getText().trim()), Integer.parseInt(Cantidad14.getText().trim()),
                Integer.parseInt(Cantidad15.getText().trim())  };
        String nombreProducto[] = { Producto1.getText(), Producto2.getText(), Producto3.getText(), Producto4.getText(),
                Producto5.getText(), Producto6.getText(), Producto7.getText(), Producto8.getText(), Producto9.getText(),
                Producto10.getText(), Producto11.getText(), Producto12.getText(), Producto13.getText(),
                Producto14.getText(), Producto15.getText() };
        int precio[] = { 50, 25, 35, 40, 15, 70, 28, 800, 450, 150, 300, 450, 380, 600, 400 };
        String codigo[] = { "A0001", "A0002", "A0003", "A0004", "A0005", "A0006", "A0007", "A0008", "A0009", "A0010",
                "A0011", "A0012", "A0013", "A0014", "A0015" };

        for (int i = 0; i < estados.length; i++) {
            if (estados[i] == true) {
                listaProductos.add(new Producto(codigo[i], nombreProducto[i], cantidades[i], precio[i], true));

            }
        }
    }

    public void establecerDatosTabla(List<Producto> listaProductos) {
        String[][] datos = new String[listaProductos.size()][5];
        double productoTotal = 0;
        for (int i = 0; i < listaProductos.size(); i++) {
            if (listaProductos.get(i).getEstadoProducto() == true) {

                datos[i][0] = listaProductos.get(i).getCodigo();
                datos[i][1] = listaProductos.get(i).getNombreProducto();
                datos[i][2] = listaProductos.get(i).getCantidad() + "";
                datos[i][3] = listaProductos.get(i).getPrecio() + "";
                datos[i][4] = listaProductos.get(i).getPrecio() * listaProductos.get(i).getCantidad() + "";
                productoTotal = productoTotal + listaProductos.get(i).getPrecio() * listaProductos.get(i).getCantidad();
            }

        }
        SVentas.TextoCostotal.setText(productoTotal+" Soles.");
        SVentas.tablilla.setModel(new javax.swing.table.DefaultTableModel(datos, cabezera) {
            private static final long serialVersionUID = 1L;
            // Para que ningun campo sea editable
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 5) {
                    return true;
                } else {
                    return false;
                }
            }
        });

		SVentas.JEliminar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
              
                Cantidad1.setText("0");
                Cantidad1.setEditable(false);
                Producto1.setEnabled(true);
                Producto1.setSelected(false);
                estados[0] = false;

                Cantidad2.setText("0");
                Cantidad2.setEditable(false);
                Producto2.setEnabled(true);
                Producto2.setSelected(false);
                estados[1] = false;
                
                Cantidad3.setText("0");
                Cantidad3.setEditable(false);
                Producto3.setEnabled(true);
                Producto3.setSelected(false);
                estados[2] = false;
                
                Cantidad4.setText("0");
                Cantidad4.setEditable(false);
                Producto4.setEnabled(true);
                Producto4.setSelected(false);
                estados[3] = false;
                
                Cantidad5.setText("0");
                Cantidad5.setEditable(false);
                Producto5.setEnabled(true);
                Producto5.setSelected(false);
                estados[4] = false;
                
                Cantidad6.setText("0");
                Cantidad6.setEditable(false);
                Producto6.setEnabled(true);
                Producto6.setSelected(false);
                estados[5] = false;
                
                Cantidad7.setText("0");
                Cantidad7.setEditable(false);
                Producto7.setEnabled(true);
                Producto7.setSelected(false);
                estados[6] = false;
                
                Cantidad8.setText("0");
                Cantidad8.setEditable(false);
                Producto8.setEnabled(true);
                Producto8.setSelected(false);
                estados[7] = false;
                
                Cantidad9.setText("0");
                Cantidad9.setEditable(false);
                Producto9.setEnabled(true);
                Producto9.setSelected(false);
                estados[8] = false;
                
                Cantidad10.setText("0");
                Cantidad10.setEditable(false);
                Producto10.setEnabled(true);
                Producto10.setSelected(false);
                estados[9] = false;
                
                Cantidad11.setText("0");
                Cantidad11.setEditable(false);
                Producto11.setEnabled(true);
                Producto11.setSelected(false);
                estados[10] = false;
                
                Cantidad12.setText("0");
                Cantidad12.setEditable(false);
                Producto12.setEnabled(true);
                Producto12.setSelected(false);
                estados[11] = false;
                
                Cantidad13.setText("0");
                Cantidad13.setEditable(false);
                Producto13.setEnabled(true);
                Producto13.setSelected(false);
                estados[12] = false;
                

                Cantidad14.setText("0");
                Cantidad14.setEditable(false);
                Producto14.setEnabled(true);
                Producto14.setSelected(false);
                estados[13] = false;
                
                Cantidad15.setText("0");
                Cantidad15.setEditable(false);
                Producto15.setEnabled(true);
                Producto15.setSelected(false);
                estados[14] = false;
                
			}
        });
    }
    

    private void BOTONESV2() {
        JButton Aceptar = new JButton("Registrar");
        Aceptar.setBounds(170, 250, 100, 30);
        Aceptar.setForeground(new Color(0, 128, 64));
        Aceptar.setFont(new Font("Times New Roman", 3, 16));
        contentPanel.add(Aceptar);

        Aceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                  if(Cantidad1.getText().length()==0 ) {
                    JOptionPane.showMessageDialog(null, "Ingresar una cantidad aceptable", null, JOptionPane.ERROR_MESSAGE);
                  }
                  if(Cantidad2.getText().length()==0){
                    JOptionPane.showMessageDialog(null, "Ingresar una cantidad aceptable", null, JOptionPane.ERROR_MESSAGE);
                  }
                  if(Cantidad3.getText().length()==0){
                    JOptionPane.showMessageDialog(null, "Ingresar una cantidad aceptable", null, JOptionPane.ERROR_MESSAGE);
                  }
                  if(Cantidad4.getText().length()==0){
                    JOptionPane.showMessageDialog(null, "Ingresar una cantidad aceptable", null, JOptionPane.ERROR_MESSAGE);
                  }
                  if(Cantidad5.getText().length()==0){
                    JOptionPane.showMessageDialog(null, "Ingresar una cantidad aceptable", null, JOptionPane.ERROR_MESSAGE);
                  }
                  if(Cantidad6.getText().length()==0){
                    JOptionPane.showMessageDialog(null, "Ingresar una cantidad aceptable", null, JOptionPane.ERROR_MESSAGE);
                  }
                  if(Cantidad7.getText().length()==0){
                    JOptionPane.showMessageDialog(null, "Ingresar una cantidad aceptable", null, JOptionPane.ERROR_MESSAGE);
                  }
                  if(Cantidad8.getText().length()==0){
                    JOptionPane.showMessageDialog(null, "Ingresar una cantidad aceptable", null, JOptionPane.ERROR_MESSAGE);
                  }
                  if(Cantidad9.getText().length()==0){
                    JOptionPane.showMessageDialog(null, "Ingresar una cantidad aceptable", null, JOptionPane.ERROR_MESSAGE);
                  }
                  if(Cantidad10.getText().length()==0){
                    JOptionPane.showMessageDialog(null, "Ingresar una cantidad aceptable", null, JOptionPane.ERROR_MESSAGE);
                  }
                  if(Cantidad11.getText().length()==0){
                    JOptionPane.showMessageDialog(null, "Ingresar una cantidad aceptable", null, JOptionPane.ERROR_MESSAGE);
                  }
                  if(Cantidad12.getText().length()==0){
                    JOptionPane.showMessageDialog(null, "Ingresar una cantidad aceptable", null, JOptionPane.ERROR_MESSAGE);
                  }
                  if(Cantidad13.getText().length()==0){
                    JOptionPane.showMessageDialog(null, "Ingresar una cantidad aceptable", null, JOptionPane.ERROR_MESSAGE);
                  }
                  if(Cantidad14.getText().length()==0){
                    JOptionPane.showMessageDialog(null, "Ingresar una cantidad aceptable", null, JOptionPane.ERROR_MESSAGE);
                  }
                  if(Cantidad15.getText().length()==0){
                    JOptionPane.showMessageDialog(null, "Ingresar una cantidad aceptable", null, JOptionPane.ERROR_MESSAGE);
                  }
                
                if (SVentas.estadoVentana == true) {

                    estableceDatos(listaProductos);

                    establecerDatosTabla(listaProductos);
                }
                else if(SVentas.estadoVentana == false){

                    List<Producto> listaP = new ArrayList<>();
                    estableceDatos(listaP);
                    establecerDatosTabla(listaP);

                }
            
                // Para que no se dimensionen los tamaños de las seldas cabezera
                SVentas.tablilla.getColumnModel().getColumn(0).setResizable(false);
                SVentas.tablilla.getColumnModel().getColumn(1).setResizable(false);
                SVentas.tablilla.getColumnModel().getColumn(2).setResizable(false);
                SVentas.tablilla.getColumnModel().getColumn(3).setResizable(false);
                SVentas.tablilla.getColumnModel().getColumn(4).setResizable(false);

                // dispose();
                SVentas.estadoVentana = false;
                setVisible(false);

            }
        });

        JButton JTCancelar = new JButton("Cancelar");
        JTCancelar.setBounds(330, 250, 100, 30);
        JTCancelar.setForeground(new Color(237, 28, 36));
        JTCancelar.setFont(new Font("Times New Roman", 3, 16));
        contentPanel.add(JTCancelar);
        // Fucion Cancelar
        JTCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Desea cancelar el pedido?", null,
                        JOptionPane.YES_NO_OPTION) == 0) {
                    dispose();
                }
            }

        }

        );
    }

    // Seleccionar(nombre de nuestros productos) *************************************************************************************
    public void ESCOGER() {
        Producto1 = new JCheckBox("Teclado");
        Producto1.setBackground(Color.LIGHT_GRAY);
        Producto1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 
                if (Producto1.isSelected()) {
                    Cantidad1.setText("");
                    Cantidad1.setEditable(true);
                    estados[0] = true;
                    Producto1.setEnabled(false);
                } else {
                    Cantidad1.setText("");
                    Cantidad1.setEditable(false);
                }
            }
        });
        Producto1.setBounds(16, 25, 90, 23);
        Producto1.setBackground(new Color(145, 235, 221));
        contentPanel.add(Producto1);

        Producto2 = new JCheckBox("Mouse");
        Producto2.setBackground(Color.LIGHT_GRAY);
        Producto2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (Producto2.isSelected()) {
                    Cantidad2.setText("");
                    Cantidad2.setEditable(true);
                    estados[1] = true;
                    Producto2.setEnabled(false);
                } else {
                    Cantidad2.setText("");
                    Cantidad2.setEditable(false);
                }
            }
        });
        Producto2.setBounds(16, 65, 90, 23);
        Producto2.setBackground(new Color(145, 235, 221));
        contentPanel.add(Producto2);

        Producto3 = new JCheckBox("Parlante");
        Producto3.setBackground(Color.LIGHT_GRAY);
        Producto3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (Producto3.isSelected()) {
                    Cantidad3.setText("");
                    Cantidad3.setEditable(true);
                    estados[2] = true;
                    Producto3.setEnabled(false);
                } else {
                    Cantidad3.setText("");
                    Cantidad3.setEditable(false);
                }
            }
        });
        Producto3.setBounds(16, 103, 90, 23);
        Producto3.setBackground(new Color(145, 235, 221));
        contentPanel.add(Producto3);

        Producto4 = new JCheckBox("Aud\u00EDfono");
        Producto4.setBackground(Color.LIGHT_GRAY);
        Producto4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (Producto4.isSelected()) {
                    Cantidad4.setText("");
                    Cantidad4.setEditable(true);
                    estados[3] = true;
                    Producto4.setEnabled(false);
                } else {
                    Cantidad4.setText("");
                    Cantidad4.setEditable(false);
                }
            }
        });
        Producto4.setBounds(16, 142, 90, 23);
        Producto4.setBackground(new Color(145, 235, 221));
        contentPanel.add(Producto4);

        Producto5 = new JCheckBox("Auricular");
        Producto5.setBackground(Color.LIGHT_GRAY);
        Producto5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (Producto5.isSelected()) {
                    Cantidad5.setText("");
                    Cantidad5.setEditable(true);
                    estados[4] = true;
                    Producto5.setEnabled(false);
                } else {
                    Cantidad5.setText("");
                    Cantidad5.setEditable(false);
                }
            }
        });
        Producto5.setBounds(16, 183, 90, 23);
        Producto5.setBackground(new Color(145, 235, 221));
        contentPanel.add(Producto5);

        Producto6 = new JCheckBox("Cooler");
        Producto6.setBackground(Color.LIGHT_GRAY);
        Producto6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (Producto6.isSelected()) {
                    Cantidad6.setText("");
                    Cantidad6.setEditable(true);
                    estados[5] = true;
                    Producto6.setEnabled(false);
                } else {
                    Cantidad6.setText("");
                    Cantidad6.setEditable(false);
                }
            }
        });
        Producto6.setBounds(217, 27, 83, 22);
        Producto6.setBackground(new Color(145, 235, 221));
        contentPanel.add(Producto6);

        Producto7 = new JCheckBox("USB");
        Producto7.setBackground(Color.LIGHT_GRAY);
        Producto7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (Producto7.isSelected()) {
                    Cantidad7.setText("");
                    Cantidad7.setEditable(true);
                    estados[6] = true;
                    Producto7.setEnabled(false);
                } else {
                    Cantidad7.setText("");
                    Cantidad7.setEditable(false);
                }
            }
        });
        Producto7.setBounds(217, 65, 83, 22);
        Producto7.setBackground(new Color(145, 235, 221));
        contentPanel.add(Producto7);

        Producto8 = new JCheckBox("Laptop HP");
        Producto8.setBackground(Color.LIGHT_GRAY);
        Producto8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (Producto8.isSelected()) {
                    Cantidad8.setText("");
                    Cantidad8.setEditable(true);
                    estados[7] = true;
                    Producto8.setEnabled(false);
                } else {
                    Cantidad8.setText("");
                    Cantidad8.setEditable(false);
                }
            }
        });
        Producto8.setBounds(217, 103, 83, 22);
        Producto8.setBackground(new Color(145, 235, 221));
        contentPanel.add(Producto8);
        Producto9 = new JCheckBox("Tablet");
        Producto9.setBackground(Color.LIGHT_GRAY);
        Producto9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (Producto9.isSelected()) {
                    Cantidad9.setText("");
                    Cantidad9.setEditable(true);
                    estados[8] = true;
                    Producto9.setEnabled(false);
                } else {
                    Cantidad9.setText("");
                    Cantidad9.setEditable(false);
                }
            }
        });
        Producto9.setBounds(217, 142, 83, 22);
        Producto9.setBackground(new Color(145, 235, 221));
        contentPanel.add(Producto9);

        Producto10 = new JCheckBox("C\u00E1mara");
        Producto10.setBackground(Color.LIGHT_GRAY);
        Producto10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (Producto10.isSelected()) {
                    Cantidad10.setText("");
                    Cantidad10.setEditable(true);
                    estados[9] = true;
                    Producto10.setEnabled(false);
                } else {
                    Cantidad10.setText("");
                    Cantidad10.setEditable(false);
                }
            }
        });
        Producto10.setBounds(217, 183, 83, 22);
        Producto10.setBackground(new Color(145, 235, 221));
        contentPanel.add(Producto10);

        Producto11 = new JCheckBox("Micr\u00F3fono");
        Producto11.setBackground(Color.LIGHT_GRAY);
        Producto11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (Producto11.isSelected()) {
                    Cantidad11.setText("");
                    Cantidad11.setEditable(true);
                    estados[10] = true;
                    Producto11.setEnabled(false);
                } else {
                    Cantidad11.setText("");
                    Cantidad11.setEditable(false);
                }
            }
        });
        Producto11.setBounds(404, 27, 90, 23);
        Producto11.setBackground(new Color(145, 235, 221));
        contentPanel.add(Producto11);

        Producto12 = new JCheckBox("Impresora");
        Producto12.setBackground(Color.LIGHT_GRAY);
        Producto12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (Producto12.isSelected()) {
                    Cantidad12.setText("");
                    Cantidad12.setEditable(true);
                    estados[11] = true;
                    Producto12.setEnabled(false);
                } else {
                    Cantidad12.setText("");
                    Cantidad12.setEditable(false);
                }
            }
        });
        Producto12.setBounds(404, 65, 90, 23);
        Producto12.setBackground(new Color(145, 235, 221));
        contentPanel.add(Producto12);

        Producto13 = new JCheckBox("Modem");
        Producto13.setBackground(Color.LIGHT_GRAY);
        Producto13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (Producto13.isSelected()) {
                    Cantidad13.setText("");
                    Cantidad13.setEditable(true);
                    estados[12] = true;
                    Producto13.setEnabled(false);
                } else {
                    Cantidad13.setText("");
                    Cantidad13.setEditable(false);
                }
            }
        });
        Producto13.setBounds(404, 103, 90, 23);
        Producto13.setBackground(new Color(145, 235, 221));
        contentPanel.add(Producto13);

        Producto14 = new JCheckBox("Celular");
        Producto14.setBackground(Color.LIGHT_GRAY);
        Producto14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (Producto14.isSelected()) {
                    Cantidad14.setText("");
                    Cantidad14.setEditable(true);
                    estados[13] = true;
                    Producto14.setEnabled(false);
                } else {
                    Cantidad14.setText("");
                    Cantidad14.setEditable(false);
                }
            }
        });
        Producto14.setBounds(404, 142, 90, 23);
        Producto14.setBackground(new Color(145, 235, 221));
        contentPanel.add(Producto14);

        Producto15 = new JCheckBox("Monitor");
        Producto15.setBackground(Color.LIGHT_GRAY);
        Producto15.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (Producto15.isSelected()) {
                    Cantidad15.setText("");
                    Cantidad15.setEditable(true);
                    estados[14] = true;
                    Producto15.setEnabled(false);
                } else {
                    Cantidad15.setText("");
                    Cantidad15.setEditable(false);
                }
            }
        });
        Producto15.setBounds(404, 183, 90, 23);
        Producto15.setBackground(new Color(145, 235, 221));
        contentPanel.add(Producto15);

    }

    // LA CANTIDAD A INGRESAR
    public void CANTIDAD() {

        Cantidad1 = new JTextField();
        Cantidad1.setHorizontalAlignment(SwingConstants.CENTER);
        Cantidad1.setEditable(false);
        Cantidad1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char validar = e.getKeyChar();
                
                if((validar < '0' || validar > '9')){
                    e.consume();
                }
                if (Cantidad1.getText().length() >= 2) {
                    e.consume();
                }
                if (Character.isLetter(validar)) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Ingresar solo Numeros", null, JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        Cantidad1.setColumns(10);
        Cantidad1.setBounds(120, 27, 35, 22);
        Cantidad1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        contentPanel.add(Cantidad1);

        Cantidad2 = new JTextField();
        Cantidad2.setHorizontalAlignment(SwingConstants.CENTER);
        Cantidad2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char validar = e.getKeyChar();
                if((validar < '0' || validar > '9')){
                    e.consume();
                }
                if (Cantidad2.getText().length() >= 2) {
                    e.consume();
                }
                if (Character.isLetter(validar)) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Ingresar solo Numeros", null, JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        Cantidad2.setEditable(false);
        Cantidad2.setColumns(10);
        Cantidad2.setBounds(120, 65, 35, 22);
        Cantidad2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        contentPanel.add(Cantidad2);

        Cantidad3 = new JTextField();
        Cantidad3.setHorizontalAlignment(SwingConstants.CENTER);
        Cantidad3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char validar = e.getKeyChar();
                if((validar < '0' || validar > '9')){
                    e.consume();
                }
                if (Cantidad3.getText().length() >= 2) {
                    e.consume();
                }
                if (Character.isLetter(validar)) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Ingresar solo Numeros", null, JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        Cantidad3.setEditable(false);
        Cantidad3.setColumns(10);
        Cantidad3.setBounds(120, 103, 35, 22);
        Cantidad3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        contentPanel.add(Cantidad3);

        Cantidad4 = new JTextField();
        Cantidad4.setHorizontalAlignment(SwingConstants.CENTER);
        Cantidad4.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char validar = e.getKeyChar();
                if((validar < '0' || validar > '9')){
                    e.consume();
                }
                if (Cantidad4.getText().length() >= 2) {
                    e.consume();
                }
                if (Character.isLetter(validar)) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Ingresar solo Numeros", null, JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        Cantidad4.setEditable(false);
        Cantidad4.setColumns(10);
        Cantidad4.setBounds(120, 142, 35, 22);
        Cantidad4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        contentPanel.add(Cantidad4);

        Cantidad5 = new JTextField();
        Cantidad5.setHorizontalAlignment(SwingConstants.CENTER);
        Cantidad5.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char validar = e.getKeyChar();
                if((validar < '0' || validar > '9')){
                    e.consume();
                }
                if (Cantidad5.getText().length() >= 2) {
                    e.consume();
                }
                if (Character.isLetter(validar)) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Ingresar solo Numeros", null, JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        Cantidad5.setEditable(false);
        Cantidad5.setColumns(10);
        Cantidad5.setBounds(120, 183, 35, 22);
        Cantidad5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        contentPanel.add(Cantidad5);

        Cantidad6 = new JTextField();
        Cantidad6.setHorizontalAlignment(SwingConstants.CENTER);
        Cantidad6.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char validar = e.getKeyChar();
                if((validar < '0' || validar > '9')){
                    e.consume();
                }
                if (Cantidad6.getText().length() >= 2) {
                    e.consume();
                }
                if (Character.isLetter(validar)) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Ingresar solo Numeros", null, JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        Cantidad6.setEditable(false);
        Cantidad6.setColumns(10);
        Cantidad6.setBounds(314, 27, 35, 22);
        Cantidad6.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        contentPanel.add(Cantidad6);

        Cantidad7 = new JTextField();
        Cantidad7.setHorizontalAlignment(SwingConstants.CENTER);
        Cantidad7.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char validar = e.getKeyChar();
                if((validar < '0' || validar > '9')){
                    e.consume();
                }
                if (Cantidad7.getText().length() >= 2) {
                    e.consume();
                }
                if (Character.isLetter(validar)) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Ingresar solo Numeros", null, JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        Cantidad7.setEditable(false);
        Cantidad7.setColumns(10);
        Cantidad7.setBounds(314, 65, 35, 22);
        Cantidad7.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        contentPanel.add(Cantidad7);

        Cantidad8 = new JTextField();
        Cantidad8.setHorizontalAlignment(SwingConstants.CENTER);
        Cantidad8.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char validar = e.getKeyChar();
                if((validar < '0' || validar > '9')){
                    e.consume();
                }
                if (Cantidad8.getText().length() >= 2) {
                    e.consume();
                }
                if (Character.isLetter(validar)) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Ingresar solo Numeros", null, JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        Cantidad8.setEditable(false);
        Cantidad8.setColumns(10);
        Cantidad8.setBounds(314, 103, 35, 22);
        Cantidad8.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        contentPanel.add(Cantidad8);

        Cantidad9 = new JTextField();
        Cantidad9.setHorizontalAlignment(SwingConstants.CENTER);
        Cantidad9.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char validar = e.getKeyChar();
                if((validar < '0' || validar > '9')){
                    e.consume();
                }
                if (Cantidad9.getText().length() >= 2) {
                    e.consume();
                }
                if (Character.isLetter(validar)) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Ingresar solo Numeros", null, JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        Cantidad9.setEditable(false);
        Cantidad9.setColumns(10);
        Cantidad9.setBounds(314, 142, 35, 22);
        Cantidad9.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        contentPanel.add(Cantidad9);

        Cantidad10 = new JTextField();
        Cantidad10.setHorizontalAlignment(SwingConstants.CENTER);
        Cantidad10.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char validar = e.getKeyChar();
                if((validar < '0' || validar > '9')){
                    e.consume();
                }
                if (Cantidad10.getText().length() >= 2) {
                    e.consume();
                }
                if (Character.isLetter(validar)) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Ingresar solo Numeros", null, JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        Cantidad10.setEditable(false);
        Cantidad10.setColumns(10);
        Cantidad10.setBounds(314, 183, 35, 22);
        Cantidad10.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        contentPanel.add(Cantidad10);

        Cantidad11 = new JTextField();
        Cantidad11.setHorizontalAlignment(SwingConstants.CENTER);
        Cantidad11.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char validar = e.getKeyChar();
                if((validar < '0' || validar > '9')){
                    e.consume();
                }
                if (Cantidad11.getText().length() >= 2) {
                    e.consume();
                }
                if (Character.isLetter(validar)) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Ingresar solo Numeros", null, JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        Cantidad11.setEditable(false);
        Cantidad11.setColumns(10);
        Cantidad11.setBounds(508, 27, 35, 22);
        Cantidad11.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        contentPanel.add(Cantidad11);

        Cantidad12 = new JTextField();
        Cantidad12.setHorizontalAlignment(SwingConstants.CENTER);
        Cantidad12.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char validar = e.getKeyChar();
                if((validar < '0' || validar > '9')){
                    e.consume();
                }
                if (Cantidad12.getText().length() >= 2) {
                    e.consume();
                }
                if (Character.isLetter(validar)) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Ingresar solo Numeros", null, JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        Cantidad12.setEditable(false);
        Cantidad12.setColumns(10);
        Cantidad12.setBounds(508, 65, 35, 22);
        Cantidad12.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        contentPanel.add(Cantidad12);

        Cantidad13 = new JTextField();
        Cantidad13.setHorizontalAlignment(SwingConstants.CENTER);
        Cantidad13.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char validar = e.getKeyChar();
                if((validar < '0' || validar > '9')){
                    e.consume();
                }
                if (Cantidad13.getText().length() >= 2) {
                    e.consume();
                }
                if (Character.isLetter(validar)) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Ingresar solo Numeros", null, JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        Cantidad13.setEditable(false);
        Cantidad13.setColumns(10);
        Cantidad13.setBounds(508, 103, 35, 22);
        Cantidad13.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        contentPanel.add(Cantidad13);

        Cantidad14 = new JTextField();
        Cantidad14.setHorizontalAlignment(SwingConstants.CENTER);
        Cantidad14.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char validar = e.getKeyChar();
                if((validar < '0' || validar > '9')){
                    e.consume();
                }
                if (Cantidad14.getText().length() >= 2) {
                    e.consume();
                }
                if (Character.isLetter(validar)) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Ingresar solo Numeros", null, JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        Cantidad14.setEditable(false);
        Cantidad14.setColumns(10);
        Cantidad14.setBounds(508, 142, 35, 22);
        Cantidad14.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        contentPanel.add(Cantidad14);

        Cantidad15 = new JTextField();
        Cantidad15.setHorizontalAlignment(SwingConstants.CENTER);
        Cantidad15.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char validar = e.getKeyChar();
                if((validar < '0' || validar > '9')){
                    e.consume();
                }
                if (Cantidad15.getText().length() >= 2) {
                    e.consume();
                }
                if (Character.isLetter(validar)) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Ingresar solo Numeros", null, JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        Cantidad15.setEditable(false);
        Cantidad15.setColumns(10);
        Cantidad15.setBounds(508, 183, 35, 22);
        Cantidad15.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        contentPanel.add(Cantidad15);

    }

}