package Juego;

import java.net.InetAddress;
import java.net.Socket;

public class Principal {
	public static void main(String[] args) {
		Socket s = new Socket();
		Jugador j=new Jugador(s);
		j.mostrarMapa();
	}

}
