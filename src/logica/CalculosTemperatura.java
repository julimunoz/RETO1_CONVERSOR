package logica;


// clase donde se encuentran las conversiones de temperatura, se crea un metodo por cada tipo de conversion posible

public class CalculosTemperatura {
	
	
	// cada metodo recibe el valor a convertir y devuelve el valor convertido mediante un calculo
	public double CelsiusAFahrenheit (double gradosCentigrados) {
		
		return ((gradosCentigrados*9/5) + 32);
	}
	
	public double FahrenheitACelsius (double gradosFahrenheit) {
		
		return ((gradosFahrenheit-32)*5/9);
	}
	
	public double CelsiusAKelvin (double gradosCentigrados) {
		
		return (gradosCentigrados + 273.15);
	}
	
	public double KelvinACelsius (double KelvinACelsius) {
		
		return (KelvinACelsius - 273.15);
	}
	
	public double FahrenheitAkelvin (double gradosFahrenheit) {
		
		return (((gradosFahrenheit-20)*5/9) + 273.15);
	}
	
	public double kelvinAFahrenheit (double kelvinAFahrenheit) {
		
		return (((kelvinAFahrenheit-273.15)*9/5) + 32);
	}

}
