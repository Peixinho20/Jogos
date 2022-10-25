import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class pedestre here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class pedestre extends Actor
{
    public void act()
    {
        //movimentos do personagem
        if(Greenfoot.isKeyDown("left")){
            move(-1);
        }
        
        if(Greenfoot.isKeyDown("right")){
            move(1);
        }
        
        if(Greenfoot.isKeyDown("up")){
            setLocation(getX(), getY() -1);
        }
        
        if(Greenfoot.isKeyDown("down")){
            setLocation(getX(), getY() +1);
        }
        
        isAtropelado();
    }
    
    //metodo que avisa ao jogo quando o pedestre foi atropelado
    public void isAtropelado(){
        if(isTouching(carro.class)){
            ((Rua) getWorld()).fimDeJogo();
        }
    }
}
