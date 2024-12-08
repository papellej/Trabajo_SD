package Juego;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Jugador {
	private int[][] mapa;
	private List<Barco> barcos;
	private Socket jug;
	public Jugador(Socket jug) {
		this.jug=jug;
		mapa= new int[10][10];
		barcos=new ArrayList<Barco>();
		for(int i=1;i<=4;i++) {
			for(int j=i;j<=4;j++) {
				barcos.add(new Barco(i));
			}
		}
	}
	public boolean colocarBarco(int fila, int col, Barco b, char orientacion) {
		if (orientacion != 'H' || orientacion != 'V') {
			return false;
		}
		if ((orientacion == 'H' && col + b.longitud > mapa[0].length) || (orientacion == 'V' && fila + b.longitud > mapa.length)) {
            return false;
        }
		for (int i = 0; i < b.longitud; i++) {
			if (orientacion == 'H' && mapa[fila][col + i] != 0) {
				return false;
			}
			if (orientacion == 'V' && mapa[fila + i][col] != 0) {
				return false;
			}
		}
		for (int i = 0; i < b.longitud; i++) {
			if (orientacion == 'H') {
				mapa[fila][col + i ] = 1;
			} else {
				mapa[fila + i][col] = 1;
			}
		}
		return true;
	}
	
	public void mostrarMapa() {
		System.out.print("\t");
		for(int i=0; i<10;i++) {
			System.out.print((char)(i+65));
		}
		System.out.println();
		for(int i=0;i<10;i++){
			System.out.print((i+1)+"\t");
			for(int n : mapa[i]) {
				System.out.print(n);
			}
			System.out.println();
		}
		
	}
	
	
	
	public class Barco{
		private int longitud;
		public Barco(int longitud) {
			this.longitud=longitud;
		}
	}
}
