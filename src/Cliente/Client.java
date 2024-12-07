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
		Scanner ent=null;
		BufferedReader entrada;
		BufferedWriter salida;
		try(Socket s=new Socket("localhost",55555)){
			ent=new Scanner(System.in);
			int opc;
			entrada = new BufferedReader(new InputStreamReader(s.getInputStream(),"UTF-8"));
			salida = new BufferedWriter(new OutputStreamWriter(s.getOutputStream(),"UTF-8"));
			do {
			System.out.println(entrada.readLine());
			System.out.println(entrada.readLine());
			System.out.println(entrada.readLine());
			System.out.println(entrada.readLine());
			System.out.println(entrada.readLine());

			opc=Integer.parseInt(ent.nextLine());
			salida.write(opc+"\n");
			salida.flush();
			switch(opc){
			case 1:
				System.out.print(entrada.readLine());
				salida.write(ent.nextLine()+"\n");
				salida.flush();
				do {
					System.out.println(entrada.readLine());
					System.out.println(entrada.readLine());
					opc=Integer.parseInt(ent.nextLine());
					salida.write(opc+"\n");
					salida.flush();
				}while(opc!=0);
				break;
			case 2:
				System.out.println(entrada.readLine());
				System.out.println(entrada.readLine());
			case 3:
				System.out.println(entrada.readLine());
				salida.write(ent.nextLine()+"\n");
			}
			}while(opc!=4);
			//Comenzar juego
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
		}
	}
}

