
public class TableroMagico {
	
	private int[][] tablero;
	private int tamañoTablero;
	private int sumaFilas[];
	private int sumaColumnas[];
	private int S;
	private int max;
	private boolean disponibles[];
	
	public TableroMagico(int n, int max, int S) {
		this.tamañoTablero = n;
		this.tablero = new int[this.tamañoTablero][this.tamañoTablero];
		this.sumaFilas = new int[this.tamañoTablero];
		this.sumaColumnas = new int[this.tamañoTablero];
		this.S = S;
		this.max = max;
		this.disponibles = new boolean[this.max+1];
	}
	
	private boolean isSolucion() {
			for (int i = 0; i < this.tamañoTablero; i++) {
				if(this.sumaFilas[i] != S || this.sumaColumnas[i] != S )
					return false;
			}
			return true;
	}
	
	public void mostrarTablero() {
		for (int i = 0; i<this.tamañoTablero;i++) {
			for (int j = 0; j<this.tamañoTablero; j++) {
				System.out.print(this.tablero[i][j] + " - ");
			}
			System.out.println();
		}
	}
	
	private boolean poda(int proxValor, int fila, int columna) {
		if (fila<this.tamañoTablero) {
			if (this.sumaFilas[fila]+proxValor > this.S || this.sumaColumnas[columna]+proxValor > this.S) 
				return true;
			else {
				return false;
			}
		}else {
			return true;
		}
	}
	
	private boolean hasCeros() {
		for (int i = 0; i<this.tamañoTablero;i++) {
			for (int j = 0; j<this.tamañoTablero;j++) {
				if (this.tablero[i][j] == 0) 
					return true;
			}
		}
		return false;
	}
	
	public boolean back() {
		if (this.tamañoTablero == 1) 
			if (S <= max) {
				this.tablero[0][0] = S;
				this.mostrarTablero();
				return true;
			}	
			else
				return false;
		else 
			{
			if (max >= this.tamañoTablero*this.tamañoTablero)
				return this.backtracking(0, 0);			
			else
				return false;
			}
	}
		
	private boolean backtracking(int fila, int columna) {
//		System.out.println("---------------------------------");
//		this.mostrarTablero();
//		System.out.println("---------------------------------");
		if (this.isSolucion()&&!this.hasCeros()) {
			this.mostrarTablero();
			return true;
		}else {	
			boolean solucion = false;
			boolean hayPoda = false;
			int i = 1;
			while (!solucion && !hayPoda && i<=max) {
				if (!this.disponibles[i]) {
					if (this.poda(i, fila, columna)) {
						hayPoda = true;
					}
					else {

     					//Luego de insertar un numero, realiza la recursion (backtracking)
//						encontroSolucion = (proximaFila == cantidadFC || proximaFila == cantidadFC) ? false : backTrackingTablero(proximaFila, proximaColumna); 
						//Luego vuelvo a la situacion inicial
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
						this.disponibles[i] = true;
						this.sumaColumnas[columna] += i;
						this.sumaFilas[fila] += i;
						if (prox_fila <= this.tamañoTablero) {
							solucion = this.backtracking(prox_fila, prox_col);
						}
						this.disponibles[i] = false;
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
