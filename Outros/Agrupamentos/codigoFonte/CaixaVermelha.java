import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class CaixaVermelha here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaixaVermelha extends Actor
{
    public Fase1 fase1; //declaracao
    
    public CaixaVermelha(){
        GreenfootImage verde = new GreenfootImage("images/red.png");
        setImage(verde);
        int largura1 = 150;
        int altura1 = 50;
        
        GreenfootImage imagemRedimensionada = new GreenfootImage(verde);
        imagemRedimensionada.scale(largura1,altura1);
        setImage(imagemRedimensionada);  
    }
          
    /**
     * Act - do whatever the CaixaVermelha wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        Actor objeto = getOneIntersectingObject(Figuras.class);
        if (objeto != null && objeto instanceof Figuras) {
            Figuras figura = (Figuras) objeto;
            if (figura.getCor() != null && figura.getCor().equals(Color.RED)) {
                getWorld().removeObject(figura);
                
                Fase1 fase1 = (Fase1) getWorld();
                fase1.Pontuacao();
                fase1.atualizarPontuacao();
                
                Fase2 fase2 = (Fase2) getWorld();
                fase2.Pontuacao();
                fase2.atualizarPontuacao();
            }else {
                getWorld().removeObject(figura);
                
                Fase1 fase1 = (Fase1) getWorld();
                fase1.reduzPontuacao();
                fase1.atualizarPontuacao();
                
                Fase2 fase2 = (Fase2) getWorld();
                fase2.reduzPontuacao();
                fase2.atualizarPontuacao();
            }
            
            String corFigura = figura.getCorString();
        }
    }
}
