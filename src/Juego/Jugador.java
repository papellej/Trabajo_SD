package Juego;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
	private int[][] mapa;
	private List<Barco> barcos;
	public Jugador() {
		mapa= new int[10][10];
		barcos=new ArrayList<Barco>();
		for(int i=1;i<=4;i++) {
			for(int j=i;j<=4;j++) {
				barcos.add(new Barco(i));
			}
		}
	}
	public void colocarBarco() {
		
	}
	public class Barco{
		private int longitud;
		public Barco(int longitud) {
			this.longitud=longitud;
		}
	}
	public void mostrarMapa() {
		for(int[] fila : mapa){
			for(int n : fila) {
				System.out.print(n);
			}
			System.out.println();
		}
		
	}
}
