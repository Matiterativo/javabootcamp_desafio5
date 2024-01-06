package com.javabootcamp_desafio5;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio_1 {

	public static void main(String[] args) {
		
		final String MENSAJE_INICIO ="ANALIZADOR DE ORACION \n----------------------" ;
		final String MENSAJE_INGRESO_ORACION = "Indique la oración a evaluar (no puede ser vacía): ";
		Scanner teclado = new Scanner(System.in);
		
		System.out.println(MENSAJE_INICIO);		
		String oracion = obtenerOracion(teclado, MENSAJE_INGRESO_ORACION);
		
		System.out.println("La cantidad de palabras de la oración es: " + cantidadPalabras(oracion));
		System.out.println(hayPalabrasRepetidas(oracion) ? "Hay palabras repetidas" : "Ninguna palabra se repite");		
		System.out.println("Palabras ordenadas: \n" + Arrays.toString(ordenarPalabras(oracion)));
		System.out.println("Letras ordenadas: \n" + Arrays.toString(ordenarCaracteres(oracion)));

		teclado.close();
	}
	
	//Solicita una oracion mientras sea vacia y retorna la misma cuando el ingreso es valido
	private static String obtenerOracion(Scanner scanner, String mensajeIngreso) {
	    String oracion;
	    do {
	        System.out.println(mensajeIngreso);
	        oracion = scanner.nextLine();
	    } while (oracion.trim().isEmpty());
	    return oracion;
	}
	
	//Recibe una oracion y devuelve la cantidad de palabras que contiene
	private static int cantidadPalabras(String oracion) {	
		return oracion.trim().split("\\s+").length;		
	}
	
	//Recibe una oracion(String) y retorna true si hay palabras repetidas o false caso contrario
	private static boolean hayPalabrasRepetidas(String oracion) {
		
		String[] arregloPalabras = oracion.trim().split("\\s+");
		//Ordena el arreglo de palabras para buscar repetidas facilmente
		Arrays.sort(arregloPalabras);
		
		boolean hayRepetidas = false;						
		for (int i=1; i< arregloPalabras.length;i++) {			
			if (arregloPalabras[i].equals(arregloPalabras[i-1])) {
				hayRepetidas = true;
				break;
			}
		}	
		
		return hayRepetidas;
	}

	//Recibe una oracion (String) y retorna un arreglo con sus palabras ordenadas ascendentemente
	private static String[] ordenarPalabras(String oracion) {
		String[] arregloPalabras = oracion.trim().split("\\s+");
		Arrays.sort(arregloPalabras);		
		return arregloPalabras;		
	}
	
	//Recibe una oracion (String) y retorna un arreglo con todos los caracteres ordenados ascendentemente
	private static char[] ordenarCaracteres(String oracion) {
		char[] caracteres = oracion.replaceAll("\\s+", "").toCharArray();
		Arrays.sort(caracteres);
		return caracteres;
	}
}
