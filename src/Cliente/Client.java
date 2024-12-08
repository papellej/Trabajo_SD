package Cliente;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
		}
	}
}

