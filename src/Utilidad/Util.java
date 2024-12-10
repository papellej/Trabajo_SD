package Utilidad;

import java.io.Closeable;
import java.io.IOException;
import java.util.Scanner;

public class Util {
	public static void cerrar(Closeable closeable) {
		if (closeable != null ) {
			try {
				closeable.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static int tryParseInt(Scanner teclado, String mensaje) {
		int aux = -1;
		do {
			try {
				System.out.println(mensaje);
				aux = Integer.parseInt(teclado.nextLine());
			} catch(NumberFormatException e) {
				System.out.println("No se ha introducido un valor valido");
				aux = -1;
			}
		} while(aux == -1);
		return aux;
	}
	public static int tryParseInt(Scanner teclado) {
		int aux = -1;
		do {
			try {
				aux = Integer.parseInt(teclado.nextLine());
			} catch(NumberFormatException e) {
				System.out.println("No se ha introducido un valor valido");
				aux = -1;
			}
		} while(aux == -1);
		return aux;
	}
}
