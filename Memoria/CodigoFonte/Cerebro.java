import greenfoot.*;

public class Cerebro{
    private int qtdCartasViradas = 0;
    private static int QTD_PARES = 1;
    private int qtdCartasDescobertas = 0;
    private int pontuacao = 10;
    private Mundo refMundo;
    private Carta carta;
    
    public Cerebro(Mundo d){
        refMundo = d;
    }
    
    public String getReference(){
       // compara a imagem clicada com a imagem de referência
       return refMundo.getReference().getCaminho();
    }
    
    public void cartaDescoberta(){
        qtdCartasDescobertas++;
    }
    
    /**
     * Verifica o fim do jogo
     */
    public void verificaFimDeJogo(){
        if(qtdCartasDescobertas == QTD_PARES){
            qtdCartasDescobertas = 0;
            refMundo.setPontuacao(pontuacao);
        }
    }
    
    /**
     * Verifica se é possível desvirar uma carta, quando não há duas cartas desviradas.
     */
    public boolean podeDesvirarCarta(){
        if(qtdCartasViradas <= 1){
            return true; 
        }else{
            return false;
        }
    }
    
    /**
     * 
    */
    public void desvirarCartas(){
        refMundo.desvirarCartas();
    }
    
    /**
     * 
    */
    public void virarCartas(){
        refMundo.virarCartas();
        //Greenfoot.delay(10);
    }
}
