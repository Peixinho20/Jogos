import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import greenfoot.Actor;

/**
 * Ele gera figuras de cores aleatórias e os adiciona ao mundo 
 * usando coordenadas x e y aleatórias.
 * 
 */

public class Fase2 extends World
{
    private int pontuacao = 0; 
    private List<Color> cores;
    private Caixa[] caixas;
    private CaixaAzul caixaAzul;
    private CaixaVerde caixaVerde;
    private CaixaAmarela caixaAmarela;
    private CaixaVermelha caixaVermelha;
    
    /**
     * Constructor for objects of class Fase1.
     * 
     */
    public Fase2(){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        pontuacao = 0;
        
        //Array de cores para as figuras
        cores = new ArrayList<>();
        cores.add(Color.RED);
        cores.add(Color.BLUE);
        cores.add(Color.GREEN);
        cores.add(Color.YELLOW);
        
        Random random = new Random();
        
        gerarFiguras();        
    }
        
    public void gerarFiguras() {
        //Logica para adicionar as figuras geometricas
        for (int i = 0; i < 15; i++) {
            int tipoAleatorio = Greenfoot.getRandomNumber(3); // Número aleatório entre 0 e n-1
            Figuras figura;
        
            switch (tipoAleatorio) {
                case 0:
                    figura = criarCirculoAleatorio();
                    break;
                case 1:
                    figura = criarTrianguloAleatorio();
                    break;
                case 2:
                    figura = criarCuboAleatorio();
                    break;
                default:
                    figura = criarCirculoAleatorio(); // Valor padrão caso ocorra algum erro
                    break;
            }
            int larguraTela = getWidth() - 100;
            int alturaTela = getHeight() - 100;

            int x = larguraTela - Greenfoot.getRandomNumber(larguraTela/2);
            int y = Greenfoot.getRandomNumber(alturaTela);
            addObject(figura, x, y);
        }
        
        //Logica para adicionar uma unica caixa para essa fase
        for (int i=0; i<2; i++){
            if (i<2) {
                //Numero total de caixas a ser considerado
                int tipoCaixaAleatoria = Greenfoot.getRandomNumber(4);                   
                switch (tipoCaixaAleatoria) {
                    case 0:
                        CaixaVermelha caixaVermelha = new CaixaVermelha();
                        addObject(caixaVermelha, 100, 350);
                        break;
                    case 1:
                        CaixaVerde caixaVerde = new CaixaVerde();
                        addObject(caixaVerde, 100, 350);
                        break;
                    case 2:
                        CaixaAzul caixaAzul = new CaixaAzul();
                        addObject(caixaAzul, 100, 350);
                        break;
                    case 3:
                        CaixaAmarela caixaAmarela = new CaixaAmarela();
                        addObject(caixaAmarela, 100, 350);
                        break;
                }
            }
        }
    }
        
    private Circulo criarCirculoAleatorio() {
        Random random = new Random();
        int indiceCor = random.nextInt(cores.size());
        Color cor = cores.get(indiceCor);
        return new Circulo(cor);
    }
    
    private Triangulo criarTrianguloAleatorio() {
        Random random = new Random();
        int indiceCor = random.nextInt(cores.size());
        Color cor = cores.get(indiceCor);
        return new Triangulo(cor);
    }
    
    private Cubo criarCuboAleatorio() {
        Random random = new Random();
        int indiceCor = random.nextInt(cores.size());
        Color cor = cores.get(indiceCor);
        return new Cubo(cor);
    }
    
    public void Pontuacao(){
        pontuacao += 2;
        atualizarPontuacao();          
    }
    
    public void reduzPontuacao(){
        pontuacao -= 1;
        atualizarPontuacao();
    }
    
    public void atualizarPontuacao(){
        showText("Pontuacao: " + pontuacao, 120,50);
    }
}
