import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class SVentas extends JFrame implements Printable{

	public static Ventana2 v2;
	public static boolean estadoVentana;// true la segunda ventana está activa, false está oculta

	// string´s para capturar la informacion
	private String direccion;
	private String nombre;
	private String cedula;
	private String telefono;
	private String CostoTotal;
	
	private JTextField TextoDireccion;
	private JTextField TextoNombre;
	private JTextField TextoCedula;
	private JTextField TextoTelefono;
    public static JTextField TextoCostotal;
	private JLabel Etiqueta1;
	private JLabel JLDatos;
	private JLabel JLNombre;
	private JLabel JLDireccion;
	private JLabel JLCedula;
	private JLabel JLTelefono;
	private JLabel JLLista;
    private JLabel JLcostotal;
	public static JButton JAgregar,JEliminarpro,JGuardar,JEliminar,JImprimir;
	private JPanel panel;
	public static JTable tablilla;
	DefaultTableModel modelo;
	
	String [] cabezera = {"CODIGO","PRODUCTO","CANTIDAD","PRECIO U.","PRECIO T"};  
	String [][] datos;

	public SVentas() {
		v2 = new Ventana2();
		v2.getContentPane().setBackground(new Color(145,235,221));
		//Componentes de la ventana
		JFrame ventana = new JFrame("Ventana");
		ventana.getContentPane().setBackground(new Color(145,235,221));
		//ventana.setIconImage();
		ventana.setSize(800, 600);
		ventana.setLocationRelativeTo(null);
		ventana.setResizable(false);
		ventana.getContentPane().setLayout(null);
		
		BOTONES(ventana);
		JTEXTFIELD(ventana);
		JLABEL(ventana);
		JTABLEPANEL(ventana);
		
		//Se crea la ventana con todas las funciones agregadas
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//CREAMOS LOS BOTONES
	public void BOTONES(JFrame ventana) {
		JAgregar = new JButton(new ImageIcon("D:\\SVentas\\Images\\Agregar.png"));
       
		JAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				v2.setVisible(true);

			}
		});

		JAgregar.setBounds(668, 201, 39, 39);
		ventana.getContentPane().add(JAgregar);
		
		JEliminarpro = new JButton(new ImageIcon("D:\\SVentas\\Images\\Editar.png"));		
		JEliminarpro.setBounds(668, 312, 39, 39);
		ventana.getContentPane().add(JEliminarpro);
		
		JEliminarpro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int item = tablilla.getSelectedRow();
				if(item >= 0){

					DefaultTableModel tm = (DefaultTableModel) tablilla.getModel();
				
					tm.removeRow(tablilla.getSelectedRow());
					
				}else{
					JOptionPane.showMessageDialog(null, "Seleccione un producto", null, JOptionPane.ERROR_MESSAGE);
				}
                	
			}
		});

		JEliminar = new JButton(new ImageIcon("D:\\SVentas\\Images\\Eliminar.png"));
		JEliminar.setBounds(480, 470, 75, 76);
		ventana.getContentPane().add(JEliminar);

		JEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				TextoDireccion.setText("");
				TextoNombre.setText("");
				TextoCedula.setText("");
				TextoTelefono.setText("");
				datos = new String [0][0];
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
				SVentas.TextoCostotal.setText("");
				
			}
		});

		// creación del botón guardar
		JGuardar = new JButton(new ImageIcon("Images\\Guardar.png"));
		JGuardar.setBounds(344, 470, 75, 76);
		ventana.getContentPane().add(JGuardar);

		// evento al clickear "guardar"
		JGuardar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// obtiene y guarda la información
				direccion = TextoDireccion.getText();
				nombre = TextoNombre.getText();
				cedula = TextoCedula.getText();
				telefono = TextoTelefono.getText();
				CostoTotal = TextoCostotal.getText();

				// función para la creación del .txt
				GenerarTXT(e);

			}

		});

		JImprimir = new JButton(new ImageIcon("D:\\SVentas\\Images\\Imprimir.png"));
		JImprimir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				jButtonActionPerformed(e);

			}
		});
		JImprimir.setBounds(208, 470, 75, 76);
		JImprimir.setBackground(new Color(145, 235, 221));
		ventana.getContentPane().add(JImprimir);
	  }


       // guardando datos... *********************************************************************************************************
	private void GenerarTXT(ActionEvent e) {

		try {
			BufferedWriter Mitxt = new BufferedWriter(new FileWriter("Boleta.txt"));

			Mitxt.write("\t\t\tSISTEMA DE PEDIDO");
			Mitxt.newLine();
			Mitxt.newLine();
			Mitxt.write("Datos del cliente");
			Mitxt.newLine();
			Mitxt.newLine();
			Mitxt.write("\tNombre:\t" + nombre);
			Mitxt.newLine();
			Mitxt.write("\tDireccion:\t" + direccion);
			Mitxt.newLine();
			Mitxt.write("\tDNI/RUC:\t" + cedula);
			Mitxt.newLine();
			Mitxt.write("\tTelefono:\t" + telefono);
			Mitxt.newLine();
			Mitxt.newLine();
			Mitxt.write("Lista de Productos");
			Mitxt.newLine();
			Mitxt.newLine();
			Mitxt.write("Codigo\t\tProducto\tCantidadt\tPrecio U.\tPrecio T.");
			Mitxt.newLine();

			// guardando tablilla...
			for (int i = 0; i < tablilla.getRowCount(); i++) {

				Mitxt.write(tablilla.getValueAt(i, 0).toString() + "\t\t");
				Mitxt.write(tablilla.getValueAt(i, 1).toString() + "\t\t");
				Mitxt.write(tablilla.getValueAt(i, 2).toString() + "\t\t");
				Mitxt.write(tablilla.getValueAt(i, 3).toString() + "\t\t");
				Mitxt.write(tablilla.getValueAt(i, 4).toString() + "\t\t");
				Mitxt.newLine();

			}
			Mitxt.newLine();
			Mitxt.write("Total a pagar:\t"+CostoTotal);
			Mitxt.close();

			// mensaje mostrado tras haber guardado
			switch (JOptionPane.showConfirmDialog(null, "Desea mostrar .txt?", "Guardado!",
					JOptionPane.OK_CANCEL_OPTION)) {

				case 0:
					// función para mostrar datos
					abrirarchivo("Boleta.txt"); // se muestra el nombre del archivo con el cual será creado y se
												// guardará dentro de esta misma carpeta (no cambien esto prros 
												//atentamente Iber -_- )						
					break;
				case 2:
					dispose();
					break;
			}

		} catch (Exception x) {
			JOptionPane.showMessageDialog(null, "Error");
		}

	}

	// Mostrando informacion guardada...
	public void abrirarchivo(String archivo) {

		try {

			File objetofile = new File(archivo);
			Desktop.getDesktop().open(objetofile);

		} catch (IOException ex) {

			System.out.println(ex);

		}

	}
		//Funcion que designará el hecho de lo que se ejecutará el boton

	    private void jButtonActionPerformed(ActionEvent e){
			PrinterJob job  = PrinterJob.getPrinterJob();
			job.setPrintable((Printable)this);
			if(job.printDialog()){
		try{
			 job.print();

		}catch(PrinterException ex){
			Logger.getLogger(SVentas.class.getName()).log(Level.SEVERE, null, ex);
		}
	   }else{
		   JOptionPane.showMessageDialog(this, "La impresion se cancelo");
	   }
	}
	
	//Funcion de impresora *****************************************************************************************************
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) {
		if(pageIndex > 0){
			return NO_SUCH_PAGE;
		}

		Graphics2D g2d = (Graphics2D)graphics;
		g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
		panel.printAll(graphics);

		return PAGE_EXISTS;
	}
	
	//CREAMOS LOS TEXTOS
	public void JTEXTFIELD(JFrame ventana) {
		
		TextoDireccion = new JTextField();
		TextoDireccion.setBounds(137, 118, 272, 20);
		TextoDireccion.setColumns(10);
		ventana.getContentPane().add(TextoDireccion);
		
		
		TextoNombre = new JTextField();
		TextoNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char valida = e.getKeyChar();
				if((valida < 'a' || valida > 'z')){
					e.consume();
				}
				if(Character.isDigit(valida)) {
					ventana.getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "Ingresar solo letras");
				}
			}
		});
		TextoNombre.setBounds(137, 80, 272, 20);
		TextoNombre.setColumns(10);
		ventana.getContentPane().add(TextoNombre);

		TextoCedula = new JTextField();
		TextoCedula.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent evt){
			   char valida2 = evt.getKeyChar();
			   if((valida2 < '0' || valida2 > '9')){
				evt.consume();
			}
			   if(Character.isLetter(valida2)){
			   evt.consume();
			   JOptionPane.showMessageDialog(null, "Ingrese solo numeros");
			  }
			  if(TextoCedula.getText().length() > 10){
				evt.consume();
				JOptionPane.showMessageDialog(null, "Ingrese solo 11 numeros");
			  }

			}
			
		});
		TextoCedula.setBounds(616, 78, 124, 20);
		TextoCedula.setColumns(10);
		ventana.getContentPane().add(TextoCedula);
		
		TextoTelefono = new JTextField();
		TextoTelefono.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent evt){
			  char valida3 = evt.getKeyChar();
			   if((valida3 < '0' || valida3 > '9')){
				evt.consume();
			   if(Character.isLetter(valida3)){
			   evt.consume();
			   JOptionPane.showMessageDialog(null, "Ingrese solo numeros");
			   }
			   if(TextoTelefono.getText().length() > 8){
				evt.consume();
				JOptionPane.showMessageDialog(null, "Ingrese solo 9 numeros");
			  }
		 	}
		   }
		});
		TextoTelefono.setBounds(616, 118, 124, 20);
		TextoTelefono.setColumns(10);
		ventana.getContentPane().add(TextoTelefono);

        TextoCostotal = new JTextField();
		TextoCostotal.setBounds(455, 390, 124, 20);
		TextoCostotal.setColumns(10);
        TextoCostotal.setEditable(false);
		TextoCostotal.setHorizontalAlignment(SwingConstants.CENTER);
		TextoCostotal.setBorder(BorderFactory.createLineBorder(Color.black));
		ventana.getContentPane().add(TextoCostotal);
	} 
	
	//CREAMOS LAS ETIQUETAS 
	public void JLABEL(JFrame ventana) {
		Etiqueta1 = new JLabel("SISTEMA DE PEDIDO");
		Etiqueta1.setBounds(307, 11, 198, 34);
		Etiqueta1.setFont(new Font("Tahoma", Font.BOLD, 15));
		Etiqueta1.setHorizontalAlignment(SwingConstants.CENTER);
		ventana.getContentPane().add(Etiqueta1);
		
		JLDatos = new JLabel("Datos del cliente");
		JLDatos.setBounds(51, 51, 124, 18);
		JLDatos.setHorizontalAlignment(SwingConstants.CENTER);
		JLDatos.setFont(new Font("Tahoma", Font.BOLD, 13));
		ventana.getContentPane().add(JLDatos);
		
		JLNombre = new JLabel("Nombre: ");
		JLNombre.setBounds(51, 80, 75, 17);
		JLNombre.setHorizontalAlignment(SwingConstants.CENTER);
		ventana.getContentPane().add(JLNombre);
		
		JLDireccion = new JLabel("Direcci\u00F3n: ");
		JLDireccion.setBounds(51, 120, 75, 17);
		JLDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		ventana.getContentPane().add(JLDireccion);
		
		JLCedula = new JLabel("DNI / RUC: ");
		JLCedula.setBounds(531, 80, 75, 17);
		JLCedula.setHorizontalAlignment(SwingConstants.CENTER);
		ventana.getContentPane().add(JLCedula);
		
		JLTelefono = new JLabel("Tel\u00E9fono: ");
		JLTelefono.setBounds(531, 120, 75, 17);
		JLTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		ventana.getContentPane().add(JLTelefono);
		
		JLLista = new JLabel("Lista de Productos");
		JLLista.setBounds(33, 170, 138, 20);
		JLLista.setFont(new Font("Tahoma", Font.BOLD, 13));
		JLLista.setHorizontalAlignment(SwingConstants.CENTER);
		ventana.getContentPane().add(JLLista);

        //Creacion de la subcabecera del precio total a pagar
		JLcostotal = new JLabel("Total a pagar : ");
		JLcostotal.setBounds(35, 390, 138, 20);
		JLcostotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		JLcostotal.setHorizontalAlignment(SwingConstants.CENTER);
		ventana.getContentPane().add(JLcostotal);
	}
	
	//SE CREA LA TABLILLA Y SE LE AGREGA ALGUNOS COMPONENTES
	public void JTABLEPANEL(JFrame ventana) {
		panel = new JPanel();
		panel.setBounds(43, 201, 533, 183);
		ventana.getContentPane().add(panel);
		
		//Creacion de la Tabla
		modelo = new DefaultTableModel(datos,cabezera){
			@Override
			public boolean isCellEditable(int row, int column) {
				if(column==5){
					return true;
				}else{
					return false;
				}
			}
		};
		tablilla = new JTable(modelo);
		tablilla.setBorder(BorderFactory.createLineBorder(Color.black));
		tablilla.getTableHeader().setReorderingAllowed(false); 
		tablilla.setBackground(Color.WHITE);

		panel.setLayout(new GridLayout(0, 1, 0, 0));
		JScrollPane Ruedita = new JScrollPane(tablilla);
		panel.add(Ruedita);
		
		JLabel JLAgregar = new JLabel("Agregar");
		JLAgregar.setHorizontalAlignment(SwingConstants.CENTER);
		JLAgregar.setFont(new Font("Times New Roman", Font.BOLD, 14));
		JLAgregar.setBounds(639, 251, 101, 18);
		ventana.getContentPane().add(JLAgregar);

		JLabel JLEditar = new JLabel("y/o editar");
		JLEditar.setHorizontalAlignment(SwingConstants.CENTER);
		JLEditar.setFont(new Font("Times New Roman", Font.BOLD, 14));
		JLEditar.setBounds(639, 266, 101, 18);
		ventana.getContentPane().add(JLEditar);
		
		JLabel JLQuitar = new JLabel("Eliminar");
		JLQuitar.setHorizontalAlignment(SwingConstants.CENTER);
		JLQuitar.setFont(new Font("Times New Roman", Font.BOLD, 14)); 
		JLQuitar.setBounds(639, 360, 101, 18);
		ventana.getContentPane().add(JLQuitar);
	}
    public static void main(String[] args) {
        new SVentas();
    }

}