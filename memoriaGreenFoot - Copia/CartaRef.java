import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CartaRef here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CartaRef extends Actor
{
    /**
     * Act - do whatever the CartaRef wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
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
    
    public CartaRef(ListaImagens imagem, Cerebro c){
        this.imagem = imagem;
        //Guarda a imagem que a carta ir� representar
        bufferImage = imagem.getRandomImage();
        back = imagem.getBack();
        empty = imagem.getEmpty();
        //Guarda uma refer�ncia para o cerebro do jogo
        cerebro = c;
        setImage(back);//Seta a imagem das costas da carta
    }
}

