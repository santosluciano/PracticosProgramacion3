package Ejercicio;
import java.util.Iterator;


public class ListaVinculadaSimple implements Iterable<Object> {
	
	//Atributos
	protected Nodo first;
	protected Nodo ultimo;
	private int cantidad;
	
	public class MyIterator implements Iterator<Object>{
		
		private Nodo cursor;
		
		@Override
		public boolean hasNext() {
			return cursor !=  null;
		}

		@Override
		public Object next() {
			Nodo tmp = cursor;
			cursor = cursor.getNext();
			return tmp.getInfo();
		}
		public void remove() {
			
		}
		private MyIterator (Nodo first) {
			cursor = first;
		}
		
	}
	//Constructor de la clase
	public ListaVinculadaSimple() {
		this.first = null;
		this.cantidad = 0;
		this.ultimo = null;
	}	
	//Inserta un nodo al principio de la lista
	public void insert(Object o) {
		Nodo tmp = new Nodo(o,null);
		tmp.setNext(first);
		first = tmp;
		if (ultimo == null)
			ultimo = first;
		this.cantidad++;
	}
	//Inserta un entero de manera ordenada en la lista, si esta repetido no lo inserta
	public void insertOrdenado(Object o) {
		if (first == null) 
			this.insert(o);
		else if ((int)first.getInfo() > (int)o)
			this.insert(o);
		else {
			Nodo cursor = first;
			while (cursor.getNext() != null && cursor.getInfo()!=o && cursor.getNext().getInfo() != o) {
				if ((int)cursor.getNext().getInfo() > (int)o) {
					Nodo tmp = new Nodo(o,cursor.getNext());
					cursor.setNext(tmp);
					cantidad++;
					break;
				}
				cursor = cursor.getNext();
			}
			if ((cursor.getNext() == null && cursor.getInfo()!=o))
				this.add(o);
		}
	}
	/*Recibe una lista de enteros desordenada y retorna una lista ordenada con los 
	elementos comunes entre la lista actual y la lista pasada por parametro*/
	public ListaVinculadaSimple getListaIguales(ListaVinculadaSimple lista1) {
		ListaVinculadaSimple listaretorno = new ListaVinculadaSimple();
		MyIterator iterator1 = this.iterator();
		int o;
		while (iterator1.hasNext()) {
			o = (int)iterator1.next();
			MyIterator iterator2 = lista1.iterator();
			while (iterator2.hasNext()) {
				if ((int)iterator2.next() == o) {
					listaretorno.insertOrdenado(o);
					break;
				}
			}
		} 
		return listaretorno;
	}
	/*Recibe una lista de enteros ordenada y retorna una lista ordenada con los 
	elementos comunes entre la lista actual y la lista pasada por parametro*/
	public ListaVinculadaSimple getListaIgualesOrdenadas(ListaVinculadaSimple lista1) {
		ListaVinculadaSimple listaretorno = new ListaVinculadaSimple();
		MyIterator iterator1 = this.iterator();
		int o;
		while (iterator1.hasNext()) {
			o = (int)iterator1.next();
			MyIterator iterator2 = lista1.iterator();
			while (iterator2.hasNext()) {
				int tmp = (int)iterator2.next();
				if ( tmp == o) {
					listaretorno.insertOrdenado(o);
					break;
				} else if (tmp > o) {
					break;
				}
			}
		} 
		return listaretorno;
	}
	//Agrega nodo al final de la lista
	public void add(Object o) {
		Nodo tmp = new Nodo(o,null);
		if (ultimo!=null) {
			ultimo.setNext(tmp);
			ultimo = tmp;
		}else {
			ultimo = tmp;
			first = tmp;
		}
		this.cantidad++;	
	}
	//Elimina el primer nodo y devuelve su informacion
	public Object extract() {
		Object info = null;
		if (!this.isEmpty()) {
			info = this.first.getInfo();
			this.first = this.first.getNext();
			this.cantidad--;
		}
		return info;
	}
	//Imprime el nodo que se encuentra en esa posicion
    public void print(int n) {
	    if (!isEmpty()&&n<this.size()) {
	        Nodo tmp = first;
	        for (int i = 0; i < n; i++) {
	            tmp=tmp.getNext();
	            if (tmp == null)
	                return; 
	        }
	        System.out.println(tmp.getInfo());
	    }
    }
	//true si esta vacia, sino false
	public boolean isEmpty() {
		return (this.size() == 0);
	}
	//Devuelve la cantidad de elementos de la lista
	public int size() {
		return this.cantidad;
	}
	//Resetea el cursor
	@Override
	public MyIterator iterator() {
		return new MyIterator(first);
	}
	//Vacia la lista
	public void vaciarLista() {
		this.first = null;
	}	
	public void mostrarLista() {
		MyIterator iterador = this.iterator();
		while (iterador.hasNext())
			System.out.print(" - " + iterador.next());
		System.out.println(" - ");
	}	
}
