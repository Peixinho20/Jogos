import greenfoot.*;
import java.util.List;

public class Caixa extends Actor{
    private Color cor; 
    public Fase1 fase1;
        
    //Criaçao e definiçao da caixa  
    /**
    public Caixa(){
        GreenfootImage vermelha = new GreenfootImage("images/red.png");
        setImage(vermelha);
        int largura1 = 150;
        int altura1 = 50;
        
        GreenfootImage imagemRedimensionada = new GreenfootImage(vermelha);
        imagemRedimensionada.scale(largura1,altura1);
        setImage(imagemRedimensionada);  
    }
    **/
    
    /**
     * Adicionar a verificaçao e contabilidade dos objetos que 
     * foram adicionados na caixa
     */
    public void act(){
        verificarObjetos();
        
        /**
        Actor objeto = getOneIntersectingObject(Figuras.class);
        if (objeto != null && objeto instanceof Figuras) {
            Figuras figura = (Figuras) objeto;
            if (figura.getCor() != null && figura.getCor().equals(Color.RED)) {
                getWorld().removeObject(figura);
                
                MeuMundo mundo = (MeuMundo) getWorld();
                mundo.Pontuacao();
                mundo.atualizarPontuacao();
            }else {
                getWorld().removeObject(figura);
                
                MeuMundo mundo = (MeuMundo) getWorld();
                mundo.reduzPontuacao();
                mundo.atualizarPontuacao();
            }
            
            String corFigura = figura.getCorString();
        }
        **/
    }
    
    public void verificarObjetos(){
        List<Figuras> objetos = getIntersectingObjects(Figuras.class);
        for (Figuras figura : objetos) {
            getWorld().removeObject(figura);
            fase1.reduzPontuacao();
            fase1.atualizarPontuacao();

            String corFigura = figura.getCorString();
        }
    }
    
    public String getColorString() {
        GreenfootImage image = getImage();
        if (image != null) {
            Color cor = image.getColorAt(getImage().getWidth() / 2, getImage().getHeight() / 2);
            return cor.toString();
        }
        return null;
    }    
}