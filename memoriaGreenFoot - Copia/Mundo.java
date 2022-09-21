import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Mundo extends World{
    private static final int QTD_CARTAS = 6;
    private static final int QTD_CARTASref= 1;
    private static final int ESPACO_HORIZONTAL = 81; //distancia entre os pontos iniciais de cada carta
    private static final int ESPACO_VERTICAL = 106;// distancia entre os topos das ca
    private Carta cartaRef; /*= new Carta(lista,cerebro)/*[QTD_CARTASref]*/;//Def. da variavel cartaRef
    private Carta [] carta = new Carta[QTD_CARTAS];
    //O objeto lista � usado para conseguir obter uma imagem
    private ListaImagens lista = new ListaImagens();
    //Cerebro do jogo
    Cerebro cerebro = new Cerebro(this);
    //Objeto Carta de refer�ncia
    private Pontuacao qPontos;
    /**
     * Construtor da classe Mundo
     */
    public Mundo(){    
        super(578, 438, 1); //largura e altura da tela
        //setBackground("images/background.png");
        carregaCartas();
        //carregarCartaRef();
    }
    
    /**
     * come�ar novo jogo
     */
    public void comecarNovoJogo(){
        lista.carregaIdentificacao();
        
        for(int i = 0; i < QTD_CARTAS; i++){
            carta[i].reiniciarCarta(lista.getRandomImage());
        }
       //Caso queira usar mais um de uma carta de referencia, use o codigo abaixo 
       /*for (int i = 0; i < QTD_CARTASref; i++){
            cartaRef[i].reiniciarCarta();
        }*/
        
        cartaRef.reiniciarCarta(carta[(int)(Math.random() * QTD_CARTAS)].getBufferImage());
    }
    
    /**
     * Cria os objetos Carta e os adiciona na tela
     */
    public void carregaCartas(){ //posi��o das cartas
        int coluna = 370, 
            linha = 270, 
            qtd = 1;
            
        for(int i = 0; i < QTD_CARTAS; i++){
            carta[i] = new Carta(lista.getRandomImage(),lista.getBack(),lista.getEmpty(), cerebro);
            if(qtd <= 3){ //quantidade de cartas na linha
                qtd++;
                addObject(carta[i], coluna, linha);
                coluna += ESPACO_HORIZONTAL;
            }else{
                qtd = 2; //quantidade por coluna
                linha += ESPACO_VERTICAL;
                coluna = 370; //posi��o da segunda fileira de cartas
                addObject(carta[i], coluna, linha);
                coluna += ESPACO_HORIZONTAL;
            }
        }
        coluna = 100; 
        linha = 200;
        //Garantia de que a carta ref vai estar nas op��es
        cartaRef = new Carta(carta[(int)(Math.random() * QTD_CARTAS)].getBufferImage(),lista.getBack(),lista.getEmpty(),cerebro);
        cartaRef.setSizeImagem(71*2,96*2); //tamanho da imagem da carta de refencia
        cartaRef.setReference();
        addObject(cartaRef,coluna,linha);
        qPontos = new Pontuacao(this);
        addObject(qPontos, 400, 70);
        cartaRef.virarCarta();
        desvirarCartas();
    }
    public Carta getReference(){
        return cartaRef;
    }
    public void desvirarCartas(){
        for(int i = 0; i < QTD_CARTAS; i++){
            carta[i].desvirarCarta();
        }
    }
    public void virarCartas(){
        for(int i = 0; i < QTD_CARTAS; i++){
            carta[i].virarCarta();
        }
    }
    public void setPontuacao(int pontuacao){
        qPontos.setPontuacao(pontuacao);
    }
}
