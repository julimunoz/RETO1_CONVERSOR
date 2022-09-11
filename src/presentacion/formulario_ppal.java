package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import logica.CalculosMoneda;
import logica.CalculosTemperatura;
import logica.validarDatosEntrados;

public class formulario_ppal extends JFrame implements ActionListener{

	
	private JPanel panelppal, panelconversion, panelconversionTemperatura;
	private JComboBox<String> jcbseleccionaconversor, jcbmoneda1, jcbmoneda2, jcTemperatura1, jcTemperatura2;
	private JLabel mensajeSeleccion, mensajeConversionTemperatura, mensajeConversion;
	private JButton btnIr, btnSalir, btnRegresar, btnRegresar2, btnConvertir, btnConvertir2;
	private JTextField txtMoneda1, txtMoneda2, txtTemperatura1, txtTemperatura2;
	
	public formulario_ppal()
    {
        // se establecen los parametros del formulario
        
        setTitle("CONVERSOR ALURA");       // establecemos el titulo dela ventana
        setSize(600,400);                       // establecemos el ancho y largo dela ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); // establecemos que hace cuando se presiona la x delaventana, en este caso salir
        setLocationRelativeTo(null);             // con este comando se coloca en el centro la ventana
        setLayout(null);                         // con este comando deshabilitamos el layout del form, es decir que podemos colocar los elementos donde queramos
        
        
        iniciarComponentes();
        
        
    }
	
	public void iniciarComponentes( ) {
		
		// aqui creo el panel principal
		
	    panelppal = new JPanel();   //  panel para pestaña principal
		panelppal.setLayout(null);      // se deja sin layout (distribuccion estandar de elementos)
		panelppal.setSize(600, 400);
		
		mensajeSeleccion = new JLabel("Seleccione el tipo de conversion a realizar"); // se crea la etiqueta datos,como para mostrar un mensaje gnal
		mensajeSeleccion.setBounds(100, 50, 250, 30); // se asigna posicion con respecto al panel y tamaño de etiqueta
		panelppal.add(mensajeSeleccion);           // se añade la etiqueta al panel
		
		jcbseleccionaconversor = new JComboBox<String>(new String[] { "Moneda", "Temperatura"}); // se crea un JComboBox con las opciones a elegir dentro de un array
		jcbseleccionaconversor.setBounds(200, 140, 150, 30); // se asigna posicion con respecto al panel y tamaño de etiqueta
		panelppal.add(jcbseleccionaconversor);           // se añade el comboBox al panel
		
		btnIr = new JButton("Ir");
		btnIr.setBounds(300, 260, 100, 30);
		btnIr.addActionListener(this); // se agrega un listener a el boton, para luego leer el evento click y ejecutar codigo
		panelppal.add(btnIr);           // se añade el boton al panel
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(420, 260, 100, 30);
		btnSalir.addActionListener(this); // se agrega un listener a el boton, para luego leer el evento click y ejecutar codigo
		panelppal.add(btnSalir);           // se añade el boton al panel
		
		panelppal.setVisible(true); // establezco la visibilidad del panel en true para que sea el que se cargue al cargar el formulario
		
		
		// aqui creo el panel de conversion de moneda
		
		panelconversion = new JPanel();   //  panel para pestaña principal
		panelconversion.setLayout(null);      // se deja sin layout (distribuccion estandar de elementos)
		panelconversion.setSize(600, 400);
		
		mensajeConversion = new JLabel("Seleccione el tipo de moneda que desea convertir"); // se crea la etiqueta datos,como para mostrar un mensaje gnal
		mensajeConversion.setBounds(100, 50, 350, 30); // se asigna posicion con respecto al panel y tamaño de etiqueta
		panelconversion.add(mensajeConversion);           // se añade la etiqueta al panel
		
		txtMoneda1 = new JTextField(); // se crea la caja de texto iD
		txtMoneda1.setBounds(50, 140, 100, 30);  // se asigna posicion con respecto al panel y tamaño de cuadro de texto		
		panelconversion.add(txtMoneda1);  
		
		jcbmoneda1 = new JComboBox<String>(new String[] { "Libra Esterlina", "Dolar", "Euro", "Yen", "Won", "Peso"}); // se crea un JComboBox con las opciones a elegir dentro de un array
		jcbmoneda1.setBounds(170, 140, 100, 30); // se asigna posicion con respecto al panel y tamaño de etiqueta
		panelconversion.add(jcbmoneda1);           // se añade el comboBox al panel
		
		txtMoneda2 = new JTextField(); // se crea la caja de texto iD
		txtMoneda2.setBounds(290, 140, 100, 30);  // se asigna posicion con respecto al panel y tamaño de cuadro de texto
		panelconversion.add(txtMoneda2); 
		
		jcbmoneda2 = new JComboBox<String>(new String[] { "Libra Esterlina", "Dolar", "Euro", "Yen", "Won", "Peso"}); // se crea un JComboBox con las opciones a elegir dentro de un array
		jcbmoneda2.setBounds(410, 140, 100, 30); // se asigna posicion con respecto al panel y tamaño de etiqueta
		panelconversion.add(jcbmoneda2);           // se añade el comboBox al panel
		
		btnConvertir = new JButton("Convertir");
		btnConvertir.setBounds(250, 190, 100, 30);
		btnConvertir.addActionListener(this); // se agrega un listener a el boton, para luego leer el evento click y ejecutar codigo
		panelconversion.add(btnConvertir);           // se añade el boton al panel
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(420, 260, 100, 30);
		btnRegresar.addActionListener(this); // se agrega un listener a el boton, para luego leer el evento click y ejecutar codigo
		panelconversion.add(btnRegresar);           // se añade el boton al panel
		
		panelconversion.setVisible(false); // establezco la visibilidad del panel en false
		
		// aqui creo el panel de conversion de temperatura
		
		panelconversionTemperatura = new JPanel();   //  panel para pestaña principal
		panelconversionTemperatura.setLayout(null);      // se deja sin layout (distribuccion estandar de elementos)
		panelconversionTemperatura.setSize(600, 400);
				
		mensajeConversionTemperatura = new JLabel("Seleccione el tipo de temperatura que desea convertir"); // se crea la etiqueta datos,como para mostrar un mensaje gnal
		mensajeConversionTemperatura.setBounds(100, 50, 350, 30); // se asigna posicion con respecto al panel y tamaño de etiqueta
		panelconversionTemperatura.add(mensajeConversionTemperatura);           // se añade la etiqueta al panel
				
		txtTemperatura1 = new JTextField(); // se crea la caja de texto iD
		txtTemperatura1.setBounds(50, 140, 100, 30);  // se asigna posicion con respecto al panel y tamaño de cuadro de texto
		panelconversionTemperatura.add(txtTemperatura1);  
				
		jcTemperatura1 = new JComboBox<String>(new String[] { "Celsius", "Kelvin", "Farengeiht"}); // se crea un JComboBox con las opciones a elegir dentro de un array
		jcTemperatura1.setBounds(170, 140, 100, 30); // se asigna posicion con respecto al panel y tamaño de etiqueta
		panelconversionTemperatura.add(jcTemperatura1);           // se añade el comboBox al panel
				
		txtTemperatura2 = new JTextField(); // se crea la caja de texto iD
		txtTemperatura2.setBounds(290, 140, 100, 30);  // se asigna posicion con respecto al panel y tamaño de cuadro de texto
		panelconversionTemperatura.add(txtTemperatura2); 
				
		jcTemperatura2 = new JComboBox<String>(new String[] { "Celsius", "Kelvin", "Farengeiht"}); // se crea un JComboBox con las opciones a elegir dentro de un array
		jcTemperatura2.setBounds(410, 140, 100, 30); // se asigna posicion con respecto al panel y tamaño de etiqueta
		panelconversionTemperatura.add(jcTemperatura2);           // se añade el comboBox al panel
			
		btnConvertir2 = new JButton("Convertir");
		btnConvertir2.setBounds(250, 190, 100, 30);
		btnConvertir2.addActionListener(this); // se agrega un listener a el boton, para luego leer el evento click y ejecutar codigo
		panelconversionTemperatura.add(btnConvertir2);           // se añade el boton al panel
				
		btnRegresar2 = new JButton("Regresar");
		btnRegresar2.setBounds(420, 260, 100, 30);
		btnRegresar2.addActionListener(this); // se agrega un listener a el boton, para luego leer el evento click y ejecutar codigo
		panelconversionTemperatura.add(btnRegresar2);           // se añade el boton al panel
				
		panelconversionTemperatura.setVisible(false); // establezco la visibilidad del panel en false
		
		add(panelppal);
		add(panelconversion);
		add(panelconversionTemperatura);
	}
	
	//implemento los listener, en est caso sobreescribiendo el metodo y los eventos son el click al boton
	
	@Override
	public void actionPerformed(ActionEvent e) {
				
		if(e.getSource() == btnIr) {
			
			if(jcbseleccionaconversor.getSelectedIndex() == 0) { //evaluo el index de la opcion seleccionada del combobox y hago visible el panel de la ocion seleccionada
				
				panelppal.setVisible(false);
				txtMoneda1.setText(""); // limpio los campos cuando cargo el panel
				txtMoneda2.setText("");
				panelconversion.setVisible(true);
			}else {
				
				panelppal.setVisible(false);
				txtTemperatura1.setText(""); // limpio los campos cuando cargo el panel
				txtTemperatura2.setText("");
				panelconversionTemperatura.setVisible(true);
			}
		}else if (e.getSource() == btnRegresar) { // al presinar el boton regresa al panel inicial
			
			panelconversion.setVisible(false);
			panelppal.setVisible(true);
			
		}else if (e.getSource() == btnRegresar2) {
			
			panelconversionTemperatura.setVisible(false);
			panelppal.setVisible(true);
			
		}else if (e.getSource() == btnConvertir) {
			
			
			
			validarDatosEntrados dato = new validarDatosEntrados();
			
			boolean datoEnviado = dato.comprobar(txtMoneda1.getText());
			
			if(datoEnviado) {
				
				double moneda1 = Double.parseDouble(txtMoneda1.getText()); // convierto a doble el valor introducido por el usuario que es un string
				
				int x = jcbmoneda1.getSelectedIndex(); // obtiene el index del JCombobox seleccionado, se usa para la conversion de las monedas
				int y = jcbmoneda2.getSelectedIndex(); // obtiene el index del JCombobox seleccionado,
				CalculosMoneda calculo = new CalculosMoneda(); // crea un objeto de la clase calculos
				double factorConversion = calculo.retornaValor(x, y);  //llama al metodo retornar valor del objeto creado
				double valor = moneda1*factorConversion; // multiplica el valor a convertir por el valor retornado
				DecimalFormat formato = new DecimalFormat("#.00"); //este metodo sirve para darle el numero de decimales requerido, devuelve un string
				String moneda2 = formato.format(valor); // formateo el valor a 2 decimales
				txtMoneda2.setText(moneda2);  // envio el valor obtenido a la caja de texto 2 que es el resultado de la conversion.
				
			}else {
				
				JOptionPane.showMessageDialog(this, "El formato ingresado no coincide con el requerido ###.##");
			}
			
			
		}else if (e.getSource() == btnConvertir2) {
			
			
			validarDatosEntrados dato = new validarDatosEntrados();
			
			boolean datoEnviado = dato.comprobar(txtTemperatura1.getText());
			
			if(datoEnviado) {
			
				double temperatura1 = Double.parseDouble(txtTemperatura1.getText());
				
				CalculosTemperatura calculotemp = new CalculosTemperatura(); // creo un nuevo objeto
				
				int x = jcTemperatura1.getSelectedIndex(); // obtiene el index del JCombobox seleccionado, se usa para la conversion de las temperaturas
				int y = jcTemperatura2.getSelectedIndex(); // obtiene el index del JCombobox seleccionado,
						
				if(x == y) { // si las 2 opciones seleccionadas de los combobox son iguales paso el valor del texbox 1 al 2
					
					
					txtTemperatura2.setText(txtTemperatura1.getText());  // envio el valor obtenido a la caja de texto 2 que es el resultado de la conversion.
					
					
				}else if (x == 0 && y == 1) {
					
					Double valorConvertido = calculotemp.CelsiusAKelvin(temperatura1); // llamo al metodo y le paso el valor a aconvertir que esta en el texfield 1
					
					DecimalFormat formato = new DecimalFormat("#.00"); //este metodo sirve para darle el numero de decimales requerido, devuelve un string
					String valorConvertidoString = formato.format(valorConvertido); // formateo el valor a 2 decimales
					txtTemperatura2.setText(valorConvertidoString);  // envio el valor obtenido a la caja de texto 2 que es el resultado de la conversion.
					
				}else if (x == 0 && y == 2) {
					
					Double valorConvertido = calculotemp.CelsiusAFahrenheit(temperatura1);
					
					DecimalFormat formato = new DecimalFormat("#.00"); //este metodo sirve para darle el numero de decimales requerido, devuelve un string
					String valorConvertidoString = formato.format(valorConvertido); // formateo el valor a 2 decimales
					txtTemperatura2.setText(valorConvertidoString);  // envio el valor obtenido a la caja de texto 2 que es el resultado de la conversion.
					
				}else if (x == 1 && y == 0) {
					
					Double valorConvertido = calculotemp.KelvinACelsius(temperatura1);
					
					DecimalFormat formato = new DecimalFormat("#.00"); //este metodo sirve para darle el numero de decimales requerido, devuelve un string
					String valorConvertidoString = formato.format(valorConvertido); // formateo el valor a 2 decimales
					txtTemperatura2.setText(valorConvertidoString);  // envio el valor obtenido a la caja de texto 2 que es el resultado de la conversion.
					
				}else if (x == 1 && y == 2) {
					
					Double valorConvertido = calculotemp.kelvinAFahrenheit(temperatura1);
					
					DecimalFormat formato = new DecimalFormat("#.00"); //este metodo sirve para darle el numero de decimales requerido, devuelve un string
					String valorConvertidoString = formato.format(valorConvertido); // formateo el valor a 2 decimales
					txtTemperatura2.setText(valorConvertidoString);  // envio el valor obtenido a la caja de texto 2 que es el resultado de la conversion.
					
				}else if (x == 2 && y == 0) {
					
					Double valorConvertido = calculotemp.FahrenheitACelsius(temperatura1);
					
					DecimalFormat formato = new DecimalFormat("#.00"); //este metodo sirve para darle el numero de decimales requerido, devuelve un string
					String valorConvertidoString = formato.format(valorConvertido); // formateo el valor a 2 decimales
					txtTemperatura2.setText(valorConvertidoString);  // envio el valor obtenido a la caja de texto 2 que es el resultado de la conversion.
					
				}else if (x == 2 && y == 1) {
					
					Double valorConvertido = calculotemp.FahrenheitAkelvin(temperatura1);
					
					DecimalFormat formato = new DecimalFormat("#.00"); //este metodo sirve para darle el numero de decimales requerido, devuelve un string
					String valorConvertidoString = formato.format(valorConvertido); // formateo el valor a 2 decimales
					txtTemperatura2.setText(valorConvertidoString);  // envio el valor obtenido a la caja de texto 2 que es el resultado de la conversion.
					
				}
			}else{
				
				JOptionPane.showMessageDialog(this, "El formato ingresado no coincide con el requerido ###.##");
				
			}
			
		}else if (e.getSource() == btnSalir) {
			
			// Método con 4 parámetros
	        int respuesta = JOptionPane.showConfirmDialog(null, "Esta Seguro que desea salir de la aplicacion",
	                "OK_CANCEL_OPTION", JOptionPane.OK_CANCEL_OPTION,
	                JOptionPane.INFORMATION_MESSAGE);
	        
	        if(respuesta == 0) {
	            System.exit(0);
	        }
	                   
		}
		
		
	// se agrega un listener al textfield para solo permitir ingresar numeros del 0 al 9, la tecla de borrado (backspace) y el punto
	
	txtMoneda1.addKeyListener(new KeyListener() {
		
		
		@Override
		public void keyTyped(KeyEvent e) { // evento al teclear
			
			char c = e.getKeyChar(); // convierta en caracter la tecla recibida
			//System.out.println(c);
			
			// si es diferente a digito (0-9), "." o tecla retroceso
			  if(!Character.isDigit(c) && c != e.VK_BACK_SPACE && c != '.') {
			  
			  e.consume(); // descarte lo intorducido
			  
			  }
			 
			
		}
		
		// estos 2 metodos se deben sobreescribir asi no se usen porque si no da error, ya que es una interfaz y sus metodos deben ser implementado

		@Override
		public void keyPressed(KeyEvent e) {
			
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
			
		}
		
	});
	
	
	// se agrega un listener al textfield para solo permitir ingresar numeros del 0 al 9, la tecla de borrado (backspace) y el punto
	txtTemperatura1.addKeyListener(new KeyListener() {
		
		
		@Override
		public void keyTyped(KeyEvent e) {
			
			char c = e.getKeyChar();
			System.out.println(c);
			
			
			  if(!Character.isDigit(c) && c != e.VK_BACK_SPACE && c != '.') {
			  
			  e.consume();
			  
			  }
			 
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
			
		}
		
	});
	            	    
}
	

}
