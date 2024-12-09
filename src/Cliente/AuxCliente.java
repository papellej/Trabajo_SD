package Cliente;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;
import Utilidad.*;

public class AuxCliente {
	public static void main(String[] args) {
		Scanner teclado=null;
		BufferedReader entrada = null;
		BufferedWriter salida = null;
		try(Socket s=new Socket("localhost",55555)){
			teclado=new Scanner(System.in);
			int opc;
			entrada = new BufferedReader(new InputStreamReader(s.getInputStream(),"UTF-8"));
			salida = new BufferedWriter(new OutputStreamWriter(s.getOutputStream(),"UTF-8"));
			DataOutputStream salidaDatos = new DataOutputStream(s.getOutputStream());
			do {
			System.out.println("Selecciona opcion:");
			System.out.println("1. Crear sala");
			System.out.println("2. Listar salas");
			System.out.println("3. Unirse a sala");
			System.out.println("4. Salir del servidor");

			opc=Integer.parseInt(teclado.nextLine());
			salida.write(opc+"\n");
			salida.flush();
			switch(opc){
			case 1:
				System.out.println("Introduce el nombre de sala");
				salida.write(teclado.nextLine()+"\n");
				salida.flush();
				do {
					opc=Integer.parseInt(entrada.readLine());
				}while(opc!=0 && opc!=-55555);
				break;
			case 2:
				System.out.println("Todas las salas disponibles");
				System.out.println(entrada.readLine());
				break;
			case 3:
				System.out.println("Introduce el nombre de la sala");
				salida.write(teclado.nextLine()+"\n");
				salida.flush();
				break;
			}
			opc=Integer.parseInt(entrada.readLine());
			}while(opc!=4 && opc!=-55555);
			
			if(opc==-55555) {
				System.out.println("---------Coloca los barcos----------");
				int numeroBarcos;
				do {
					System.out.println(entrada.readLine());
					mostrarMapa(entrada);
					leerBarco(salidaDatos, teclado);
					System.out.println(entrada.readLine());
					numeroBarcos = Integer.parseInt(entrada.readLine()); 
				} while (numeroBarcos > 0);
				System.out.println("---------Comienza el juego----------");
				int cod = Integer.parseInt(entrada.readLine());
				while (cod != 2) {
					if (cod == 0) {
						System.out.println("---------Tu turno---------");
						System.out.println("Leyenda: 0 desconocido, 1 barco enemigo golpeado, 2 agua");
						mostrarMapa(entrada);
						do {
							leerCasilla(salidaDatos, teclado);
						} while (Integer.parseInt(entrada.readLine()) != 1);
						System.out.println(entrada.readLine());
					} else {
						System.out.println("---------Turno del rival---------");					
						System.out.println(entrada.readLine());
						System.out.println("Leyenda: 0 agua, 1 barco aliado, 2 barco aliado golpeado");	
						mostrarMapa(entrada);
					}
					cod = Integer.parseInt(entrada.readLine());
				}				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			Util.cerrar(teclado);
		}
	}
	public static void leerBarco(DataOutputStream salidaDatos, Scanner teclado) throws IOException {
		System.out.println("Introduzca la longitud del barco a elegir: ");
		int longitud = Integer.parseInt(teclado.nextLine());
		salidaDatos.writeInt(longitud);
		salidaDatos.flush();
		System.out.println("Introduzca la fila del barco: ");
		int fila = Integer.parseInt(teclado.nextLine());
		salidaDatos.writeInt(fila-1);
		salidaDatos.flush();
		System.out.println("Introduzca la columna del barco: ");
		char columna = teclado.nextLine().charAt(0);
		int columnaNum = (int) columna - 65;
		salidaDatos.writeInt(columnaNum);
		salidaDatos.flush();
		System.out.println("Introduzca la horientacion del barco: ");
		char orientacion = teclado.nextLine().charAt(0);
		salidaDatos.writeChar(orientacion);
		salidaDatos.flush();
	}
	public static void mostrarMapa(BufferedReader entrada) throws IOException{
		for (int i = 0; i < 11; i++) {
			System.out.println(entrada.readLine());
		}
	}
	public static void leerCasilla(DataOutputStream salidaDatos, Scanner teclado) throws IOException {
		System.out.println("Introduzca la fila de la casilla a golpear: ");
		int fila = Integer.parseInt(teclado.nextLine());
		salidaDatos.writeInt(fila-1);
		salidaDatos.flush();
		System.out.println("Introduzca la columna de la casilla a golpear: ");
		char columna = teclado.nextLine().charAt(0);
		int columnaNum = (int) columna - 65;
		salidaDatos.writeInt(columnaNum);
		salidaDatos.flush();
	}
}

