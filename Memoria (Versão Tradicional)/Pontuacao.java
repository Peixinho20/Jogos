import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Pontuacao extends Actor{
    private Mundo w;
    GreenfootImage imagem;
    private boolean fimDeRodada = false;
    private int pontuacaoTotal;
    //private int altura = 100;
    //private int comprimento = 100;
    
    public Pontuacao(Mundo w){
        this.w = w;
        pontuacaoTotal = 0;
        imagem = new GreenfootImage("images/quadro.png");
        imagem.clear();
        imagem.setColor(Color.BLACK); //Quando a pontuaçao eh zero
        //Tamanho da fonte inicial
        imagem.setFont(new Font("Comic Sans MS",true,false,20));
        //Posicao da fonte inicial
        imagem.drawString("Pontos: "+pontuacaoTotal,50, 50);
        int altura = (int)imagem.getHeight();
        int comprimento = (int)imagem.getWidth();
        imagem.scale(comprimento,altura);
        setImage(imagem);
    }
    
    public void setPontuacao(int pontuacao){
        int altura = (int)imagem.getHeight()*2;
        int comprimento = (int)imagem.getWidth()/2;
        pontuacaoTotal += pontuacao;
        imagem.clear();
        imagem.setColor(Color.BLACK);//Aparece ao final do jogo
        imagem.drawString(pontuacaoTotal + " Pontos",50,50);
        
        //Clique para jogar de novo
        //imagem.setFont(new Font("Comic Sans MS", true,false,20));
        //imagem.drawString("Clique para",100,100);
        //imagem.drawString("jogar de novo",100,130);
    
        //imagem.scale(comprimento,altura);
        setImage(imagem);
        fimDeRodada = true;
    }
    /**
     * Troca a imagem da carta para jogar novamente
     
    public void reiniciarPontuacao(){
        //bufferImage = imagem.getRandomImage();
        pontuacaoTotal = 0;
    }*/
    
    public void act(){
        if(fimDeRodada){
            if(Greenfoot.mousePressed(this)){
                w.comecarNovoJogo();
                fimDeRodada=false;
            }
        }
    }
}
