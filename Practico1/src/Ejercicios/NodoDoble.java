package Ejercicios;

public class NodoDoble extends Nodo{
	private Nodo prev;
	
	public NodoDoble() {
		super();
		this.prev = null;
	}
	public NodoDoble(Object o, Nodo n) {
		super(o,n);
	}
	public void setPrev(Nodo n) {
		this.prev = n;
	}
	public Nodo getPrev() {
		return this.prev;
	}
}
