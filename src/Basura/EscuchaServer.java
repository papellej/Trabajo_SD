package Basura;

import java.io.BufferedReader;
import java.io.IOException;

public class EscuchaServer extends Thread {
	private BufferedReader entrada;
	private int opc;
	private IOException e;
	
	public EscuchaServer(BufferedReader entrada) {
		this.entrada=entrada;
		opc=-1;
		e=null;
	}
	public void run() {
		do {
			try {
				opc=Integer.parseInt(entrada.readLine());
				System.out.println(opc+" opcion");
			} catch (IOException e) {
				this.e=e;
			}
		}while(opc!=0 && opc!=-55555);
	}
	public int getResultado() throws IOException {
		if(e==null) {
			return opc;
		}else {
			throw e;
		}
	}
	
}
