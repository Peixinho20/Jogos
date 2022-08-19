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
        
        setPaintOrder(JanelaFinal.class, carro.class, pedestre.class); //determina a ordem que os objetos serão desehados na tela
        
        criarComponentes(); //declaração do método
    }
    
    public void act()
    {
        if(Greenfoot.getRandomNumber(100)<2){
            addObject(new carro(), 0, Greenfoot.getRandomNumber(400)); //faz com que carros sejam gerados aleatoriamente na tela
        }
    }
    public void criarComponentes() //chama os objetos dentro dela
    {
        addObject(new pedestre(), 300, 10); //esse método chama o objet pedestre na posição x = 300 e y = 10
    }
}
