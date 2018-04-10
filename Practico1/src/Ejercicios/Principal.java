package Ejercicios;

import Ejercicios.ListaVinculadaSimple.MyIterator;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListaVinculadaSimple lista1 = new ListaVinculadaSimple();
		ListaVinculadaSimple lista2 = new ListaVinculadaSimple();
		for (int i = 0; i<10 ;i++) {
			lista1.insert((int)(Math.random() * 10) + 1);
			lista2.insert((int)(Math.random() * 10) + 1);
		}
		ListaVinculadaSimple listaresultante = lista1.getListaIguales(lista2);
		System.out.println("Lista resultante de listas desordenadas");
		listaresultante.mostrarLista();
		lista1.vaciarLista();
		lista2.vaciarLista();
		for (int i = 0; i<10 ;i++) {
			lista1.insertOrdenado((int)(Math.random() * 10) + 1);
			lista2.insertOrdenado((int)(Math.random() * 10) + 1);
		}
		listaresultante = lista1.getListaIgualesOrdenadas(lista2);
		System.out.println("Lista resultante de listas ordenadas");
		listaresultante.mostrarLista();
	}

}
