import greenfoot.*;  
import java.util.ArrayList;

public class ListaImagens{
    //Declara��o de vari�veis
    private String caminhos [] = {"images/cartas/1.png", "images/cartas/2.png",
                                  "images/cartas/3.png", "images/cartas/4.png",
                                  "images/cartas/5.png", "images/cartas/6.png",
                                  "images/cartas/7.png", "images/cartas/8.png",
                                  "images/cartas/9.png", "images/cartas/10.png",
                                  "images/cartas/11.png", "images/cartas/12.png",
                                  "images/cartas/13.png", "images/cartas/14.png"};                     
    private ArrayList <Integer> numerosRestantes = new ArrayList<Integer>();
    private GreenfootImage [] imagens = new GreenfootImage[14];
    private GreenfootImage back = new GreenfootImage("images/cartas/blueflip.png");
    private GreenfootImage empty = new GreenfootImage("images/cartas/empty.png");

    /**
     * Construtor da classe ListaImagens
     */
    public ListaImagens(){
        carregaIdentificacao();
        carregaImagens();
    }

    /**
     * Carrega identifica��o das cartas 
     */
    public void carregaIdentificacao(){
        for(int i = 0; i < 14; i++){
            numerosRestantes.add(i);
            numerosRestantes.add(i);
        }
    }
    
    /**
     * Cria os objetos GreenfootImage com as imagens no array caminhos
     */
    public void carregaImagens(){
        for(int i = 0; i < caminhos.length; i++){
            imagens[i] = new GreenfootImage(caminhos[i]);
        } 
    }
    
    /**
     * Retorna um String que � um caminho para uma imagem de forma aleat�ria
     */
    public GreenfootImage getRandomImage(){
        //Gera um indice aleatorio baseado na quantidade de elementos do ArrayList
        int numeroAleatorio = (int)(Math.random() * numerosRestantes.size());
        int numeroSelecionado = numerosRestantes.get(numeroAleatorio);
        //Retira o n�mero utilizado da cole��o
        numerosRestantes.remove(numeroAleatorio);
        //Retorna a imagem selecionada aleatoriamente
        return imagens[numeroSelecionado];
    }
    
    /**
     * Retorna as costas da imagem
     */
    public GreenfootImage getBack(){
        return back;
    } 
    
    /**
     * Retorna a imagem vazia
     */
    public GreenfootImage getEmpty(){
        return empty;
    }
}
    
    
    
    
