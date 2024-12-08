package Juego;

import java.net.Socket;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Partida {
	private Jugador jug1;
	private Jugador jug2;
	
	
	public Partida(Socket jugador1, Socket jugador2) {
		this.jug1=new Jugador(jugador1);
		this.jug2=new Jugador(jugador2);
	}
	public void colocarBarcos() {
		
	}
	public void empezarPartida() {
		ExecutorService pool = Executors.newFixedThreadPool(2);
		try {
			CountDownLatch barrera = new CountDownLatch(2);
			pool.execute(new ColocarBarcos(jug1, barrera));
			pool.execute(new ColocarBarcos(jug2, barrera));
			barrera.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pool.shutdown();
		}
	}
	
	
}
