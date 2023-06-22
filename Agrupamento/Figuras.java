import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Figuras here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Figuras extends Actor
{
    private String corString;
    private Color cor;
    
    public Figuras(Color cor){
        this.cor = cor;
        atualizarImagem();
    }
    
    public Figuras(String corString){
        this.corString = corString;
    }
    
    public String getCorString(){
        return corString;
    }
        
    public Color getCor() {
        return cor;
    }
    
    public void setCor(Color cor) {
        this.cor = cor;
        atualizarImagem();
    }
    
    public void setCorString(String corString) {
        this.corString = corString;
        atualizarImagem();
    }
        
    private void atualizarImagem() {
        GreenfootImage imagem = new GreenfootImage(50, 50);
        imagem.setColor(cor);
        // Lógica para desenhar a figura na imagem
        
        setImage(imagem);
    }
}
