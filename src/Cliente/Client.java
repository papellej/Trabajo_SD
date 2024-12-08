package Cliente;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
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
			System.out.println(entrada.readLine());
			System.out.println(entrada.readLine());
			System.out.println(entrada.readLine());
			System.out.println(entrada.readLine());
			System.out.println(entrada.readLine());

			opc=Integer.parseInt(teclado.nextLine());
			salida.write(opc+"\n");
			salida.flush();
			switch(opc){
			case 1:
				System.out.print(entrada.readLine());
				salida.write(teclado.nextLine()+"\n");
				salida.flush();
				do {
					System.out.println(entrada.readLine());
					System.out.println(entrada.readLine());
					System.out.println(entrada.readLine());
					opc=Integer.parseInt(teclado.nextLine());
					salida.write(opc+"\n");
					salida.flush();
				}while(opc!=0);
				break;
			case 2:
				System.out.println(entrada.readLine());
				System.out.println(entrada.readLine());
			case 3:
				System.out.println(entrada.readLine());
				salida.write(teclado.nextLine()+"\n");
			}
			}while(opc!=4);
			opc=Integer.parseInt(entrada.readLine());
			if(opc==-55555) {
				System.out.println("Coloca los barcos");
				int numeroBarcos;
				do {
					System.out.println(entrada.readLine());
					System.out.println("Introduzca la longitud del barco a elegir: ");
					int longitud = Integer.parseInt(teclado.nextLine());
					salidaDatos.writeInt(longitud);
					salidaDatos.flush();
					System.out.println("Introduzca la fila del barco: ");
					int fila = Integer.parseInt(teclado.nextLine());
					salidaDatos.writeInt(fila);
					salidaDatos.flush();
					System.out.println("Introduzca la columna del barco: ");
					int columna = Integer.parseInt(teclado.nextLine());
					salidaDatos.writeInt(columna);
					salidaDatos.flush();
					System.out.println("Introduzca la horientacion del barco: ");
					char orientacion = teclado.nextLine().charAt(0);
					salidaDatos.writeChar(orientacion);
					salidaDatos.flush();
					System.out.println(entrada.readLine());
					numeroBarcos = Integer.parseInt(entrada.readLine()); 
				} while (numeroBarcos > 0);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
		}
	}
}

