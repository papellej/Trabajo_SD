package Juego;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import Juego.Jugador.Barco;

public class ColocarBarcos extends Thread {
	private CountDownLatch barrera;
	private Jugador jug;
	public ColocarBarcos(Jugador jug, CountDownLatch barrera) {
		this.jug=jug;
		this.barrera=barrera;
	}
	public void run() {
		try {
			List<Integer> barcos=new ArrayList<Integer>();
			for(int i=1;i<=4;i++) {
				for(int j=i;j<=4;j++) {
					barcos.add(i);
				}
			}
			while(barcos.size()>0) {
				DataInputStream entrada = new DataInputStream(jug.getSocket().getInputStream());
				BufferedWriter salida = new BufferedWriter(new OutputStreamWriter(jug.getSocket().getOutputStream(),"UTF-8"));
				salida.write("Barcos disponibles: ");
				for(int i : barcos) {
					salida.write(i+", ");
				}
				salida.newLine();
				salida.flush();
				int longitud=entrada.readInt();
				int fila=entrada.readInt();
				int columna=entrada.readInt();
				char orientacion=entrada.readChar();
				if(barcos.contains((Integer)longitud)) {
					if(jug.colocarBarco(fila, columna, longitud, orientacion)) {
						barcos.remove((Integer)longitud);
						salida.write("El barco se ha colocado correctamente\n");
					}
				}else {
					salida.write("El barco no ha podido colocarse\n");						
				}
				salida.write(barcos.size()+"\n");
				salida.flush();
			}
			barrera.countDown();
		} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
