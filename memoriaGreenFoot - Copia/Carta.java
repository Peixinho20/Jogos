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
    private GreenfootImage back;
    //Imagem Vazia
    private GreenfootImage empty;
    //Status da carta
    private boolean statusDaCarta = true;
    private boolean reference = false;
    private GreenfootImage bufferImage;
    //private ListaImagens imagem; removido para desacoplamento, agora as imagens (back,empty,carta) da carta são passadas como parâmetro no construtor
    
    /**
     * Construtor da classe Carta
     * 
     */
        
     public Carta(GreenfootImage carta,GreenfootImage _back,GreenfootImage _empty, Cerebro c){
        //Guarda a imagem que a carta irá representar e cria um novo objt
        bufferImage = new GreenfootImage(carta);
        //cria novos objs para img de costa e vazio
        back = new GreenfootImage(_back);
        empty = new GreenfootImage(_empty);
        //Guarda uma referência para o cerebro do jogo
        cerebro = c;
        setImage(back);//Seta a imagem das costas da carta
    } 
    /**
     * Retorna a imagem da carta
    */
    public GreenfootImage getBufferImage(){
        return bufferImage;
    }
    
    public void setSizeImagem(int width, int height){
        bufferImage.scale(width,height);
        back.scale(width,height);
        empty.scale(width,height);
    }
    public void setReference(){
        reference =true;
    }
    
    public boolean getStatusDaCarta(){
        return statusDaCarta;
    }
    
    /**
     * Troca a imagem da carta para jogar novamente
     */
    public void reiniciarCarta(GreenfootImage carta){
        bufferImage = new GreenfootImage(carta);
        desvirarCarta();
    }
        
    /**
     * Mostra a imagem da carta
     */
    public void virarCarta(){
        if(statusDaCarta == true){
            statusDaCarta = false;
            setImage(bufferImage);
            //cerebro.VerificaCartaVirada(bufferImage, this);
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
     * Remove a carta após ela ser descoberta
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
        if(reference){
           if(Greenfoot.mousePressed(this)){
                desvirarCarta();
                cerebro.virarCartas();
            } 
        }else{
            if(Greenfoot.mousePressed(this)){
               /*if(cerebro.podeDesvirarCarta()){
                    virarCarta();  
               } */
               cerebro.VerificaCartaVirada(this);
            }
        }
    }
}    




