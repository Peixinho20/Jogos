package telas;
import javax.swing.JFrame;

public class TelaPrincipal extends JFrame{
	
	public TelaPrincipal () {
		super("Jogo da memória");
		
		//tamanho da tela
		this.setBounds(250,100,600,600);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
	
	}

}
