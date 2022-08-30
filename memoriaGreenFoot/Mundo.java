import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Mundo extends World{
    private static final int QTD_CARTAS = 6;
    private static final int ESPACO_HORIZONTAL = 100; //espaço entre as cartas
    private static final int ESPACO_VERTICAL =150;
    private Carta [] carta = new Carta[QTD_CARTAS];
    //O objeto lista é usado para conseguir obter uma imagem
    private ListaImagens lista = new ListaImagens();
    //Cerebro do jogo
    Cerebro cerebro = new Cerebro(this);
    
    /**
     * Construtor da classe Mundo
     */
    public Mundo(){    
        super(578, 438, 1);
        setBackground("images/background.png");
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
    public void carregaCartas(){
        int coluna = 45, 
            linha = 57, 
            qtd = 1;
            
        for(int i = 0; i < QTD_CARTAS; i++){
            carta[i] = new Carta(lista, cerebro);
            if(qtd <= 3){
                qtd++;
                addObject(carta[i], coluna, linha);
                coluna += ESPACO_HORIZONTAL;
            }else{
                qtd = 2;
                linha += ESPACO_VERTICAL;
                coluna = 45;
                addObject(carta[i], coluna, linha);
                coluna += ESPACO_HORIZONTAL;
            }
            
        }
    }
}
