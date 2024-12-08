package Juego;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
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
		List<Integer> barcos=new ArrayList<Integer>();
		for(int i=1;i<=4;i++) {
			for(int j=i;j<=4;j++) {
				barcos.add(i);
			}
		}
		while(barcos.size()>0) {
			try {
				DataInputStream entrada;
				BufferedWriter salida = new BufferedWriter(new OutputStreamWriter(jug.getSocket().getOutputStream(),"UTF-8"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
