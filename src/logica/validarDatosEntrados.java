package logica;

public class validarDatosEntrados {
	
	

	public boolean comprobar (String valorRecibido) {
		
		if(valorRecibido.matches("^(\\d+)?([.]?\\d{0,2})?$")) {
			
			return true;
		}else {
			
			return false;
		}
	}

}
