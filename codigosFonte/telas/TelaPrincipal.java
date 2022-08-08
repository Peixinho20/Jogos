package telas;

import javax.swing.JPanel; //biblioteca que cria as figuras na tela
import javax.swing.JButton;//biblioteca que cria botoes
import javax.swing.JFrame; //biblioteca que cria a janela do jogo

public class TelaPrincipal extends JFrame{
	
	private JPanel painel;
	private JButton botao1;
	private JButton botao2;
	
	public TelaPrincipal () {
		super("Jogo da memória");
		
		painel = new JPanel();
		this.add(painel);
		painel.setLayout(null);
		
		botao1 = new JButton("Botao1");
		painel.add(botao1);
		botao1.setBounds(10, 10, 100, 100);
		
		botao2 = new JButton("Botao2");
		painel.add(botao2);
		botao2.setBounds(120, 10, 100, 100);
		
		//tamanho da tela
		this.setBounds(250,100,600,600);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
	
	}

}
