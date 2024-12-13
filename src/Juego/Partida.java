package Juego;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Utilidad.Util;

public class Partida {
	private Jugador[] jug;
	
	
	public Partida(Socket jugador1, Socket jugador2) {
		this.jug=new Jugador[2];
		this.jug[0]=new Jugador(jugador1);
		this.jug[1]=new Jugador(jugador2);
	}
	
	public void empezarPartida(){
		
		ExecutorService pool = Executors.newFixedThreadPool(2);
		DataInputStream[] entradaDatos= new DataInputStream[2];
		BufferedWriter[] salida = new BufferedWriter[2];
		try {
			salida[0] = new BufferedWriter(new OutputStreamWriter(jug[0].getSocket().getOutputStream(),"UTF-8"));
			salida[1] = new BufferedWriter(new OutputStreamWriter(jug[1].getSocket().getOutputStream(),"UTF-8"));
			entradaDatos[0]=new DataInputStream(jug[0].getSocket().getInputStream());
			entradaDatos[1]=new DataInputStream(jug[0].getSocket().getInputStream());
			
			CountDownLatch barrera = new CountDownLatch(2);
			pool.execute(new ColocarBarcos(jug[0], barrera));
			pool.execute(new ColocarBarcos(jug[1], barrera));
			barrera.await();
			salida[0].write("---------Comienza el juego----------");
			salida[0].flush();
			salida[1].write("---------Comienza el juego----------");
			salida[1].flush();
			int i=0;
			while(!jug[i%2].haPerdido()) {
				salida[i%2].write((i%2)+"\n");
				salida[i%2].flush();
				salida[(i+1)%2].write(((i+1)%2)+"\n");
				salida[(i+1)%2].flush();
				jug[i%2].mostrarMapaDisparos();
				boolean disparoHecho;
				do {
					int fila=entradaDatos[i%2].readInt();
					int columna=entradaDatos[i%2].readInt();
					disparoHecho=jug[i%2].puedeHacerDisparo(fila, columna);
					salida[i%2].write(disparoHecho+"\n");
					salida[i%2].flush();
					if(disparoHecho) {
						if(jug[(i+1)%2].recibirDisparo(fila, columna)) {
							jug[i%2].hacerDisparo(fila, columna, true);
							salida[i%2].write("Ha golpeado\n");
						}else {
							jug[i%2].hacerDisparo(fila, columna, false);	
							salida[i%2].write("Ha tocado agua\n");
						}
						salida[i%2].flush();
						salida[(i+1)%2].write("El rival ha disparado a la casilla "+(fila+1)+" "+(char)(columna+65)+"\n");
						salida[(i+1)%2].flush();
					}
				}while(!disparoHecho);
				jug[(i+1)%2].mostrarMapa();
				i++;
			}
			salida[i%2].write(2+"\n");
			salida[i%2].flush();
			salida[(i+1)%2].write(2+"\n");
			salida[(i+1)%2].flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Util.cerrar(entradaDatos[0]);
			Util.cerrar(entradaDatos[1]);
			Util.cerrar(salida[0]);
			Util.cerrar(salida[1]);
			pool.shutdown();
			Util.cerrar(jug[0].getSocket());
			Util.cerrar(jug[1].getSocket());
		}
	}
	
	
}
