package Servidor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;

import Juego.Partida;

public class AtenderPeticion implements Runnable {

	public static ConcurrentHashMap<String,Socket> salas= new ConcurrentHashMap<String,Socket>();
	private Socket s;
	
	public AtenderPeticion(Socket s) {
		this.s=s;
	}
	
	
	@Override
	public void run() {
		int opc;
		Socket sala=null;
		BufferedReader entrada = null;
		BufferedWriter salida = null;
		try {
			entrada = new BufferedReader(new InputStreamReader(s.getInputStream(),"UTF-8"));
			salida = new BufferedWriter(new OutputStreamWriter(s.getOutputStream(),"UTF-8"));
			do {
				//Codigo en servidor
				salida.write("Selecciona opcion: \n");
				salida.write("1. Crear sala\n");
				salida.write("2. Listar salas\n");
				salida.write("3. Unirse a sala\n");
				salida.write("4. Salir del servidor\n");
				salida.flush();
				System.out.println(salas);
				opc=Integer.parseInt(entrada.readLine());
				switch(opc){
				case 1:
					salida.write("Introduce el nombre de sala\n");
					salida.flush();
					String nombreSala=entrada.readLine();
					salas.put(nombreSala,s);
					do {
						salida.write("Esperando a que se unan a la sala\n");
						salida.write("1. Actualizar sala(Comprobar si se han unido)\n");
						salida.write("0. Salir de la sala\n");
						salida.flush();
						System.out.println(salas);
						opc=Integer.parseInt(entrada.readLine());
					}while(opc!=0 || salas.contains(nombreSala));
					if(opc==0) {
						salas.remove(nombreSala);
					}else {
						opc=-55555;
					}
					break;
				case 2:
					salida.write("Todas las salas disponibles\n");
					salida.flush();
					Enumeration<String> nombreSalas=salas.keys();
					while(nombreSalas.hasMoreElements()) {
						salida.write(nombreSalas.nextElement()+", ");
					}
					salida.newLine();
					salida.flush();
					break;
				case 3:
					salida.write("Introduce el nombre de la sala\n");
					salida.flush();
					sala=salas.remove(entrada.readLine());
					if(sala!=null) {
						opc=-55555;
					}
				}
			}while(opc!=4 || opc!=-55555);
			salida.write(opc+"\n");
			if(sala!=null) {
				Partida p = new Partida(sala, s);
				p.empezarPartida();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
