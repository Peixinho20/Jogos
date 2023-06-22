import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cubo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cubo extends Figuras{
    private boolean dragging;
    private int lastMouseX;
    private int lastMouseY;
    
    /**
     * Act - do whatever the Cubo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        // Add your action code here.
        if (Greenfoot.mouseDragged(this)){
            MouseInfo mouse = Greenfoot.getMouseInfo();
            int mouseX = mouse.getX();
            int mouseY = mouse.getY();
            
            if (!dragging) {
                dragging = true;
                lastMouseX = mouseX;
                lastMouseY = mouseY;
            }
            
            int deltaX = mouseX - lastMouseX;
            int deltaY = mouseY - lastMouseY;
            
            int newX = getX() + deltaX;
            int newY = getY() + deltaY;
            
            setLocation(newX, newY);
   
            lastMouseX = mouseX;
            lastMouseY = mouseY;
        }
        
        if (Greenfoot.mouseDragEnded(this)) {
            dragging = false;
        }
    }
    
    public Cubo(Color cor) {
        super(cor);
        GreenfootImage image = new GreenfootImage(50, 50);
        image.setColor(cor);
        image.fillRect(10, 10, 30, 30);
        setImage(image);
        
        String corString = cor.toString();
    }
    
    public void atuar() {
        String corString = getCorString();
    }
}
