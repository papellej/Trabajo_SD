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
