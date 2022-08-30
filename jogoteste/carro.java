import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class carro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class carro extends Actor
{
    public void act(){
        // Add your action code here.
        setLocation(getX() +1, getY()); //faz o carro andar alterando ele de local
        if(getX() >= 590){ //se o objeto sair da tela remove o carro para nao se acumularem
            ((Rua) getWorld()).removeObject(this);
        }
    }
}
