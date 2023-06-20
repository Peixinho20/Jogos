import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Ele gera figuras de cores aleatórias e os adiciona ao mundo 
 * usando coordenadas x e y aleatórias.
 * 
 */

public class MeuMundo extends World
{
    int pontuacao; 
    int totalFiguras;
    private List<Color> cores;
    public int figurasClassificadas;
    /**
     * Constructor for objects of class MeuMundo.
     * 
     */
    public MeuMundo(){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        pontuacao = 0;
        
        cores = new ArrayList<>();
        cores.add(Color.RED);
        cores.add(Color.BLUE);
        cores.add(Color.GREEN);
                       
        //Instanciando Caixa ao MeuMeundo
        Caixa caixa1 = new Caixa();
        addObject(caixa1, 200, 100);
        
        gerarFiguras();
        
        atualizarPontuacao();
    }
    
    public void gerarFiguras() {
        totalFiguras = 10;
        for (int i = 0; i < totalFiguras; i++) {
            int tipoAleatorio = Greenfoot.getRandomNumber(6); // Número aleatório entre 0 e n-1
        
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
            int x = Greenfoot.getRandomNumber(getWidth() - figura.getImage().getWidth());
            int y = Greenfoot.getRandomNumber(getHeight()- figura.getImage().getHeight());
            addObject(figura, x, y);
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
    
    public void classificarFigura(String cor){
        pontuacao++;
        atualizarPontuacao();
        figurasClassificadas++;
        
        for (Figuras figura : getObjects(Figuras.class)) {
            String corFigura = figura.getCorString();
            if (corFigura.equals(cor)) {
                // Lógica para agrupar a figura de acordo com a cor da caixa
                pontuacao += pontuacao;
            }
        }
        
        if (figurasClassificadas == totalFiguras) {
            Greenfoot.stop(); //todos os cubos foram classificados
        }        
    } 
    
    private void atualizarPontuacao(){
        showText("Pontuacao: " + pontuacao, 120,50);
    }
}
