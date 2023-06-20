import greenfoot.*;

public class Caixa extends Actor{
    //Criaçao e definiçao da caixa    
    public Caixa(){
        GreenfootImage vermelha = new GreenfootImage("images/red.png");
        setImage(vermelha);
        int largura1 = 150;
        int altura1 = 100;
        
        GreenfootImage imagemRedimensionada = new GreenfootImage(vermelha);
        imagemRedimensionada.scale(largura1,altura1);
        setImage(imagemRedimensionada);         
    }
    
    /**
     * Adicionar a verificaçao e contabilidade dos objetos que 
     * foram adicionados na caixa
     */
    public void act(){
        Actor objeto = getOneIntersectingObject(Figuras.class);
        if (objeto != null && objeto instanceof Figuras) {
            Figuras figura = (Figuras) objeto;
            String corFigura = figura.getCorString();
            if (corFigura.equals(getColorString())) {
                // A figura tem a mesma cor da caixa, portanto, está sendo agrupada corretamente
                getWorld().removeObject(figura);
                ((MeuMundo)getWorld()).classificarFigura(corFigura);
            } else {
                // A figura não tem a mesma cor da caixa, portanto, não está sendo agrupada corretamente
                // Adicione aqui o código para lidar com essa situação, se necessário
            }
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