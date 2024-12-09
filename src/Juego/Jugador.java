package Juego;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Jugador {
	private int[][] mapa;
	private int[][] mapaDisparos;
	private List<Barco> barcos;
	private Socket jug;
	public Jugador(Socket jug) {
		this.jug=jug;
		mapa= new int[10][10];
		mapaDisparos= new int[10][10];
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++) {
				mapa[i][j]=0;
				mapaDisparos[i][j]=0;
			}
		}
		barcos=new ArrayList<Barco>();
		for(int i=1;i<=4;i++) {
			for(int j=i;j<=4;j++) {
				barcos.add(new Barco(i));
			}
		}
	}
	
	//Getters/Setters
	public Socket getSocket() {
		return jug;
	}
	
	//Metodos
	public boolean colocarBarco(int fila, int col, int longitud, char orientacion) {
		if (orientacion != 'H' && orientacion != 'V') {
			return false;
		}
		if ((orientacion == 'H' && col + longitud > mapa[0].length) || (orientacion == 'V' && fila + longitud > mapa.length)) {
            return false;
        }
		for (int i = 0; i < longitud; i++) {
			if (orientacion == 'H' && mapa[fila][col + i] != 0) {
				return false;
			}
			if (orientacion == 'V' && mapa[fila + i][col] != 0) {
				return false;
			}
		}
		for (int i = 0; i < longitud; i++) {
			if (orientacion == 'H') {
				mapa[fila][col + i ] = 1;
			} else {
				mapa[fila + i][col] = 1;
			}
		}
		return true;
	}
	
	public boolean haPerdido() {
		for(int i=0;i<10;i++){
			for(int n : mapa[i]) {
				if(n!=0) {
					return false;
				}
			}
			System.out.println();
		}
		return true;
	}
	public boolean puedeHacerDisparo(int fila, int columna) {
		if(0<fila && fila<=10 && 0<columna && columna<=10) {
			return mapaDisparos[fila][columna]==0;
		}
		return false;
	}
	public void hacerDisparo(int fila, int columna, boolean golpeado) {
		if(golpeado) {
			mapaDisparos[fila][columna]=1;
		}else {
			mapaDisparos[fila][columna]=2;
		}
	}
	public boolean recibirDisparo(int fila, int columna) {
		if(mapa[fila][columna]==1) {
			mapa[fila][columna]=2;
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void mostrarMapa() throws IOException {
		BufferedWriter salida = new BufferedWriter(new OutputStreamWriter(jug.getOutputStream(),"UTF-8"));
		salida.write("\t");
		for(int i=0; i<10;i++) {
			salida.write((char)(i+65));
		}
		salida.newLine();
		for(int i=0;i<10;i++){
			salida.write((i+1)+"\t");
			for(int n : mapa[i]) {
				salida.write(n+"");
			}
			salida.newLine();
		}
		salida.flush();
	}
	public void mostrarMapaDisparos() throws IOException {
		BufferedWriter salida = new BufferedWriter(new OutputStreamWriter(jug.getOutputStream(),"UTF-8"));
		salida.write("\t");
		for(int i=0; i<10;i++) {
			salida.write((char)(i+65));
		}
		salida.newLine();
		for(int i=0;i<10;i++){
			salida.write((i+1)+"\t");
			for(int n : mapaDisparos[i]) {
				salida.write(n+"");
			}
			salida.newLine();
		}
		salida.flush();
	}
	
	
	
	public class Barco{
		private int longitud;
		public Barco(int longitud) {
			this.longitud=longitud;
		}
	}
}
