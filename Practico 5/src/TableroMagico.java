
public class TableroMagico {
	
	private int[][] tablero; //Matriz tablero
	private int tamañoTablero; //Tamaño del tablero
	private int sumaFilas[]; //Arreglo que lleva el registro de sumar las filas
	private int sumaColumnas[]; //Arreglo que lleva el registro de sumar las columnas
	private int S; //Resultado que se quiere obtener al sumar filas o columnas
	private int max; //Maximo del rango de numeros disponible (1-max)
	private boolean numNoDisponible[]; //Arreglo que controla si el numero esta disponible
	                                   //para colocar en el tablero. (false disponible, true no disponible)
	
	public TableroMagico(int n, int max, int S) {
		this.tamañoTablero = n;
		this.tablero = new int[this.tamañoTablero][this.tamañoTablero];
		this.sumaFilas = new int[this.tamañoTablero];
		this.sumaColumnas = new int[this.tamañoTablero];
		this.S = S;
		this.max = max;
		this.numNoDisponible = new boolean[this.max+1]; //Es +1 para que la posicion del arreglo represente el numero en cuestion
	}
	
	//Controla si los numeros del tablero son una solucion posible, sin contemplar el rango
	//Si la suma de filas o columnas da distinto de S devuelve false
	private boolean isSolucion() {
			for (int i = 0; i < this.tamañoTablero; i++) {
				if(this.sumaFilas[i] != S || this.sumaColumnas[i] != S )
					return false;
			}
			return true;
	}
	
	//Muestra la matriz tablero por pantalla
	private void mostrarTablero() {
		for (int i = 0; i<this.tamañoTablero;i++) {
			for (int j = 0; j<this.tamañoTablero; j++) {
				System.out.print(this.tablero[i][j] + "  ");
			}
			System.out.println();
		}
	}
	

	/*verifica 	si el valor de la fila o columna sumada al proximo da mayor que la solucion
	   de ser asi devuelve true indicando que no se debe seguir por esa solucion
	  Ademas tambien verifica si el valor max*filasSinCompletar < a la S tambien devuelve true
	   debido a que ya no se podra llegar a S*/
	private boolean poda(int proxValor, int fila, int columna) {
		if (fila<this.tamañoTablero) {
			if (this.sumaFilas[fila]+proxValor > this.S 
					|| this.sumaColumnas[columna]+proxValor > this.S
					|| this.sumaColumnas[fila]+(this.max*this.tamañoTablero-fila) < this.S
					|| this.sumaColumnas[columna]+(this.max*this.tamañoTablero-columna) < this.S) 
				return true;
			else {
				return false;
			}
		}else {
			return true;
		}
	}
	
	//Verifica si el tablero tiene 0´s
	private boolean hasCeros() {
		for (int i = 0; i<this.tamañoTablero;i++) {
			for (int j = 0; j<this.tamañoTablero;j++) {
				if (this.tablero[i][j] == 0) 
					return true;
			}
		}
		return false;
	}
	
	public boolean hasSolucion() {
				if (max >= this.tamañoTablero*this.tamañoTablero)
					return this.buscarSolucion(0,0);			
				else
					return false;
	}
		
	private boolean buscarSolucion(int fila, int columna) {
		if (this.isSolucion()&&!this.hasCeros()) { //verifica si es una solucion y no tiene 0´s
			this.mostrarTablero(); //Muestra el tablero solucion
			return true;
		}else {	
			boolean solucion = false;
			boolean hayPoda = false;
			int i = 1;
			while (!solucion && !hayPoda && i<=max) {
				if (!this.numNoDisponible[i]) {
					if (this.poda(i, fila, columna)) {
						hayPoda = true;
					}
					else {
						int prox_col = 0;
						int prox_fila = 0;
						if (columna == this.tamañoTablero - 1) {
							prox_fila = fila+1;
							prox_col = 0;
						}else {
							prox_col = columna+1;
							prox_fila = fila;
						}
						this.tablero[fila][columna] = i;
						this.numNoDisponible[i] = true;
						this.sumaColumnas[columna] += i;
						this.sumaFilas[fila] += i;
						if (prox_fila <= this.tamañoTablero) {
							solucion = this.buscarSolucion(prox_fila, prox_col);
						}
						this.numNoDisponible[i] = false;
						this.tablero[fila][columna] = 0;
						this.sumaFilas[fila] -= i;
						this.sumaColumnas[columna] -= i;
					}
				}
				i++;
			}
			return solucion;
		}
	}
	
}
