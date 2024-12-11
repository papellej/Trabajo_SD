package Basura;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import Utilidad.Util;

public class EscuchaCliente extends Thread{
	private Scanner teclado;
	private BufferedWriter salida;
	private int opc;
	private IOException e;
	
	public EscuchaCliente(Scanner teclado, BufferedWriter salida) {
		this.teclado=teclado;
		this.salida=salida;
		opc=-1;
		e=null;
	}
	public void run() {
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
			do {
				if(entrada.ready()) {
					opc=Util.tryParseInt(teclado);
				}
			}while(opc!=0 && opc!=-55555);
		
			System.out.println(opc+" opcion");
			salida.write(opc+"\n");
			salida.flush();
		} catch (IOException e) {
			this.e=e;
		}
	}
	public int getResultado() throws IOException {
		if(e==null) {
			return opc;
		}else {
			throw e;
		}
	}
}
