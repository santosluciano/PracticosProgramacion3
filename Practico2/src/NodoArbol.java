
public class NodoArbol {
	
	private Integer info;
	private NodoArbol izq;
	private NodoArbol der;
	
	public NodoArbol (Integer o) {
		this.info = o;
		this.izq = null;
		this.der = null;
	}
	
	public NodoArbol getIzq () {
		return this.izq;
	}
	
	public NodoArbol getDer () {
		return this.der;
	}
	
	public Integer getInfo() {
		return this.info;
	}
	
	public boolean isHoja() {
		return (this.getDer() == null && this.getIzq() == null);
	}
	
	public void setInfo (Integer o) {
		this.info = o;
	}
	
	public void setIzq (NodoArbol nodo) {
		this.izq = nodo;
	}
	
	public void setDer (NodoArbol nodo) {
		this.der = nodo;
	}

}
