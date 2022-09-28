import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.Border;


public class Carta  extends Actor{
    //AI do jogo
    Cerebro cerebro;
    //Obtém um objeto com informações do mouse
    MouseInfo mouse = Greenfoot.getMouseInfo();
    //Imagem nas costas da carta
    private GreenfootImage costas;
    //Imagem Vazia
    private GreenfootImage vazio;
    //situacao da carta
    private boolean situacaoDaCarta = true;
    private GreenfootImage bufferImage;
    private ListaImagens imagem;
    
    /**
     * Construtor da classe Carta
     */
    public Carta(ListaImagens imagem, Cerebro c){
        this.imagem = imagem;
        //Guarda a imagem que a carta irá representar
        bufferImage = imagem.getRandomImage();
        costas = imagem.getBack();
        vazio = imagem.getEmpty();
        //Guarda uma referência para o cerebro do jogo
        cerebro = c;
        setImage(costas);//Seta a imagem das costas da carta
    }
    
    public boolean getsituacaoDaCarta(){
        return situacaoDaCarta;
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
        if(situacaoDaCarta == true){
            situacaoDaCarta = false;
            setImage(bufferImage);
            cerebro.VerificaCartaVirada(bufferImage, this);
        }
    }
    
    /**
     * Desvira a carta mostrando as costas da carta
     */
    public void desvirarCarta(){
        situacaoDaCarta = true;
        setImage(costas);
    }
    
    /**
     * Remove a carta após ela ser descoberta
     */
    public void removerCarta(){
        situacaoDaCarta = false; 
        setImage(vazio);
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




