import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.Border;


public class Carta  extends Actor{
    //AI do jogo
    Cerebro cerebro;
    //Obt�m um objeto com informa��es do mouse
    MouseInfo mouse = Greenfoot.getMouseInfo();
    //Imagem nas costas da carta
    private GreenfootImage back;
    //Imagem Vazia
    private GreenfootImage empty;
    //Status da carta
    private boolean statusDaCarta = true;
    private GreenfootImage bufferImage;
    private ListaImagens imagem;
    
    /**
     * Construtor da classe Carta
     * 
     */
    public Carta(ListaImagens imagem, Cerebro c){
        this.imagem = imagem;
        //Guarda a imagem que a carta ir� representar
        bufferImage = imagem.getRandomImage();
        back = imagem.getBack();
        empty = imagem.getEmpty();
        //Guarda uma refer�ncia para o cerebro do jogo
        cerebro = c;
        setImage(back);//Seta a imagem das costas da carta
    }  
    
    public boolean getStatusDaCarta(){
        return statusDaCarta;
    }
    
    /**
     * Troca a imagem da carta para jogar novamente
     */
    public void reiniciarCarta(){
        bufferImage = imagem.getRandomImage();
        desvirarCarta();
    }
    
    /**
     * Mostra a imagem da carta
     */
    public void virarCarta(){
        if(statusDaCarta == true){
            statusDaCarta = false;
            setImage(bufferImage);
            cerebro.VerificaCartaVirada(bufferImage, this);
        }
    }
    
    /**
     * Desvira a carta mostrando as costas da carta
     */
    public void desvirarCarta(){
        statusDaCarta = true;
        setImage(back);
    }
    
    /**
     * Remove a carta ap�s ela ser descoberta
     */
    public void removerCarta(){
        statusDaCarta = false; 
        setImage(empty);
    }
    
    /**
     * Act - do whatever the Carta wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        if(Greenfoot.mousePressed(this)){
           if(cerebro.podeDesvirarCarta()){
                virarCarta();  
           }        
        } 
    }
}    




