import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rua here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rua extends World
{

    /**
     * Constructor for objects of class Rua.
     * 
     */
    public Rua()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        //determina a ordem que os objetos serão desehados na tela
        setPaintOrder(JanelaFinal.class, carro.class, pedestre.class);
        
        //declaração do método
        criarComponentes(); 
    }
    
    public void act()
    {
        if(Greenfoot.getRandomNumber(100)<2){
            //faz com que carros sejam gerados aleatoriamente na tela
            addObject(new carro(), 0, Greenfoot.getRandomNumber(400)); 
        }
    }
    public void criarComponentes() //chama os objetos dentro dela
    {
        //esse método chama o objet pedestre na posição x = 300 e y = 10
        addObject(new pedestre(), 300, 10); 
    }
    
    public void fimDeJogo()
    {
        //instanciou a JanelaFinal e passou a localizaçao da mensagem "Fim de Jogo".
        addObject(new JanelaFinal("Fim de Jogo!"), getWidth()/2, getHeight()/2);
        Greenfoot.playSound("FimDeJogo.wav");
        Greenfoot.stop();
    }
}
