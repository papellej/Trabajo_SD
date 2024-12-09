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
				System.out.println(salas);
				opc=Integer.parseInt(entrada.readLine());
				switch(opc){
				case 1:
					String nombreSala=entrada.readLine();
					salas.put(nombreSala,s);
					do {
						System.out.println(salas);
//						opc=Integer.parseInt(entrada.readLine());
						if(!salas.containsKey(nombreSala)) {
							opc=-55555;
						}
						salida.write(opc+"\n");
						salida.flush();
					}while(opc!=0 && opc!=-55555);
					if(opc==0) {
						salas.remove(nombreSala);
					}
					System.out.println(salas);
					System.out.println(opc+" ");
					break;
				case 2:
					Enumeration<String> nombreSalas=salas.keys();
					while(nombreSalas.hasMoreElements()) {
						salida.write(nombreSalas.nextElement()+", ");
					}
					salida.newLine();
					salida.flush();
					break;
				case 3:
					sala=salas.remove(entrada.readLine());
					if(sala!=null) {
						opc=-55555;
					}
					break;
				}
				salida.write(opc+"\n");
				salida.flush();
			}while(opc!=4 && opc!=-55555);
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
