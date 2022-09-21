import greenfoot.*;

public class Cerebro{
    private int qtdCartasViradas = 0;
    private static int QTD_PARES = 1;
    private int qtdCartasDescobertas = 0;
    private int pontuacao = 10;
    //private Carta CartaRef;
    // private GreenfootImage nomeDaCartaVirada1;
    // private GreenfootImage nomeDaCartaVirada2;//carta de refer�ncia
    private Mundo refMundo;
    //private Pontuacao qPontos;
    
    public Cerebro(Mundo d){
        refMundo = d;
        //qPontos = new Pontuacao(refMundo);
    }
    
    public void VerificaCartaVirada(/*GreenfootImage i, */Carta carta){
        /* c�digo anterior com a l�gica de duas cartas
        if(++qtdCartasViradas == 1){
            nomeDaCartaVirada1 = i;
            carta1 = c;
        }else{
            if(qtdCartasViradas == 2){
                nomeDaCartaVirada2 = i;
                CartaRef = c;
                
                qtdCartasViradas = 0;
                pontuacao++;
                if(nomeDaCartaVirada1 == nomeDaCartaVirada2){
                    qtdCartasDescobertas++;
                    Greenfoot.delay(10);
                    carta1.removerCarta();
                    CartaRef.removerCarta();
                    verificaFimDeJogo();
                }else{
                    Greenfoot.delay(10);
                    carta1.desvirarCarta();
                    CartaRef.desvirarCarta();
                    carta1 = null;
                    CartaRef = null;
                    nomeDaCartaVirada1 = null;
                    nomeDaCartaVirada2 = null;
                }
            }    
        }*/
        /**
         * Nova l�gica usando a carta de refere�ncia
        */
       // comparaa imagem clicada com a imagem de refer�ncia
        if(refMundo.getReference().getBufferImage()== carta.getBufferImage()){
            qtdCartasDescobertas++;
            verificaFimDeJogo();
        }
        
    }
    
    /**
     * Verifica o fim do jogo
     */
    public void verificaFimDeJogo(){
        if(qtdCartasDescobertas == QTD_PARES){
            qtdCartasDescobertas = 0;
            refMundo.setPontuacao(pontuacao);
            //refMundo.addObject(qPontos, 287, 220);
            //pontuacao = 0;
        }
    }
    
    /**
     * Verifica se � poss�vel desvirar uma carta, quando n�o h� duas cartas desviradas.
     */
    public boolean podeDesvirarCarta(){
        if(qtdCartasViradas <= 1)
            return true;
        else
            return false;
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
    }
}
