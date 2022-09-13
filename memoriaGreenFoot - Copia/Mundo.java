import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Mundo extends World{
    private static final int QTD_CARTAS = 6;
    private static final int ESPACO_HORIZONTAL = 81; //distancia entre os pontos iniciais de cada carta
    private static final int ESPACO_VERTICAL = 106;// distancia entre os topos das ca
    private Carta [] carta = new Carta[QTD_CARTAS];
    //O objeto lista é usado para conseguir obter uma imagem
    private ListaImagens lista = new ListaImagens();
    //Cerebro do jogo
    Cerebro cerebro = new Cerebro(this);
    
    /**
     * Construtor da classe Mundo
     */
    public Mundo(){    
        super(578, 438, 1); //largura e altura da tela
        //setBackground("images/background.png");
        carregaCartas();
    }
    
    /**
     * começar novo jogo
     */
    public void comecarNovoJogo(){
        lista.carregaIdentificacao();
        for(int i = 0; i < QTD_CARTAS; i++){
            carta[i].reiniciarCarta();
        }
    }
    
    /**
     * Cria os objetos Carta e os adiciona na tela
     */
    public void carregaCartas(){ //posição das cartas
        int coluna = 370, 
            linha = 270, 
            qtd = 1;
            
        for(int i = 0; i < QTD_CARTAS; i++){
            carta[i] = new Carta(lista, cerebro);
            if(qtd <= 3){ //quantidade de cartas na linha
                qtd++;
                addObject(carta[i], coluna, linha);
                coluna += ESPACO_HORIZONTAL;
            }else{
                qtd = 2; //quantidade por coluna
                linha += ESPACO_VERTICAL;
                coluna = 370; //posição da segunda fileira de cartas
                addObject(carta[i], coluna, linha);
                coluna += ESPACO_HORIZONTAL;
            }
            
        }
    }
    
    /**
     * Carregar carta de referencia
    **/
    public void carregaCartaRef(){
        int coluna = 100,
        linha = 100,
        qtd = 1;
    }

}
