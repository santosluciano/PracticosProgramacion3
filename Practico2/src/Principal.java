import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		Arbol arbolito = new Arbol();
		System.out.println(arbolito.getRoot());
		System.out.println(arbolito.getHeight());
		arbolito.insert(12);
		arbolito.insert(7);
		arbolito.insert(5);
		arbolito.insert(3);
		arbolito.insert(6);
		arbolito.insert(4);
		arbolito.insert(10);
		arbolito.insert(9);
		arbolito.insert(11);
		arbolito.insert(15);
		arbolito.insert(18);
		arbolito.insert(20);
		arbolito.insert(22);
		arbolito.insert(17);
		arbolito.insert(14);
		arbolito.insert(13);
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
