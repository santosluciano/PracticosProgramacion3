import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		Arbol arbolito = new Arbol();
		arbolito.insert(2);
		arbolito.insert(8);
		arbolito.insert(1);
		arbolito.insert(3);
		if (arbolito.isEmpty())
			System.out.println("esta vacio");
		else
			System.out.println("tiene elementos");
		System.out.println(arbolito.getHeight());
		if (arbolito.hasElem(1)) {
			System.out.println("encontre el numero");
		}
		System.out.println("El maximo elemento del arbolito es");
		System.out.println(arbolito.getMaxElem());
		System.out.println("Arbol post order");
		arbolito.printPosOrder();
		System.out.println("Arbol pre order");
		arbolito.printPreOrder();
		System.out.println("Arbol in order");
		arbolito.printInOrder();
		ArrayList<Integer> listado = arbolito.getFrontera();
		System.out.println("Frontera del arbol");
		for (Integer elemento:listado) {
			System.out.println(elemento);
		}
		
	}

}
