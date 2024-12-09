package Juego;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Partida {
	private Jugador[] jug;
	
	
	public Partida(Socket jugador1, Socket jugador2) {
		this.jug=new Jugador[2];
		this.jug[0]=new Jugador(jugador1);
		this.jug[1]=new Jugador(jugador2);
	}
	public void colocarBarcos() {
		
	}
	public void empezarPartida() {
		ExecutorService pool = Executors.newFixedThreadPool(2);
		try {
			BufferedWriter[] salida = new BufferedWriter[2];
			salida[0] = new BufferedWriter(new OutputStreamWriter(jug[0].getSocket().getOutputStream(),"UTF-8"));
			salida[1] = new BufferedWriter(new OutputStreamWriter(jug[1].getSocket().getOutputStream(),"UTF-8"));
			DataInputStream[] entradaDatos= new DataInputStream[2];
			entradaDatos[0]=new DataInputStream(jug[0].getSocket().getInputStream());
			entradaDatos[1]=new DataInputStream(jug[0].getSocket().getInputStream());
			
			CountDownLatch barrera = new CountDownLatch(2);
			pool.execute(new ColocarBarcos(jug[0], barrera));
			pool.execute(new ColocarBarcos(jug[1], barrera));
			barrera.await();
			int i=0;
			while(!jug[i%2].haPerdido()) {
				salida[i%2].write((i%2)+"\n");
				salida[i%2+1].write((i%2+1)+"\n");

				jug[i%2].mostrarMapaDisparos();
				boolean disparoHecho;
				do {
					int fila=entradaDatos[i%2].readInt();
					int columna=entradaDatos[i%2].readInt();
					disparoHecho=jug[i%2].puedeHacerDisparo(fila, columna);
					salida[i%2].write(disparoHecho+"\n");
					salida[i%2].flush();
					if(disparoHecho) {
						if(jug[i%2+1].recibirDisparo(fila, columna)) {
							jug[i%2].hacerDisparo(fila, columna, true);
							salida[i%2].write("Ha golpeado\n");
						}else {
							jug[i%2].hacerDisparo(fila, columna, false);	
							salida[i%2].write("Ha tocado agua\n");
						}
						salida[i%2].flush();
						salida[i%2+1].write("El rival ha disparado a la casilla "+(fila+1)+" "+(char)(columna+65)+"\n");
						salida[i%2+1].flush();
					}
				}while(!disparoHecho);
				jug[i%2+1].mostrarMapa();
				i++;
			}
			salida[i%2].write(2+"\n");
			salida[i%2+1].write(2+"\n");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pool.shutdown();
		}
	}
	
	
}
