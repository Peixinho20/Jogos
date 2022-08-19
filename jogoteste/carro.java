import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class carro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class carro extends Actor
{
    /**
     * Act - do whatever the carro wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        setLocation(getX() +1, getY());
        if(getX() >= 590){
            ((Rua) getWorld()).removeObject(this);
        }
    }
}
