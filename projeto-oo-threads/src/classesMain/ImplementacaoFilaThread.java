package classesMain;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

import classes.ObjetoFilaThread;

public class ImplementacaoFilaThread extends Thread {
	
	private static ConcurrentLinkedQueue<ObjetoFilaThread> pilha_fila = 
			new ConcurrentLinkedQueue<ObjetoFilaThread>();
	
	public static void add(ObjetoFilaThread objetoFilaThread) {
		pilha_fila.add(objetoFilaThread);
	}
	
	@Override
	public void run() {
		System.out.println("RODANDO");
		
		while(true) {
			synchronized (pilha_fila) {//Bloquear o acesso a esta lista por outros processos
				Iterator iteracao = pilha_fila.iterator();
				while (iteracao.hasNext()) {//Enquanto conter dados na lista irá processar
					
					ObjetoFilaThread processar = (ObjetoFilaThread) iteracao.next();//Pega o objeto atual
					
					//Processar 10 mil notas fiscal
					//Gerar uma lista de PDF
					//Gerar um envio em massa de email
					
					System.out.println("---------------------------------");
					System.out.println(processar.getNome());
					System.out.println(processar.getEmail());
					
					iteracao.remove();
					
					try {
						Thread.sleep(1000);//Dar um tempo de descargo de memória
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
			try {
				Thread.sleep(1000);//Dar um tempo para limpesa de memoria
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
