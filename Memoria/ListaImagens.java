import greenfoot.*;  
import java.util.ArrayList;

public class ListaImagens{
    //Declaração de variáveis
    private ArrayList <String> caminhos = new ArrayList<String>();                     
    private String back = "images/cartas/blueflip.png";
    private String empty = "images/cartas/empty.png";
    /**
     * Construtor da classe ListaImagens
     */
    public ListaImagens(){
        caminhos.add("images/cartas/1.png");
        caminhos.add("images/cartas/2.png");
        caminhos.add("images/cartas/3.png");
        caminhos.add("images/cartas/4.png");
        caminhos.add("images/cartas/5.png");
        caminhos.add("images/cartas/6.png");
        caminhos.add("images/cartas/7.png");
        caminhos.add("images/cartas/8.png");
        caminhos.add("images/cartas/9.png");
        caminhos.add("images/cartas/10.png");
        caminhos.add("images/cartas/11.png");
        caminhos.add("images/cartas/12.png");
        caminhos.add("images/cartas/13.png");
        caminhos.add("images/cartas/14.png");
    }

    /**
     * Retorna um String que é um caminho para uma imagem de forma aleatória
     */
    public String getRandomImage(){
        //Gera um indice aleatorio baseado na quantidade de elementos do ArrayList
        int numeroAleatorio = (int)(Math.random() * caminhos.size());
        return caminhos.get(numeroAleatorio);
    }
    
    /**
     * Retorna as costas da imagem
     */
    public String getBack(){
        return back;
    } 
    
    /**
     * Retorna a imagem vazia
     */
    public String getEmpty(){
        return empty;
    }
}
    
    
    
    
