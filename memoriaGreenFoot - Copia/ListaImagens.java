import greenfoot.*;  
import java.util.ArrayList;

public class ListaImagens{
    //Declaração de variáveis
    private ArrayList <String> caminhos = new ArrayList<String>();                     
    //private ArrayList <Integer> numerosRestantes = new ArrayList<Integer>();
    //private GreenfootImage [] imagens = new GreenfootImage[14];
    //private GreenfootImage back = new GreenfootImage("images/cartas/blueflip.png");
    //private GreenfootImage empty = new GreenfootImage("images/cartas/empty.png");
    private String back = "images/cartas/blueflip.png";
    private String empty = "images/cartas/empty.png";
    /**
     * Construtor da classe ListaImagens
     */
    public ListaImagens(){
        //carregaIdentificacao();
        //carregaImagens();
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
     * Carrega identificação das cartas 
     */
    // public void carregaIdentificacao(){
        // for(int i = 0; i < 14; i++){
            // numerosRestantes.add(i);
            // numerosRestantes.add(i);
        // }
    // }
    
    /**
     * Cria os objetos GreenfootImage com as imagens no array caminhos
     */
    // public void carregaImagens(){
        // for(int i = 0; i < caminhos.length; i++){
            // imagens[i] = new GreenfootImage(caminhos[i]);
        // } 
    // }
    
    /**
     * Retorna um String que é um caminho para uma imagem de forma aleatória
     */
    public String getRandomImage(){
        //Gera um indice aleatorio baseado na quantidade de elementos do ArrayList
        int numeroAleatorio = (int)(Math.random() * caminhos.size());
        //int numeroSelecionado = numerosRestantes.get(numeroAleatorio);
        //Retira o número utilizado da coleção
        //numerosRestantes.remove(numeroAleatorio);
        //Retorna a imagem selecionada aleatoriamente
        //return imagens[numeroSelecionado];
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
    
    
    
    
