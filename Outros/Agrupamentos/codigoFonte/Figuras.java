import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Figuras here.
     * Essa classe serve como uma base genérica para a criação de 
     * diferentes tipos de figuras no mundo do Greenfoot.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Figuras extends Actor
{
    private String corString; //uma String que representa a cor da figura em formato de texto.
    private Color cor; //um objeto Color que representa a cor da figura.
    
    /**
    * Construtor que recebe um objeto Color como parâmetro e
    * define a cor da figura.
    */
    public Figuras(Color cor){
        /** this.cor se refere ao parametro 'cor' da classe Figuras,
         * evitando ambiguidade com a variavel local 'cor'.
         */ 
        this.cor = cor; 
        atualizarImagem();
    }
    
    /**
    * Construtor que recebe uma String representando a cor 
    * da figura e armazena na variável corString.
    */
    public Figuras(String corString){
        this.corString = corString;
    }
    
    /**
    * retorna a cor da figura como uma String.
    */
    public String getCorString(){
        return corString;
    }
        
    
    /**
    * retorna a cor da figura como um objeto Color.
    */
    public Color getCor() {
        return cor;
    }
    
    /**
    * atualiza a cor da figura com um novo objeto Color e chama o 
    * método atualizarImagem() para atualizar a imagem da figura.
    */
    public void setCor(Color cor) {
        this.cor = cor;
        atualizarImagem();
    }
    
    /**
    * atualiza a cor da figura com uma nova String e chama o método 
    * atualizarImagem() para atualizar a imagem da figura.
    */
    public void setCorString(String corString) {
        this.corString = corString;
        atualizarImagem();
    }
    
    /**
    * atualiza a imagem da figura com base na cor definida. Neste 
    * código de exemplo, o método apenas define a cor de fundo da 
    * imagem com a cor especificada.
    */
    private void atualizarImagem() {
        GreenfootImage imagem = new GreenfootImage(50, 50);
        imagem.setColor(cor);
        // Lógica para desenhar a figura na imagem
        
        setImage(imagem);
    }
}
