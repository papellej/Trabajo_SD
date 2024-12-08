package Juego;

import java.net.Socket;

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
		
	}
	
	
}
