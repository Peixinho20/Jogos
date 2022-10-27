import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Mundo extends World{
    private static final int TotalCartas = 28;
    private static final int linhaHORIZONTAL = 81;
    private static final int linhaVERTICAL = 106;
    private Carta [] carta = new Carta[TotalCartas];
    //O objeto lista é usado para conseguir obter uma imagem
    private ListaImagens lista = new ListaImagens();
    //Cerebro do jogo
    Cerebro cerebro = new Cerebro(this);
    //Pontuaçao do jogo
    private Pontuacao qPontos;
    /**
     * Construtor da classe Mundo
     */
    public Mundo(){    
        super(780, 438, 1);
        //setBackground("images/background.png");
        exibeCartas();
    }
    
    /**
     * começar novo jogo
     */
    public void comecarNovoJogo(){
        lista.guardaIdentificacao();
        for(int i = 0; i <= TotalCartas; i++){
            carta[i].reiniciarCarta();
        }
    }
    
    /**
     * Cria os objetos Carta e os adiciona na tela
     */
    public void exibeCartas(){
        int coluna = 45, 
            linha = 57, 
            qtd = 1;
            
        for(int i = 0; i < TotalCartas; i++){
            carta[i] = new Carta(lista, cerebro);
            if(qtd <= 7){
                qtd++;
                addObject(carta[i], coluna, linha);
                coluna += linhaHORIZONTAL;
            }else{
                qtd = 2;
                linha += linhaVERTICAL;
                coluna = 45;
                addObject(carta[i], coluna, linha);
                coluna += linhaHORIZONTAL;
            }
        }
        
        /**
        * Quadro de pontuação adicionado ao mundo
        */
        qPontos = new Pontuacao(this);
        addObject(qPontos,670,160); //objeto, posicao x, posicao y
    }
    
    public void setPontuacao(int pontuacao){
        qPontos.setPontuacao(pontuacao);
    }
}
