import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		Arbol arbolito = new Arbol();
		System.out.print("Raiz del arbol: ");
		System.out.println(arbolito.getRoot());
		System.out.print("Altura del arbol: ");
		System.out.println(arbolito.getHeight());
		if (arbolito.isEmpty())
			System.out.println("El arbol esta vacio");
		else
			System.out.println("El arbol tiene elementos");	
		System.out.println("Inserto elementos");		
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
		System.out.println("--------------------------------------");
		System.out.print("Raiz del arbol: ");
		System.out.println(arbolito.getRoot());
		System.out.print("Altura del arbol: ");
		System.out.println(arbolito.getHeight());
		if (arbolito.isEmpty())
			System.out.println("El arbol esta vacio");
		else
			System.out.println("El arbol tiene elementos");		
		if (arbolito.hasElem(1)) {
			System.out.println("encontre el numero 1");
		}else {
			System.out.println("No encontre numero 1");
			System.out.println("inserto el numero 1");
			arbolito.insert(1);
		}
		if (arbolito.hasElem(1)) {
			System.out.println("encontre el numero 1");
		}else {
			System.out.println("No encontre el numero 1");
		}
		System.out.print("El maximo elemento del arbolito es: ");
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
