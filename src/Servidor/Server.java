package Servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import Utilidad.*;


public class Server {
	public static void main(String[] args) {
		ExecutorService pool=Executors.newCachedThreadPool();
		Socket s = null;
		try(ServerSocket ss=new ServerSocket(55555);){
			while(true) {
					s=ss.accept();
					pool.execute(new AtenderPeticion(s));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pool.shutdown();
			Util.cerrar(s);
		}
	}
}
