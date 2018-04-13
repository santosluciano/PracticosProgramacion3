package Ejercicio;

public class Pila {
	private ListaVinculadaSimple datos;
	public Pila() {
		this.datos = new ListaVinculadaSimple();
	}
	public void apilar(Object o) {
		this.datos.insert(o);
	}
	public Object desapilar() {
		return this.datos.extract();
	}
	public boolean pilaVacia() {
		return this.datos.isEmpty();
	}
	public Object tope() {
		Object retorno = this.datos.extract();
		this.datos.insert(retorno);
		return retorno;
	}
}
