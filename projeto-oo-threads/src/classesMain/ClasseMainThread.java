package classesMain;

import javax.swing.JOptionPane;

public class ClasseMainThread {

	public static void main(String[] args) throws InterruptedException {
		
		/*for(int i = 0; i < 10; i++) {
			
			System.out.println("Rotina "+(i+1));
			Thread.sleep(2000);
			
		}
		System.out.println("FINALIZOU");*/
		
		new Thread() {
			public void run() {
				for(int i = 0; i < 10; i++) {
					System.out.println("Envio de e-mail...");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
		}.start();
		
		new Thread() {
			public void run() {
				for(int i = 0; i < 10; i++) {
					System.out.println("Envio de nota fiscal...");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
		}.start();
		
		System.out.println("FINALIZOU");
		JOptionPane.showMessageDialog(null, "Segue o fluxo");

	}

}
