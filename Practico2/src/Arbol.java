import java.util.ArrayList;

public class Arbol {

	private NodoArbol root;
	private int height;
	
	public Arbol() {
		this.root = null;
	}
	
	public Arbol(Integer o) {
		this.root = new NodoArbol (o);
	}
	
	public Arbol(NodoArbol raiz) {
		this.root = raiz;
	}
	
	//La complejidad del hasElem es O(log n), considerando que el arbol no va a tener forma de lista.
	//Si el arbol tiene forma de lista va a ser O(n)
	public boolean hasElem (Integer o) {
		return this.hasElem(this.root, o);
	}
	private boolean hasElem (NodoArbol raiz, Integer o) {
		if (raiz != null) {
			if (raiz.getInfo().equals(o)) {
				return true;
			}
			else if (raiz.getInfo().compareTo(o) > 0) {
				return hasElem (raiz.getIzq(), o);
			}
			else{
				return hasElem (raiz.getDer(), o);
			}
		} else
			return false;
	}
	
	public Integer getRoot(){
		if (this.root == null) 
			return null;
		else
			return this.root.getInfo();
	}
	
	public boolean isEmpty() {
		return (this.root == null);
	}
	
	//La complejidad del insert es O(log n), considerando que el arbol no va a tener forma de lista
	//Si el arbol tiene forma de lista va a ser O(n)
	public void insert(Integer o) { 
		if (this.root == null) {
			this.root = new NodoArbol(o);
		} else {
			this.insert(this.root,o);
		}
	}	
	private void insert(NodoArbol raiz, Integer o) {
		if (!raiz.getInfo().equals(o)) {
			if (raiz.getInfo().compareTo(o) > 0) {
				if (raiz.getIzq() == null) {
					raiz.setIzq(new NodoArbol(o));
				}else {
					insert(raiz.getIzq(),o);
				}
			} else {
				if (raiz.getDer() == null) {
					raiz.setDer(new NodoArbol(o));
				}else {
					insert(raiz.getDer(),o);
				}
			}
		}		
	}

	public int getHeight() {
		this.height = 0;
		getHeight(this.root, 1);
		return height;
	}
	
	private void getHeight(NodoArbol raiz, int nivel) {
        if (raiz != null) {
            getHeight(raiz.getIzq(), nivel + 1);
            getHeight(raiz.getDer(), nivel + 1);
            if (nivel > this.height) {
                this.height = nivel;
            }
        }
	}

	
	public void printPosOrder() {
		printPosOrder(this.root);
	}
	
	private void printPosOrder(NodoArbol raiz) {
		if (raiz != null) {
			if (raiz.getIzq() != null)
				printPosOrder(raiz.getIzq());
			if (raiz.getDer() != null)
				printPosOrder(raiz.getDer());
			System.out.println(raiz.getInfo());
		}
	}
	
	
	public void printPreOrder() {
		printPreOrder(this.root);
	}
	
	private void printPreOrder(NodoArbol raiz) {
		if (raiz != null) {
			System.out.println(raiz.getInfo());
			if (raiz.getIzq() != null)
				printPreOrder(raiz.getIzq());
			if (raiz.getDer() != null)
				printPreOrder(raiz.getDer());
		}		
	}
	
	
	public void printInOrder() {
		printInOrder(this.root);
	}
	
	private void printInOrder(NodoArbol raiz) {
		if (raiz != null) {
			if (raiz.getIzq() != null) 
				printInOrder(raiz.getIzq());
			System.out.println(raiz.getInfo());
			if (raiz.getDer() != null) 
				printInOrder(raiz.getDer());
		}
	}
	
	
	public Integer getMaxElem() {
        if (!this.isEmpty()) {
            NodoArbol raiz = this.root;
            while (raiz.getDer() != null) {
                raiz = raiz.getDer();
            }
           return raiz.getInfo();
        } else
        	return null;
	}
	
//	public List<Integer> getLongestBranch(){
//		
//	}
	
	
	public ArrayList<Integer> getFrontera(){
		ArrayList<Integer> lista = new ArrayList<Integer>();
		this.getFrontera(this.root,lista);
		return lista;
	}
	
	
	private void getFrontera (NodoArbol raiz, ArrayList<Integer> lista) {
		if (raiz != null) {
			if (raiz.getIzq() != null)
				getFrontera(raiz.getIzq(),lista);
			if (raiz.getDer() != null)
				getFrontera(raiz.getDer(),lista);
			if (raiz.isHoja()) {
				lista.add(raiz.getInfo());
			}
		}
	}
	
//	public List<Integer> getElemAtLevel(int i){
//	
//	}


	
}