package Ejercicios;

public class Nodo {
	//Atributos
	private Object info;
	private Nodo next;
	//Constructor vacio de la clase
	public Nodo() {
		this.info = null;
		this.next = null;
	}
	//Constructor con datos de la clase
	public Nodo(Object o, Nodo n) {
		setInfo(o);
		setNext(n);
	}
	//Sets and Gets
	public void setInfo(Object o) {
		this.info = o;
	}
	
	public void setNext(Nodo n) {
		next = n;
	}
	
	public Object getInfo() {
		return info;
	}
	
	public Nodo getNext() {
		return next;
	}
}
