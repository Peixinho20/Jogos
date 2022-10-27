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
       // compara a imagem clicada com a imagem de refer�ncia
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
     * Verifica se � poss�vel desvirar uma carta, quando n�o h� duas cartas desviradas.
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
