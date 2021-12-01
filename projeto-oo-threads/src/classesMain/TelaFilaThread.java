package classesMain;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import classes.ObjetoFilaThread;

public class TelaFilaThread extends JDialog{
	
private JPanel jPanel = new JPanel(new GridBagLayout());
	
	private JLabel descricaoNome = new JLabel("Nome");
	private JTextField textNome = new JTextField();
	
	private JLabel descricaoEmail = new JLabel("E-mail");
	private JTextField textEmail = new JTextField();
	
	private JButton jButtonAddList = new JButton("Add Lista");
	private JButton jButtonStop = new JButton("Stop");
	
	
	private ImplementacaoFilaThread	fila = new ImplementacaoFilaThread();
	
	public TelaFilaThread() {
		setTitle("Tela Fila com Thread");
		setSize(new Dimension(240, 240));
		setLocationRelativeTo(null);
		setResizable(false);
		
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.insets = new Insets(5, 10, 5, 5);
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.gridwidth = 2;
		
		descricaoNome.setPreferredSize(new Dimension(200, 25));
		jPanel.add(descricaoNome, gridBagConstraints);
		
		textNome.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy ++;
		jPanel.add(textNome, gridBagConstraints);
		
		descricaoEmail.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy ++;
		jPanel.add(descricaoEmail, gridBagConstraints);
		
		textEmail.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy ++;
		jPanel.add(textEmail, gridBagConstraints);
		
		gridBagConstraints.gridwidth = 1;
		
		jButtonAddList.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridy ++;
		jPanel.add(jButtonAddList, gridBagConstraints);
		
		jButtonStop.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridx ++;
		jPanel.add(jButtonStop, gridBagConstraints);
		
		
		jButtonAddList.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ObjetoFilaThread filaThread =  new ObjetoFilaThread();
				
				filaThread.setNome(textNome.getText());
				filaThread.setEmail(textEmail.getText());
				
				fila.add(filaThread);
				
				
			}
		});
		
		jButtonStop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
	
				
			}
		});
		
		
		fila.start();
		add(jPanel, BorderLayout.WEST);
		setVisible(true);
	}
	

}
