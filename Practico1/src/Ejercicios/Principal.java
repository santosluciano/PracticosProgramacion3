package Ejercicios;

import Ejercicios.ListaVinculadaSimple.MyIterator;

public class Principal {

	public static void main(String[] args) {
		//Se crean dos listas
		ListaVinculadaSimple lista1 = new ListaVinculadaSimple();
		ListaVinculadaSimple lista2 = new ListaVinculadaSimple();
		//Se llena la lista con numeros aleatorios desordenados
		for (int i = 0; i<10 ;i++) {
			lista1.insert((int)(Math.random() * 10) + 1);
			lista2.insert((int)(Math.random() * 10) + 1);
		}
		//Se llama a la funcion getListaIguales para listas desordenadas y se guarda el puntero
		//a la nueva lista en listaresultante
		ListaVinculadaSimple listaresultante = lista1.getListaIguales(lista2);
		System.out.println("Lista resultante de listas desordenadas");
		//Se muestra la lista resultante con los numeros en comun de manera ordenada
		listaresultante.mostrarLista();
		//Se vacian las dos listas creadas anteriormente
		lista1.vaciarLista();
		lista2.vaciarLista();
		//Se insertan numeros aleatorios en las dos listas de manera ordenada
		for (int i = 0; i<10 ;i++) {
			lista1.insertOrdenado((int)(Math.random() * 10) + 1);
			lista2.insertOrdenado((int)(Math.random() * 10) + 1);
		}
		//Se llama a la funcion getListaIgualesOrdenadas para listas ordenadas y se guarda el puntero
		//a la nueva lista en listaresultante
		listaresultante = lista1.getListaIgualesOrdenadas(lista2);
		System.out.println("Lista resultante de listas ordenadas");
		//Se muestra la lista resultante con los numeros en comun de manera ordenada
		listaresultante.mostrarLista();
	}

}
