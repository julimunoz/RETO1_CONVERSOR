package logica;

import java.util.Arrays;


// esta clase permite realizar la onversion entre monedas

public class CalculosMoneda {
	
	// inicializo la matriz de 5 x 5
	
	public double [][] moneda = new double [6][6];
		
	// cargo los valores de la matriz, tambien me sirve para en un futuro cargar los valores desde una pestaña

        double libraLibra = moneda[0][0] = 1;

        double libraDolar = moneda[0][1] = 1.15;

        double libraEuro = moneda[0][2] = 1.16;

        double libraYen = moneda[0][3] = 161.85;

        double libraWon = moneda[0][4] = 1578.36;

        double libraPesos = moneda[0][5] = 5140.22;

        double dolarDolar = moneda[1][1] = 1;

        double dolarEuro = moneda[1][2] = 1.01;

        double dolarYen = moneda[1][3] = 140.55;

        double dolarWon = moneda[1][4] = 1370.44;

        double dolarPesos = moneda[1][5] = 4463.33;

        double euroEuro = moneda[2][2] = 1;

        double euroYen = moneda[2][3] = 139.57;

        double euroWon = moneda[2][4] = 1360.83;

        double euroPesos = moneda[2][5] = 4431.86;

        double yenYen = moneda[3][3] = 1;

        double yenWon = moneda[3][4] = 9.75;

        double yenPesos = moneda[3][5] = 31.76;

        double wonWon = moneda[4][4] = 1;

        double wonPesos = moneda[4][5] = 3.26;

        double pesosPesos = moneda[5][5] = 1;
        
// los otors valores son los inveros de los anteriores
        double dolarLibra = moneda[1][0] = 1/libraDolar;

        double euroLibra = moneda[2][0] = 1/libraEuro;

        double yenLibra = moneda[3][0] = 1/libraYen;

        double wonLibra = moneda[4][0] = 1/libraWon;

        double pesosLibra = moneda[5][0] = 1/libraPesos;

        double euroDolar = moneda[2][1] = 1/dolarEuro;

        double yenDolar = moneda[3][1] = 1/dolarYen;

        double wonDolar = moneda[4][1] = 1/dolarWon;

        double pesosDolar = moneda[5][1] = 1/dolarPesos;

   

        double yenEuro = moneda[3][2] = 1/euroYen;

        double wonEuro = moneda[4][2] = 1/euroWon;

        double pesosEuro = moneda[5][2] = 1/euroPesos;

   

        double wonYen = moneda[4][3] = 1/yenWon;

        double pesosYen = moneda[5][3] = 1/yenPesos;

              
        double pesosWon = moneda[5][4] = 1/wonPesos;

 

     // System.out.println(Arrays.deepToString(moneda));  // este metodo sirve para imprimir el array, de la forma [[...],[...]]

     
	// metodo que retorna el valor de conversion de acuerdo a la posicion en la matriz, requiere la posicion en x y y de la matriz.
	
	public double retornaValor(int x, int y) {
		
		//busca el valor de acuerdo a la posicion en la matriz y lo retorna
		
		double valor =  moneda[x][y]; 
		
		return valor;
	}

}
